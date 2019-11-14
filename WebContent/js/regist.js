// JavaScript Document

//设置背景自适应浏览器宽度
window.onload = function() {

	var winHeight = document.documentElement.clientHeight;
	var winWidth = window.screen.width;
	document.getElementById("backgrounds").style.height = winHeight + "px";
	document.getElementById("backgrounds").style.width = winWidth + "px";

	// 设置登录框垂直居中
	document.getElementById("div_position").style.marginTop = winHeight / 2
			- 170 + "px";
}
$(document).ready(
		function() {

			$("#regist_button").click(function() {
				regist('reg_form');
			});
		
			
			$("#r_name").blur(function (){
				
				var user={username:$("#r_name").val()};
				$.ajax({
					url:"http://localhost:8080/Final_PRJ/registcheck.jhtml",
					data:user,
					async:true,
					type:"POST",
					datatype:"html",
					success:function(result){
						
						if(result=="用户已存在")
						{
							$("#r_content").html("用户名已存在");
							$("#regist_button").attr("disabled",true);

						}
						else
						{
							$("#r_content").html("<font color=green>用户可注册</font>");
							$("#regist_button").attr("disabled",false);
							
						}
					}
					
				});
})
		})
		
/**
 * 此处是登录页面修改点击登录的表单action值
 * 切换到登录模式
 * @param formName 表单名称
 */
function regist(formName) {
	if (check()) {
		
		window.document.forms[formName].submit();
	}
}
/**
 * 此处是点击注册进入注册页面后修改表单提交的action
 * 切换到注册模式
 * @param formName 表单名称
 */

/**
 * 对用户名、密码、验证码进行验证。
 * @returns {Boolean} 返回是否验证通过
 */
function check() {
	// 点击登录按钮时，对输入框的值进行验证
		var regist_email=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
		var regist_phone=/^[1][3,4,5,7,8][0-9]{9}$/;
		var regist_youbian=/^[0-9]{6}$/;
		var regist_name=/^[a-zA-Z0-9_-]{3,16}$/;
		var regist_pwd=/^[a-zA-Z0-9!@#$%^&*?]{6,25}$/;
		var name = $("#r_name").val();
		var pwd = $("#r_password").val();
		var check_pwd=$("#r_checkpassword").val();
		var email = $("#r_email").val();
		var phone = $("#r_phone").val();
		var youbian = $("#r_youbian").val();
		
		
		
		
		if (name==""||!regist_name.test(name)) {
			$("#r_content").html("用户名至少由3到16位数字和字母组成");
			return false;
		} else if (pwd==""||!regist_pwd.test(pwd)) {
			$("#r_content").html("密码需要6到25位且不包含特殊字符");
			return false;
		} else if (check_pwd==""||check_pwd!=pwd) {
			$("#r_content").html("两次密码需要一致");
			return false;
		}else if (!regist_email.test(email)&&email!="") {
			$("#r_content").html("邮箱格式不正确，格式示例：xxxxxx@163.com");
			return false;
		}else if (!regist_phone.test(phone)&&phone!="") {
			$("#r_content").html("电话号码格式不正确");
			return false;
		}else if(!regist_youbian.test(youbian)&&youbian!=""){
			$("#r_content").html("邮编格式不正确");
			return false;
		}
		return true;
		
}
		
// js获取项目根路径，如： http://localhost:8080/Qunawan
function getRootPath() {
	// 获取当前网址，如： http://localhost:8080/Qunawan/pages/index.jsp
	var curWwwPath = window.document.location.href;
	// 获取主机地址之后的目录，如： Qunawan/pages/index.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	// 获取主机地址，如： http://localhost:8080
	var localhostPaht = curWwwPath.substring(0, pos);
	// 获取带"/"的项目名，如：/Qunawan
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}
