package com.xxj.curriculavariable.entity;

import java.io.Serializable;

public class Select implements Serializable {
    private String s_id;
    private String c_id;
    private int point;

    public Select(){}

    public Select(String s_id, String c_id, int point) {
        this.s_id = s_id;
        this.c_id = c_id;
        this.point = point;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Select{" +
                "s_id='" + s_id + '\'' +
                ", c_id='" + c_id + '\'' +
                ", point=" + point +
                '}';
    }
}