<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>登陆</title>

</head>
<body>
		<h2>登陆</h2>
        <s:form id="loginform" action="LoginAction" >
        <s:fielderror name="error"/>
        <br>
        ID:<br><input type="text" name="id" />
        <br>
        PassWord:<br><input type="password"  name="password"/>
        <br>
        <s:submit value="登陆" /> 
        </s:form >
        
        <input type="button" value="返回首页" onclick="window.location.href='start.jsp';"/>
   		<input type="button" value="注册" onclick="window.location.href='register.jsp';"/>
   		<a href="LogoutAction.action">注销</a>
</body>
</html>