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
    
    <title>My JSP 'countLevel.jsp' starting page</title>
    
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
  	<h1>客户来源统计分析</h1>
  	<table cellpadding="10" cellspacing="0" border="1" bordercolor="orange">
  		<tr>
  			<td>客户来源</td>
  			<td>客户数量</td>
  		</tr>
	  	<c:forEach items="${list }" var="map">
	  		<tr>
	  			<td>${map.custSource }</td>
	  			<td>${map.num }</td>
	  		</tr>
	  	</c:forEach>
  	</table>
  </body>
</html>
