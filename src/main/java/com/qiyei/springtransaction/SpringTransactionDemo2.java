package com.qiyei.springtransaction;

import com.qiyei.springtransaction.dao.BookDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Created by qiyei2015 on 2020/5/31.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SpringTransactionDemo2 {


    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        BookDao dao = (BookDao) applicationContext.getBean("bookDao");
        System.out.println(dao.findBookByIsbn("191-39-PRC"));
    }


}
