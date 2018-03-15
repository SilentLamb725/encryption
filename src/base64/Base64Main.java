package base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import org.apache.commons.codec.binary.Base64;

public class Base64Main {

    private static String STR = "this is the text";

    public static void main(String[] args) {
        bouncyCastleBase64();
    }

    /**
     * jdk BASE64加密
     */
    private static void jdkBase64() {
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            String encode = encoder.encode(STR.getBytes());
            System.out.println("encode: " + encode);

            BASE64Decoder decoder = new BASE64Decoder();
            String decode = new String(decoder.decodeBuffer(encode));
            System.out.println("decode: " + decode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * commons-codec BASE64加密
     */
    private static void commonsCodecBase64() {
        String encode = new String(Base64.encodeBase64(STR.getBytes()));
        System.out.println("encode: " + encode);

        String decode = new String(Base64.decodeBase64(encode));
        System.out.println("decode: " + decode);
    }

    /**
     * bouncy Castle BASE64加密
     */
    private static void bouncyCastleBase64() {
        String encode = new String(org.bouncycastle.util.encoders.Base64.encode(STR.getBytes()));
        System.out.println("encode: " + encode);

        String decode = new String(org.bouncycastle.util.encoders.Base64.decode(encode));
        System.out.println("decode: " + decode);
    }
}
