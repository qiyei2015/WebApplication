package com.qiyei.utils;

/**
 * @author Created by qiyei2015 on 2019/10/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class TextUtils {

    public static boolean isEmpty(String text){
        if (text == null ||  "".equals(text)){
            return true;
        }
        return false;
    }
}
