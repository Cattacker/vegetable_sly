<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	<title>个人计划-修改</title>
	<sx:head/>

<meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<title>选择一条路线</title>
</head>
<body>

	
	    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			
			<ul class="breadcrumb">
				<li>
				<a class="navbar-brand" href="index?">寻找“驴友”</a>
				</li>
				<li>
					<a href="homepage.jsp">个人主页</a> <span class="divider">/</span>
				</li>
				<li>
					<a href="start.jsp">首页</a> <span class="divider">/</span>
				</li>
				
			</ul>
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">


	<h5>计划名 : ${name}</h5><br/>
	<h5>开始日期 : ${date}</h5><br/>
	<form action="SetMyTravelPlan_show">
		<input name="planId" type="hidden" value="${planId}"/>
		<input type="submit" value="自定义路线"/>
	</form>
	<h3>系统推荐路线 : </h3><br/>
	<table>
		<s:iterator value="recommendPaths">
		<tr>
			<th>${text}</th>
			<th><form action="NewTravelPlan_choosePath">
				<input name="planId" type="hidden" value="${planId}"/>
				<input name="choosenPathId" type="hidden" value="${id}"/>
				<input type="submit" value="选择此路线"/>
			</form></th>
		</tr>
		</s:iterator>
	</table>
</body>
</html>