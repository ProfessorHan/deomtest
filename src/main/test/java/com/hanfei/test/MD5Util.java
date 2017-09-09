package com.hanfei.test;

import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;

/**
 * @Author: Hanfei
 * @Date: 2017/9/9
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:MD5Util
 */
public class MD5Util {

    private MD5Util() {

    }

    private static final Charset UTF8 = Charset.forName("UTF-8");

    public static String encode(String source) {
        return DigestUtils.md5DigestAsHex(source.getBytes(UTF8));
    }

    public static String decode(String source) {
        return null;
    }
}
