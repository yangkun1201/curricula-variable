$(function () {
    // 加载dialog页面
    $(".dialog").load("static/page/dialog.html");
    // 上一页
    $(".pagination li a[name='font']").click(function () {
       var url = location.search;
       var page = url.split("=")[1];
       if(page==1) window.location.href="/course1?page=1";
       else{
           page--;
           window.location.href="/course1?page="+page;
       }
    });

    // 下一页
    $(".pagination li a[name='next']").click(function () {
        var url = location.search;
        var page = url.split("=")[1];
        var number = $(this).parent("li").parent("ul").attr("name");
        number++;
        if(page==number) window.location.href="/course1?page="+number;
        else{
            page++;
            window.location.href="/course1?page="+page;
        }
    });
    console.log("绑定方法");
    //删除课程
    $("input[name='deleteCourse']").click(function () {
        console.log("sss");
        var c_id = $(this).parent("td").parent("tr").children("td[name='c_id']").children("input").val();
        var c_name = $(this).parent("td").parent("tr").children("td[name='c_name']").children("input").val();
        var c_room = $(this).parent("td").parent("tr").children("td[name='c_room']").children("input").val();
        var c_time = $(this).parent("td").parent("tr").children("td[name='c_time']").children("input").val();
        var c_point = $(this).parent("td").parent("tr").children("td[name='c_point']").children("input").val();
        var c_teacher = $(this).parent("td").parent("tr").children("td[name='c_teacher']").children("input").val();
        if(c_id==""||c_name==""||c_room==""||c_time==""||c_point==""){
            dialog("输入框不能为空！");
            return;
        }
        var data = {"c_id":c_id,"c_name":c_name,"c_room":c_room,"c_time":c_time,"c_point":c_point,"c_teacher":c_teacher};
        console.log(data);
        delete_courseInfo(data)
    });

    //修改课程
    $("input[name='updateCourse']").click(function () {
        console.log("sss");
        var c_id = $(this).parent("td").parent("tr").children("td[name='c_id']").children("input").val();
        var c_name = $(this).parent("td").parent("tr").children("td[name='c_name']").children("input").val();
        var c_room = $(this).parent("td").parent("tr").children("td[name='c_room']").children("input").val();
        var c_time = $(this).parent("td").parent("tr").children("td[name='c_time']").children("input").val();
        var c_point = $(this).parent("td").parent("tr").children("td[name='c_point']").children("input").val();
        var c_teacher = $(this).parent("td").parent("tr").children("td[name='c_teacher']").children("input").val();
        if(c_id==""||c_name==""||c_room==""||c_time==""||c_point==""){
            dialog("输入框不能为空！");
            return;
        }
        var data = {"c_id":c_id,"c_name":c_name,"c_room":c_room,"c_time":c_time,"c_point":c_point,"c_teacher":c_teacher};
        console.log(data);
        update_courseInfo(data)
    });


})