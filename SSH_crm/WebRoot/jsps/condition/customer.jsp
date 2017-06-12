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
    
    <title>My JSP 'Customer.jsp' starting page</title>
    
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
  	<h1>客户信息查询</h1><br/><hr/>
  	<form action="<c:url value='/customerAction_findByCondition.action'/>" method="post">
  		客户名称:<input type="test" name="custName"/><br/><br/>
  		客户级别:
  		<select name="custLevel">
  			<option value="">不限</option>
  			<option value="vip">vip</option>
  			<option value="普通客户">普通客户</option>
  		</select><br/><br/>
  		客户来源:
  		<select name="custSource">
  			<option value="">不限</option>
  			<option value="网络">网络</option>
  			<option value="报纸">报纸</option>
  			<option value="其他">其他</option>
  		</select><br/><br/>
  		<input type="submit" value="查询"/>
  	</form>
  </body>
</html>
