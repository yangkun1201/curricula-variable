package com.xxj.curriculavariable.mapper;

import com.xxj.curriculavariable.entity.Course;

import java.util.List;

public interface CourseMapper {

    // 查询所有记录
    public List<Course> selectAll();

    // 根据id查询记录
    public Course selectById(String c_id);
}
