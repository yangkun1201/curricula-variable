$(function () {
    // 加载dialog页面
    $(".dialog").load("static/page/dialog.html");
    // 上一页
    $(".pagination li a[name='font']").click(function () {
        var url = location.search;
        var page = url.split("=")[1];
        if (page == 1) window.location.href = "/course1?page=1";
        else {
            page--;
            window.location.href = "/course1?page=" + page;
        }
    });

    // 下一页
    $(".pagination li a[name='next']").click(function () {
        var url = location.search;
        var page = url.split("=")[1];
        var number = $(this).parent("li").parent("ul").attr("name");
        number++;
        if (page == number) window.location.href = "/course1?page=" + number;
        else {
            page++;
            window.location.href = "/course1?page=" + page;
        }
    });

    //审核通过
    $("input[name='check']").click(function () {
        console.log("SSSS");
        var c_id = $(this).parent("td").parent("tr").children("td[name='cid']").text();
        var s_id = $(this).parent("td").parent("tr").children("td[name='sid']").text();
        console.log(c_id);
        console.log(s_id);
        var data = {"c_id":c_id,"s_id":s_id};
        check(data)
    });



})

//删除课程
function check(data) {
    $.ajax({
        method: "POST",
        type: "POST",
        url: "/checkCourse",
        data: data,
        success: function (msg) {
            if (msg == "success") {
                dialog("操作成功！");
            }else {
                dialog("操作失败！")
            }
            window.location.href="/check?page=1";
        }, error: function () {
            dialog("ajax出错！");
        }
    });
}