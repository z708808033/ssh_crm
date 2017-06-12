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
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			background: #f0ffff;
		}
		a {
			text-decoration: none;
		}
	</style>
  </head>
  
  <body>
 	<h2>客户管理</h2>
	<a href="<c:url value='/customerAction_toAddPage.action'/>"  target="body">&nbsp; - 新增客户</a><br/>
	<a href="<c:url value='/customerAction_findAllCustomer.action'/>"  target="body">&nbsp; - 客户列表</a><br/>
	<a href="<c:url value='/customerAction_listPage.action?currentPage=1&cname='/>"  target="body">&nbsp; - 分页客户列表</a><br/>
	<h2>联系人管理</h2>
	<a href="<c:url value='/linkmanAction_toAddPage.action'/>"  target="body">&nbsp; - 新增联系人</a><br/>
	<a href="<c:url value='/linkmanAction_findLinkman.action?currentPage=1&lname='/>"  target="body">&nbsp; - 联系人列表</a><br/>
	<h2>客户拜访管理</h2>
	<a href="<c:url value='/visitAction_toAddPage.action'/>"  target="body">&nbsp; - 新增客户拜访</a><br/>
	<a href="<c:url value='/visitAction_findAllVisit.action'/>"  target="body">&nbsp; - 客户拜访列表</a><br/>
	<h2>综合查询</h2>
	<a href="<c:url value='/jsps/condition/customer.jsp'/>"  target="body">&nbsp; - 客户信息查询</a><br/>
	<a href="<c:url value='/linkmanAction_toConditionPage.action'/>"  target="body">&nbsp; - 联系人信息查询</a><br/>
	<a href="<c:url value='/visitAction_toConditionPage.action'/>"  target="body">&nbsp; - 拜访信息查询</a><br/>
	<h2>统计分析</h2>
	<a href="<c:url value='/customerAction_countLevel.action'/>"  target="body">&nbsp; - 客户等级统计</a><br/>
	<a href="<c:url value='/customerAction_countSource.action'/>"  target="body">&nbsp; - 客户来源统计</a><br/>
  </body>
</html>