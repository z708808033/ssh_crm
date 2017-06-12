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
    
    <title>My JSP 'listPage.jsp' starting page</title>
    
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
	<h1>客户分页列表</h1><br/><hr/>
	<form method="post" action="<c:url value='/customerAction_listPage.action?currentPage=1'/>">
	  	客户名称:<input type="text" name="cname" value="${cname }"/> <input type="submit" value="筛选"/><br/><br/>
  	</form>
  	<table cellpadding="10" cellspacing="0" border="1" bordercolor="orange">
  		<tr>
  			<th>客户名称</th>
  			<th>客户级别</th>
  			<th>客户来源</th>
  			<th>客户电话</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach items="${requestScope.pageBean.list }" var="customer">
  			<tr align="center">
  				<td>${customer.custName }</td>
  				<td>${customer.dict.dname }</td>
  				<td>${customer.custSource }</td>
  				<td>${customer.custPhone }</td>
  				<td><a href="<c:url value='/customerAction_preEdit.action?cid=${customer.cid }' />">修改</a>&nbsp;&nbsp;
  					<a href="<c:url value='/customerAction_delete.action?cid=${customer.cid }' />">删除</a></td>
  			</tr>
  		</c:forEach>
  	</table>
  		<br/>
  		共[${requestScope.pageBean.totalCount}]条记录,
  		当前第[${requestScope.pageBean.currentPage}]页 / 共[${requestScope.pageBean.totalPage}]页 
  		<c:if test="${requestScope.pageBean.currentPage > 1 }">
  		<a href="<c:url value='/customerAction_listPage.action?currentPage=${requestScope.pageBean.currentPage-1 }&cname=${cname }'/>">[上一页]</a>
  		</c:if> 
  		<c:if test="${requestScope.pageBean.currentPage < requestScope.pageBean.totalPage }">
  		<a href="<c:url value='/customerAction_listPage.action?currentPage=${requestScope.pageBean.currentPage+1 }&cname=${cname }'/>">[下一页]</a>
  		</c:if>
  </body>
</html>
