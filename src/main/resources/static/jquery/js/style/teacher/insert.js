$(function () {
    // 加载dialog页面
    $(".dialog").load("static/page/dialog.html");

    // 重置按钮
    $("input[name='restart']").click(function () {
        window.location.href="/courseInsert";
    });
    // 保存按钮
    $("input[name='save']").click(function () {
        var c_id = $("input[name='c_id']").val();
        var c_name = $("input[name='c_name']").val();
        var c_room = $("input[name='c_room']").val();
        var c_time = $("input[name='c_time']").val();
        var c_point = $("input[name='c_point']").val();
        var c_teacher = $("input[name='c_teacher']").val();
        if(c_id==""||c_name==""||c_room==""||c_time==""||c_point==""){
            dialog("输入框不能为空！");
            return;
        }
        var data = {"c_id":c_id,"c_name":c_name,"c_room":c_room,"c_time":c_time,"c_point":c_point,"c_teacher":c_teacher};
        console.log(data);
        insert_courseInfo(data);
    });
})