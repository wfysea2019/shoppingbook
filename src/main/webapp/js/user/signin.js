$(function() {
	// 登录验证的controller url
	var loginUrl = '/user/login.do';

	//alert("sdfdsfsdf")

	$('#name').blur(function (){
	//	alert("hhhhhh")
		// 获取输入的帐号
		var userName = $('#name').val();
		//用户名正则，6到20位（字母，数字，下划线，减号）
		var uPattern = /^[a-zA-Z0-9_-]{6,20}$/;
		if (uPattern.test(userName)==false) {
			$("#nameMsg").html("用户名6到20位（字母，数字，下划线，减号）");
			$("#nameMsg").css("color","red");
			return;
		}
		else{
			$("#nameMsg").html("");
		}
	})

	$('#pwd').blur(function (){
		var password=$('#pwd').val();
		//密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
		var pPattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
	});
	$('#submit').click(function() {
		// 获取输入的帐号
		var userName = $('#name').val();
		//用户名正则，6到20位（字母，数字，下划线，减号）
		var uPattern = /^[a-zA-Z0-9_-]{6,20}$/;
		if (uPattern.test(userName)==false) {
			$("#nameMsg").html("用户名6到20位（字母，数字，下划线，减号）");
			$("#nameMsg").css("color","red");
			return;
		}


		// 获取输入的密码
		var password = $('#pwd').val();
		// 获取输入的验证码
		var verifyCode=$('#j_captcha').val();

		// 访问后台进行登录验证
		$.ajax({
			url : loginUrl,
			async : false,
			cache : false,
			type : "post",
			dataType : 'json',
			data : {
				userName : userName,
				password : password,
				verifyCode:verifyCode
			},
			success : function(data) {
				if (data.success) {
					alert("登录成功！");

						// 自动链接到前端展示系统首页
					window.location.href = '/html/frontend/index.html';
				} else {
					alert('登录失败！' + data.errMsg);
					$('#captcha_img').click();
				}
			}
		});
	});
});