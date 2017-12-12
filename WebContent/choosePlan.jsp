<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>选择一个计划</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    
 </head>
 <body>
  	<h4>请选择一个计划</h4>
	<table width="1200" border="0" cellpadding="0" cellspacing="0" id="tabProduct">
        <tr>
            <td width="100" bgcolor="#EFEFEF" Name="TeamID" EditType="TextBox">计划名</td>
            <td width="100" bgcolor="#EFEFEF" Name="TeamID" EditType="TextBox">开始时间</td>
            <td width="400" bgcolor="#EFEFEF" Name="Path" EditType="TextBox">出发地 </td>
            <td width="400" bgcolor="#EFEFEF" Name="WishDate" EditType="TextBox">目的地</td>
            <td width="200" bgcolor="#EFEFEF" Name="WishDate" EditType="TextBox">操作</td>
        </tr>
		<s:iterator value="planList.personalUnstartPlans">
			<tr>
				<th><s:property value="name"/></th>
				<th><s:property value="beginningDate"/></th>
				<th><s:property value="path.start.name"/></th>
				<th><s:property value="path.end.name"/></th>
				<th>
					<a href="NewTeam_choosePlan.action?planId=${id}">选择</a>
				</th>
			</tr>
		</s:iterator>
	</table>
		
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>
		