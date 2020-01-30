package com.xxj.curriculavariable.service.impl;

import com.xxj.curriculavariable.entity.course;
import com.xxj.curriculavariable.mapper.courseMapper;
import com.xxj.curriculavariable.service.courseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class courseServiceImpl implements  courseService{

    @Resource
    private courseMapper courseMapper;

    @Override
    public List<course> sortPage(int page) {
        List<course> list = null;
        List<course> newlist = new ArrayList<>();
        try {
            list=courseMapper.selectAll();
            int start=(page-1)*5;
            for(int i=start;i<start+5;i++){
                if(i>=list.size()) break;
                newlist.add(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {}
        return newlist;
    }

    @Override
    public int getNumber() {
        List<course> list = null;
        try{
            list = courseMapper.selectAll();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return (list.size()/5);
    }

}
