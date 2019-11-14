<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link type="text/css" rel="stylesheet" href="css/regist.css" />
<script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/regist.js"></script>

<title>注册界面</title>
</head>
<script type="text/javascript">
	$(function() {
		
		// 初始化省市区
		initAddress();
 
		// 更改省份后的操作
		$("select[name='province']").change(function() {
 
			var provCode = $("select[name='province']").val();
 
			getCity(provCode);
 
		});
 
		// 更改城市后的操作
		$("select[name='city']").change(function() {
			var cityCode = $("select[name='city']").val();
			getArea(cityCode);
		});
 
	});
 
	function initAddress() {
 
		var firstProvCode;
		// ajax请求所有省份
		$.get("AddressServlet", {
			method : "initProvince"
		}, function(data) {
 
			$.each(data, function(i, d) {
				$("select[name='province']").append(
						"<option value='"+d.code+"'>" + d.name
								+ "</option>");
			});
 
			// 获取第一个省份的code
			firstProvCode = data[0].code;
			console.log(firstProvCode)
			// 根据第一个省份code获取对应城市列表
			getCity(firstProvCode);
		}, 'json');
 
	}
 
	//获取对应城市列表（里面包括获取第一个城市的区县列表）
	function getCity(provCode) {
 
		var firstCityCode;
 		
		// ajax请求所有市级单位
		$.get("AddressServlet", {
			method : "getCity",
			provCode : provCode
		}, function(data) {
 
			// 先清空城市下拉框
			$("select[name='city']").empty();
 
			$.each(data, function(i, d) {
				$("select[name='city']").append(
						"<option value='"+d.code+"'>" + d.name
								+ "</option>");
			});
			
			// 获取第一个城市的code
			firstCityCode = data[0].code;
			// 根据第一个城市code获取对应区县列表
			getArea(firstCityCode);
			
		}, 'json');
	}
 
	function getArea(cityCode) {
 
		// ajax请求所有区县单位
		$.get("AddressServlet", {
			method : "getArea",
			cityCode : cityCode
		}, function(data) {
			
			// 先清空区县下拉框
			$("select[name='area']").empty();
			$.each(data, function(i, d) {
				$("select[name='area']").append(
						"<option value='"+d.code+"'>" + d.name
								+ "</option>");
			});
		}, 'json');
	}
</script>
<body>
		
			<!-- 背景  开始 -->
	<div class="backgrounds" id="backgrounds">
		<!-- 表单框 -->
		<div class="content" id="div_position">

			<div class="login_framework">
			
				<form id="reg_form" method="post" name="reg_form" action="/Final_PRJ/regist.jhtml">
				
					<div class="content2">
						
						<div id="r_content" class="contents">${message}</div>
						
						<ul>
							<li><input name="r_name" id="r_name" type="text" class="text" placeholder="请输入用户名"/><br /></li>
						</ul>
						<ul >
							<li><input type="password" name="r_password" id="r_password" class="text"
								placeholder="请输入密码" /></li>
							
						</ul>
						<ul >
							<li><input type="password" name="r_checkpassword" id="r_checkpassword" class="text"
								placeholder="请确认密码" /></li>							
						</ul>
						<ul >
							<li><input type="text" name="r_email" id="r_email" class="text"
								placeholder="请输入邮箱" /></li>							
						</ul>
						<ul >
							<li><input type="text" name="r_phone" id="r_phone" class="text"
								placeholder="请输入电话" /></li>							
						</ul>
						<ul >							
							<li><input type="text" name="r_youbian" id="r_youbian" class="text"
								placeholder="请输入邮编" /></li>						
						</ul>
						<ul >							
							<select name='province'></select>
							<select name='city'></select>
							<select name='area'></select>						
						</ul>													
						<span class="rem_password"> <a href="#" class="texts">&nbsp</a>
						</span> <input class="login_button"  id="regist_button" value="注册用户"
							type="button"/>
					</div>
					已有账号?<span class="texts cursors"><a href="login.jsp" class="texts">马上登录</a></span>
				</form>
				
			</div>
										
	</div>
	<!-- 背景  结束 -->
</body>
</html>