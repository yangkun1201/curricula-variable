package com.xxj.curriculavariable.entity;

public class User {
    private String id;
    private String username;
    private String password;
    private String usertype;
    private String gender;
    private String major;
    private int point;

    public User(){}

    public User(String id,String username,String password,String usertype,String gender,String major,int point){
        this.id=id;
        this.username=username;
        this.password=password;
        this.usertype=usertype;
        this.gender=gender;
        this.major=major;
        this.point=point;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() { return usertype; }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getMajor() { return major; }

    public void setMajor(String major) { this.major = major; }

    public int getPoint(){return point;}

    public void setPoint(){this.point=point;}

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ",gender='"+gender+'\''+
                ",major'+"+major+'\''+
                ",point+"+point+'\''+
                '}';
    }
}

