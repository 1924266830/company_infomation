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
			<%@page import="camsg.ci.Dao.MessageDao"%>
			<%@page import="camsg.ci.DaoImpl.MessageDaoImpl"%>
			<%@page import="camsg.ci.entity.Message"%>
			<%@page import="java.util.ArrayList"%>
			<%
			String receiver=(String)request.getSession().getAttribute("username");
			MessageDao md=new MessageDaoImpl();
			List<Message> messages=md.acceptMessge(receiver);
			List<Message> messagelist=new ArrayList<>();
			
			int m_pageNow=1;
			if(request.getParameter("m_pageNow")!=null)
			{
				m_pageNow=Integer.parseInt(request.getParameter("m_pageNow"));
				System.out.println("m_pageNow:"+m_pageNow);
			}
			int m_Totalpage=(int)Math.ceil(messages.size()/3.0);
			
			int start=(m_pageNow-1)*3;
			if(m_pageNow<m_Totalpage)
			{
				for(int i=start;i<start+3;i++)
				{
					messagelist.add(messages.get(i));
				}
			}else if(m_pageNow==m_Totalpage){
				for(int i=start;i<messages.size();i++)
				{
					messagelist.add(messages.get(i));
				}
			}
						
			request.setAttribute("m_pageNow", m_pageNow);
			request.setAttribute("m_Totalpage", m_Totalpage);
			request.setAttribute("messagelist",messagelist);
			%>
	<div id="list" style="float:left">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style="text-decoration:none;" id="bt" class="listedit" href="addmessage.jsp?m_pageNow=<%=request.getParameter("m_pageNow")%>">新增消息</a>	
		<table width="1100px">
				<tr id="info" name="info">
					<th>ID</th><th>内容</th><th>发送者</th><th>已读</th><th>回复</th>
				</tr>
				<c:forEach items="${messagelist}" var="message">
				<tr>
					<td>${message.getId()}</td>
					<td>${message.getContent()}</td>
					<td>${message.getSender()}</td>
					<td>${message.getIsread()}</td>	
									
					<td width="100px"><a style="text-decoration:none;" class="listedit" id="bt" href="answermessge.jsp?m_id=${message.getId()}&m_pageNow=${m_pageNow}">&nbsp;&nbsp;&nbsp;回复&nbsp;&nbsp;&nbsp;</a></td>
				</tr>
				
							
				</c:forEach>
				<span style="font-size:20px">总共${m_Totalpage}页</span>
				<span  style="font-size:20px">当前：第${m_pageNow}页</span>	
				<c:if test="${m_pageNow>1}">
					<a style="text-decoration:none;" id="bt"  href="Message.jsp?m_pageNow=${m_pageNow-1}" >&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;</a>
				</c:if>
				<c:if test="${m_pageNow<m_Totalpage}">
					<a style="text-decoration:none;" id="bt"  href="Message.jsp?m_pageNow=${m_pageNow+1}" >&nbsp;&nbsp;&nbsp;下一页&nbsp;&nbsp;&nbsp;</a>
				</c:if>								
			</table>
</div>
</body>
</html>