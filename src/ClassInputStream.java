import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassInputStream extends DataInputStream {
    /**
     * Creates a DataInputStream that uses the specified
     * underlying InputStream.
     *
     * @param in the specified input stream
     */
    public ClassInputStream(InputStream in) {
        super(in);
    }

    public long readU4()throws IOException {
        return Integer.toUnsignedLong(this.readInt());
    }

    public int readU2()throws IOException{
        return this.readUnsignedShort();
    }

    public int readU1()throws IOException{
        return this.readUnsignedByte();
    }
}
