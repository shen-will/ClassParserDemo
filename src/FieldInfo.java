import java.io.IOException;

public class FieldInfo {

      public int  access_flags;
      public String acccss_des;
      public int  name_index;
      public String name;
      public int  descriptor_index;
      public String desc;
      public int  attributes_count;
      public AttributeInfo[] attributes; //length->attributes_count

      public void fromeBytesSub(ClassInputStream dins,ClassFile clFile)
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

            if((this.access_flags & AccessFlags.ACC_VOLATILE)>0)
                  sb.append("ACC_VOLATILE").append(",");
            if((this.access_flags & AccessFlags.ACC_TRANSIENT)>0)
                  sb.append("ACC_TRANSIENT").append(",");

            if((this.access_flags & AccessFlags.ACC_SYNTHETIC)>0)
                  sb.append("ACC_SYNTHETIC").append(",");

            if((this.access_flags & AccessFlags.ACC_ENUM)>0)
                  sb.append("ACC_ENUM").append(",");

            this.acccss_des =sb.toString();



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

      public static FieldInfo fromeBytes(ClassInputStream dins,ClassFile clFile)
                                                            throws IOException{
            FieldInfo info =new FieldInfo();
            info.fromeBytesSub(dins,clFile);
            return info;
      }
}
