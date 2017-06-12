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
  	<h1>添加联系人</h1><br/>
  	${msg }<hr/>
  	<form action="<c:url value='/linkmanAction_add.action'/>" method="post" enctype="multipart/form-data">
	  	联系人姓名:<input type="test" name="lkmName" value="${linkman.lkmName }"/><br/><br/>
	  	联系人性别:<input type="radio" name="lkmGender" value="男" <c:if test="${linkman.lkmGender eq 男 }">checked="checked"</c:if>/>男
	  			<input type="radio" name="lkmGender" value="女" <c:if test="${linkman.lkmGender eq 女 }">checked="checked"</c:if>/>女<br/><br/>
	  	联系人电话:<input type="test" name="lkmPhone" value="${linkman.lkmPhone }"/><br/><br/>
	  	联系人所属客户:
	  	<select name="cid">
	  		<c:forEach items="${customerList }" var="customer" >
		  		<option value="${customer.cid }">${customer.custName }</option>
	  		</c:forEach>
	  	</select><br/><br/>
	  	上传:<input type="file" name="upload"/><br/><br/>
	  	<input type="submit" value="添加"/>
  	</form>
  </body>
</html>
