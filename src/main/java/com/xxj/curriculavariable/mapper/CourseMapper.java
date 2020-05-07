package com.xxj.curriculavariable.mapper;

import com.xxj.curriculavariable.entity.Course;
import com.xxj.curriculavariable.entity.Vcourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    // 查询所有记录
    public List<Course> selectAll();

    // 根据id查询记录
    public Course selectById(String c_id);

    //根据教师和时间查询记录
    public Course selectByTime( @Param("c_time") String c_time,@Param("c_teacher") String c_teacher);

    //根据c_teacher查询记录
    public List<Course> selectByTeacher(String c_teacher);

    //根据c_name查询记录
    public Course selectByName(String c_name);

    //删除课程
    public boolean deleteCourse(String c_id);

    //创建课程
    public boolean insertCourse(@Param("c_id") String c_id, @Param("c_name") String c_name,  @Param("c_room") String c_room,  @Param("c_time") String c_time, @Param("c_point") int c_point,@Param("c_teacher") String c_teacher);

    //修改课程信息
    public boolean updateCourse(@Param("c_id") String c_id, @Param("c_name") String c_name,  @Param("c_room") String c_room,  @Param("c_time") String c_time, @Param("c_point") int c_point,@Param("c_teacher") String c_teacher);

    List<Vcourse> select(String c_teacher);

    Integer updateFlag(@Param("c_id")String c_id, @Param("s_id")String s_id,@Param("isFlag") int isFlag);

    void deleteSelect(String c_id);
}
