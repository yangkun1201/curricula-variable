package com.xxj.curriculavariable.service;

import com.xxj.curriculavariable.entity.VGrade;

import java.util.List;

public interface GradeService {

    String addGrade(String c_id,String s_id,String grade);

    List<VGrade> getAllGrade();

}
