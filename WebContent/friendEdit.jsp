<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet" href="css/friendedit.css" />
<title>Insert title here</title>
</head>
<body>
				<%@page import="camsg.ci.entity.Friend"%>
				<%@page import="camsg.ci.DaoImpl.FriendDaoImpl"%>
				<% 	
						String sex1="男";
						String sex2="女";
						FriendDaoImpl fd = new FriendDaoImpl();
						int f_id=Integer.valueOf(request.getParameter("f_id")); 
						Friend friend =fd.getFriendbyID(f_id);
						
						if(friend.getSex().equals("女"))
						{
							sex1="女";
							sex2="男";
						}
						if(friend.getSex().equals("男"))
						{
							sex1="男";
							sex2="女";
						}	
						
				%>
	<div id="middle">
			<form action="editfriend.jhtml" method="post" name="pernal_change_Form" id="pernal_change_Form">
				<ul style="text-align: center;">
				<table style="position:relative;left:400px;">
					<tr>
						<td colspan="2"><p style="font-size: 48px;">通讯录编辑</p></td>
					</tr>
					
				<li><input type="text" style="color:white"  id="f_id" name="f_id"
							value="<%=friend.getId() %>"></li>
				
				<tr>
					<td>姓名  :</td>
					<td><li><input type="text" name="f_name" class="phone"  id="f_name" placeholder="请输入姓名"
							value="<%=friend.getName()%>"></li></td>
				</tr>
				<tr>
					<td>性别:	</td>
					<td><li>
						<select name="f_sex">
							<option checked><%=sex1%></option>	
							<option><%=sex2%></option>
						</select>	
					</li></td>																													
				</tr>
				<tr>
					<td>Phone：</td>			
					<td><li><input type="text" name="f_phone"" class="phone"  id="f_phone" placeholder="请输入电话"
							value="<%=friend.getPhone()%>"></li></td>
				</tr>
				<tr>
					<td>Email：</td>			
					<td><li><input  type="text" name="f_email" class="email" id="f_email" placeholder="请输入Email" 
							value="<%=friend.getEmail()%>"></li></td>
				</tr>	
				<tr>
					<td>QQ：</td>		
					<td><li><input  type="text" name="f_qq" class="email" id="f_qq" placeholder="请输入QQ" 
							value="<%=friend.getQq()%>"></li></td>
				</tr>
				<tr>
					<td>邮编：</td>								
					<td><li><input type="text" name="f_youbian" class="youbian"  id="f_youbian" placeholder="请输入邮编"
							value="<%=friend.getYoubian() %>"></li></td>
				</tr>						
								
				<tr>
					<td></td>
					<td>
					<li>
						<input type="submit" id="pernal_change" value="确认修改">
						<input type="reset" id="pernal_change" value="重置">
					</li>
					</td>
				</tr>	
				</table>			
													
				</ul>
			</form>
		</div>		
</body>
</html>