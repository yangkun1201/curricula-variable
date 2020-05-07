$(function () {
    // 加载dialog页面
    $(".dialog").load("static/page/dialog.html");

    // 重置按钮
    $("input[name='restart']").click(function () {
        window.location.href="/memberInsert";
    });
    // 保存按钮
    $("input[name='save']").click(function () {
        var c_name = $("input[name='c_name']").val();
        var c_id = $("input[name='c_id']").val();
        var c_pwd = $("input[name='c_pwd']").val();
        var c_sex = $("input[name='c_sex']").val();
        var c_type = $("input[name='c_type']").val();
        var c_major = $("input[name='c_major']").val();
        if(c_name==""||c_id==""||c_pwd==""||c_sex==""||c_type==""){
            dialog("输入框不能为空！");
            return;
        }
        var data = {"c_name":c_name,"c_id":c_id,"c_pwd":c_pwd,"c_sex":c_sex,"c_type":c_type,"c_major":c_major};
        console.log(data);
        insert_memberInfo(data);
    });
})
function insert_memberInfo(data) {
    $.ajax({
        method:"POST",
        type:"POST",
        url:"/insert_memberInfo",
        data:data,
        success:function (msg) {
            if(msg=="success"){
                dialog("添加用户成功！");
            }else if(msg=="duplicate"){
                dialog("此用户已存在！");
            } else if(msg=="conflict"){
                dialog("该用户名称被占用！")
            } else{
                dialog("添加用户失败！")
            }
        },error:function () {
            dialog("ajax出错！");
        }
    });
}