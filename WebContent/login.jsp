<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>登陆</title>
<s:head theme="ajax"/>

</head>
<body>
		<h2>登陆</h2>
        <s:form id="loginform" action="LoginAction" method='post'  theme="ajax">
        <s:textfield name="id" label="ID"/>
        <s:textfield name="password" label="PassWord"/>
        <s:submit value="登陆" targets="show" /> 
        </s:form >
        <div id="show" ></div>
        <input type="button" value="返回首页" onclick="window.location.href='start.jsp';"/>
   		<a href="register.jsp">注册</a>
   		<a href="LogoutAction.action">注销</a>
</body>
</html>