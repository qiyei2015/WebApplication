package com.qiyei.javaweb;

import com.qiyei.xml.XmlManager;

import java.io.File;

/**
 * @author Created by qiyei2015 on 2019/9/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class XmlParserTest {

    public static void main(String[] args){
        File file = new File("F://Test/test.xml");
        XmlManager.starParse(file);
        XmlManager.writeXml("F://Test/test.xml");
    }

}
