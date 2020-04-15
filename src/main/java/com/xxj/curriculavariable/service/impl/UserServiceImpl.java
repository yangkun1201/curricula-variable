package com.xxj.curriculavariable.service.impl;

import com.xxj.curriculavariable.entity.Course;
import com.xxj.curriculavariable.mapper.UserMapper;
import com.xxj.curriculavariable.entity.User;
import com.xxj.curriculavariable.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User>queryAllUserList(){
        return userMapper.queryAllUserList();
    }

    @Override
    public User login(String id,String password){
        return userMapper.login(id,password);
    }

    @Override
    public User getUser(String id){
        User user=null;
        try {
            user=userMapper.selectById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
        public boolean updateService(String id,String userName,String password,String gender,String major){
        try{
            userMapper.updateByID(id,userName,password,gender,major);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String insertUserInfo(String c_name, String c_id, String c_pwd, String c_sex, String c_type, String c_major) {
        try{
            User ch=userMapper.selectByName(c_name);
            User ch2=userMapper.selectById(c_id);
            if(ch!=null)
            {
                return "duplicate";
            }
            if(ch2!=null)
            {
                return "conflict";
            }
            User user = new User();
            user.setId(c_id);
            user.setUsername(c_name);
            user.setGender(c_sex);
            user.setUsertype(c_type);
            user.setMajor(c_major);
            user.setPassword(c_pwd);
            userMapper.insertUser(user);

        }catch (Exception e){
            e.printStackTrace();
            return "no";
        }
        return "success";
    }

    @Override
    public List<User> queryUser(int page) {
        List<User> list = null;
        List<User> newlist = new ArrayList<>();
        try {
            list=userMapper.queryUser();
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
    public int getNumber() {
        return (userMapper.getNumber()-1)/5;
    }

    @Override
    public String deleteById(String c_id) {
        return userMapper.deleteUserById(c_id)==1?"success":"no";
    }

    @Override
    public String updateUserInfo(String c_name, String c_id, String c_pwd, String c_sex, String c_type, String c_major, int c_point) {
        try{
            User ch=userMapper.selectByName(c_name);
            if(ch!=null&&!ch.getId().equals(c_id))
            {
                return "duplicate";
            }
            User user = new User();
            user.setId(c_id);
            user.setUsername(c_name);
            user.setGender(c_sex);
            user.setUsertype(c_type);
            user.setMajor(c_major);
            user.setPassword(c_pwd);
            user.setPoint(c_point);
            userMapper.updateUserInfo(user);

        }catch (Exception e){
            e.printStackTrace();
            return "no";
        }
        return "success";
    }

}
