package com.xxj.curriculavariable.controller;

import com.xxj.curriculavariable.entity.*;
import com.xxj.curriculavariable.service.FileUploadRecordService;
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

    @Resource
    private FileUploadRecordService fileUploadRecordService;

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

    //请求添加用户界面
    @RequestMapping("/memberInsert")
    public String memberInsert(javax.servlet.http.HttpServletRequest request){
        updatePageInfo3((HttpServletRequest) request);
        return "admin/insert";
    }


    // 请求学生课程分页显示
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

    // 请求用户列表分页显示
    @RequestMapping("/member")
    public String member(@RequestParam("page") int page, javax.servlet.http.HttpServletRequest request){
        HttpSession session = null;
        try{
            session = request.getSession();
            List<User> list = userService.queryUser(page);
            int number = userService.getNumber();
            session.setAttribute("member",list);
            session.setAttribute("number",number);
        }catch (Exception e){
            e.printStackTrace();
        }finally {}
        return "admin/member";
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

    // 请求显示学生已选课程
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

    //请求显示教师审核课题界面
    @RequestMapping("/check")
    public String check(@RequestParam("page") int page,javax.servlet.http.HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            User teacher = (User) session.getAttribute("teacher");
            String c_teacher=teacher.getId();
            List<Vcourse> list = courseService.selectPage(page,c_teacher);
            int number = courseService.getNumber_select(c_teacher);
            session.setAttribute("select",list);
            session.setAttribute("number",number);
        }catch (Exception e){
            e.printStackTrace();
        }finally {}
        return "teacher/check";
    }

    //学生上传课题报告页面
    @RequestMapping("/uploding")
    public String uploding(){
        return "student/upload";
    }

    //教师查看学生课题报告界面
    @RequestMapping("/fileUploadRecord1")
    public String fileUploadRecord1(@RequestParam("page") int page, javax.servlet.http.HttpServletRequest request){
        HttpSession session = null;
        try{
            session = request.getSession();
            User teacher = (User) session.getAttribute("teacher");
            String c_teacher=teacher.getUsername();
            List<FileUploadRecord> list =fileUploadRecordService.sortPage(page,c_teacher);
            int number = fileUploadRecordService.getNumber();
            session.setAttribute("fileUploadRecord",list);
            session.setAttribute("number",number);
        }catch (Exception e){
            e.printStackTrace();
        }finally {}
        return "teacher/download";
    }

    //请求显示教师审核课题界面
    @RequestMapping("/grade1")
    public String grade1(@RequestParam("page") int page,javax.servlet.http.HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            User teacher = (User) session.getAttribute("teacher");
            String c_teacher=teacher.getId();
            List<Vcourse> list = courseService.selectPage(page,c_teacher);
            int number = courseService.getNumber_select(c_teacher);
            session.setAttribute("vcourse",list);
            session.setAttribute("number",number);
        }catch (Exception e){
            e.printStackTrace();
        }finally {}
        return "teacher/grade";
    }

    //教师下载课题报告界面
    @RequestMapping("/downloding")
    public String downloding(@RequestParam("page") int page,javax.servlet.http.HttpServletRequest request){
        try {
        }catch (Exception e){
            e.printStackTrace();
        }
        return "teacher/download";
    }
    //教师给学生评分界面
    @RequestMapping("/graded")
    public String graded(@RequestParam("page") int page,javax.servlet.http.HttpServletRequest request){
        try {
        }catch (Exception e){
            e.printStackTrace();
        }
        return "teacher/grade";
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
