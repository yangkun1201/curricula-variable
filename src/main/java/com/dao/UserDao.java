package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserDao {
    Integer insertUser(User user);
    Integer updateUser(User user);
    Integer deleteUserById(Integer id);
    User queryUserByUserId(Integer id);
    List<User> queryAllUserList();
    Integer insertBatchUserList(List<User> list);
    Map queryUserMap(Integer userId);
}
