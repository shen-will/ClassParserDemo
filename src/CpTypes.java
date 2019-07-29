public interface CpTypes {

    byte CONSTANT_Class = 7;
    byte CONSTANT_Fieldref = 9;
    byte CONSTANT_Methodref = 10;
    byte CONSTANT_InterfaceMethodref = 11;
    byte CONSTANT_String = 8;
    byte CONSTANT_Integer = 3;
    byte CONSTANT_Float = 4;
    byte CONSTANT_Long = 5;
    byte CONSTANT_Double = 6;
    byte CONSTANT_NameAndType = 12;
    byte CONSTANT_Utf8 = 1;
    byte CONSTANT_MethodHandle = 15;
    byte CONSTANT_MethodType = 16;
    byte CONSTANT_InvokeDynamic = 18;

    int maxTypeId = 18;
    Class<? extends CpInfo>[] cpClassArray=new Class[]{
            null,
            CpInfo.Utf8CpInfo.class,
            null,
            CpInfo.IntegerCpInfo.class,
            CpInfo.FloatCpInfo.class,
            CpInfo.LongCpInfo.class,
            CpInfo.DoubleCpInfo.class,
            CpInfo.ClassCpInfo.class,
            CpInfo.StringCpInfo.class,
            CpInfo.FieldRefCpInfo.class,
            CpInfo.MethodRefCpInfo.class,
            CpInfo.InterfaceMethodRefCpInfo.class,
            CpInfo.NameAndTypeCpInfo.class,
            null,null,
            CpInfo.MethodHandleCpInfo.class,
            CpInfo.MethodTypeCpInfo.class,
            null,
            CpInfo.InvokeDynamicCpInfo.class

    };
}
