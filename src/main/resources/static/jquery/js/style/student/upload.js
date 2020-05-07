$(function () {
    // 加载dialog页面
    $(".dialog").load("static/page/dialog.html");

    // 重置按钮
    $("input[name='restart']").click(function () {
        window.location.href = "/upload";
    });
    // 保存按钮
    $('#uplodProjectForm').on('submit', function(){
        var formData = new FormData();
        formData.append("name",$('#uplodProjectForm_name').val());
        formData.append("file",$('#uplodProjectForm_file')[0].files[0]);
        console.log(formData);
        upload_projectReport(formData);
        return false;
    })
})