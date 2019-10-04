package com.qiyei.utils;

import java.util.List;

/**
 * @author Created by qiyei2015 on 2019/10/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LogUtils {

    public static void println(String tag,String msg){
        System.out.println("[" + tag + "] " + msg);
    }

    public static void println(String tag,int msg){
        System.out.println("[" + tag + "] " + msg);
    }

    public static <E> void println(String TAG,List<E> list){
        for (E e:list){
            println(TAG,e.toString());
        }
    }
}
