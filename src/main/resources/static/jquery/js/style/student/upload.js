$(function () {
    // 加载dialog页面
    $(".dialog").load("static/page/dialog.html");

    // 重置按钮
    $("input[name='restart']").click(function () {
        window.location.href = "/upload";
    });
    // 保存按钮
    $('#uplodProjectForm').on('submit', function(){
        var file = $('#uplodProjectForm_file')[0].files[0];
        var fileType = file.name.substring(file.name.lastIndexOf('.')+1);
        if(fileType !== 'rar' && fileType !== 'zip'){
            dialog('只能上传rar或zip压缩包');
            return false;
        }
        var fileSize = file.size;
        if(fileSize > 209715200){
            dialog('只能上传200MB以内压缩包');
            return false;
        }
        var formData = new FormData();
        formData.append("name",$('#uplodProjectForm_name').val());
        formData.append("file",file);
        upload_projectReport(formData);
        return false;
    })
})