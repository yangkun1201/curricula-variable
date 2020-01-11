package com.xxj.curriculavariable.mapper;

import com.xxj.curriculavariable.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Component
public interface UserMapper {

    Integer insertUser(User user);

    Integer updateUser(User user);

    Integer deleteUserById(Integer id);

    User queryUserByUserId(Integer id);

    List<User> queryAllUserList();

    Integer insertBatchUserList(List<User> list);

    Map queryUserMap(Integer userId);

    User login(@Param("username")String username,@Param("password")String password);

}
