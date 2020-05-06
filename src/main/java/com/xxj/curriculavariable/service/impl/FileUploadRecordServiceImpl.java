package com.xxj.curriculavariable.service.impl;

import com.xxj.curriculavariable.entity.FileUploadRecord;
import com.xxj.curriculavariable.mapper.FileUploadRecordMapper;
import com.xxj.curriculavariable.service.FileUploadRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<FileUploadRecord> sortPage(int page, String c_teacher) {
        List<FileUploadRecord> list = null;
        List<FileUploadRecord> newlist = new ArrayList<>();
        try {
            list=fileUploadRecordMapper.selectAll();
            int start=(page-1)*5;
            for(int i=start;i<start+5;i++){
                if(i>=list.size())
                {break;}
                newlist.add(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {}
        return newlist;
    }

    @Override
    public int getNumber() {
        List<FileUploadRecord> list = null;
        try{
            list = fileUploadRecordMapper.selectAll();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return ((list.size()-1)/5);
    }
}
