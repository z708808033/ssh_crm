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
  	<h1>联系人信息查询</h1><br/><hr/>
  	<form action="<c:url value='/linkmanAction_findByCondition.action'/>" method="post">
  		联系人名称:<input type="test" name="lkmName"/><br/><br/>
  		联系人所属客户:
  		<select name="customer.cid">
 			<option value="-1">不限</option>
  			<c:forEach items="${requestScope.customerList }" var="customer">
  				<option value="${customer.cid }">${customer.custName }</option>
  			</c:forEach>
  		</select><br/><br/>
  		<input type="submit" value="查询"/>
  	</form>
  </body>
</html>
