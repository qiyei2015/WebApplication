package com.qiyei.springdemo.demo2;

/**
 * @author Created by qiyei2015 on 2019/11/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Bean3Factory {

    public Bean3 createBean3(){
        System.out.println("Bean3Factory执行了...");
        return new Bean3();
    }
}
