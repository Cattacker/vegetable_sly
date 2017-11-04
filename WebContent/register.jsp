<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>注册</title>
<s:head/>

</head>
<body>
		<h2>注册</h2>
        <s:form id="regform" action="RegAction" >
        <s:fielderror name="error"></s:fielderror>
        ID:<br><input type="text" name="id" />
        <br>NickName:<br><input type="text"name="nickname" />
        <br>PassWord:<br><input type="password" name="password" />
        <br>RePassWord:<br><input type="password" name="repassword" />
        <s:submit value="注册" /> 
        </s:form >
        <input type="button" value="返回首页" onclick="window.location.href='start.jsp';"/>
   		
</body>
</html>