package com.xxj.curriculavariable.mapper;

import com.xxj.curriculavariable.entity.course;

import java.util.List;

public interface courseMapper {

    // 查询所有记录
    public List<course> selectAll();

    // 根据id查询记录
    public course selectById(String c_id);
}
