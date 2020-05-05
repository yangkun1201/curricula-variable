package com.xxj.curriculavariable.controller;

import com.xxj.curriculavariable.entity.Select;
import com.xxj.curriculavariable.entity.User;
import com.xxj.curriculavariable.service.FileUploadRecordService;
import com.xxj.curriculavariable.service.SelectService;
import com.xxj.curriculavariable.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class StudentController {

    @Resource
    private UserService userService;

    @Resource
    private SelectService selectService;

    @Resource
    private FileUploadRecordService fileUploadRecordService;

    private String filePath = System.getProperty("user.dir") + "/upload";

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
                             HttpServletRequest request,HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            HttpSession session = request.getSession();
            String s_id = ((User)session.getAttribute("student")).getId();
            String result = selectService.selectCourse(new Select(s_id,c_id));
            out.print(result);
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

    // 上传操作
    @RequestMapping(value = "/uploadProjectReport",method = RequestMethod.POST)
    public void uplodFile(HttpSession session,
                          HttpServletResponse response,
                          @RequestParam("name") String name,
                          @RequestParam("file") MultipartFile file){
        try {
            PrintWriter out = response.getWriter();
            //获取当前登录的用户信息
            User user = ((User) session.getAttribute("student"));
            //创建目录
            File savedPath = new File(filePath);
            if(!savedPath.exists()){
                savedPath.mkdir();
            }
            //存储文件
            File savedFile = new File(filePath,file.getOriginalFilename());
            if(!savedFile.exists()){
                savedFile.createNewFile();
            }
            file.transferTo(savedFile);
            //上传记录入库
            fileUploadRecordService.addRecord(user.getId(),name,"/upload/"+file.getOriginalFilename());
            out.print("success");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
