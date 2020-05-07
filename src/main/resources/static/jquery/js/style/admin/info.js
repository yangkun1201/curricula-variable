$(function () {
    // 加载dialog页面
    $(".dialog").load("static/page/dialog.html");

    // 重置按钮
    $("input[name='restart']").click(function () {
       window.location.href="/studentInfo";
    });
    // 保存按钮
    $("input[name='save']").click(function () {
        var userName = $("input[name='userName']").val();
        var password = $("input[name='password']").val();
        var gender = $("input[name='gender']").val();
        var major = $("input[name='major']").val();
        if(userName==""||password==""||gender==""||major==""){
            dialog("输入框不能为空！");
            return;
        }
        var data = {"userName":userName,"password":password,"gender":gender,"major":major};
        console.log(data);
        update_studentInfo(data);
    });
})