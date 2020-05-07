package com.xxj.curriculavariable.service;

import com.xxj.curriculavariable.entity.FileUploadRecord;

import java.util.List;

public interface FileUploadRecordService {
    boolean addRecord(String userId,String name,String path);

    public List<FileUploadRecord> sortPage(int page, String c_teacher);
    // 获取页数
    public int getNumber();
}
