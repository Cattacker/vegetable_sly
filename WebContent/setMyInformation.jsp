<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改我的个人信息</title>
</head>
<body>
    <s:form action="SetMyInformation_commit" >
    	<input type="hidden" name="user.id" value="${user.id}"/>
    	ID : ${user.id}<br/>
		<s:textfield name="user.nickname" label="昵称" 
					value='${user.nickname}'/>
		<s:textfield name="user.name" label="姓名" value="${user.name}"/>
		<s:textfield name="user.startCity" label="常用出发城市"
					value="${user.startCity}"/>
		<s:textfield name="user.birthday" label="出生日期"
					value="${user.birthday}"/>
		<s:textfield name="user.phoneNum" label="电话号码"
					value="${user.phoneNum}"/>
		<s:submit value="提交修改" /> 
	</s:form >
</body>
</html>