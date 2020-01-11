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
     * @param username
     * @param password
     * @return
     */
    User login( String username,String password);

}


