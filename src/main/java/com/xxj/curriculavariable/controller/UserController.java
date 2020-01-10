package com.xxj.curriculavariable.controller;

import com.xxj.curriculavariable.entity.User;
import com.xxj.curriculavariable.service.UserService;
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

    @RequestMapping("/login")
    public String login(){
        System.out.println("调转登陆页面");

        return "login/login";
    }

    @RequestMapping("/index")
    public String index(){
        System.out.println("sdcsf");
        return "xgg";
    }
}
