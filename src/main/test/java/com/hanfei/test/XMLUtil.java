package com.hanfei.test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;

/**
 * @Author: Hanfei
 * @Date: 2017/9/2
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:XMLUtil
 */
public class XMLUtil <T>{
    private static XStream xStream = null;
    private final static String XMLHEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+ File.separator;

    static {
        xStream = new XStream(new DomDriver());
        XStream xStream = new XStream(new DomDriver());
        xStream.aliasPackage("", "com.hanfei.test");
        xStream.setMode(XStream.NO_REFERENCES);
    }
   /* public static String toXML(T obj) {
        return XMLHEADER+xStream.toXML(obj);
    }*/

}
