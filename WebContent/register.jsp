<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta charset="GBK">
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
				<a class="navbar-brand" href="index.jsp">寻找“驴友”</a>
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
    						<label for="firstname" class="col-sm-2 control-label">用户名</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" name="id" placeholder="请输入用户名,8~16位字符">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="lastname" class="col-sm-2 control-label">昵 称</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" name="nickname" placeholder="请输入昵称,10位以下字符">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="lastname" class="col-sm-2 control-label">密 码</label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control" name="password" placeholder="请输入密码,8~16位字符">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="lastname" class="col-sm-2 control-label">确认密码</label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control" name="repassword" placeholder="请再次输入密码">
						    </div>
						  </div>
						  <li>  
                    <label class="enterText">旅行爱好：</label>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="1" class="type" id="typeA" name="type"/>  
                        <label for="typeA">地文景观</label>  
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="2" class="type" id="typeB" name="type"/>  
                        <label for="typeB">水域风光</label>   
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="3" class="type" id="typeC" name="type"/>  
                        <label for="typeC">生物景观</label>   
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="4" class="type" id="typeD" name="type"/>  
                        <label for="typeD">天象与气候</label>   
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="5" class="type" id="typeE" name="type"/>  
                        <label for="typeA">历史遗迹</label>  
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="6" class="type" id="typeF" name="type"/>  
                        <label for="typeB">建筑物</label>   
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="7" class="type" id="typeG" name="type"/>  
                        <label for="typeC">博物馆</label>   
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="8" class="type" id="typeH" name="type"/>  
                        <label for="typeD">民族民俗</label>   
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="9" class="type" id="typeI" name="type"/>  
                        <label for="typeA">宗教</label>  
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="10" class="type" id="typeJ" name="type"/>  
                        <label for="typeB">主题公园</label>   
                    </p>
                    <p class="enterRadio">
                        <input type="checkbox" value="11" class="type" id="typeK" name="type"/>  
                        <label for="typeC">旅游度假区</label>   
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="12" class="type" id="typeL" name="type"/>  
                        <label for="typeD">美食类</label>   
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="13" class="type" id="typeM" name="type"/>  
                        <label for="typeA">探险类</label>  
                    </p>  
                    <p class="enterRadio">  
                        <input type="checkbox" value="14" class="type" id="typeN" name="type"/>  
                        <label for="typeB">刺激类</label>   
                    </p>  
                    <div class="Validform_checktip"></div>  
                </li>  
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
		