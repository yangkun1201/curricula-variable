package com.xxj.curriculavariable.service.impl;

import com.xxj.curriculavariable.entity.User;
import com.xxj.curriculavariable.entity.Select;
import com.xxj.curriculavariable.entity.Vcourse;
import com.xxj.curriculavariable.mapper.SelectMapper;
import com.xxj.curriculavariable.mapper.UserMapper;
import com.xxj.curriculavariable.mapper.CourseMapper;
import com.xxj.curriculavariable.service.SelectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SelectServiceImpl implements SelectService {
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private SelectMapper selectMapper;

    @Override
    public String selectCourse(Select select) {
        try{
            User student = userMapper.selectById(select.getS_id());
            if(select.getPoint()>student.getPoint()) return "npoint";
            if(selectMapper.selects(select.getS_id(),select.getC_id())!=null) return "no";
            userMapper.reducePoint(select.getS_id(),select.getPoint());
            selectMapper.insert(select);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @Override
    public boolean updatePoint(Select select) {
        try{
            int old = selectMapper.selects(select.getS_id(),select.getC_id()).getPoint();
            if(old<select.getPoint()){
                int newpoint = select.getPoint()-old;
                userMapper.reducePoint(select.getS_id(),newpoint);
            }
            if(old>select.getPoint()){
                int newpoint = old-select.getPoint();
                userMapper.plusPoint(select.getS_id(),newpoint);
            }

            selectMapper.updatePoint(select);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean removeCourse(String s_id, String c_id) {
        try{
            int point = selectMapper.selects(s_id,c_id).getPoint();
            userMapper.plusPoint(s_id,point);
            selectMapper.delete(s_id,c_id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Vcourse> selectCourse2(String s_id) {
        List<Select> list = null;
        List<Vcourse> list2 = null;
        try{
            list = selectMapper.selectBySid(s_id);
            list2 = new ArrayList<>();
            Vcourse p = null;
            for(Select e : list){
                p = new Vcourse(courseMapper.selectById(e.getC_id()),e.getPoint());
                list2.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {}
        return list2;
    }

}
