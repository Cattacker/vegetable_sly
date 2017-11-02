<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>注册</title>
<s:head theme="ajax"/>

</head>
<body>
		<h2>注册</h2>
        <s:form id="regform" action="RegAction" method='post'  theme="ajax">
        <s:textfield name="id" label="ID"/>
        <s:textfield name="nickname" label="NickName"/>
        <s:textfield name="password" label="PassWord"/>
        <s:textfield name="repassword" label="repassword"></s:textfield>
        <s:submit value="注册" targets="show"/> 
        </s:form >
        <div id="show" ></div>
        <input type="button" value="返回首页" onclick="window.location.href='start.jsp';"/>
   		
</body>
</html>