import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;

public class Disassembler {

    public static void disassembleCode(AttributeInfo.CodeAttribute code){

        if(code.code == null || code.code.length == 0)
            throw new RuntimeException("disassemble empty code!");

        StringBuilder sb =new StringBuilder();
        DataInputStream dins =new DataInputStream(new ByteArrayInputStream(code.code));

        try {
            while (true){
                byte opcode = dins.readByte();
                InstructDef op = InstructDef.valueOf("m0x" + Integer.toHexString(Byte.toUnsignedInt(opcode)));
                sb.append(op.parse(dins));
            }
        }catch (EOFException exeof){
            code.code_str = sb.toString();
        }catch (Exception ex){
            throw new RuntimeException("disassemble code error msg->"+ ex.getMessage());
        }
    }

    public static String disassembleClass(ClassFile clFile){

        StringBuilder sb =new StringBuilder();

        //write file name
        sb.append("compile from ").append(clFile.getFileName()).append("\n\n");

        //write header
        sb.append(clFile.header.toString()).append("\n");

        //write class start
        sb.append(clFile.header.access_desc).append(" ")
                .append("class ")
                .append(clFile.header.class_name)
                .append(" ")
                .append(clFile.header.super_name).append(" ");

        //implement interfaces
        if(clFile.header.interfaces_count >0){
            sb.append("implements ").append(clFile.getImpls());
        }

        sb.append("{\n\n");

        //write field
        for(int i=0;i<clFile.header.fields_count;i++){
            FieldInfo field = clFile.fields[i];
            sb.append("    ").append(field.acccss_des)
            .append(" ").append(field.desc).append(":")
            .append(field.name).append("=...;\n");
        }

        //write method
        for(int i=0;i<clFile.header.methods_count;i++){
            MethodInfo method = clFile.methods[i];

            sb.append(method.access_desc)
                    .append(" ")
                    .append(method.desc)
                    .append(":")
                    .append(method.name)
                    .append("{\n\n")
                    .append(method.getCodeStr())
                    .append("\n}\n\n");
        }
        //write class end
        sb.append("}\n");

        return sb.toString();
    }
}
