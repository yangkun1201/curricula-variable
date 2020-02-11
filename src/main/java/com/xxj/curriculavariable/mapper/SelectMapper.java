package com.xxj.curriculavariable.mapper;

import com.xxj.curriculavariable.entity.Select;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SelectMapper {
    // 插入一条记录
    public void insert(Select select);
    // 查询操作
    public Select selects(@Param("s_id") String s_id, @Param("c_id") String c_id);
    // 根据学生id查询
    public List<Select> selectBySid(String s_id);
    // 修改积分
    public void updatePoint(Select select);
    // 删除一条记录
    public void delete(@Param("s_id") String s_id, @Param("c_id") String c_id);
}
