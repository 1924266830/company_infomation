<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/maillist.css" />
<script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/maillist.js"></script>
<title>Insert title here</title>
</head>
<body>
			<%@page import="java.util.List"%>
			<%@page import="camsg.ci.Dao.FriendDao"%>
			<%@page import="camsg.ci.DaoImpl.FriendDaoImpl"%>
			<%@page import="camsg.ci.entity.Friend"%>
			<%@page import="java.util.ArrayList"%>
			<% 
				String username=(String) request.getSession().getAttribute("username");
				FriendDao ud=new FriendDaoImpl();
				List<Friend> friends=ud.getFriendList(username);
				List<Friend> friendlist=new ArrayList<Friend>();
				int f_pageNow=1;
				if(request.getParameter("f_pageNow")!=null)
				{
					f_pageNow=Integer.parseInt(request.getParameter("f_pageNow"));
					System.out.println("f_pageNow:"+f_pageNow);
				}
				int f_Totalpage=(int)Math.ceil(friends.size()/3.0);
			
				int start=(f_pageNow-1)*3;
				if(f_pageNow<f_Totalpage)
				{
					for(int i=start;i<start+3;i++)
					{
						friendlist.add(friends.get(i));
					}
				}else if(f_pageNow==f_Totalpage){
					for(int i=start;i<friends.size();i++)
					{
						friendlist.add(friends.get(i));
					}
				}
				request.setAttribute("f_pageNow", f_pageNow);
				request.setAttribute("f_Totalpage", f_Totalpage);
				request.setAttribute("friendlist",friendlist);
			%>
<div id="list" style="float:left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style="text-decoration:none;"  class="listedit" href="addfriend.jsp?f_pageNow=<%=request.getParameter("f_pageNow")%>">新增通讯录</a>	
		<table width="1100px" >		
				<tr id="info" name="info">
					<th>ID</th><th>姓名</th><th>性别</th><th>电话</th><th>邮箱</th><th>QQ</th><th>邮编</th>
					<th colspan="3">操作</th>
				</tr>
				<c:forEach items="${friendlist}" var="friend">
				<tr>
					<td>${friend.getId() }</td>
					<td>${friend.getName() }</td>
					<td>${friend.getSex() }</td>
					<td>${friend.getPhone() }</td>
					<td>${friend.getEmail() }</td>
					<td>${friend.getQq() }</td>
					<td>${friend.getYoubian()}</td>
					<td width="100px"><a style="text-decoration:none;" class="listedit" id="bt" href="friendEdit.jsp?f_id=${friend.getId()}&f_pageNow=${f_pageNow}">&nbsp;&nbsp;&nbsp;编  辑&nbsp;&nbsp;&nbsp;</a></td>
					<td width="100px"><a style="text-decoration:none;" class="listedit" id="bt" href="deletefriend.jhtml?f_id=${friend.getId()}">&nbsp;&nbsp;&nbsp;删  除&nbsp;&nbsp;&nbsp;</a></td>
					<td width="100px"><a style="text-decoration:none;" class="listedit" id="bt" href="addmessage.jsp?f_id=${friend.getId()}">&nbsp;&nbsp;&nbsp;发消息&nbsp;&nbsp;&nbsp;</a></td>
				</tr>
	
				</c:forEach>
				<tr>
				<span style="font-size:20px">总共${sf_Totalpage}页</span>
				<span  style="font-size:20px">当前：第${f_pageNow}页</span>
				<c:if test="${f_pageNow>1}">
					<a style="text-decoration:none;" id="bt"  href="Maillist.jsp?f_pageNow=${f_pageNow-1}" >&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;</a>
				</c:if>
				<c:if test="${f_pageNow<f_Totalpage}">
					<a style="text-decoration:none;" id="bt"  href="Maillist.jsp?f_pageNow=${f_pageNow+1}" >&nbsp;&nbsp;&nbsp;下一页&nbsp;&nbsp;&nbsp;</a>
				</c:if>	
				</tr>			
			</table><br><br><br>
		
		<form action="searchfriend.jhtml" method="post">
			<input type="text" id="search_content" name="search_content" value="<%=request.getAttribute("search_content")%>">
    		<button type="submit" id="btn">search</button>
		</form>	
 		
			<table width="1100px" >		
				<tr id="info" name="info">
					<th>ID</th><th>姓名</th><th>性别</th><th>电话</th><th>邮箱</th><th>QQ</th><th>邮编</th>
					<th colspan="3">操作</th>
				</tr>
				<c:forEach items="${search_friendlist}" var="friend">
				<tr>
					<td>${friend.getId() }</td>
					<td>${friend.getName() }</td>
					<td>${friend.getSex() }</td>
					<td>${friend.getPhone() }</td>
					<td>${friend.getEmail() }</td>
					<td>${friend.getQq() }</td>
					<td>${friend.getYoubian()}</td>
					<td width="100px"><a style="text-decoration:none;" class="listedit" id="bt" href="friendEdit.jsp?f_id=${friend.getId()}&sf_pageNow=${sf_pageNow}">&nbsp;&nbsp;&nbsp;编  辑&nbsp;&nbsp;&nbsp;</a></td>
					<td width="100px"><a style="text-decoration:none;" class="listedit" id="bt" href="deletefriend.jhtml?f_id=${friend.getId()}">&nbsp;&nbsp;&nbsp;删  除&nbsp;&nbsp;&nbsp;</a></td>
					<td width="100px"><a style="text-decoration:none;" class="listedit" id="bt" href="addmessage.jsp?f_id=${friend.getId()}">&nbsp;&nbsp;&nbsp;发消息&nbsp;&nbsp;&nbsp;</a></td>
				</tr>
	
				</c:forEach>				
			</table>

</div>
</body>
</html>