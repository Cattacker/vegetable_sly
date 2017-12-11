<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    
  </head>
  <body>
  
  
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			
			<ul class="breadcrumb">
				<li>
				<a class="navbar-brand" href="index?">寻找“驴友”</a>
				</li>
				<li>
					<a href="homepage.jsp">个人主页</a> <span class="divider">/</span>
				</li>
				<li>
					<a href="start.jsp">首页</a> <span class="divider">/</span>
				</li>
				
			</ul>
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">
					<form class="form-horizontal" role="form"  action="RegAction.action">
						<s:fielderror name="error"/>
						
  						<div class="form-group">
    						<label for="firstname" class="col-sm-2 control-label">团队名</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" name="id" placeholder="请输入用户名10位字符">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="lastname" class="col-sm-2 control-label"></label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control" name="nickname" placeholder="请输入昵称6-8位字符">
						    </div>
						  </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <button type="submit" class="btn btn-default">注册</button>
						  </div>
						</div>
					</form>
				</div>
				<div class="col-md-3">
				</div>
			</div>
			<ul class="breadcrumb">
				
			</ul>
		</div>
	</div>
</div>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>
		