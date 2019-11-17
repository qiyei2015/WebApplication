package com.qiyei.springdemo.demo3;

/**
 * @author Created by qiyei2015 on 2019/11/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class UserDaoImpl implements IUserDao {

    @Override
    public void queryAll() {
        System.out.println("查询用户。。。");
    }

    @Override
    public void save() {
        System.out.println("保存用户。。。");
    }

    @Override
    public void update() {
        System.out.println("修改用户。。。");
    }

    @Override
    public void delete() {
        System.out.println("删除用户。。。");
    }
}
