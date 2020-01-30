package com.xxj.curriculavariable.controller;

import com.xxj.curriculavariable.entity.User;
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

    //修改个人信息
    @RequestMapping(value = "/updateStudentInfo", method = RequestMethod.POST)
    public void updateStudentInfo(@RequestParam(value = "userName") String userName,
                                  @RequestParam(value = "password") String password,
                                  @RequestParam(value = "gender") String gender,
                                  @RequestParam(value = "major") String major,
                                  HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = null;
        PrintWriter out = null;
        try {
            out = response.getWriter();
            session = request.getSession();
            String id = ((User) session.getAttribute("student")).getId();
            boolean ch = userService.updateService(id,userName, gender, password, major);
            if (ch) out.print("success");
            else out.print("error");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        out.close();
    }
}
