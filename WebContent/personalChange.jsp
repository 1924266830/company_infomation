<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet" href="css/pchange.css" />
<script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/pchange.js"></script>


<title>Insert title here</title>
</head>
<body>
		<div id="middle">
			<form action="personalchange.jhtml" method="post" name="pernal_change_Form" id="pernal_change_Form">
				<ul style="text-align: center;">
				<%@page import="camsg.ci.entity.User"%>
				<%@page import="camsg.ci.DaoImpl.UserDaoImpl"%>
				<% 	
					UserDaoImpl ud = new UserDaoImpl();
					User user =ud.getUserbyusername((String)request.getSession().getAttribute("username"));
				%>
				<p style="font-size: 48px;">信息修改</p><br>
				<li>Email:<input  type="text" name="personal_email" class="email" id="p_email" placeholder="请输入邮箱" 
							value="<%=user.getEmail()%>"></li>
				
				<li>Phone:<input type="text" name="personal_phone" class="phone"  id="p_phone" placeholder="请输入电话"
							value="<%=user.getPhone()%>"></li>
				
				<li>邮编：<input type="text" name="personal_youbian" class="youbian"  id="p_youbian" placeholder="请输入邮编"
							value="<%=user.getYoubian() %>"></li>				
								
				<li>
					<input type="submit" id="pernal_change" value="确认修改">
					<input type="reset" id="pernal_change" value="重置">
				</li>
													
				</ul>
			</form>
		</div>
</body>
</html>