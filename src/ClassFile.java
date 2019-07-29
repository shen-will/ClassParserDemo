
public class ClassFile {

    /*
    * type define
    * public short short
    * u4 int
    * */
    public ClassFileHeader header;
    public CpInfo[] constant_pool;  // length->constant_pool_count-1
    public int[] interfaces;  //length->[interfaces_count]
    public FieldInfo[]  fields; //length->fields_count
    public MethodInfo[] methods; //length->methods_count
    public AttributeInfo[] attributes; //length->attributes_count

    public String getClassNameByIndex(int index){

        if(index >= this.constant_pool.length)
            return null;

        CpInfo info = this.constant_pool[index];

        if(info instanceof CpInfo.ClassCpInfo)
            return ((CpInfo.ClassCpInfo) info).name;

        return null;
    }

    public String getUtf_8(int index){

        if(index >= this.constant_pool.length)
            return null;

        CpInfo info = this.constant_pool[index];

        if(info instanceof CpInfo.Utf8CpInfo)
            return ((CpInfo.Utf8CpInfo) info).value;

        return null;
    }

    public String getFileName(){

        for(AttributeInfo info : this.attributes){
            if("SourceFile".equals(info.name)){
                return ((AttributeInfo.SourceFileAttribute)info).name;
            }
        }

        return "";
    }

    public String getImpls(){

        if(this.header.interfaces_count <=0 || this.interfaces.length == 0)
            return "";

        StringBuilder sb =new StringBuilder();

        for(int i=0;i<this.header.interfaces_count;i++){
            sb.append(this.getClassNameByIndex(this.interfaces[i])).append(",");
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }

}


