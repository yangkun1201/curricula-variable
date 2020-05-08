package com.xxj.curriculavariable.util;

import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    public static <T> void export(String excelName, List<T> list, LinkedHashMap<String, String> fieldMap, HttpServletResponse response) {

        // 设置默认文件名为当前时间：年月日时分秒
        if (excelName == null || excelName == "") {
            excelName = new SimpleDateFormat("yyyyMMddhhmmss").format(
                    new Date()).toString();
        }
        // 设置response头信息
        response.reset();
        response.setContentType("application/vnd.ms-excel"); // 改成输出excel文件
        try {
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String(excelName.getBytes("gb2312"), "ISO-8859-1") + ".xls");
        } catch (UnsupportedEncodingException e1) {

        }

        try {
            //创建一个WorkBook,对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            //在Workbook中，创建一个sheet，对应Excel中的工作薄（sheet）
            HSSFSheet sheet = wb.createSheet(excelName);
            for(int i=0;i<5;i++){
                sheet.setColumnWidth(i,10*256);
            }
            //创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = wb.createCellStyle();
            //创建一个居中格式
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            // 填充工作表
            fillSheet(sheet, list, fieldMap, style);

            //将文件输出
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
        }
    }

    public static <T> void fillSheet(HSSFSheet sheet, List<T> list,
                                     LinkedHashMap<String, String> fieldMap, HSSFCellStyle style) throws Exception {
        // 定义存放英文字段名和中文字段名的数组
        String[] enFields = new String[fieldMap.size()];
        String[] cnFields = new String[fieldMap.size()];

        // 填充数组
        int count = 0;
        for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
            enFields[count] = entry.getKey();
            cnFields[count] = entry.getValue();
            count++;
        }

        //在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);

        // 填充表头
        for (int i = 0; i < cnFields.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(cnFields[i]);
            cell.setCellStyle(style);
            //sheet.autoSizeColumn(i);
        }

        // 填充内容
        for (int index = 0; index < list.size(); index++) {
            row = sheet.createRow(index + 1);
            // 获取单个对象
            T item = list.get(index);
            for (int i = 0; i < enFields.length; i++) {
                Object objValue = getFieldValueByNameSequence(enFields[i], item);
                String fieldValue = objValue == null ? "" : objValue.toString();
                row.createCell(i).setCellValue(fieldValue);
            }
        }
    }

    public static Object getFieldValueByNameSequence(String fieldNameSequence,
                                                     Object o) throws Exception {
        Object value = null;
        // 将fieldNameSequence进行拆分
        String[] attributes = fieldNameSequence.split("\\.");
        if (attributes.length == 1) {
            value = getFieldValueByName(fieldNameSequence, o);
        } else {
            // 根据数组中第一个连接属性名获取连接属性对象，如student.department.name
            Object fieldObj = getFieldValueByName(attributes[0], o);
            //截取除第一个属性名之后的路径
            String subFieldNameSequence = fieldNameSequence
                    .substring(fieldNameSequence.indexOf(".") + 1);
            //递归得到最终的属性对象的值
            value = getFieldValueByNameSequence(subFieldNameSequence, fieldObj);
        }
        return value;
    }

    public static Field getFieldByName(String fieldName, Class<?> clazz) {
        // 拿到本类的所有字段
        Field[] selfFields = clazz.getDeclaredFields();

        // 如果本类中存在该字段，则返回
        for (Field field : selfFields) {
            //如果本类中存在该字段，则返回
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }

        // 否则，查看父类中是否存在此字段，如果有则返回
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null && superClazz != Object.class) {
            //递归
            return getFieldByName(fieldName, superClazz);
        }

        // 如果本类和父类都没有，则返回空
        return null;
    }

    /**
     * 根据字段名获取字段值
     *
     * @param fieldName 字段名
     * @param o         对象
     * @return 字段值
     * @throws Exception 异常
     */
    public static Object getFieldValueByName(String fieldName, Object o)
            throws Exception {

        Object value = null;
        //根据字段名得到字段对象
        Field field = getFieldByName(fieldName, o.getClass());

        //如果该字段存在，则取出该字段的值
        if (field != null) {
            field.setAccessible(true);//类中的成员变量为private,在类外边使用属性值，故必须进行此操作
            value = field.get(o);//获取当前对象中当前Field的value
        } else {
            throw new Exception(o.getClass().getSimpleName() + "类不存在字段名 "
                    + fieldName);
        }
        return value;
    }


}
