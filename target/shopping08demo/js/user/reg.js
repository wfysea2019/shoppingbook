$(function () {

    var regUrl = '/user/reg.do';

    //用户名正则，6到20位（字母，数字，下划线，减号）
    var uPattern = /^[a-zA-Z0-9_-]{6,20}$/;

    $('#name').blur(function () {
        // 获取输入的帐号
        var userName = $('#name').val();

        if (uPattern.test(userName) == false) {
            $("#nameMsg").html("用户名6到20位（字母，数字，下划线，减号）");
            $("#nameMsg").css("color", "red");
            return ;
        }

        $.getJSON("/user/userexist.do",{name:userName},function (data){
            if (data.success){
                $("#nameMsg").html("该用户名可用");
                $("#nameMsg").css("color", "green");
            }else{
                $("#nameMsg").html("该用户名已经被注册");
                $("#nameMsg").css("color", "red");
            }
        })
    })

    $('#submit').click(function () {
        // 获取输入的帐号
        var userName = $('#name').val();
        if (!userName) {
            $("#nameMsg").html("用户名不能为空");
            $("#nameMsg").css("color", "red");
            return;
        }
        if (!uPattern.test(userName)) {
            $("#nameMsg").html("用户名6到20位（字母，数字，下划线，减号）");
            $("#nameMsg").css("color", "red");
            return;
        }

        // 获取输入的密码
        var password = $('#pwd').val();
        if (!password) {
            alert('请输入密码！');
            return;
        }
        // 获取重复密码
        var rePassword = $('#repwd').val();
        if (!rePassword) {
            alert('请输入确认密码！');
            return;
        }
        if (password != rePassword) {
            alert('密码不一致！');
            return;
        }

        var email=$("#email").val();
        var md5pwd=hex_md5(password);
        alert(md5pwd);
        // 获取验证码
        var verifyCodeActual = $('#j_captcha').val();
        if (!verifyCodeActual) {
            alert('请输入验证码！');
            return;
        }

        // 访问后台进行登录验证
        $.ajax({
            url: regUrl,
            async: false,
            cache: false,
            type: "post",
            dataType: 'json',
            data: {
                name: userName,
                pwd: password,
                email:email,
                verifyCode: verifyCodeActual
            },
            success: function (data) {
                if (data.success) {
                    alert("注册成功！");
                    // 自动链接到登录
                    window.location.href = '/html/user/signin.html';
                } else {
                    alert('注册失败！' + data.errMsg);

                }
            }
        });
    });

})

