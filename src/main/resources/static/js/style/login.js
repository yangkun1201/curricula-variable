$(function () {
    // 加载dialog页面
    $(".dialog").load("static/page/dialog.html");
    // 登录按钮绑定事件
    $("input[name='submit']").click(function () {
       var username = $("input[name='username']").val();
       var password = $("input[name='password']").val();
       if(username==""||password==""){
           dialog("输入框不能为空！");
           return;
       }
       var data = {"username":username,"password":password};
       login(data);
    });
})