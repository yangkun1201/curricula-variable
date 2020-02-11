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

    //请求访问学生个人中心
    @RequestMapping("/studentInfo")
    public String studentInfo(javax.servlet.http.HttpServletRequest request){
        updatePageInfo((HttpServletRequest) request);
        return "student/info";
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


    //更新页面
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
}
