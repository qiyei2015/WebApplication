package com.qiyei.springdemo.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Created by qiyei2015 on 2019/11/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SpringDemo2 {

    @Test
    public void demo1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        applicationContext.getBean("bean1");
    }

    @Test
    public void demo2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        applicationContext.getBean("bean2");
    }

    @Test
    public void demo3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        applicationContext.getBean("bean3");
    }
}
