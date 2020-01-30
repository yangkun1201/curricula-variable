package com.xxj.curriculavariable.service;

import com.xxj.curriculavariable.entity.course;

import java.util.List;

public interface courseService {
    // 处理课程分页业务
    public List<course> sortPage(int page);

    // 获取页数
    public int getNumber();
}
