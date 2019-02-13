import java.io.UnsupportedEncodingException;

import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.util.encoders.Hex;

public class Ripemd160 {

    private static String Cryp = "12345";

    public static void main(String[] args) {
        byte[] r = null;


        try {
            r = Cryp.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte last[] = getRIPEMDHash(r);
        try {
            System.out.println("Encrypted string = "+ new String(last, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    public static byte[] getRIPEMDHash(byte[] in)
    {
        RIPEMD160Digest d = new RIPEMD160Digest();
        d.update(in, 0, in.length);

        byte[] o = new byte[d.getDigestSize()];
        d.doFinal(o, 0);

        byte[] last =  Hex.encode(o);

        return last;
    }
}
