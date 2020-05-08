package com.xxj.curriculavariable.service.impl;

import com.xxj.curriculavariable.entity.Grade;
import com.xxj.curriculavariable.entity.VGrade;
import com.xxj.curriculavariable.mapper.GradeMapper;
import com.xxj.curriculavariable.service.GradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Resource
    private GradeMapper gradeMapper;

    @Override
    public String addGrade(String c_id, String s_id, String grade) {
        String result = "";
        List<Grade> gradeList = gradeMapper.getGrade(Integer.valueOf(c_id),Integer.valueOf(s_id));
        if(gradeList.size() == 0){ //不存在，则插入
            result = gradeMapper.addGrade(Integer.valueOf(c_id),
                    Integer.valueOf(s_id),
                    Integer.valueOf(grade))
                    ? "success" : "no";
        }else{ //存在，则更新
            result = gradeMapper.updateGrate(Integer.valueOf(c_id),
                    Integer.valueOf(s_id),
                    Integer.valueOf(grade))
                    ? "success" : "no";
        }
        return result;
    }

    @Override
    public List<VGrade> getAllGrade() {
        List<VGrade> gradeList = gradeMapper.getAllGrade();
        return gradeList;
    }
}
