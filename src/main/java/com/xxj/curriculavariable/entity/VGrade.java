package com.xxj.curriculavariable.entity;

public class VGrade extends Grade {
    private String cName;
    private String sName;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "VGrade{" +
                "cName='" + cName + '\'' +
                ", sName='" + sName + '\'' +
                ", cId=" + cId +
                ", sId=" + sId +
                ", grade=" + grade +
                '}';
    }
}
