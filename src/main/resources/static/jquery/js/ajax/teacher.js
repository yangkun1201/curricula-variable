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
                dialog("此课题已存在！");
            } else if(msg=="conflict"){
                dialog("该时间段已被占用！")
            } else{
                dialog("添加课程失败！")
            }
        },error:function () {
            dialog("ajax出错！");
        }
    });
}

//删除课程
function delete_courseInfo(data) {
    $.ajax({
        method: "POST",
        type: "POST",
        url: "/deleteCourseInfo",
        data: data,
        success: function (msg) {
            if (msg == "success") {
                dialog("下载成功！");
            }else {
                dialog("下载失败！")
            }
            window.location.href="/course1?page=1";
        }, error: function () {
            dialog("ajax出错！");
        }
    });
}

//修改课程信息
    function update_courseInfo(data) {
        $.ajax({
            method: "POST",
            type: "POST",
            url: "/updateCourseInfo",
            data: data,
            success: function (msg) {
                if (msg == "success") {
                    dialog("修改课题成功！");
                } else if (msg == "duplicate") {
                    dialog("课题编号已存在！");
                } else {
                    dialog("修改课题失败！")
                }
                window.location.href="/course1?page=1";
            }, error: function () {
                dialog("ajax出错！");
            }
        });
    }

//显示学生的上传报告
function watch_studentfiles(data) {
    $.ajax({
        method: "POST",
        type: "POST",
        url: "/watchStudentFiles",
        data: data,
        success: function (msg) {
            if (msg == "success") {
                dialog("下载成功！");
            }else {
                dialog("下载失败！")
            }
            window.location.href="/fileUpdateRecord?page=1";
        }, error: function () {
            dialog("ajax出错！");
        }
    });
}

//审核选题
function check(data) {
    $.ajax({
        method: "POST",
        type: "POST",
        url: "/checkCourse",
        data: data,
        success: function (msg) {
            if (msg == "success") {
                dialog("审核成功！");
            } else if (msg == "duplicate") {
                dialog("审核失败！");
            }
        }, error: function () {
            dialog("ajax出错！");
        }
    });
}

//下载文件
function downloadFile(path){
    path = window.location.origin + path;
    console.log(path);
    var a = document.createElement('a');
    a.href = path;
    a.click();
    window.URL.revokeObjectURL(path);
}

//保存成绩
function saveGrage(obj){
    var parent = $(obj).parent('td').parent('tr');
    var c_id = $(parent).children()[0].innerText;
    var s_id = $(parent).children()[1].innerText;
    var grade = $(obj).parent('td').prev('td').children().val();
    if(grade==""){
        dialog("输入框不能为空！");
        return;
    }
    var data = {
        'c_id':c_id,
        's_id':s_id,
        'grade':grade
    }
    console.log(data);
    $.ajax({
        method: "POST",
        type: "POST",
        url: "/addGrade",
        data: data,
        success: function (msg) {
            if (msg == "success") {
                dialog("评分成功！");
            }else {
                dialog("评分失败！")
            }
        }, error: function () {
            dialog("ajax出错！");
        }
    });
}

//导出成绩表
function exportGrade(){
    path = window.location.origin + '/exportGrade';
    var a = document.createElement('a');
    a.href = path;
    a.click();
    window.URL.revokeObjectURL(path);
}