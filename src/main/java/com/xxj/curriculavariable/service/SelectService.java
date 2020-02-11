package com.xxj.curriculavariable.service;

import com.xxj.curriculavariable.entity.Select;
import com.xxj.curriculavariable.entity.Vcourse;

import java.util.List;

public interface SelectService {
    // 处理选课业务
    public String selectCourse(Select select);
    // 修改积分业务
    public boolean updatePoint(Select select);
    // 处理课程查询业务
    public List<Vcourse> selectCourse2(String s_id);
    // 退课业务
    public boolean removeCourse(String s_id, String c_id);
}
