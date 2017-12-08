<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的计划</title>
</head>
<body>
	<h3>我的旅游计划</h3><br/>
	<p>尚未开始:</p>
		<s:iterator value="personalUnstartPlans">
		<form action="SetMyTravelPlan_show">
			<table>
			<tr>
				<th><s:property value="name"/></th>
				<th>开始时间<s:property value="beginningDate"/></th>
				<th>出发地 :<s:property value="path.start.name"/></th>
				<th>目的地 :<s:property value="path.end.name"/></th>
			</tr>
			</table>
			<input type="hidden" name="planId" value="${id}"/>
			<input type="submit" value="修改"/>
		</form>
		</s:iterator>
	<p>进行中:</p>
	<p>已结束:</p>
	<p>已评价:</p>
	<h3>我参与的团队计划</h3>
</body>
</html>