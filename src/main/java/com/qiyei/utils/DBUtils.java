package com.qiyei.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Created by qiyei2015 on 2019/10/27.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class DBUtils {

    private static String RESOURCE = "mybatis-config.xml";
    private static SqlSessionFactory sSqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    public static void init(){
        try {
            InputStream is = Resources.getResourceAsStream(RESOURCE);
            sSqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取工厂对象的方法
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return sSqlSessionFactory;
    }

    public static SqlSession getSession(){
        return sSqlSessionFactory.openSession();
    }

    /**
     * 关闭SqlSession的方法
     */
    public static void close(){
        SqlSession session = threadLocal.get();
        if(session != null) {
            session.close();
            threadLocal.set(null);
        }
    }
}
