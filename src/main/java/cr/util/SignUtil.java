package cr.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by 小富 on 2018/1/18.
 */
public class SignUtil {
    // 与接口配置信息中的Token要一致
    private static String token = "weixinCourse";

    /**
     * 验证签名
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = {signature, timestamp, nonce};
        Arrays.sort(arr);
        StringBuffer context = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            context.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            MessageDigest.getInstance("SHA-1");
            byte[] digest = context.toString().getBytes();
            tmpStr = byteToStr(digest);

        } catch (Exception e) {
            throw new RuntimeException("加密失败");
        }
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    public static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;

    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    public static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        //字节转换16进制
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        return new String(tempArr);
    }

}
