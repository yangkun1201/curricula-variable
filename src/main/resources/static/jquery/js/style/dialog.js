// 显示提示对话框
function dialog(info) {
    console.log("开始执行");
    $("#dialog-info").text(info);
    $("#myModal").modal();
    console.log("执行完成");
}