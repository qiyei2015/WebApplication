package com.qiyei.springdemo.demo2;

/**
 * @author Created by qiyei2015 on 2019/11/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Bean2Factory {

    public static Bean2 createBean2(){
        System.out.println("Bean2Factory的方法已经执行了...");
        return new Bean2();
    }
}
