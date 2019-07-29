public class ClassFileHeader {

    public long magic;
    public int minor_version;
    public int major_version;
    public int constant_pool_count;
    public int access_flags;
    public String access_desc;
    public int this_class;
    public String class_name;
    public int super_class;
    public String super_name;
    public int interfaces_count;
    public int fields_count;
    public int methods_count;
    public int attributes_count;


    @Override
    public String toString() {

        StringBuilder sb =new StringBuilder();

        sb.append("魔数:0x");
        sb.append(Long.toHexString(magic).toUpperCase());
        sb.append("\n");

        sb.append("版本:");
        sb.append(major_version)
                .append(".")
                .append(minor_version);
        sb.append("\n");


        sb.append("常量池项:");
        sb.append(constant_pool_count -1);
        sb.append("\n");

        sb.append("类名:");
        sb.append(this.class_name);
        sb.append("\n");

        sb.append("父类:");
        sb.append(this.super_name);
        sb.append("\n");

        sb.append("访问修饰:");
        sb.append(this.access_desc);
        sb.append("\n");

        sb.append("实现接口:");
        sb.append(interfaces_count);
        sb.append("\n");

        sb.append("字段数:");
        sb.append(fields_count);
        sb.append("\n");

        sb.append("方法数:");
        sb.append(methods_count);
        sb.append("\n");

        return sb.toString();

    }
}
