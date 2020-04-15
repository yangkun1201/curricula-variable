$(function () {
    // 加载dialog页面
    $(".dialog").load("static/page/dialog.html");
    // 上一页
    $(".pagination li a[name='font']").click(function () {
       var url = location.search;
       var page = url.split("=")[1];
       if(page==1) window.location.href="/member?page=1";
       else{
           page--;
           window.location.href="/member?page="+page;
       }
    });

    // 下一页
    $(".pagination li a[name='next']").click(function () {
        var url = location.search;
        var page = url.split("=")[1];
        var number = $(this).parent("li").parent("ul").attr("name");
        console.log(number);
        number++;
        if(page==number) window.location.href="/member?page="+number;
        else{
            page++;
            window.location.href="/member?page="+page;
        }
    });

    //删除课程
    $("input[name='deleteMember']").click(function () {

        var c_id = $(this).parent("td").parent("tr").children("td[name='c_id']").children("input").val();
        if(c_id==""){
            dialog("输入框不能为空！");
            return;
        }
        var data = {"c_id":c_id};
        console.log(data);
        delete_userInfo(data)
    });

    //修改课程
    $("input[name='updateMember']").click(function () {
        console.log("sss");
        var c_id = $(this).parent("td").parent("tr").children("td[name='c_id']").children("input").val();
        var c_name = $(this).parent("td").parent("tr").children("td[name='c_name']").children("input").val();
        var c_sex = $(this).parent("td").parent("tr").children("td[name='c_sex']").children("input").val();
        var c_pwd = $(this).parent("td").parent("tr").children("td[name='c_pwd']").children("input").val();
        var c_type = $(this).parent("td").parent("tr").children("td[name='c_type']").children("input").val();
        var c_major = $(this).parent("td").parent("tr").children("td[name='c_major']").children("input").val();
        var c_point = $(this).parent("td").parent("tr").children("td[name='c_point']").children("input").val();
        if(c_id==""||c_name==""||c_sex==""||c_pwd==""||c_point==""){
            dialog("输入框不能为空！");
            return;
        }
        var data = {"c_id":c_id,"c_name":c_name,"c_sex":c_sex,"c_pwd":c_pwd,"c_type":c_type,"c_major":c_major,"c_point":c_point};
        console.log(data);
        update_userInfo(data)
    });
})

function delete_userInfo(data) {
    $.ajax({
        method:"POST",
        type:"POST",
        url:"/delete_userInfo",
        data:data,
        success:function (msg) {
            if(msg=="success"){
                dialog("删除成功！");
            }else{
                dialog("删除失败！")
            }
            window.location.href="/member?page=1";
        },error:function () {
            dialog("ajax出错！");
        }
    });
}

function update_userInfo(data) {
    $.ajax({
        method:"POST",
        type:"POST",
        url:"/update_userInfo",
        data:data,
        success:function (msg) {
            if(msg=="success"){
                dialog("修改成功！");
            }else{
                dialog("修改失败！")
            }
        },error:function () {
            dialog("ajax出错！");
        }
    });
}