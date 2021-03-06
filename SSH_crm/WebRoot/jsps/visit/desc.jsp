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
    
    <title>My JSP 'addCustomer.jsp' starting page</title>
    
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
  	<h1>编辑拜访</h1><br/><hr/>
  	<form action="<c:url value='/visitAction_edit.action'/>" method="post">
  		<input type="hidden" name="vid" value="${requestScope.visit.vid }"/>
	  	用户:
	  	<select name="user.uid">
	  		<c:forEach items="${requestScope.userList }" var="user">
		  		<option value="${user.uid }" <c:if test="${requestScope.visit.user.uid eq user.uid}">selected="selected"</c:if>>${user.username }</option>
	  		</c:forEach>
	  	</select>
	  	客户:
	  	<select name="customer.cid">
	  		<c:forEach items="${requestScope.customerList }" var="customer">
		  		<option value="${customer.cid }" <c:if test="${requestScope.visit.customer.cid eq customer.cid }">selected="selected"</c:if>>${customer.custName }</option>
	  		</c:forEach>
	  	</select><br/><br/>
	  	拜访地址:<input type="test" name="visitAddress" value="${requestScope.visit.visitAddress }"/><br/><br/>
	  	拜访内容:<input type="test" name="visitContent" value="${requestScope.visit.visitContent }"/><br/><br/>
	  	<input type="submit" value="编辑"/>
  	</form>
  </body>
</html>
