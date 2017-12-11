<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
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
							<a href="MyDetails3.action?id=${sessionScope.user_ID}">个人主页</a> <span class="divider">/</span>
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
		          <a class="nav-link" href="expresseditor.action">旅游攻略</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" href="QueryUsers.jsp">用户查询</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="QueryTeams.jsp">团队查询</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="path.jsp">路线查询</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="newplan.html">创建计划</a>
		        </li>
		      </ul>
			</div>
			<ul class="nav nav-pills nav-fill">
			</ul>
			
					
					<s:form class="form-horizontal" role="form"  action="OthersDedails.action">
						<div class="col-md-6">
  						<div class="form-group">
    						<label for="firstname" class="col-sm-2 control-label">关键字</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" name="id" placeholder="请输入关键字进行查询">
						    </div>
						  </div>
						  </div>
						  <div class="col-md-3">
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <button type="submit" class="btn btn-primary">查找</button>
						  	</div>
						 </div>
						 </div>
					</s:form>
					<s:fielderror name="error"></s:fielderror>
					
					<table width="698" border="0" cellpadding="0" cellspacing="0" id="tabProduct">
        <tr>
        	<td width="186" bgcolor="#EFEFEF" >团队id</td>
            <td width="186" bgcolor="#EFEFEF" >申请者id</td>
            <td width="186" bgcolor="#EFEFEF" >操作</td>
            <td width="186" bgcolor="#EFEFEF" >操作</td>
        </tr>

        <s:iterator value="applyteams">
            <tr>
            	<td>${teamid}</td>
                <td>${userid}</td>
                <td><a class="nav-link active" href="AllowApplyTeam.action?teamid=${teamid}&userid=${userid}">同意</a></td>  
                <td><a class="nav-link active" href="RefuseApplyTeam.action?teamid=${teamid}&userid=${userid}">拒绝</a></td>  
            </tr>
            
        </s:iterator>
				
					    
				
		</div>
		
	
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>
        