<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/messagelist.css" />
<title>Insert title here</title>
</head>
<body>
			<%@page import="java.util.List"%>
			<%@page import="camsg.ci.Dao.FriendDao"%>
			<%@page import="camsg.ci.DaoImpl.FriendDaoImpl"%>
			<%@page import="camsg.ci.entity.Friend"%>
			<%@page import="java.util.ArrayList"%>
			<%
				String username=(String)request.getSession().getAttribute("username");
				Friend friend=new Friend();
				friend.setName("");
				FriendDao fd=new FriendDaoImpl();
				if(request.getParameter("f_id")!=null)
					friend=fd.getFriendbyID(Integer.valueOf(request.getParameter("f_id")));
				List<Friend> flist=fd.getFriendList(username);
				request.setAttribute("flist", flist);
				String pageNow=request.getParameter("m_pageNow");
			%>
	<div id="newmsg">		
		<FORM id="sendmsg" method="post" action="sendmessage.jhtml" enctype="multipart/form-data">
			
			 <h3 style="font-family:华文细黑,STHeiti,MingLiu;font-size:20px;color:#0000EE;
					text-shadow:1px 1px 3px #599DD5;margin-bottom:20px;">接收者:	
					<input list="receivers" name="receiver" value="<%=friend.getName()%>"/>				
					<datalist  id="receivers">
					<% if(flist.size()>0){%>
						<c:forEach items="${flist}" var="friend">
							<option>${friend.getName()}</option>							
						</c:forEach>
						<%} %>	
					</datalist>					
			</h3>
						
			<textarea rows="3" cols="20" style="height: 200px;width: 700px;resize: none;border:solid 1px #0000EE;" name="content" ></textarea>
			<br />  
			<input type="file"  name="file1"><font color=green><%if(request.getAttribute("ok")!=null)
				out.print(request.getAttribute("ok"));%></font>
			<input  id="bt"  class="listedit" value="发送" type="submit"/>
			<a style="text-decoration:none;color:blue;"  class="listedit"  href="Message.jsp?m_pageNow=<%=pageNow%>">&nbsp;&nbsp;&nbsp;返回短信息列表&nbsp;&nbsp;&nbsp;</a>
		</FORM>
	</div>
</body>
</html>