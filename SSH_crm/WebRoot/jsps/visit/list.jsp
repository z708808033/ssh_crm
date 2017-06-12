<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1>客户拜访列表</h1><br/><hr/>
  	<table cellpadding="10" cellspacing="0" border="1" bordercolor="orange">
  		<tr>
  			<th>客户名称</th>
  			<th>用户名称</th>
  			<th>拜访地址</th>
  			<th>拜访内容</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach var="visit" items="${requestScope.visitList }">
  			<tr align="center">
  				<td>${visit.customer.custName }</td>
  				<td>${visit.user.username }</td>
  				<td>${visit.visitAddress }</td>
  				<td>${visit.visitContent }</td>
  				<td><a href="<c:url value='visitAction_preEdit.action?vid=${visit.vid }' />">修改</a>
  			</tr>
  		</c:forEach>
  	</table>
  </body>
</html>
