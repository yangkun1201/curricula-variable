package com.xxj.curriculavariable.entity;

public class Vcourse {
    private String s_id;
    private String c_id;
    private String c_name;
    private String c_room;
    private String c_time;
    private int c_point;
    private String c_teacher;
    private Integer isFlag;
    private String s_name;
    private Integer grade;

    public Vcourse(){}

    public Vcourse(Course course){
        this.c_id = course.getC_id();
        this.c_name = course.getC_name();
        this.c_room = course.getC_room();
        this.c_time = course.getC_time();
        this.c_point = course.getC_point();
        this.c_teacher=course.getC_teacher();
    }

    public Vcourse(String c_id, String c_name, String c_room, String c_time, int c_point,String c_teacher) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_room = c_room;
        this.c_time = c_time;
        this.c_point = c_point;
        this.c_teacher=c_teacher;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_room() {
        return c_room;
    }

    public void setC_room(String c_room) {
        this.c_room = c_room;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public int getC_point() {
        return c_point;
    }

    public void setC_point(int c_point) {
        this.c_point = c_point;
    }

    public String getC_teacher(){return c_teacher;}

    public void setC_teacher(String c_teacher){this.c_teacher=c_teacher;}

    @Override
    public String toString() {
        return "Vcourse{" +
                "c_id='" + c_id + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_room='" + c_room + '\'' +
                ", c_time='" + c_time + '\'' +
                ", c_point=" + c_point +'\''+
                ", c_teacher"+ c_teacher+
                '}';
    }
    public Integer getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(Integer isFlag) {
        this.isFlag = isFlag;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Integer getGrade(){return grade;}

    public void setGrade(Integer grade){this.grade = grade; }
}
