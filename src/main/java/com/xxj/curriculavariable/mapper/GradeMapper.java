package com.xxj.curriculavariable.mapper;

import com.xxj.curriculavariable.entity.Grade;
import com.xxj.curriculavariable.entity.VGrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GradeMapper {

    boolean addGrade(@Param("c_id") int c_id,@Param("s_id") int s_id,@Param("grade") int grade);

    List<Grade> getGrade(@Param("c_id") int c_id, @Param("s_id") int s_id);

    boolean updateGrate(@Param("c_id") int c_id,@Param("s_id") int s_id,@Param("grade") int grade);

    List<VGrade> getAllGrade();

}
