package com.xxj.curriculavariable.controller;

import com.xxj.curriculavariable.entity.User;
import com.xxj.curriculavariable.service.CourseService;
import com.xxj.curriculavariable.service.SelectService;
import com.xxj.curriculavariable.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class TeacherController {
    @Resource
    private UserService userService;

    @Resource
    private CourseService courseService;

    //修改个人信息
    @RequestMapping(value = "/updateTeacherInfo", method = RequestMethod.POST)
    public void updateStudentInfo(@RequestParam(value = "userName",required = false) String userName,
                                  @RequestParam(value = "password",required = false) String password,
                                  @RequestParam(value = "gender",required = false) String gender,
                                  @RequestParam(value = "major",required = false) String major,
                                  HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = null;
        PrintWriter out = null;
        try {
            out = response.getWriter();
            session = request.getSession();
            String id = ((User) session.getAttribute("teacher")).getId();
            boolean ch = userService.updateService(id,userName,password, gender, major);
            if(ch) { out.print("success");}
            else{ out.print("error");}
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        out.close();
    }

    //创建课程信息
    @RequestMapping(value = "/insertCourseInfo", method = RequestMethod.POST)
    public void  insertCourseInfo(@RequestParam(value = "c_id",required = false) String c_id,
                                  @RequestParam(value = "c_name",required = false) String c_name,
                                  @RequestParam(value = "c_room",required = false) String c_room,
                                  @RequestParam(value = "c_time",required = false) String c_time,
                                  @RequestParam(value = "c_point",required = false) int c_point,
                                  @RequestParam(value = "c_teacher",required = false) String c_teacher,
                                  HttpServletRequest request,HttpServletResponse response){
        HttpSession session=null;

        PrintWriter out=null;
        try {
            out = response.getWriter();
            session=request.getSession();
            String ch=courseService.insertService(c_id,c_name,c_room,c_time,c_point,c_teacher);
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

    //修改课程信息
    @RequestMapping(value = "/updateCourseInfo", method = RequestMethod.POST)
    public void  updateCourseInfo(@RequestParam(value = "c_id",required = false) String c_id,
                                  @RequestParam(value = "c_name",required = false) String c_name,
                                  @RequestParam(value = "c_room",required = false) String c_room,
                                  @RequestParam(value = "c_time",required = false) String c_time,
                                  @RequestParam(value = "c_point",required = false) int c_point,
                                  @RequestParam(value = "c_teacher",required = false) String c_teacher,
                                  HttpServletRequest request,HttpServletResponse response){
        HttpSession session=null;

        PrintWriter out=null;
        try {
            out = response.getWriter();
            session=request.getSession();
            String ch=courseService.updateService(c_id,c_name,c_room,c_time,c_point,c_teacher);
            if(ch=="success") { out.print("success");}
            else if(ch=="duplicate"){out.print("duplicate");}
            else {out.print("no");}
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        out.close();
    }

    //删除课程
    @RequestMapping(value = "/deleteCourseInfo", method = RequestMethod.POST)
    public void  deleteCourseInfo(@RequestParam(value = "c_id",required = false) String c_id,
                                  @RequestParam(value = "c_name",required = false) String c_name,
                                  @RequestParam(value = "c_room",required = false) String c_room,
                                  @RequestParam(value = "c_time",required = false) String c_time,
                                  @RequestParam(value = "c_point",required = false) int c_point,
                                  @RequestParam(value = "c_teacher",required = false) String c_teacher,
                                  HttpServletRequest request,HttpServletResponse response){
        HttpSession session=null;
        PrintWriter out=null;
        try {
            out = response.getWriter();
            session=request.getSession();
            String ch=courseService.deleteService(c_id,c_name,c_room,c_time,c_point,c_teacher);
            if(ch=="success") { out.print("success");}
            else {out.print("no");}
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        out.close();
    }

    //审核课程
    @RequestMapping(value = "/checkCourse", method = RequestMethod.POST)
    public void  deleteCourseInfo(@RequestParam(value = "c_id",required = false) String c_id,
                                  @RequestParam(value = "s_id",required = false) String s_id,
                                  HttpServletRequest request,HttpServletResponse response){
        HttpSession session=null;
        PrintWriter out=null;
        try {
            out = response.getWriter();
            session=request.getSession();
            String ch=courseService.checkCourse(c_id,s_id);
            if(ch=="success") { out.print("success");}
            else {out.print("no");}
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        out.close();
    }


}
