<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet" href="css/friendedit.css" />
<script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/addfriend.js"></script>
<title>Insert title here</title>
</head>
<body>
				<%@page import="camsg.ci.entity.Friend"%>
				<%@page import="camsg.ci.DaoImpl.FriendDaoImpl"%>
				<% 	
						String sex1="男";
						String sex2="女";
						
				%>
	<div id="middle" >
			<form action="addfriend.jhtml" method="post" name="pernal_change_Form" id="pernal_change_Form">
				<ul >
				<table style="position:relative;left:400px;">
					<tr style="text-align: center;"><td colspan="2"><p style="font-size: 48px;">通讯录新增</p></td></tr>
				<tr>
					<td>姓名  :</td><td><li><input type="text" name="fadd_name" class="phone"  id="f_name" placeholder="请输入姓名"></li></td>
					<td><p id="f_content" style="color:red"></p></td>
				</tr>
				<tr>
				<td>性别 :</td><td>	<li>
						<select name="fadd_sex">
							<option checked><%=sex1%></option>	
							<option><%=sex2%></option>
						</select>																			
				</li></td>
				</tr>
				<tr>			
					<td>Phone：</td><td><li><input type="text" name="fadd_phone"" class="phone"  id="f_phone" placeholder="请输入电话"></li></td>
				</tr>
				<tr>	
					<td>Email：</td><td><li><input  type="text" name="fadd_email" class="email" id="f_email" placeholder="请输入Email" ></li></td>
				</tr>
				<tr>
					<td>QQ：</td><td><li><input  type="text" name="fadd_qq" class="email" id="f_qq" placeholder="请输入QQ" ></li></td>					
				</tr>
				<tr>
					<td>邮编：</td><td><li><input type="text" name="fadd_youbian" class="youbian"  id="f_youbian" placeholder="请输入邮编"></li></td>			
				</tr>
				<tr>
					<td></td>									
					<td ><li><input type="button" id="pernal_change" value="确认修改" onclick="addfriend()"></li></td>					
				</tr>	
				<tr><td><td><a style="text-decoration:none;" id="bt" class="listedit" href="Maillist.jsp?nowpage=<%=request.getParameter("f_pageNow")%>">&nbsp;&nbsp;&nbsp;返回通讯录列表&nbsp;&nbsp;&nbsp;</a></td></td></tr>				
				</table>								
				</ul>
			</form>
		</div>		
</body>
</html>