// 修改学生信息
function update_studentInfo(data) {
    $.ajax({
       method:"POST",
       type:"POST",
       url:"/updateStudentInfo",
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

// 学生选课操作
function select_studentCourse(data) {
    $.ajax({
       method:"POST",
       type:"POST",
       url:"/selectCourse",
       data:data,
        success:function (msg) {
           console.log(msg);
            switch (msg){
                case "success":{
                    dialog("选课成功！");
                    break;
                }
                case "nouse":{
                    dialog("你已选课，不可多选！");
                    break;
                }
                case "no":{
                    dialog("该课程已选！");
                    break;
                }
                case "error":{
                    dialog("选课失败！");
                    break;
                }
                default:break;
            }
        },error:function () {
            dialog("ajax出错！");
        }
    });
}

// 修改选课积分
function update_point(data) {
    $.ajax({
        method:"POST",
        type:"POST",
        url:"/updatePoint",
        data:data,
        success:function (msg) {
            if(msg=="success"){
                dialog("修改积分成功！");
            }else{
                dialog("修改积分失败！");
            }
        },error:function () {
            dialog("ajax出错！");
        }
    });
}

// 退课
function remove_course(data) {
    $.ajax({
        method:"POST",
        type:"POST",
        url:"/removeSelect",
        data:data,
        success:function (msg) {
            if(msg=="success"){
                $("#"+data['id']).parent("tr").remove();
                dialog("退课成功！");
            }else{
                dialog("退课失败！");
            }
        },error:function () {
            dialog("ajax出错！");
        }
    });
}

//上传课题报告
function upload_projectReport(data) {
    $.ajax({
        method:"POST",
        type:"POST",
        url:"/uploadProjectReport",
        contentType: false,
        processData: false,
        data:data,
        success:function (msg) {
            if(msg=="success"){
                dialog("上传成功！");
            }else{
                dialog("上传失败！");
            }
        },error:function () {
            dialog("ajax出错！");
        }
    });
}