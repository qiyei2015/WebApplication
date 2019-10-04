package com.qiyei.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * @author Created by qiyei2015 on 2019/10/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class XmlManager {

    private static final String TAG = "[XmlManager] ";

    public static void starParse(File file){
        //1 获取SAXParserFactory
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            //2 获取SAXParser对象
            SAXParser saxParser = saxParserFactory.newSAXParser();
            //3 通过parse进行解析
            saxParser.parse(file,new DefaultHandler(){
                //当前正在处理的tag
                private String currentTag;

                //每当解析文档开始时触发该方法
                @Override
                public void startDocument() throws SAXException {
                    System.out.println(TAG + "startDocument");
                }

                //解析文档结束时触发该方法
                @Override
                public void endDocument() throws SAXException {
                    System.out.println(TAG + "endDocument");
                }

                //解析元素开始时触发该方法
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println(TAG + "start parse:" + qName);
                    currentTag = qName;
                    //有属性
                    if (attributes.getLength() > 0){
                        System.out.println(TAG + "<" + currentTag + ">属性如下:");
                        for (int i = 0; i < attributes.getLength(); i++){
                            System.out.println(TAG + "<" + currentTag + ">:" + attributes.getQName(i) + " --> " + attributes.getValue(i));
                        }
                    }
                }

                //解析元素结束时触发该方法
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println(TAG + "end parse:" + qName);
                }

                //每当处理文本数据时将触发该方法
                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String content = new String(ch,start,length);
                    if (content.trim().length() > 0) {
                        System.out.println(TAG + "<" + currentTag + ">元素的值是:" + content.trim());
                    }
                }
            });
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeXml(String file){
        //1 生成xml StreamResult对象
        Result resultXml = new StreamResult(new File(file));
        //2 获取sax生成工厂实例
        SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            //3 获取SAX生成处理者对象实例
            TransformerHandler transformerHandler = saxTransformerFactory.newTransformerHandler();

            //4 获取SAX生成器
            Transformer transformer = transformerHandler.getTransformer();
            //设置编码
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            //设置缩进
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            transformerHandler.setResult(resultXml);
            //5 开始生成文档
            transformerHandler.startDocument();

            //第一本书
            AttributesImpl attrImpl = new AttributesImpl();
            transformerHandler.startElement("", "", "书籍列表", attrImpl);
            transformerHandler.startElement("", "", "计算机书籍", attrImpl);
            transformerHandler.startElement("", "", "书名", attrImpl);
            transformerHandler.characters("Java思想".toCharArray(), 0, "Java思想".length());
            transformerHandler.endElement("", "", "书名");

            transformerHandler.startElement("", "", "作者", attrImpl);
            transformerHandler.characters("小王".toCharArray(), 0, "小王".length());
            transformerHandler.endElement("", "", "作者");

            transformerHandler.startElement("", "", "价格", attrImpl);
            transformerHandler.characters("79.00".toCharArray(), 0, "79.00".length());
            transformerHandler.endElement("", "", "价格");
            transformerHandler.endElement("", "", "计算机书籍");

            //第二本书

            transformerHandler.startElement("", "", "计算机书籍", attrImpl);
            transformerHandler.startElement("", "", "书名", attrImpl);
            transformerHandler.characters("Spring指南".toCharArray(), 0, "Spring指南".length());
            transformerHandler.endElement("", "", "书名");

            transformerHandler.startElement("", "", "作者", attrImpl);
            transformerHandler.characters("小李".toCharArray(), 0, "小李".length());
            transformerHandler.endElement("", "", "作者");

            transformerHandler.startElement("", "", "价格", attrImpl);
            transformerHandler.characters("89.00".toCharArray(), 0, "89.00".length());
            transformerHandler.endElement("", "", "价格");
            transformerHandler.endElement("", "", "计算机书籍");

            transformerHandler.endElement("", "", "书籍列表");

            //6 结束写入
            transformerHandler.endDocument();
            System.out.println(TAG + " xml generate success");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
