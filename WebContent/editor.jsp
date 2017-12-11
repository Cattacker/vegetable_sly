<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>编写旅游日志</title>
	<script src="ckeditor/ckeditor.js"></script>
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
							<a href="MyDetails.action?id=${sessionScope.user_ID}">个人主页</a> <span class="divider">/</span>
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
		          <a class="nav-link" href="MyDetails.action?id=${sessionScope.user_ID}">我的信息</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" href="QueryFriends.action">我的好友</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="QueryTravelPlan.action?state=0">待执行计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="QueryTravelPlan.action?state=1">正在执行计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="QueryTravelPlan.action?state=2">未评价计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="QueryTravelPlan.action">全部计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="QueryTeam.action">我的团队</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="editor.jsp">编写攻略</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="QueryApplyTeam.action">系统消息</a>
		        </li>
		      </ul>
			</div>
			<ul><s:fielderror name="error"/></ul>
			<form action="editor.action">
            <textarea name="editor1" id="editor1" rows="10" cols="80">
                请在这里开始编辑
            </textarea>
            <script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace( 'editor1' );
            </script>
            <input type="submit" value="提交"/>
        </form>
		</div>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>