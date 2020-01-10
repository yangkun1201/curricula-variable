package com.xxj.curriculavariable.mapper;

import com.xxj.curriculavariable.entity.User;


import java.util.List;
import java.util.Map;


public interface UserMapper {

    Integer insertUser(User user);

    Integer updateUser(User user);

    Integer deleteUserById(Integer id);

    User queryUserByUserId(Integer id);

    List<User> queryAllUserList();

    Integer insertBatchUserList(List<User> list);

    Map queryUserMap(Integer userId);
}
