public interface AccessFlags {

    short ACC_PUBLIC = 0x0001;
    short ACC_FINAL = 0x0010;
    short ACC_SUPER = 0x0020;;
    short ACC_INTERFACE = 0x0200;
    short ACC_ABSTRACT = 0x0400;
    short ACC_SYNTHETIC = 0x1000;
    short ACC_ANNOTATION = 0x2000;
    short ACC_ENUM = 0x4000;

    short ACC_PRIVATE = 0x0002;
    short ACC_PROTECTED = 0x0004;
    short ACC_STATIC = 0x0008;
    short ACC_VOLATILE = 0x0040;
    short ACC_TRANSIENT =0x0080;


    short ACC_SYNCHRONIZED=0x0020;
    short ACC_BRIDGE =0x0040;
    short ACC_VARARGS = 0x0080;
    short ACC_NATIVE= 0x0100;
    short ACC_STRICT = 0x0800;
}
