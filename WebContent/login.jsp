

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link type="text/css" rel="stylesheet" href="css/login.css" />
<script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>

</head>
<body>
		
		<div id="head"></div>
		<div id="middle">
			<form action="login.jhtml" method="post" name="loginForm" id="loginForm">
				<ul style="text-align: center;">
				
				<li style="font-size: 48px">用户管理系统</li>
				
				<li><span id="contents" style="display: inline-block;">${message}</span></li>
				
				<li><input  type="text" name="username" class="name" id="tid" placeholder="请输入用户名"></li>
				
				<li><input type="password" name="password" class="pwd"  id="pwd" placeholder="请输入密码"></li>				
				
				<li id="verifyCode" style="display: block;">
					<input id="valid" name="rand"  placeholder="请输入验证码" maxlength="4">
					<span id="validcode">
						<img id="verifyCodePic" id="img_captcha" src="code.jhtml" 
						onclick="javascript:this.src='code.jhtml?id='+new Date().getMilliseconds()">
					</span>
				</li>
				
				<li><input type="button" id="login" value="立即登录"></li>
				
				没有账号？<span><a href="regist.jsp" class="texts">马上注册</a></span>						
				</ul>
			</form>
		</div>
		<div id="footer">

		<a>关于我@qq1924266830 &nbsp &nbsp|&nbsp &nbsp</a>
 
		<a>Copyright © 2019 zyk16211160221</a>
		</div>


</body>
</html>
