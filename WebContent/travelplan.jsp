<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>我的旅游计划</title>
</head>
<body>
		<h2>我的旅游计划</h2>
		<table border="1">
		<thead>  
                <tr>  
                    <td>ID</td>  
                    <td>TeamID</td>
                    <td>Path</td>
                    <td>WishDate</td>
                </tr>  
            <thead>  
            <tbody id="tb">  
            	<s:iterator value="travelplan">
         	<td>${ID} </td>
            <td>${teamID} </td>
            <td>${path}</td>
            <td>${wishdate}</td>
         </s:iterator>
            </tbody>  

  		
  		</table>
</body>
</html>