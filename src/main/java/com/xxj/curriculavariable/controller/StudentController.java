package com.xxj.curriculavariable.controller;

import com.xxj.curriculavariable.entity.Select;
import com.xxj.curriculavariable.entity.User;
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
public class StudentController {

    @Resource
    private UserService userService;

    @Resource
    private SelectService selectService;

    //修改个人信息
    @RequestMapping(value = "/updateStudentInfo", method = RequestMethod.POST)
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
            String id = ((User) session.getAttribute("student")).getId();
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

    //选课操作
    @RequestMapping(value = "/selectCourse",method = RequestMethod.POST)
    public void selectCourse(@RequestParam(value = "id",required = false) String c_id,
                             @RequestParam(value = "point",required = false) int point,
                             HttpServletRequest request,HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            HttpSession session = request.getSession();
            String s_id = ((User)session.getAttribute("student")).getId();
            String result = selectService.selectCourse(new Select(s_id,c_id,point));

            out.print(result);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 修改积分操作
    @RequestMapping(value = "/updatePoint",method = RequestMethod.POST)
    public void updatePoint(@RequestParam(value = "id") String c_id,
                            @RequestParam(value = "point") int point,
                            HttpServletRequest request,HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            HttpSession session = request.getSession();
            String s_id = ((User)session.getAttribute("student")).getId();
            Select select = new Select(s_id,c_id,point);
            selectService.updatePoint(select);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 退课操作
    @RequestMapping(value = "/removeSelect",method = RequestMethod.POST)
    public void removeSelect(@RequestParam(value = "id",required = false) String c_id,
                             HttpServletRequest request,HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            HttpSession session = request.getSession();
            String s_id = ((User)session.getAttribute("student")).getId();
            selectService.removeCourse(s_id,c_id);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}

    }
}
