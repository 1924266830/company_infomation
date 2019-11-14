<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/personal.css">
<title>Insert title here</title>
</head>
<body style="text-align:center;" >
		<%@page import="camsg.ci.entity.User"%>
		<%@page import="camsg.ci.DaoImpl.UserDaoImpl"%>
		<%@page import="com.dao.AddressDao"%>
		<%@page import="com.dao.AddressDaoImp"%>
		<%@page import="java.util.List"%>
		<%@page import="com.pojo.Area"%>
		<%@page import="com.pojo.City"%>
		<%@page import="com.pojo.Province"%>
				<% 	
					UserDaoImpl ud = new UserDaoImpl();
					User user =ud.getUserbyusername((String)request.getSession().getAttribute("username"));
					String place="";
					AddressDaoImp addressDao = new AddressDaoImp();
					List<Province> provList = addressDao.getProvinces();
					if(user.getPlace()!=null)
					{
						String[] placecodes=user.getPlace().split(",");	
						String provCode=placecodes[0];
						String cityCode=placecodes[1];
						String areaCode=placecodes[2];
						place+=addressDao.getProvinceBycode(provCode).getName();
						place+=addressDao.getCityBycode(cityCode).getName();
						place+=addressDao.getAreaBycode(areaCode).getName();
					}
					
				%>		                 
		<div id="new" style=" position:absolute;left:450px; top:100px;">
		 	<TABLE>
		           <TBODY>		                 	   			                    		                    				                    			                   
		                  <TR>
		                    <TD width=100 align="left">用户名：</TD>
		                    <TD>
								<%=user.getUsername() %>
		                    </TD>
		                    <td colspan="2" rowspan="2">
		                    	<img width="150px" height="150px"src="img/<%=user.getPic()%>" />
		                    <td>
		                  </TR>
		                <TR>
		                    <TD width=100 align="left">邮箱：</TD>
		                    <TD>
								<%=user.getEmail() %>
		                    </TD>
		                  </TR>
		                  <TR>
		                    <TD width=100 align="left" colspan="2">电话：</TD>
		                    <TD colspan="2">
								<%=user.getPhone() %>
		                    </TD>
		                  </TR>
		                  
		                  <TR>
		                    <TD width=100 align="left" colspan="2">邮编：</TD>
		                    <TD colspan="2">
								<%=user.getYoubian() %>
		                    </TD>		
		                  </TR>
		                  <TR>
		                    <TD width=100 align="left" colspan="2">籍贯：</TD>
		                    <TD colspan="2">
								<%=place %>
		                    </TD>		
		                  </TR>
		             </TBODY>
		        </TABLE>
		</div>
</body>
</html>