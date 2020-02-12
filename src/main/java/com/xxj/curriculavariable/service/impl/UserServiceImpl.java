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

    @Override
    public User login(String id,String password){
        return userMapper.login(id,password);
    }

    @Override
    public User getUser(String id){
        User user=null;
        try {
            user=userMapper.selectById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
        public boolean updateService(String id,String userName,String password,String gender,String major){
        try{
            userMapper.updateByID(id,userName,password,gender,major);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
