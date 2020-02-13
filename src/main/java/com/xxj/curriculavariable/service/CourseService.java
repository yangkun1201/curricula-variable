package com.xxj.curriculavariable.service;

import com.xxj.curriculavariable.entity.Course;

import java.util.List;

public interface CourseService {
    // 处理课程分页业务
    public List<Course> sortPage(int page);

    // 获取页数
    public int getNumber();

    //创建课程
    public String insertService(String c_id,String c_name,String c_room,String c_time,int c_point,String c_teacher);


}
