package com.xxj.curriculavariable.controller;

import com.xxj.curriculavariable.entity.Course;
import com.xxj.curriculavariable.entity.User;
import com.xxj.curriculavariable.entity.Vcourse;
import com.xxj.curriculavariable.service.SelectService;
import com.xxj.curriculavariable.service.UserService;
import com.xxj.curriculavariable.service.CourseService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CreatePageController {
    @Resource
    private UserService userService;

    @Resource
    private CourseService courseService;

    @Resource
    private SelectService selectService;

    //请求访问学生首页
    @RequestMapping("/studentIndex")
    public String studentIndex(javax.servlet.http.HttpServletRequest request){
        updatePageInfo((HttpServletRequest) request);
        return "student/index";
    }

    //请求访问教师首页
    @RequestMapping("/teacherIndex")
    public String teacherIndex(javax.servlet.http.HttpServletRequest request){
        updatePageInfo2((HttpServletRequest) request);
        return "teacher/index";
    }
    //请求访问学生个人中心
    @RequestMapping("/studentInfo")
    public String studentInfo(javax.servlet.http.HttpServletRequest request){
        updatePageInfo((HttpServletRequest) request);
        return "student/info";
    }

    //请求访问教师个人中心
    @RequestMapping("/teacherInfo")
    public String teacherInfo(javax.servlet.http.HttpServletRequest request){
        updatePageInfo2((HttpServletRequest) request);
        return "teacher/info";
    }

    //请求教师创建课程页面
    @RequestMapping("/courseInsert")
    public String courseInsert(javax.servlet.http.HttpServletRequest request){
        updatePageInfo3((HttpServletRequest) request);
        return "teacher/insert";
    }


    // 请求课程分页显示
    @RequestMapping("/course")
    public String course(@RequestParam("page") int page, javax.servlet.http.HttpServletRequest request){
        HttpSession session = null;
        try{
            session = request.getSession();
            List<Course> list = courseService.sortPage(page);
            int number = courseService.getNumber();
            session.setAttribute("course",list);
            session.setAttribute("number",number);
        }catch (Exception e){
            e.printStackTrace();
        }finally {}
        return "student/course";
    }

    //请求教师课题分页显示
    @RequestMapping("/course1")
    public String course1(@RequestParam("page") int page, javax.servlet.http.HttpServletRequest request){
        HttpSession session = null;
        try{
            session = request.getSession();
            User teacher = (User) session.getAttribute("teacher");
            String c_teacher=teacher.getUsername();
            List<Course> list = courseService.sortPage2(page,c_teacher);
            int number = courseService.getNumber();
            session.setAttribute("course",list);
            session.setAttribute("number",number);
        }catch (Exception e){
            e.printStackTrace();
        }finally {}
        return "teacher/course";
    }

    // 请求显示已选课程
    @RequestMapping("/select")
    public String select(javax.servlet.http.HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            User student = (User) session.getAttribute("student");
            List<Vcourse> list = selectService.selectCourse2(student.getId());
            session.setAttribute("select",list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {}
        return "student/select";
    }


    //学生更新页面
    public void updatePageInfo(HttpServletRequest request){
        try {
            HttpSession session=request.getSession();
            String id=((User)session.getAttribute("student")).getId();
            User student=userService.getUser(id);
            session.setAttribute("student",student);
        }catch (Exception e){
            e.printStackTrace();
        }finally {}
    }

    //教师更新页面
    public void updatePageInfo2(HttpServletRequest request){
        try {
            HttpSession session=request.getSession();
            String id=((User)session.getAttribute("teacher")).getId();
            User teacher=userService.getUser(id);
            session.setAttribute("teacher",teacher);
        }catch (Exception e){
            e.printStackTrace();
        }finally {}
    }

    //课程更新页面
    public void updatePageInfo3(HttpServletRequest request){
        try {
            HttpSession session=request.getSession();

        }catch (Exception e){
            e.printStackTrace();
        }finally {}
    }
}
