$(function () {
    $.get("/html/frontend/header.html",function (data){
        $("#div-header").html(data);
    })

    $.get("/html/frontend/footer.html",function (data){
        $("#div-footer").html(data);
    })


    $.getJSON("/user/getloginuser.do",function (data){
        if (data.success)
        {
            //已登录状态
            $("#login-status").css("display","block");
            $("#logout-status").css("display","none");
            $("#login-name").html(data.user.custNo);
        }else
        {
            $("#login-status").css("display","none");
            $("#logout-status").css("display","block");
        }


    })


})
