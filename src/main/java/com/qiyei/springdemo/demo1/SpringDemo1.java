package com.qiyei.springdemo.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Created by qiyei2015 on 2019/11/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SpringDemo1 {

    @Test
    public void demo1(){
        IUserService userService = new UserServiceImpl();
        userService.sayHello();
    }

    @Test
    public void demo2(){
        //创建Spring的工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        // 通过工厂获得类:
        IUserService userService = (IUserService) applicationContext.getBean("userService");
        userService.sayHello();

    }

}
