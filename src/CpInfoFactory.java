
import java.io.DataInputStream;
import java.lang.reflect.Field;

public class CpInfoFactory {


    public static CpInfo fromBytes(ClassInputStream dins){

        try {
            int tag = dins.readU1();

            if(tag > CpTypes.maxTypeId+1 || tag ==0)
                return  new CpInfo(tag);

            CpInfo info = CpTypes.cpClassArray[tag].getConstructor(int.class)
                    .newInstance(tag);

            info.formBytes(dins);
            return info;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("read constant pool item error msg->"+e.getMessage());
        }

    }
}
