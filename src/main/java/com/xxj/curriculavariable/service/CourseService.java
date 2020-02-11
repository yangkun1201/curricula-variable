package com.xxj.curriculavariable.service;

import com.xxj.curriculavariable.entity.Course;

import java.util.List;

public interface CourseService {
    // 处理课程分页业务
    public List<Course> sortPage(int page);

    // 获取页数
    public int getNumber();
}
