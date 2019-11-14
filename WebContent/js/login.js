// JavaScript Document

function login() {
	if (check()) {				
		window.document.forms[0].submit();
	}
	
}

$(document).ready(
		function() {
			$("#login").click(function() {
				login();
			});
	})

			
/**
 * 对用户名、密码、验证码进行验证。
 * @returns {Boolean} 返回是否验证通过
 */
function check() {
		// 点击登录按钮时，对输入框的值进行验证

		var pwd = $("#pwd").val();
		var tid = $("#tid").val();
		var ident = $("#valid").val();
		if (tid=="") {
			$("#contents").html("账号不能为空");
			return false;
		}else if (pwd=="") {
			$("#contents").html("密码不能为空");
			return false;
		} else if (ident=="") {
			$("#contents").html("验证码不能为空");
			return false;
		}
		return true;

}
		
