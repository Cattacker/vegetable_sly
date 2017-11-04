<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>主页</title>
</head>
<body>
		<h2>主页</h2>
        欢迎，${sessionScope.user_ID}，您已登录
        <input type="button" value="个人主页" onclick="window.location.href='homepage.jsp';"/>
   		<input type="button" value="注册" onclick="window.location.href='register.jsp';"/>
   		<a href="LogoutAction.action">注销</a>
</body>
</html>