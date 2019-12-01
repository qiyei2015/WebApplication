package com.qiyei.aspectjdemo.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Created by qiyei2015 on 2019/12/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aspectj/applicationContext2.xml")
public class SpringDemo2 {

    @Resource(name = "customerDao")
    private CustomerDao customerDao;

    @Test
    public void demo1(){
        customerDao.save();
        customerDao.update();
        customerDao.delete();
        customerDao.findOne();
        customerDao.findAll();
    }

}
