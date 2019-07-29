import sun.rmi.runtime.Log;

import java.io.DataInputStream;
import java.io.IOException;

public class AttributeInfo {

    public int attribute_name_index;
    public long attribute_length;

    public String name;

    public AttributeInfo(int attribute_name_index, long attribute_length, String name) {
        this.attribute_name_index = attribute_name_index;
        this.attribute_length = attribute_length;
        this.name = name;
    }

    public void fromBytesSub(ClassInputStream dins,ClassFile clFile)throws IOException{
        dins.skipBytes((int) this.attribute_length); //skip not parse bytes
    }

    public static AttributeInfo fromBytes(ClassInputStream dins, ClassFile clFile)
                                                            throws IOException{
        int nameIndex = dins.readU2();
        long length = dins.readU4();

        String name = clFile.getUtf_8(nameIndex);

        AttributeInfo info = "Code".equals(name) ? new CodeAttribute(nameIndex,length,name)
                : "SourceFile".equals(name) ? new SourceFileAttribute(nameIndex,length,name)
                : new AttributeInfo(nameIndex,length,name);

        info.fromBytesSub(dins,clFile);

        return info;
    }


    public static class CodeAttribute extends AttributeInfo{

        public int max_stack;
        public int max_locals;
        public long code_length;

        public byte[] code;
        public String code_str;

        public int exception_table_length;
        public ExeceptionTableItem[] exception_table;
        public int attributes_count;
        public AttributeInfo[] attributes;

        public CodeAttribute(int attribute_name_index, long attribute_length, String name) {
            super(attribute_name_index, attribute_length, name);
        }

        @Override
        public void fromBytesSub(ClassInputStream dins, ClassFile clFile) throws IOException {
            this.max_stack = dins.readU2();
            this.max_locals = dins.readU2();
            this.code_length = dins.readU4();

            code = new byte[(int) code_length];
            dins.read(code,0,(int) this.code_length);

            //disassemble code
            Disassembler.disassembleCode(this);

            this.exception_table_length = dins.readU2();

            //read exeception table
            exception_table = new ExeceptionTableItem[this.exception_table_length];
            for(int i=0;i<exception_table_length;i++){
                exception_table[i] = ExeceptionTableItem.fromBytes(dins);
            }

            //read attr
            this.attributes_count = dins.readU2();
            this.attributes = new AttributeInfo[this.attributes_count];
            for(int i=0;i<this.attributes_count;i++){
                this.attributes[i] = AttributeInfo.fromBytes(dins,clFile);
            }
        }
    }

    public static class SourceFileAttribute extends AttributeInfo{

        public int number_of_classes;
        public String name;

        public SourceFileAttribute(int attribute_name_index, long attribute_length, String name) {
            super(attribute_name_index, attribute_length, name);
        }

        @Override
        public void fromBytesSub(ClassInputStream dins, ClassFile clFile) throws IOException {
            this.number_of_classes = dins.readU2();
            this.name = clFile.getUtf_8(this.number_of_classes);
        }
    }

    //only parse code,others omit...
}
