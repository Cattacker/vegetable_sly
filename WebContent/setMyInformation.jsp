<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改个人信息</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    
  </head>
  <body>
  	<div class="container-fluid">
  	<div class="col-md-12">
			<div class="row">
				<div class="col-md-10">
					<ul class="breadcrumb">
						<li>
						<a class="navbar-brand" href="index.jsp">寻找“驴友”</a>
						</li>
						<li>
							<a href="homepage.jsp">个人主页</a> <span class="divider">/</span>
						</li>
						<li>
							<a href="start.jsp">首页</a> <span class="divider">/</span>
						</li>
					</ul>
				</div>
				<div class="col-md-2">
					<ul class="breadcrumb">
					<li>
					 	<a href="LogoutAction.action">注销</a>
					 </li>
					</ul>
				</div>
			</div>
			</div>
    		<div class="container" style="padding-top: 20px; margin-top: 20px">
		      <ul class="nav nav-pills nav-fill">
		        <li class="nav-item">
		          <a class="nav-link" href="homepage.jsp">我的信息</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" href="QueryFriends.action">我的好友</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="">待执行计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="">正在执行计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="">未评价计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="QueryTravelPlan.action">全部计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="searchauthorrequest?">待加</a>
		        </li>
		      </ul>
			</div>
			<ul><s:fielderror name="error"/></ul>
			
			<s:form action="SetMyInformation_commit" >
    	<input type="hidden" name="user.id" value="${id}"/>
    	ID : ${id}<br/>
		<s:textfield name="user.nickname" label="昵称" >${nickname}</s:textfield>
		<s:textfield name="user.name" label="姓名" >${name}</s:textfield>
		<s:textfield name="user.startCity" label="常用出发城市"
					value="${comcity}"/>
		<s:textfield name="user.birthday" label="出生日期"
					value="${birthday}"/>
		<s:textfield name="user.phoneNum" label="电话号码"
					value="${phonenum}"/>
		<s:submit value="提交修改" /> 
	</s:form >
			
		</div>
	
	
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

</body>
</html>