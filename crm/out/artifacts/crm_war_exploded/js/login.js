// JavaScript Document
//支持Enter键登录
// 		document.onkeydown = function(e){
// 			if($(".bac").length==0)
// 			{
// 				if(!e) e = window.event;
// 				if((e.keyCode || e.which) == 13){
// 					var obtnLogin=document.getElementById("submit_btn")
// 					obtnLogin.focus();
// 				}
// 			}
// 		}


//  代表加载完整个页面之后执行
$(function(){
	//提交表单
	$('#submit_btn').click(function(){
		// 加载动画
		show_loading();
		//	三个格式验证
		let $jUsername = $("#j_username").val();
		let $jPassword = $("#j_password").val();
		let $jCaptcha = $("#j_captcha").val();
		// 账号密码 非空  验证码长度为6
		if ($jUsername != "" && $jPassword != "" && $jCaptcha.length == 4){
			$.ajax({
				url:"user/login",
				type:"post",
				data:{"username":$jUsername , "password":$jPassword,"captcha":$jCaptcha},
				dataType:"json",
				success:function (data) {
					// 获取后端传递得数据 进行处理 data{code: , msg: , data: }
					console.log(data)
					if (data.code == 200){
					//	跳转到成功页面 success.jsp 显示当前登录的用户
						show_msg('登录成功咯！  正在为您跳转...','user/main.do');
					}else {
						show_err_msg(data.msg);
					}
				},
				error:function (data) {
					show_err_msg("服务器错误，稍后重试！");
				}
			})
		}else{
			show_err_msg('登录信息未填写完整！');
		}

	});
});