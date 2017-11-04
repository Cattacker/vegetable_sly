<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>我的好友</title>
</head>
<body>
		<h2>我的好友</h2>
		点击好友ID查询好友详细信息
		<table border="1">
        <tr>
        	<td>序号</td>
        	<td>ID</td>
        	<td>删除操作</td>
        </tr>
        
		<s:iterator value="friends" id="cl" status="i">
		<tr>
            <td><s:property value="#i.index+1" /></td>
            <td><a href="FriendDetails.action?id=${cl}" >${cl}</a></td>
            <td>
            	<input type="button" value="删 除" onclick="window.location.href='DeleteFriend.action?id=${cl}';"/>
			</td>
        </tr>                 
		</s:iterator>
  		
  		</table>
</body>
</html>