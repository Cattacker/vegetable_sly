<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>个人主页</title>
</head>
<body>
		<h2>个人主页</h2>
        <input type="button" value="加好友" onclick="window.location.href='AddFriends.action?followed=1152340113';"/>
		<s:fielderror  name="error"/>
		<input type="button"  value="我的好友" onclick="window.location.href='QueryFriends.action';">
		<input type="button"  value="我的旅游计划" onclick="window.location.href='QueryTravelPlan.action';">
	
</body>
</html>