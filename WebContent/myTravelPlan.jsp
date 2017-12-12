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
	<title>个人计划-修改</title>
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
		<th>状态 : </th>
		<th>${travelState}</th>
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
	</table>
	<table>
		<tr>
			<th>
			<s:if test="plan.unstart == true">
				<s:if test="plan.teamPlan == false">
					<form action="SetMyTravelPlan_show">
						<input type="hidden" name="planId" value="${planId}"/>
						<input type="submit" value="修改"/>
					</form>
				</s:if>
			</s:if>
			<s:elseif test="plan.rated == true">
				
			</s:elseif>
			<s:elseif test="plan.over == true">
				<form action="RatePath">
					<input type="hidden" name="planId" value="${planId}"/>
					<s:textfield name="rate"/>
					<s:submit value="评价"/>
				</form>
			</s:elseif>
			<s:else>
				<form action="AddLog">
					<s:textfield name="text"/>
					<input type="hidden" name="planId" value="${planId}"/>
					<s:submit value="添加日志"/>
				</form>
				<s:if test="plan.teamPlan == false">
					<a href="SetMyTravelPlan_over.action?planId=${planId}">完成旅行</a>
				</s:if>
			</s:else>
			</th>
		</tr>
	</table>
	<s:if test="plan.unstart == false">
	<br/><br/>
	<h4>日志</h4>
	<table width="1200">
		<tr>
			<th width="50">序号</th>
			<th width="100">日期</th>
			<th width="1050">日志</th>
		</tr>
		<s:iterator value="plan.reverseLog" id="log">
				<tr>
					<th width="50">${log.index + 1}</th>
					<th width="100">${log.date}</th>
					<th width="1050">${log.text}</th>
				</tr>
		</s:iterator>
	</table>
	</s:if>
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
