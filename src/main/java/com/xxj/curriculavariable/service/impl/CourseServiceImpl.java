package com.xxj.curriculavariable.service.impl;

import com.xxj.curriculavariable.entity.Course;
import com.xxj.curriculavariable.entity.Vcourse;
import com.xxj.curriculavariable.mapper.CourseMapper;
import com.xxj.curriculavariable.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public List<Course> sortPage(int page) {
        List<Course> list = null;
        List<Course> newlist = new ArrayList<>();
        try {
            list=courseMapper.selectAll();
            int start=(page-1)*5;
            for(int i=start;i<start+5;i++){
                if(i>=list.size())
                {break;}
                newlist.add(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {}
        return newlist;
    }

    @Override
    public List<Course> sortPage2(int page,String c_teacher) {
        List<Course> list = null;
        List<Course> newlist = new ArrayList<>();
        try {
            list=courseMapper.selectByTeacher(c_teacher);
            int start=(page-1)*5;
            for(int i=start;i<start+5;i++){
                if(i>=list.size())
                {break;}
                newlist.add(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {}
        return newlist;
    }


    @Override
    public String insertService(String c_id,String c_name,String c_room,String c_time,int c_point,String c_teacher){
        try{
            Course ch=courseMapper.selectByName(c_name);
            Course ch2=courseMapper.selectByTime(c_time,c_teacher);
            if(ch!=null)
            {
                return "duplicate";
            }
            if(ch2!=null)
            {
                return "conflict";
            }
            courseMapper.insertCourse(c_id,c_name,c_room,c_time,c_point,c_teacher);

        }catch (Exception e){
            e.printStackTrace();
            return "no";
        }
        return "success";
    }

    @Override
    public String updateService(String c_id,String c_name,String c_room,String c_time,int c_point,String c_teacher){
        try{
            courseMapper.updateCourse(c_id,c_name,c_room,c_time,c_point,c_teacher);
        }catch (Exception e){
            e.printStackTrace();
            return "no";
        }
        return "success";
    }

    @Override
    public List<Vcourse> selectPage(int page, String c_teacher) {
        List<Vcourse> list = null;
        List<Vcourse> newlist = new ArrayList<>();
        try {
            list=courseMapper.select(c_teacher);
            int start=(page-1)*5;
            for(int i=start;i<start+5;i++){
                if(i>=list.size())
                {break;}
                newlist.add(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {}
        return newlist;
    }

    @Override
    public int getNumber_select(String c_teacher) {
        return (courseMapper.select(c_teacher).size()-1)/5;
    }

    @Override
    public String checkCourse(String c_id, String s_id,int isFlag) {
        return courseMapper.updateFlag(c_id,s_id,isFlag) == 0 ? "no" : "success";
    }

    @Override
    public String deleteService(String c_id,String c_name,String c_room,String c_time,int c_point,String c_teacher){
        try{
            courseMapper.deleteCourse(c_id);
            courseMapper.deleteSelect(c_id);
        }catch (Exception e){
            e.printStackTrace();
            return "no";
        }
        return "success";
    }

    @Override
    public int getNumber() {
        List<Course> list = null;
        try{
            list = courseMapper.selectAll();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return ((list.size()-1)/5);
    }

}
