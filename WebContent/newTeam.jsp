<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	<title>输入团队名</title>
	<sx:head/>
	
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
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
	<table>
	<tr>
		<s:if test="plan.teamPlan == false">
			<th>个人计划名:</th>
		</s:if>
		<s:else>
			<th>团队计划名:</th>
		</s:else>
		<th>${plan.name}</th></tr>
	<tr>
		<th>出发时间:</th>
		<th>${plan.beginningDate}</th>
	</tr>
	<tr>
		<th>路线 : </th>
		<th>${plan.path.text}</th>
	</tr>
	<tr>
		<th>路线评分 : </th>
		<th>${plan.path.rate}</th>
	</tr>
	<tr>
		<th>评价人数 : </th>
		<th>${plan.path.rateSize}</th>
	</tr>
	<tr>
		<th>团队名称:</th>
		<th>
			<form action="NewTeam_newTeam">
				<input type="text" name="name"/>
				<input type="hidden" name="planId" value="${planId}"/>
				<input type="submit" name="提交"/>
			</form>
		</th>
	</table>

	
				</div>
				<div class="col-md-3">
				</div>
			</div>
			<ul class="breadcrumb">
				
			</ul>
		</div>
	</div>
</div>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	
</body>
</html>
