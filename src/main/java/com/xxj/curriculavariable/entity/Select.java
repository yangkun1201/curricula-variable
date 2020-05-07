package com.xxj.curriculavariable.entity;

import java.io.Serializable;

public class Select implements Serializable {
    private String s_id;
    private String c_id;
//    private String status;

    public Select(){}

    public Select(String s_id, String c_id) {
        this.s_id = s_id;
        this.c_id = c_id;
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

//    public String getStatus() { return status; }
//
//    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Select{" +
                "s_id='" + s_id + '\'' +
                ", c_id='" + c_id + '\'' +
//                ",status='"+status+
                '}';
    }
}