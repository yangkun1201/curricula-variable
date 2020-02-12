// 修改教师信息
function update_teacherInfo(data) {
    $.ajax({
        method:"POST",
        type:"POST",
        url:"/updateTeacherInfo",
        data:data,
        success:function (msg) {
            if(msg=="success"){
                dialog("修改信息成功！");
            }else{
                dialog("修改信息失败！");
            }
        },error:function () {
            dialog("ajax出错！");
        }
    });
}

//创建课程
function insert_courseInfo(data) {
    $.ajax({
        method:"POST",
        type:"POST",
        url:"/insertCourseInfo",
        data:data,
        success:function (msg) {
            if(msg=="success"){
                dialog("添加课程成功！");
            }else if(msg=="duplicate"){
                dialog("课程编号已存在！");
            }else{
                dialog("添加课程失败！")
            }
        },error:function () {
            dialog("ajax出错！");
        }
    });
}