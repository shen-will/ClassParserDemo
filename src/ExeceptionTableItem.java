import java.io.DataInputStream;
import java.io.IOException;

public class ExeceptionTableItem {

    public short start_pc;
    public short end_pc;
    public short handler_pc;
    public short catch_type;

    public ExeceptionTableItem(short start_pc, short end_pc, short handler_pc, short catch_type) {
        this.start_pc = start_pc;
        this.end_pc = end_pc;
        this.handler_pc = handler_pc;
        this.catch_type = catch_type;
    }

    public static ExeceptionTableItem fromBytes(DataInputStream dins)
                                                throws IOException{
        return new ExeceptionTableItem(dins.readShort(),
                dins.readShort(),dins.readShort(),dins.readShort());
    }
}
