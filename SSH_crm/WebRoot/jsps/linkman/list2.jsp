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
    
    <title>My JSP 'list2.jsp' starting page</title>
    
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
  	<h1>联系人列表</h1><br/><hr/>
  	<table cellpadding="10" cellspacing="0" border="1" bordercolor="orange">
	  		<tr>
	  			<th>联系人名称</th>
	  			<th>联系人性别</th>
	  			<th>联系人电话</th>
	  			<th>联系人所属客户</th>
	  			<th>操作</th>
	  		</tr>
	  		<c:forEach var="linkman" items="${requestScope.linkmanList }">
	  			<tr align="center">
	  				<td>${linkman.lkmName }</td>
	  				<td>${linkman.lkmGender }</td>
	  				<td>${linkman.lkmPhone }</td>
	  				<td>${linkman.customer.custName }</td>
	  				<td><a href="<c:url value='/linkmanAction_preEdit.action?lid=${linkman.lid }' />">修改</a>&nbsp;&nbsp;
	  					<a href="<c:url value='/linkmanAction_delete.action?lid=${linkman.lid }' />">删除</a></td>
	  			</tr>
	  		</c:forEach>
	  	</table>
  </body>
</html>
