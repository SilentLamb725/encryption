package md;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.plugin2.message.Message;

import java.security.MessageDigest;
import java.security.Security;

public class MdMain {

    private static String STR = "this is the text";

    public static void main(String[] args) {
        jdkMD5();
        jdkMD2();
        bcMD4();
        bcMD5();
        anotherBcMD4();
    }

    public static void jdkMD5() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(STR.getBytes());
            String md5 = Hex.encodeHexString(md5Bytes);
            System.out.println("JDK MD5: " + md5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jdkMD2() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] md5Bytes = md.digest(STR.getBytes());
            String md2 = Hex.encodeHexString(md5Bytes);
            System.out.println("JDK MD2: " + md2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bcMD4() {
        Digest digest = new MD4Digest();
        digest.update(STR.getBytes(), 0, STR.getBytes().length);
        byte[] md4Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md4Bytes, 0);
        System.out.println("BC MD4: " + org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
    }

    public static void bcMD5() {
        Digest digest = new MD5Digest();
        digest.update(STR.getBytes(), 0, STR.getBytes().length);
        byte[] md5Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md5Bytes, 0);
        System.out.println("BC MD4: " + org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
    }

    public static void anotherBcMD4() {
        // 动态给jdk添加一个provider
        try {
            Security.addProvider(new BouncyCastleProvider());
            MessageDigest md = MessageDigest.getInstance("MD4");
            byte[] md4Bytes = md.digest(STR.getBytes());
            System.out.println("BC MD4: " + Hex.encodeHexString(md4Bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
