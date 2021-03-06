$(function () {
    // 菜单栏击中效果
    var menu = get();
    console.log(menu);
    if(menu==null) $(".course-menu li[name='index']").addClass("menu-focus");
    else $(".course-menu li[name='"+menu+"']").addClass("menu-focus");
    // 菜单栏点击
    $(".course-menu li").click(function () {
        var menu = $(this).attr("name");
        switch (menu){
            case "index":{
                save("index");
                window.location.href="/teacherIndex"
                break;
            }
            case "info":{
                save("info");
                window.location.href="/teacherInfo";
                break;
            }
            case"insert":{
                save("insert");
                window.location.href="/courseInsert";
                break;
            }
            case "course1":{
                save("course1");
                window.location.href="/course1?page=1";
                break;
            }
            case "check":{
                save("check");
                window.location.href="/check?page=1";
                break;
            }

            case "downloding":{
                save("dowloding");
                window.location.href="/fileUploadRecord1?page=1";
                break;
            }
            case "graded":{
                save("graded");
                window.location.href="/grade1?page=1";
                break;
            }
            case "exit":{
                clear();
                window.location.href="/exit";
                break;
            }
            default:break;
        }
    });
    
    // 存储到session缓存
    function save(data) {
        sessionStorage.setItem("menu",data);
    }
    
    // 取出session缓存
    function get() {
        return sessionStorage.getItem("menu");
    }

    // 清除class操作
    function clear() {
        sessionStorage.removeItem("menu");
    }
})