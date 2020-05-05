package com.xxj.curriculavariable.entity;

import java.util.Date;

public class FileUploadRecord {

    private int id;
    private String userId;
    private String name;
    private String path;
    private Date uploadTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "FileUploadRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
