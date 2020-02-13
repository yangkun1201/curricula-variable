package com.xxj.curriculavariable.mapper;

import com.xxj.curriculavariable.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    // 查询所有记录
    public List<Course> selectAll();

    // 根据id查询记录
    public Course selectById(String c_id);

    //创建课程
    public boolean insertCourse(@Param("c_id") String c_id, @Param("c_name") String c_name,  @Param("c_room") String c_room,  @Param("c_time") String c_time, @Param("c_point") int c_point,@Param("c_teacher") String c_teacher);
}
