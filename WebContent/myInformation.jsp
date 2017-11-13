<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC 
	"-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<body>
	<table border="1">
	<tr>
 	 	<th>ID</th>
  		<td>${user.id}</td>
	</tr>
	<tr>
 	 	<th>昵称</th>
  		<td>${user.nickname}</td>
	</tr>
	<tr>
 	 	<th>姓名</th>
  		<td>${user.name}</td>
	</tr>
	<tr>
 	 	<th>性别</th>
  		<td>${user.sex}</td>
	</tr>
	<tr>
 	 	<th>常用出发城市</th>
  		<td>${user.startCity}</td>
	</tr>
	<tr>
 	 	<th>出生日期</th>
  		<td>${user.birthday}</td>
	</tr>
	<tr>
 	 	<th>电话号码</th>
  		<td>${user.phoneNum}</td>
	</tr>
	</table>
	<input type="button" value="修改个人信息"
		onclick="window.location.href='SetMyInformation_getView.action';"/>
</body>
</html>