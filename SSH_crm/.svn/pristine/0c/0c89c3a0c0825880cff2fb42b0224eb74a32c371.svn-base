<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
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
  	<h1>添加客户</h1><br/>
  	<s:property value="msg" /><hr/>
  	<form action="<c:url value='/customerAction_addCustomer.action'/>" method="post">
	  	客户名称:<input type="test" name="custName" value="<s:property value='customer.custName'/>"/><br/><br/>
	  	客户等级:
	  	<select name="dict.did">
	  		<c:forEach items="${requestScope.dictList }" var="dict">
		  		<option value="${dict.did }" <c:if test="${requestScope.customer.dict.did eq dict.did }">selected="selected"</c:if> >${dict.dname }</option>
	  		</c:forEach>
	  	</select><br/><br/>
	  	客户来源:
	  	<select name="custSource">
	  		<option value="网络" <c:if test="${requestScope.customer.custSource eq '网络' }">selected="selected"</c:if> >网络</option>
	  		<option value="报纸" <c:if test="${requestScope.customer.custSource eq '报纸' }">selected="selected"</c:if> >报纸</option>
	  		<option value="其他" <c:if test="${requestScope.customer.custSource eq '其他' }">selected="selected"</c:if> >其他</option>
	  	</select><br/><br/>
	  	客户电话:<input type="test" name="custPhone" value="<s:property value='customer.custPhone'/>"/><br/><br/>
	  	<input type="submit" value="添加"/>
  	</form>
  </body>
</html>
