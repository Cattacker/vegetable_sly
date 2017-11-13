<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户查询</title>

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
					 <c:choose>
						<c:when test="${sessionScope.user_ID==null}">
							<a href="login.jsp">登陆</a> <span class="divider">/</span>
							<a href="register.jsp">注册</a> <span class="divider">/</span>
						</c:when>
						 <c:when test="${sessionScope.user_ID!=null}">
							<button type="button" class="btn btn-primary btn-lg" style="font-size: 10px" onclick="window.location.href='homepage.jsp';">
										<span class="glyphicon glyphicon-user"></span> 我的主页
							</button>
						</c:when>
					  </c:choose>
					</ul>
				</div>
			</div>
		</div>
    		<div class="container" style="padding-top: 20px; margin-top: 20px">
		      <ul class="nav nav-pills nav-fill">
		        <li class="nav-item">
		          <a class="nav-link" href="">旅游攻略</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" href="QueryUsers.jsp">用户查询</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="path.jsp">查询路线</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="searchauthorrequest?">待加</a>
		        </li>
		      </ul>
			</div>
			<ul class="nav nav-pills nav-fill">
			</ul>
			<div class="row">
				<div class="col-md-2">
				</div>
				
					<form class="form-horizontal" role="form"  action="LoginAction.action">
						<div class="col-md-6">
  						<div class="form-group">
    						<label for="firstname" class="col-sm-2 control-label">关键字</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" name="keywords" placeholder="请输入关键字进行查询">
						    </div>
						  </div>
						  </div>
						  <div class="col-md-3">
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <button type="submit" class="btn btn-default">查找</button>
						  	</div>
						 </div>
						 </div>
					</form>
				<div class="col-md-1">
				</div>
			</div>
			
		</div>
		
	
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>
        