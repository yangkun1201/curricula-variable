package com.xxj.curriculavariable.service.impl;

import com.xxj.curriculavariable.entity.Course;
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
    public String insertService(String c_id,String c_name,String c_room,String c_time,int c_point,String c_teacher){
        try{
            Course ch=courseMapper.selectById(c_id);
            if(ch!=null)
            {
                return "duplicate";
            }
            courseMapper.insertCourse(c_id,c_name,c_room,c_time,c_point,c_teacher);

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
        return (list.size()/5);
    }

}
