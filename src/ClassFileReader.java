import java.io.*;

public class ClassFileReader implements Closeable {

    private String clPath;
    ClassFile clFile;
    private ClassInputStream byteins;


    public ClassFileReader(String clPath) {
        this.clPath = clPath;

        init();
    }

    private void init(){

        if(this.clPath == null)
            throw new RuntimeException("class path is empty!");

        if(clFile !=null || byteins != null)
            throw new RuntimeException("can not repeated init...");


        try {
            byteins = new ClassInputStream(new FileInputStream(clPath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("can not open file "+clPath+" msg->"+e.getMessage());
        }

        this.clFile=toClassFile();

    }

    private ClassFile toClassFile(){

        ClassFile clFile = new ClassFile();

        ClassFileHeader header=new ClassFileHeader();
        try {

            header.magic = byteins.readU4();
            header.minor_version = byteins.readU2();
            header.major_version = byteins.readU2();
            header.constant_pool_count = byteins.readU2();

            clFile.header = header;

            //read constant pool
            int cp_count = header.constant_pool_count;
            if(cp_count > 1){

                clFile.constant_pool = new CpInfo[cp_count];

                for(int i=1;i<cp_count;i++){
                    clFile.constant_pool[i] = CpInfoFactory.fromBytes(byteins);

                    //stupid struct...
                    if(clFile.constant_pool[i] instanceof CpInfo.DoubleCpInfo ||
                            clFile.constant_pool[i] instanceof CpInfo.LongCpInfo){
                        i++;
                    }
                }

                for(int i=1;i<cp_count;i++){
                    CpInfo info = clFile.constant_pool[i];
                    if(info != null)
                        info.indexToValue(clFile);
                }
            }
            
            header.access_flags = byteins.readU2();
            StringBuilder sb=new StringBuilder();
            
            if((header.access_flags & AccessFlags.ACC_PUBLIC)  >0)
                sb.append("ACC_PUBLIC,");

            if((header.access_flags & AccessFlags.ACC_FINAL)  >0)
                sb.append("ACC_FINAL,");

            if((header.access_flags & AccessFlags.ACC_INTERFACE)  >0)
                sb.append("ACC_INTERFACE,");

            if((header.access_flags & AccessFlags.ACC_ABSTRACT)  >0)
                sb.append("ACC_ABSTRACT,");

            if((header.access_flags & AccessFlags.ACC_SYNTHETIC)  >0)
                sb.append("ACC_SYNTHETIC,");

            if((header.access_flags & AccessFlags.ACC_ANNOTATION)  >0)
                sb.append("ACC_ANNOTATION,");

            if((header.access_flags & AccessFlags.ACC_ENUM)  >0)
                sb.append("ACC_ENUM,");

            if((header.access_flags & AccessFlags.ACC_SUPER)  >0)
                sb.append("ACC_SUPER,");

            header.access_desc = sb.toString();
            
            header.this_class = byteins.readU2();
            header.super_class =byteins.readU2();
            header.class_name = clFile.getClassNameByIndex(header.this_class);

            if(header.super_class == 0)
                header.super_name ="java/lang/Object;";
            else
                header.super_name = clFile.getClassNameByIndex(header.super_class);

            header.interfaces_count = byteins.readU2();

            //read interface info array
            clFile.interfaces =new int[header.interfaces_count];
            for(int i=0;i<header.interfaces_count;i++){
                clFile.interfaces[i] = byteins.readU2();
            }

            //read field info array
            header.fields_count = byteins.readU2();
            clFile.fields = new FieldInfo[header.fields_count];
            for(int i=0;i<header.fields_count;i++){
                clFile.fields[i] = FieldInfo.fromeBytes(byteins,clFile);
            }

            //read method array
            header.methods_count = byteins.readU2();

            clFile.methods = new MethodInfo[header.methods_count];
            for(int i=0;i<header.methods_count;i++){
                clFile.methods[i] = MethodInfo.fromeBytes(byteins,clFile);
            }

            //read class attr
            header.attributes_count = byteins.readU2();
            clFile.attributes = new AttributeInfo[header.attributes_count];
            for(int i=0;i<header.attributes_count;i++){
                clFile.attributes[i] = AttributeInfo.fromBytes(byteins,clFile);
            }


            return clFile;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("parse class file header error msg->"+e.getMessage());
        }

    }



    public ClassFileHeader readClassHeader(){
        return clFile.header;
    }

    @Override
    public void close() throws IOException {

        if(byteins!=null){
            byteins.close();
            byteins = null;
        }
    }
}
