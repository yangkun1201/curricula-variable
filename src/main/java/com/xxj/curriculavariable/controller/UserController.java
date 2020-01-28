package com.xxj.curriculavariable.controller;

import com.xxj.curriculavariable.entity.User;
import com.xxj.curriculavariable.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/queryAllUserList")
    @ResponseBody
    public String queryAllUserList() {
        String s = "";
        List<User> list = userService.queryAllUserList();
        for (User user : list) {
            System.out.println(user.toString());
            s += user.toString();
        }
        return s;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody  //因为返回给AJAX处理,所以加这个注解,把返回的"ino"变成json格式
    public String login(@RequestParam("id") String id, @RequestParam("password") String password, HttpServletRequest request) {
        System.out.println("这里实现登陆校验");
        System.out.println("id: " + id);
        System.out.println("password: " + password);
        HttpSession session=request.getSession();
        //todo 这里实现验证密码的功能
        //这里的返回数据需要自己设计
        User user = userService.login(id, password);
        System.out.println(user.getPassword());
        if (user == null) {
            return "ino";
        } else if (password.equals(user.getPassword())) {
            if(user.getUsertype().equals("1")){
                User user1=userService.getUser(id);
                session.setAttribute("student",user1);
                return "s_success";
            }
            else if(user.getUsertype().equals("2")){ return "t_success";}
            else{return "a_success";}
        } else {
            return "pno";
        }
    }

    @RequestMapping("/index")
    public String index(){
        System.out.println("调转登陆页面");
        return "login/login";
    }

    @RequestMapping("/student")
    public String student(){
        System.out.println("调转学生界面");
        return "student/index";
    }

    @RequestMapping("/teacher")
    public String teacher(){
        System.out.println("调转教师界面");
        return "teacher/index";
    }

    @RequestMapping("/admin")
    public String admin(){
        System.out.println("调转管理员界面");
        return "admin/index";
    }
}
