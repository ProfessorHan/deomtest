package com.hanfei.test;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author : HanFei
 * @date: 2017/9/8
 * @desc:Base64编解码工具类,JDK8以上版本
 */
public class Base64Util {

    private Base64Util() {

    }

    private static final Charset UTF8 = Charset.forName("UTF-8");

    /**
     * 将传入字符串进行Base64加密
     * @param source
     * @return
     */
    public static String encodeToString(String source) {
        String base64String = Base64.getEncoder().encodeToString(source.getBytes(UTF8));
        return base64String;
    }


    /**
     * 将传入字节数组进行Base64加密
     * @param bytes
     * @return
     */
    public static String encodeToString(byte[] bytes) {
        String base64String = Base64.getEncoder().encodeToString(bytes);
        return base64String;
    }


    /**
     * 将传入字符串进行Base64解码,返回字符串
     * @param source
     * @return
     */
    public static String decodeToString(String source) {
        return new String(Base64.getDecoder().decode(source),UTF8);
    }


    /**
     * 将传入字符串进行Base64解码,返回字节数组
     * @param source
     * @return
     */
    public static byte[] decodeToBytes(String source) {
        return Base64.getDecoder().decode(source);
    }

    public static void main(String[] args) {
        System.out.println(encodeToString("123456"));
        System.out.println(decodeToString("MTIzNDU2"));
        byte[] bytes = {1, 2, 3, 4, 5, 6,8};
        System.out.println(encodeToString(bytes));
        byte[] bytes1 = decodeToBytes("AQIDBAUGCA==");
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
    }
}
