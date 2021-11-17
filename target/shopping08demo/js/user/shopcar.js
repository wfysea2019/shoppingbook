// JavaScript Document

$(function(){




	//商品数量增加1
	$(".add").click(function(){

		//alert("add");

		//获取当前商品数量并加1
		var t=$(this).parent().find('input[class*=commoditynumber]');
        t.val(parseInt(t.val())+1);

		//alert(t.val());


		//获取商品ID
		var Comm_id=$(this).parent().nextAll(".dobox").children("div.comm_id").html();
		//alert(Comm_id);
		//获取商品价格


		var comm_price=$(this).parent().prevAll(".moneybox").attr("comm_price");
		//alert(comm_price);
		var totalPrice=$(this).parent().nextAll(".moneybox").attr("totalPrice");
		//alert(totalPrice);
		var comm_number=t.val();
		//alert(comm_number);

		$(this).parent().nextAll(".moneybox").html(comm_number*comm_price);

		GetCount();

	});


	$(".reduce").click(function(){


		//获取当前商品数量并减1
		var t=$(this).parent().find('input[class*=commoditynumber]');
		if(parseInt(t.val())<=1){
			alert("不能再减了");
			return;
		}

        t.val(parseInt(t.val())-1);

		//alert(t.val());


		//获取商品ID
		var Comm_id=$(this).parent().nextAll(".dobox").children("div.comm_id").html();
		//alert(Comm_id);
		//获取商品价格


		var comm_price=$(this).parent().prevAll(".moneybox").attr("comm_price");
		//alert(comm_price);
		var totalPrice=$(this).parent().nextAll(".moneybox").attr("totalPrice");
		//alert(totalPrice);
		var comm_number=t.val();
		//alert(comm_number);

		$(this).parent().nextAll(".moneybox").html(comm_number*comm_price);
		GetCount();
	});




	$(".commoditynumber").change(function(){
		//alert("change");

       //获取当前商品数量
		var t=$(this).parent().find('input[class*=commoditynumber]');
		if(parseInt(t.val())<1){
			alert("数据错误");
			t.val(1);
			return;
		}


		//alert(t.val());


		//获取商品ID
		var Comm_id=$(this).parent().nextAll(".dobox").children("div.comm_id").html();
		//alert(Comm_id);
		//获取商品价格


		var comm_price=$(this).parent().prevAll(".moneybox").attr("comm_price");
		//alert(comm_price);
		var totalPrice=$(this).parent().nextAll(".moneybox").attr("totalPrice");
		//alert(totalPrice);
		var comm_number=t.val();
		//alert(comm_number);

		$(this).parent().nextAll(".moneybox").html(comm_number*comm_price);

	});


	$("#checkAll").click(function(){
		alert($(this).prop("checked"));
	if($(this).prop("checked")){
		$(".Checkbox").each(function(){
			$(this).prop("checked",true);
		});

	}
	else{
		$(".Checkbox").each(function(){
			$(this).prop("checked",false);
		});
	}
	GetCount();
	});


	//attr("属性"，属性值)



  $(".Checkbox").click(function(){

	  GetCount();


  });

  function GetCount(){
		var selectednumber=0; //选中商品的总数量
		var selectedtotalprice=0;//选中商品的总价
	  $(".Checkbox").each(function(){
		  //复选框选中的每一项进行数量加减，总价加减
		 if($(this).prop("checked")){


				 selectednumber=selectednumber+parseInt($(this).parent().parent().nextAll(".numberbox").children(".commoditynumber").val());//获取所选择的总数量

				 selectedtotalprice=selectedtotalprice+parseFloat($(this).parent().parent().nextAll(".numberbox").nextAll(".moneybox").html());  //获取所选择的商品的总价钱


				// alert(selectedtotalprice);
			 }
	  });


	  if(parseInt(selectednumber)==0){
		  $(".jiesuanbox").removeClass("active");
	  }
	  else{
		  $(".jiesuanbox").addClass("active");
	  }
	  $("#selectednumber").text(selectednumber);
	  $("#seletedtotalprice").text(parseFloat(selectedtotalprice).toFixed(2));

  }


  $(".delete").click(function(){
	  var comm_id=$(this).attr("comm_id");

	  $(this).parent().parent(".commoditybox").slideUp(350);//隐藏指定的版块，时间350毫秒
	  if($(this).parent().prevAll(".commodityinfo1").children(".checkbox").children(".Checkbox").attr("checked")){
		  $(this).parent().prevAll(".commodityinfo1").children(".checkbox").children(".Checkbox").attr("checked",false);

	  }
		 GetCount();

  });


});

