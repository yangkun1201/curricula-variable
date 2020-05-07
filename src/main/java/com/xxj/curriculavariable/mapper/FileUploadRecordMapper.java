package com.xxj.curriculavariable.mapper;

import com.xxj.curriculavariable.entity.FileUploadRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileUploadRecordMapper {

    boolean addRecord(FileUploadRecord fileUploadRecord);

    // 查询所有记录
    public List<FileUploadRecord> selectAll();


}
