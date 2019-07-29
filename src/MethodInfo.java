

import java.io.IOException;

public class MethodInfo {

      public int             access_flags;
      public String  access_desc;
      public int             name_index;
      public String name;
      public int             descriptor_index;
      public String desc;
      public int             attributes_count;
      public AttributeInfo[] attributes;  //length->attributes_count

      public void fromeBytesSub(ClassInputStream dins, ClassFile clFile)
              throws IOException {
            this.access_flags = dins.readU2();

            StringBuilder sb =new StringBuilder();

            if((this.access_flags & AccessFlags.ACC_PUBLIC)>0)
                  sb.append("ACC_PUBLIC").append(",");

            if((this.access_flags & AccessFlags.ACC_PRIVATE)>0)
                  sb.append("ACC_PRIVATE").append(",");

            if((this.access_flags & AccessFlags.ACC_PROTECTED)>0)
                  sb.append("ACC_PROTECTED").append(",");

            if((this.access_flags & AccessFlags.ACC_STATIC)>0)
                  sb.append("ACC_STATIC").append(",");

            if((this.access_flags & AccessFlags.ACC_FINAL)>0)
                  sb.append("ACC_FINAL").append(",");

            if((this.access_flags & AccessFlags.ACC_SYNCHRONIZED)>0)
                  sb.append("ACC_SYNCHRONIZED").append(",");

            if((this.access_flags & AccessFlags.ACC_BRIDGE)>0)
                  sb.append("ACC_BRIDGE").append(",");

            if((this.access_flags & AccessFlags.ACC_VARARGS)>0)
                  sb.append("ACC_VARARGS").append(",");

            if((this.access_flags & AccessFlags.ACC_NATIVE)>0)
                  sb.append("ACC_NATIVE").append(",");

            if((this.access_flags & AccessFlags.ACC_ABSTRACT)>0)
                  sb.append("ACC_ABSTRACT").append(",");

            if((this.access_flags & AccessFlags.ACC_STRICT)>0)
                  sb.append("ACC_STRICT").append(",");

            if((this.access_flags & AccessFlags.ACC_SYNTHETIC)>0)
                  sb.append("ACC_SYNTHETIC").append(",");

            this.access_desc =sb.toString();




            this.name_index = dins.readU2();
            this.name = clFile.getUtf_8(this.name_index);
            this.descriptor_index = dins.readU2();
            this.desc = clFile.getUtf_8(this.descriptor_index);

            this.attributes_count = dins.readU2();
            this.attributes = new AttributeInfo[this.attributes_count];
            for(int i=0;i<this.attributes_count;i++){
                  this.attributes[i] = AttributeInfo.fromBytes(dins,clFile);
            }
      }

      public static MethodInfo fromeBytes(ClassInputStream dins, ClassFile clFile)
              throws IOException{
            MethodInfo info =new MethodInfo();
            info.fromeBytesSub(dins,clFile);
            return info;
      }

      public String getCodeStr(){

            if(attributes_count <=0 || attributes.length ==0)
                  return "";

            for(AttributeInfo info : attributes){
                  if("Code".equals(info.name)){
                        return ((AttributeInfo.CodeAttribute)info).code_str;
                  }
            }
            return  "";
      }

}

