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
    String login( String username,String password);

}


