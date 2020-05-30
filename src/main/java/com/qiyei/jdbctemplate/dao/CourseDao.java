package com.qiyei.jdbctemplate.dao;


import com.qiyei.jdbctemplate.entity.Course;

import java.util.List;

public interface CourseDao {
    void insert(Course course);
    void update(Course course);
    void delete(int id);
    Course select(int id);
    List<Course> selectAll();
}
