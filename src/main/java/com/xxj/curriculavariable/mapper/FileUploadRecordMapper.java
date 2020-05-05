package com.xxj.curriculavariable.mapper;

import com.xxj.curriculavariable.entity.FileUploadRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileUploadRecordMapper {

    boolean addRecord(FileUploadRecord fileUploadRecord);

}
