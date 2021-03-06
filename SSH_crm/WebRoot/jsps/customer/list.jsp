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
  	<h1>客户列表</h1><br/><hr/>
  	<table cellpadding="10" cellspacing="0" border="1" bordercolor="orange">
  		<tr>
  			<th>客户名称</th>
  			<th>客户级别</th>
  			<th>客户来源</th>
  			<th>客户电话</th>
  			<th>操作</th>
  		</tr>
  		<s:iterator value="customerList">
  			<tr align="center">
  				<td><s:property value="custName"/></td>
  				<td><s:property value="dict.dname"/></td>
  				<td><s:property value="custSource"/></td>
  				<td><s:property value="custPhone"/></td>
  				<td><a href="<c:url value='/customerAction_preEdit.action?cid=${cid }' />">修改</a>&nbsp;&nbsp;
  					<a href="<c:url value='/customerAction_delete.action?cid=${cid }' />">删除</a></td>
  			</tr>
  		</s:iterator>
  	</table>
  </body>
</html>
