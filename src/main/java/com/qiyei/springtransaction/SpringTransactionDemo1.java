package com.qiyei.springtransaction;

import com.qiyei.springtransaction.entity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.Date;

/**
 * @author Created by qiyei2015 on 2020/5/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SpringTransactionDemo1 {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        TransactionTemplate transactionTemplate = (TransactionTemplate) applicationContext.getBean("transactionTemplate");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        //可设置事务属性，如隔离级别、超时时间等,如
        //transactionTemplate.setPropagationBehavior();
        Book book = new Book("190-33-PRC", "哈哈", 1250.56f, new Date(System.currentTimeMillis()));
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    jdbcTemplate.update("update books set price=" + book.getPrice() + ",name='" + book.getName()
                            + "'  where isbn='" + book.getIsbn() + "' ");
                } catch (DataAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 1、编程式事务管理：事务管理器PlatformTransactionManager方式实现
    @Test
    public void test2() {

        Book book = new Book("191-39-PRC", "哈哈哈哈哈哈或或或或或或或或或", 1250.56f, new Date(System.currentTimeMillis()));

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        //第一步：获取JDBC事务管理器
        DataSourceTransactionManager dtm = (DataSourceTransactionManager) applicationContext.getBean("transactionManager");
        // 第二步：创建事务管理器属性对象
        DefaultTransactionDefinition transDef = new DefaultTransactionDefinition(); // 定义事务属性
        // 根据需要，设置事务管理器的相关属性
        // 设置传播行为属性
        transDef.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        // 第三步：获得事务状态对象
        TransactionStatus ts = dtm.getTransaction(transDef);
        // 第四步：基于当前事务管理器,获取数据源，创建操作数据库的JDBC模板对象
        JdbcTemplate jt = new JdbcTemplate(dtm.getDataSource());
        try {//第五步：业务操作
            jt.update("update books set price=" + book.getPrice() + ",name='" + book.getName()
                    + "'  where isbn='" + book.getIsbn() + "' ");
            // 其它数据操作如增删
            //第六步：提交事务
            dtm.commit(ts); // 如果不commit，则更新无效果
        } catch (Exception e) {
            dtm.rollback(ts);
            e.printStackTrace();
        }
    }
}
