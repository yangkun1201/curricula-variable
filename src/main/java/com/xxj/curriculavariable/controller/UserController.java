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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
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
        if (user == null) {
            return "ino";
        } else if (password.equals(user.getPassword())) {
            if(user.getUsertype().equals("1")){
                User user1=userService.getUser(id);
                session.setAttribute("student",user1);
                return "s_success";
            }
            else if(user.getUsertype().equals("2")){
                User user2=userService.getUser(id);
                session.setAttribute("teacher",user2);
                return "t_success";
            }
            else {
                User user2=userService.getUser(id);
                session.setAttribute("admin",user2);
                return "a_success";
            }
        } else {
            return "pno";
        }
    }

    @RequestMapping({"/index",""})
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

    // 退出登录
    @RequestMapping("/exit")
    public String exit(javax.servlet.http.HttpServletRequest request){
        HttpSession session = null;
        try{
            session = request.getSession();
            String user = session.getAttribute("user").toString();
            session.removeAttribute(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {}
        return "login/login";
    }




    //删除用户
    @RequestMapping(value = "/delete_userInfo", method = RequestMethod.POST)
    public void  delete_userInfo(@RequestParam(value = "c_id",required = false) String c_id,
                                  javax.servlet.http.HttpServletRequest request, HttpServletResponse response){
        HttpSession session=null;

        PrintWriter out=null;
        try {
            out = response.getWriter();
            session=request.getSession();
            String ch=userService.deleteById(c_id);
            System.out.println(ch);
            if(ch=="success") {
                out.print("success");
            } else {
                out.print("no");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        out.close();
    }

    //添加用户信息var data = {"c_name":c_name,"c_id":c_id,"c_pwd":c_pwd,"c_sex":c_sex,"c_type":c_type};
    @RequestMapping(value = "/insert_memberInfo", method = RequestMethod.POST)
    public void  insertCourseInfo(@RequestParam(value = "c_name",required = false) String c_name,
                                  @RequestParam(value = "c_id",required = false) String c_id,
                                  @RequestParam(value = "c_pwd",required = false) String c_pwd,
                                  @RequestParam(value = "c_sex",required = false) String c_sex,
                                  @RequestParam(value = "c_type",required = false) String c_type,
                                  @RequestParam(value = "c_major",required = false) String c_major,
                                  javax.servlet.http.HttpServletRequest request, HttpServletResponse response){
        HttpSession session=null;

        PrintWriter out=null;
        try {
            out = response.getWriter();
            session=request.getSession();
            String ch=userService.insertUserInfo(c_name,c_id,c_pwd,c_sex,c_type,c_major);
            System.out.println(ch);
            if(ch=="success") { out.print("success");}
            else if(ch=="duplicate"){out.print("duplicate");}
            else if (ch =="conflict") { out.print("conflict");}
            else {
                out.print("no");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        out.close();
    }


    //修改用户信息var data = {"c_name":c_name,"c_id":c_id,"c_pwd":c_pwd,"c_sex":c_sex,"c_type":c_type};
    @RequestMapping(value = "/update_userInfo", method = RequestMethod.POST)
    public void  update_userInfo(@RequestParam(value = "c_name",required = false) String c_name,
                                  @RequestParam(value = "c_id",required = false) String c_id,
                                  @RequestParam(value = "c_pwd",required = false) String c_pwd,
                                  @RequestParam(value = "c_sex",required = false) String c_sex,
                                  @RequestParam(value = "c_type",required = false) String c_type,
                                  @RequestParam(value = "c_major",required = false) String c_major,
                                 @RequestParam(value = "c_point",required = false) int c_point,
                                  javax.servlet.http.HttpServletRequest request, HttpServletResponse response){
        HttpSession session=null;

        PrintWriter out=null;
        try {
            out = response.getWriter();
            session=request.getSession();
            String ch=userService.updateUserInfo(c_name,c_id,c_pwd,c_sex,c_type,c_major,c_point);
            System.out.println(ch);
            if(ch=="success") { out.print("success");}
            else if(ch=="duplicate"){out.print("duplicate");}
            else if (ch =="conflict") { out.print("conflict");}
            else {
                out.print("no");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        out.close();
    }
}
