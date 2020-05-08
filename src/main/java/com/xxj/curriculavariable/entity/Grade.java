package com.xxj.curriculavariable.entity;

public class Grade {
    int cId;
    int sId;
    int grade;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "cId=" + cId +
                ", sId=" + sId +
                ", grade=" + grade +
                '}';
    }
}
