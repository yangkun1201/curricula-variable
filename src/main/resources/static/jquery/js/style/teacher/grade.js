$(function () {
    // 加载dialog页面
    $(".dialog").load("static/page/dialog.html");

    // 上一页
    $(".pagination li a[name='font']").click(function () {
        var url = location.search;
        var page = url.split("=")[1];
        if(page==1) window.location.href="/grade1?page=1";
        else{
            page--;
            window.location.href="/grade1?page="+page;
        }
    });

    // 下一页
    $(".pagination li a[name='next']").click(function () {
        var url = location.search;
        var page = url.split("=")[1];
        var number = $(this).parent("li").parent("ul").attr("name");
        number++;
        if(page==number) window.location.href="/grade1?page="+number;
        else{
            page++;
            window.location.href="/grade1?page="+page;
        }
    });
    // 保存按钮
    $("input[name='save']").click(function () {
        var grade = $("input[name='grade']").val();
        if(grade==""){
            dialog("输入框不能为空！");
            return;
        }
        var data = {"grade":grade};
        console.log(data);
        update_teacherGrade(data);
    });
})