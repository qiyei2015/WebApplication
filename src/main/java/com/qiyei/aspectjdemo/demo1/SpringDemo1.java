package com.qiyei.aspectjdemo.demo1;

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
@ContextConfiguration("classpath:aspectj/applicationContext.xml")
public class SpringDemo1 {

    @Resource(name = "productDao")
    private ProductDao productDao;

    @Test
    public void demo1(){
        productDao.save();
        productDao.update();
        productDao.delete();
        productDao.findAll();
        productDao.findOne();
    }

}
