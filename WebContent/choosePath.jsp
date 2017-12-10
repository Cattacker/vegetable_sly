<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择一条路线</title>
</head>
<body>
	<h5>${name}</h5><br/>
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