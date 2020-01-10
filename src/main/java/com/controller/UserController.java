package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/queryAllUserList")
    @ResponseBody
    public String queryAllUserList(){
        String s="";
        List<User> list=userService.queryAllUserList();
        for(User user:list){
            System.out.println(user.toString());
            s+=user.toString();
        }
        return s;
    }
}
