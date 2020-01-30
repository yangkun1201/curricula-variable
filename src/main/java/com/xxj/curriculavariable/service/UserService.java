package com.xxj.curriculavariable.service;

import com.xxj.curriculavariable.entity.User;
import com.xxj.curriculavariable.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> queryAllUserList();

    /**
     * 登录
     * @param id
     * @param password
     * @return
     */
    //处理登录业务
    User login( String id,String password);
    //获取一个对象
    public User getUser(String id);
    //修改学生信息业务
    public  boolean updateService(String id,String userName,String password,String gender,String major);
}


