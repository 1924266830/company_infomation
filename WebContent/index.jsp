<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>用户信息管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/index/reset.min.css">
<link rel="stylesheet" href="css/index/style.css">
<script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>

<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<ul class="hList">
	<li>
		<a href="#click" class="menu">
			<h2 class="menu-title">首页面</h2>
			<ul class="menu-dropdown">
				<li onclick="Towelcome()">首页面</li>
			</ul>
		</a>
	</li>
	<li>
		<a href="#click" class="menu">
			<h2 class="menu-title menu-title_2nd">通讯录</h2>
			<ul class="menu-dropdown">
				<li onclick="Tomaillist()">通讯录管理</li >
				<li onclick="Tomessage()">短消息管理</li >				
			</ul>
		</a>
	</li>
	<li>
		<a href="#click" class="menu">
		<h2 class="menu-title menu-title_3rd">个人管理</h2>
		<ul class="menu-dropdown">
			<li onclick="Topersonal()">个人信息</li>
			<li onclick="TopicChange()">头像设置</li>
			<li onclick="TopersonalChange()">信息修改</li>
			
		</ul>
		</a>
	</li>
	<li>
		<a href="#click" class="menu">
			<h2 class="menu-title menu-title_4th">企业管理</h2>
			<ul class="menu-dropdown">
				<li>公司公告</li>
				<li>工作会议</li>			
			</ul>
		</a>
	</li>
</ul>
	
	<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';" heigit="100%"><br><br><br>
		<iframe id="iframe" name="iframe"  src="welcome.jsp" width="100%" height="1000px">
	</div>

</body>
</html>
