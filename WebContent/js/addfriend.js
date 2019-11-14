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

		
/**
 * 此处是登录页面修改点击登录的表单action值
 * 切换到登录模式
 * @param formName 表单名称
 */
function addfriend(formName) {
	if (check()) {
		formName="pernal_change_Form";
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
		var name = $("#f_name").val();						
		if (name=="") {
			$("#f_content").html("姓名不能为空");
			return false;
		}
		return true;
		$("#f_content").html(" ");
}
		

