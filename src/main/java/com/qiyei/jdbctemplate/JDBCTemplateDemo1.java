package com.qiyei.jdbctemplate;

import com.qiyei.jdbctemplate.dao.CourseDao;
import com.qiyei.jdbctemplate.entity.Course;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.function.Consumer;

/**
 * @author Created by qiyei2015 on 2020/5/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class JDBCTemplateDemo1 {


    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        CourseDao courseDao = (CourseDao) applicationContext.getBean("courseDaoImpl");
        Course course = new Course();
        course.setName("语文");
        course.setScore(100);
        courseDao.insert(course);
        courseDao.selectAll().stream().forEach(new Consumer<Course>() {
            @Override
            public void accept(Course course) {
                System.out.println("query course =" + course.toString());
            }
        });

    }

}
