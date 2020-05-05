package com.xxj.curriculavariable.service.impl;

import com.xxj.curriculavariable.entity.FileUploadRecord;
import com.xxj.curriculavariable.mapper.FileUploadRecordMapper;
import com.xxj.curriculavariable.service.FileUploadRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class FileUploadRecordServiceImpl implements FileUploadRecordService {

    @Resource
    private FileUploadRecordMapper fileUploadRecordMapper;

    @Override
    public boolean addRecord(String userId, String name, String path) {
        FileUploadRecord fileUploadRecord = new FileUploadRecord();
        fileUploadRecord.setUserId(userId);
        fileUploadRecord.setName(name);
        fileUploadRecord.setPath(path);
        fileUploadRecord.setUploadTime(new Date());
        return fileUploadRecordMapper.addRecord(fileUploadRecord);
    }
}
