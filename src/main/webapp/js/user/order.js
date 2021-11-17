// JavaScript Document
$(function(){
	$(".b ul li").click(function(){
		$(this).addClass("active").siblings().removeClass("active");
		alert($(this).attr("orderType"));
	});
	
	
});