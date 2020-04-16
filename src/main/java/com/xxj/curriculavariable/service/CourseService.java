package com.xxj.curriculavariable.service;

import com.xxj.curriculavariable.entity.Course;
import com.xxj.curriculavariable.entity.Vcourse;

import java.util.List;

public interface CourseService {
    // 处理课程分页业务
    public List<Course> sortPage(int page);

    // 处理课程分页业务
    public List<Course> sortPage2(int page,String c_teacher);

    // 获取页数
    public int getNumber();

    //创建课程
    public String insertService(String c_id,String c_name,String c_room,String c_time,int c_point,String c_teacher);

    //删除课程
    public String deleteService(String c_id,String c_name,String c_room,String c_time,int c_point,String c_teacher);
    //修改课程
    public String updateService(String c_id,String c_name,String c_room,String c_time,int c_point,String c_teacher);

    List<Vcourse> selectPage(int page, String c_teacher);

    int getNumber_select(String c_teacher);

    String checkCourse(String c_id, String s_id);
}
