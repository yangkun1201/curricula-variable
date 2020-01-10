package com.xxj.curriculavariable.controller;

import com.xxj.curriculavariable.entity.User;
import com.xxj.curriculavariable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    @ResponseBody  //因为返回给AJAX处理,所以加这个注解,把返回的"ino"变成json格式
    public String login(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("这里实现登陆校验");
        System.out.println("username: "+username);
        System.out.println("password: "+password);
        //todo 这里实现验证密码的功能
        //这里的返回数据需要自己设计
        //现在默认
        return "ino";
    }


    @RequestMapping("/index")
    public String index(){
        System.out.println("调转登陆页面");
        return "login/login";
    }
}
