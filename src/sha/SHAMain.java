package sha;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;

import java.security.MessageDigest;

public class SHAMain {

    private static String STR = "this is sha";

    public static void main(String[] args) {
        jdkSHA1();
        bcSHA1();
        bcSHA224();
        ccSHA1();
    }

    public static void jdkSHA1() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            String sha1 = Hex.encodeHexString(md.digest(STR.getBytes()));
            System.out.println("jdk sha-1: " + sha1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bcSHA1() {
        Digest digest = new SHA1Digest();
        digest.update(STR.getBytes(), 0, STR.getBytes().length);
        byte[] sha1Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha1Bytes, 0);
        System.out.println("bc sha-1: " + org.bouncycastle.util.encoders.Hex.toHexString(sha1Bytes));
    }

    public static void bcSHA224() {
        Digest digest = new SHA224Digest();
        digest.update(STR.getBytes(), 0, STR.getBytes().length);
        byte[] sha224Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha224Bytes, 0);
        System.out.println("bc sha224: " + org.bouncycastle.util.encoders.Hex.toHexString(sha224Bytes));
    }

    public static void ccSHA1() {
        System.out.println("cc sha1-1: " + DigestUtils.sha1Hex(STR.getBytes()));
        System.out.println("cc sha1-2: " + DigestUtils.sha1Hex(STR));
    }
}
