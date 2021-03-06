package com.xxj.curriculavariable.entity;

public class Course {
    private String c_id;
    private String c_name;
    private String c_room;
    private String c_time;
    private int c_point;
    private String c_teacher;


    public Course(){}

    public Course(String c_id, String c_name, String c_room, String c_time, int c_point,String c_teacher) {
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

    public void setC_teacher(){this.c_teacher=c_teacher;}

    @Override
    public String toString() {
        return "Course{" +
                "c_id='" + c_id + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_room='" + c_room + '\'' +
                ", c_time='" + c_time + '\'' +
                ", c_point=" + c_point +'\''+
                ", c_teacher="+c_teacher+
                '}';
    }


}
