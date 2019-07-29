import java.io.IOException;


public class CpInfo {

    public int tag;

    public CpInfo(int tag){
        this.tag = tag;
    }

    public void formBytes(ClassInputStream dins) throws IOException{}

    public void indexToValue(ClassFile clFile){}

    @Override
    public String toString() {
        return "tag:"+tag+" unknow type";
    }

    public static class ClassCpInfo extends CpInfo{

        public int name_index;

        public String name;

        public ClassCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            this.name_index = dins.readU2();
        }

        @Override
        public void indexToValue(ClassFile clFile) {
            this.name = clFile.getUtf_8(this.name_index);
        }


    }

    public static class FieldRefCpInfo extends CpInfo{

        public int class_index;
        public int name_and_type_index;

        public FieldRefCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            this.class_index = dins.readU2();
            this.name_and_type_index = dins.readU2();
        }

        @Override
        public void indexToValue(ClassFile clFile) {

        }
    }

    public static class MethodRefCpInfo extends CpInfo{

        public int class_index;
        public int name_and_type_index;

        public MethodRefCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            this.class_index = dins.readU2();
            this.name_and_type_index = dins.readU2();
        }

        @Override
        public void indexToValue(ClassFile clFile) {

        }
    }

    public static class InterfaceMethodRefCpInfo extends CpInfo{

        public int class_index;
        public int name_and_type_index;

        public InterfaceMethodRefCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            this.class_index = dins.readU2();
            this.name_and_type_index = dins.readU2();
        }

        @Override
        public void indexToValue(ClassFile clFile) {

        }
    }


    public static class StringCpInfo extends CpInfo{

        public int string_index;

        public String value;

        public StringCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            this.string_index =  dins.readU2();
        }

        @Override
        public void indexToValue(ClassFile clFile) {
            this.value = clFile.getUtf_8(this.string_index);
        }
    }


    public static class IntegerCpInfo extends CpInfo{

        public long bytes;

        public IntegerCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            this.bytes = dins.readU4();
        }

        @Override
        public void indexToValue(ClassFile clFile) {

        }
    }

    public static class FloatCpInfo extends CpInfo{

        public long bytes;
        public float value;

        public FloatCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            this.bytes = dins.readU4();
        }

        @Override
        public void indexToValue(ClassFile clFile) {
            value =Float.intBitsToFloat((int) bytes);
        }
    }


    public static class LongCpInfo extends CpInfo{

        //origin struct
        /*public int high_bytes;
        public int low_bytes;*/

        public long value;

        public LongCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            /*this.high_bytes = dins.readU4();
            this.low_bytes = dins.readU4();*/

            this.value = dins.readLong();
        }

        @Override
        public void indexToValue(ClassFile clFile) {

        }
    }

    public static class DoubleCpInfo extends CpInfo{

        //origin struct
       /* public int high_bytes;
        public int low_bytes;*/

        public double value;

        public DoubleCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
           /* this.high_bytes = dins.readU4();
            this.low_bytes = dins.readU4();*/

           this.value = dins.readDouble();
        }

        @Override
        public void indexToValue(ClassFile clFile) {

        }
    }

    public static class NameAndTypeCpInfo extends CpInfo{

        public int name_index;
        public int descriptor_index;

        public String name;
        public String desc;

        public NameAndTypeCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            this.name_index = dins.readU2();
            this.descriptor_index = dins.readU2();
        }

        @Override
        public void indexToValue(ClassFile clFile) {
            this.name = clFile.getUtf_8(this.name_index);
            this.desc = clFile.getUtf_8(this.descriptor_index);
        }
    }

    public static class Utf8CpInfo extends CpInfo{

        //origin struct
        /*
        public int length;
        public byte[] bytes;*/

        //string value
        public String value;

        public Utf8CpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {

            int length = dins.readU2();

            byte[] bytes = new byte[length];
            dins.read(bytes,0,length);

            this.value = new String(bytes,0,length,"UTF-8");
        }

        @Override
        public void indexToValue(ClassFile clFile) {

        }
    }

    public static class MethodTypeCpInfo extends CpInfo{

        public int descriptor_index;

        public String desc;

        public MethodTypeCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            this.descriptor_index = dins.readU2();
        }

        @Override
        public void indexToValue(ClassFile clFile) {
            this.desc = clFile.getUtf_8(this.descriptor_index);
        }
    }

    public static class InvokeDynamicCpInfo extends CpInfo{

        public int bootstrap_method_attr_index;
        public int name_and_type_index;

        public InvokeDynamicCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            this.bootstrap_method_attr_index = dins.readU2();
            this.name_and_type_index = dins.readU2();
        }

        @Override
        public void indexToValue(ClassFile clFile) {

        }
    }

    public static class MethodHandleCpInfo extends CpInfo{

        public int reference_kind;
        public int reference_index;

        public MethodHandleCpInfo(int tag) {
            super(tag);
        }

        @Override
        public void formBytes(ClassInputStream dins) throws IOException {
            this.reference_kind = dins.readU1();
            this.reference_index = dins.readU2();
        }

        @Override
        public void indexToValue(ClassFile clFile) {

        }
    }

}
