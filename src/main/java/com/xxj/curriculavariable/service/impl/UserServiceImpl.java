package com.xxj.curriculavariable.service.impl;

import com.xxj.curriculavariable.mapper.UserMapper;
import com.xxj.curriculavariable.entity.User;
import com.xxj.curriculavariable.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User>queryAllUserList(){
        return userMapper.queryAllUserList();
    }
}
