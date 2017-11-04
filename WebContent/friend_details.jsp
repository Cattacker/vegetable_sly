<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>好友详细信息</title>
</head>
<body>
	<table border="1">
	<tr>
 	 	<th>ID</th>
  		<td>${id}</td>
	</tr>
	<tr>
 	 	<th>NickName</th>
  		<td>${nickname}</td>
	</tr>
	<tr>
 	 	<th>Name</th>
  		<td>${name}</td>
	</tr>
	<tr>
 	 	<th>Sex</th>
  		<td>${sex}</td>
	</tr>
	<tr>
 	 	<th>ComCity</th>
  		<td>${comcity}</td>
	</tr>
	<tr>
 	 	<th>Birthday</th>
  		<td>${birthday}</td>
	</tr>
	<tr>
 	 	<th>PhoneNum</th>
  		<td>${phonenum}</td>
	</tr>
	</table>

</body>
</html>