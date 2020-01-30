package com.xxj.curriculavariable.mapper;

import com.xxj.curriculavariable.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Component
public interface UserMapper {

    String insertUser(User user);

    //修改指定id的记录
    public void updateByID(@Param("userName")String userName,@Param("password") String password,
                           @Param("gender") String gender,@Param("major") String  major);

    String deleteUserById(String id);

    User queryUserByUserId(String id);

    List<User> queryAllUserList();

     User selectById(String id);

    Integer insertBatchUserList(List<User> list);

    Map queryUserMap(Integer userId);

    User login(@Param("id")String id,@Param("password")String password);

}
