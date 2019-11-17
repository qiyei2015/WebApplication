package com.qiyei.springdemo.demo1;

/**
 * @author Created by qiyei2015 on 2019/11/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class UserServiceImpl implements IUserService {

    private String name;

    @Override
    public void sayHello() {
        System.out.println(name + " sayHello");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
