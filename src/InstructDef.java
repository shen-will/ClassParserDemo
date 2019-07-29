import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public enum  InstructDef {

    m0x32("aaload","",(short)0),

    m0x53("aastore","",(short)0),

    m0x1("aconst_null","",(short)0),

    m0x19("aload","1",(short)1),

    m0x2a("aload_0","",(short)0),

    m0x2b("aload_1","",(short)0),

    m0x2c("aload_2","",(short)0),

    m0x2d("aload_3","",(short)0),

    m0xbd("anewarray","2",(short)2),
    m0xb0("areturn","",(short)0),

    m0xbe("arraylength","",(short)0),

    m0x3a("astore","1",(short)1),

    m0x4b("astore_0","",(short)0),
    m0x4c("astore_1","",(short)0),
    m0x4d("astore_2","",(short)0),
    m0x4e("astore_3","",(short)0),

    m0xbf("athrow","",(short)0),

    m0x33("baload","",(short)0),

    m0x54("bastore","",(short)0),

    m0x10("bipush","1",(short)1),
    m0x34("caload","",(short)0),

    m0x55("castore","",(short)0),

    m0xc0("checkcast","2",(short)2),
    m0x90("d2f","",(short)0),
    m0x8e("d2i","",(short)0),
    m0x8f("d2l","",(short)0),

    m0x63("dadd","",(short)0),
    m0x31("daload","",(short)0),
    m0x52("dastore","",(short)0),

    m0x98("dcmpg","",(short)0),

    m0x97("dcmpl","",(short)0),
    m0xe("dconst_0","",(short)0),
    m0xf("dconst_1 ","",(short)0),

    m0x6f("ddiv","",(short)0),
    m0x18("dload","1",(short)1),

    m0x26("dload_0","",(short)0),
    m0x27("dload_1","",(short)0),
    m0x28("dload_2","",(short)0),
    m0x29("dload_3","",(short)0),


    m0x6b("dmul","",(short)0),

    m0x77("dneg","",(short)0),

    m0x73("drem","",(short)0),
    m0xaf("dreturn","",(short)0),
    m0x39("dstore","1",(short)1),

    m0x47("dstore_0","",(short)0),
    m0x48("dstore_1","",(short)0),
    m0x49("dstore_2","",(short)0),
    m0x4a("dstore_3","",(short)0),

    m0x67("dsub","",(short)0),

    m0x59("dup","",(short)0),

    m0x5a("dup_x1","",(short)0),
    m0x5b("dup_x2","",(short)0),

    m0x5c("dup2","",(short)0),
    m0x5d("dup2_x1","",(short)0),
    m0x5e("dup2_x2","",(short)0),

    m0x8d("f2d","",(short)0),
    m0x8b("f2i","",(short)0),
    m0x8c("f2l","",(short)0),

    m0x62("fadd","",(short)0),
    m0x51("fastore","",(short)0),
    m0x96("fcmpg","",(short)0),
    m0x95("fcmpl","",(short)0),

    m0xb("fconst_0","",(short)0),
    m0xc("fconst_1","",(short)0),
    m0xd("fconst_2","",(short)0),

    m0x6e("fdiv","",(short)0),
    m0x17("fload","1",(short)1),
    m0x22("fload_0","",(short)0),
    m0x23("fload_1","",(short)0),
    m0x24("fload_2","",(short)0),
    m0x25("fload_3","",(short)0),

    m0x6a("fmul","",(short)0),
    m0x76("fneg","",(short)0),
    m0xae("freturn","",(short)0),
    m0x38("fstore","1",(short)1),


    m0x43("fstore_0","",(short)0),
    m0x44("fstore_1","",(short)0),
    m0x45("fstore_2","",(short)0),
    m0x46("fstore_3","",(short)0),

    m0x66("fsub","",(short)0),
    m0xb4("getfield","2",(short)2),
    m0xb2("getstatic","2",(short)2),
    m0xa7("goto","2",(short)2),
    m0xc8("goto_w","4",(short)4),


    m0x91("i2b","",(short)0),
    m0x92("i2c","",(short)0),
    m0x87("i2d","",(short)0),
    m0x86("i2f","",(short)0),
    m0x85("i2l","",(short)0),
    m0x93("i2s","",(short)0),
    m0x60("iadd","",(short)0),
    m0x2e("iaload","",(short)0),
    m0x7e("iand","",(short)0),
    m0x4f("iastore","",(short)0),
    m0x2("iconst_m1","",(short)0),
    m0x3("iconst_0","",(short)0),
    m0x4("iconst_1","",(short)0),
    m0x5("iconst_2","",(short)0),
    m0x6("iconst_3","",(short)0),
    m0x7("iconst_4","",(short)0),
    m0x8("iconst_5","",(short)0),
    m0x6c("idiv","",(short)0),

    m0xa5("if_acmpeq ","2",(short)2),
    m0xa6("if_acmpne","2",(short)2),

    m0x9f("if_icmpeq","2",(short)2),
    m0xa0("if_icmpne","2",(short)2),
    m0xa1("if_icmplt","2",(short)2),
    m0xa2("if_icmpge","2",(short)2),
    m0xa3("if_icmpgt","2",(short)2),
    m0xa4("if_icmple","2",(short)2),

    m0x99("ifeq","2",(short)2),
    m0x9a("ifne","2",(short)2),
    m0x9b("iflt","2",(short)2),
    m0x9c("ifge","2",(short)2),
    m0x9d("ifgt","2",(short)2),
    m0x9e("ifle","2",(short)2),



    m0xc7("ifnonnull","2",(short)2),
    m0xc6("ifnull","2",(short)2),
    m0x84("iinc","1,1",(short)2),
    m0x15("iload","1",(short)1),

    m0x1a("iload_0","",(short)0),
    m0x1b("iload_1","",(short)0),
    m0x1c("iload_2","",(short)0),
    m0x1d("iload_3","",(short)0),

    m0x68("imul","",(short)0),
    m0x74("ineg","",(short)0),

    m0xc1("instanceof","2",(short)2),
    m0xba("invokedynamic","2,2",(short)4),
    m0xb9("invokeinterface","2,1,1",(short)4),
    m0xb7("invokespecial","2",(short)2),
    m0xb8("invokestatic","2",(short)2),
    m0xb6("invokevirtual","2",(short)2),

    m0x80("ior","",(short)0),
    m0x70("irem","",(short)0),
    m0xac("ireturn","",(short)0),
    m0x78("ishl","",(short)0),
    m0x7a("ishr","",(short)0),
    m0x36("istore","1",(short)1),

    m0x3b("istore_0 ","",(short)0),
    m0x3c("istore_1 ","",(short)0),
    m0x3d("istore_2 ","",(short)0),
    m0x3e("istore_3 ","",(short)0),

    m0x64("isub","",(short)0),
    m0x7c("iushr","",(short)0),
    m0x82("ixor","",(short)0),
    m0xa8("jsr","2",(short)2),
    m0xc9("jsr_w","4",(short)4),
    m0x8a("l2d","",(short)0),
    m0x89("l2f","",(short)0),
    m0x88("l2i","",(short)0),
    m0x61("ladd","",(short)0),
    m0x2f("laload","",(short)0),
    m0x7f("land","",(short)0),
    m0x50("lastore","",(short)0),

    m0x94("lcmp","",(short)0),
    m0x9("lconst_0","",(short)0),
    m0xa("lconst_1","",(short)0),

    m0x12("ldc","1",(short)1),
    m0x13("ldc_w","2",(short)2),
    m0x14("ldc2_w","2",(short)2),
    m0x6d("ldiv","",(short)0),
    m0x16("lload","1",(short)1),

    m0x1e("lload_0","",(short)0),
    m0x1f("lload_1","",(short)0),
    m0x20("lload_2","",(short)0),
    m0x21("lload_3","",(short)0),

    m0x69("lmul","",(short)0),
    m0x75("lneg","",(short)0),
    m0xab("lookupswitch","",(short)0), //add hand
    m0x81("lor","",(short)0),
    m0x71("lrem","",(short)0),
    moxad("lreturn","",(short)0),
    m0x79("lshl","",(short)0),
    m0x7b("lshr","",(short)0),
    m0x37("lstore","",(short)0),

    m0x3f("lstore_0","",(short)0),
    m0x40("lstore_1","",(short)0),
    m0x41("lstore_2","",(short)0),
    m0x42("lstore_3","",(short)0),

    m0x65("lsub","",(short)0),
    m0x7d("lushr","",(short)0),
    m0x83("lxor","",(short)0),
    m0xc2("monitorenter","",(short)0),
    m0xc3("monitorexit","",(short)0),
    m0xc5("multianewarray","2,1",(short)3),

    m0xbb("new","2",(short)2),
    m0xbc("newarray","1",(short)1),
    m0x0("nop","",(short)0),
    m0x57("pop","",(short)0),
    m0x58("pop2","",(short)0),
    m0xb5("putfield","2",(short)2),
    m0xb3("putstatic","2",(short)2),
    m0xa9("ret","1",(short)1),
    m0xb1("return","",(short)0),
    m0x35("saload","",(short)0),
    m0x56("sastore","",(short)0),
    m0x11("sipush","2",(short)2),
    m0x5f("swap","",(short)0),
    m0xaa("tableswitch","",(short)0),  //add hand
    m0xc4("wide","",(short)0);   //add hand
   


    public String opname;
    public String format;
    public short opdata_size;

    InstructDef(String opname, String format, short opdata_size) {
        this.opname = opname;
        this.format = format;
        this.opdata_size = opdata_size;
    }


    public java.lang.String parse(DataInputStream dins) throws IOException {

        StringBuilder sb=new StringBuilder();
        sb.append(this.opname).append(" ");


        //lookupswitch
        if(this == m0xab){
            sb.append("default:").append("0x")
                    .append(Integer.toHexString(dins.readInt()))
                    .append(" ");

            int offsetCount = dins.readInt();

            //read match:offset
            for(int i=0;i<offsetCount;i++){
                sb.append(Integer.toHexString(dins.readInt()))
                        .append(":")
                        .append(Integer.toHexString(dins.readInt()));
            }

            sb.append("\n");
            return sb.toString();
        }

        //tableswitch
        if(this == m0xaa) {

            sb.append("default:").append("0x")
                    .append(Integer.toHexString(dins.readInt()))
                    .append(" ");

            int hight= dins.readInt();
            int low = dins.readInt();

            int offsetCount = hight - low +1;

            //read match:offset
            for(int i=0;i<offsetCount;i++){
                sb.append(Integer.toHexString(dins.readInt()))
                        .append(",");
            }

            sb.append("\n");
            return sb.toString();

        }

        //wide
        if(this == m0xc4){
            byte opcode2 = dins.readByte();
            InstructDef instruct = InstructDef.valueOf("m0x" + Integer.toHexString(Byte.toUnsignedInt(opcode2)));

            sb.append(instruct.opname).append(" ");

            //iinc
            if(instruct == m0x84){
                sb.append(Integer.toHexString(dins.readShort()))
                        .append(" ")
                        .append(Integer.toHexString(dins.readShort()));
            }else{
                sb.append(Integer.toHexString(dins.readShort()));
            }

            sb.append("\n");
            return sb.toString();
        }

        if(this.opdata_size <=0){
            sb.append("\n");
            return sb.toString();
        }

        String[] dsize_array = format.split(",");

        for(int i=0;i<dsize_array.length;i++){
            int size = Integer.parseInt(dsize_array[i]);

            int value;
            if(size == 1){
                value = dins.readByte();
            }else if(size == 2){
                value = dins.readShort();
            }else if(size == 4){
                value = dins.readInt();
            }else{
                throw new RuntimeException("parse instruct error format size "+size +" in "+opname);
            }
            sb.append(value).append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }
}
