package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<User>queryAllUserList(){
        return userDao.queryAllUserList();
    }
}
