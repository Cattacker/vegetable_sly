<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>主页</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script language=Javascript>
	   var bannerAD=new Array();
	   var bannerADlink=new Array();
	   var adNum=0;
	 
	   bannerAD[0]="http://localhost:8080/test1/image/gl2.png";
	   bannerADlink[0]="http://www.mafengwo.cn/poi/404.html"
	   bannerAD[1]="http://localhost:8080/test1/image/gl3.png";
	   bannerADlink[1]="http://www.mafengwo.cn/poi/405.html";
	   bannerAD[2]="http://localhost:8080/test1/image/gl4.png";
	   bannerADlink[2]="http://www.mafengwo.cn/poi/407.html";
	   bannerAD[3]="http://localhost:8080/test1/image/gl5.png";
	   bannerADlink[3]="http://www.mafengwo.cn/poi/34011.html";
	    
	   var preloadedimages=new Array();
	   for (i=1;i<bannerAD.length;i++){
	      preloadedimages[i]=new Image();
	      preloadedimages[i].src=bannerAD[i];
	   }
	 
	function setTransition(){
	   if (document.all){
	      bannerADrotator.filters.revealTrans.Transition=Math.floor(Math.random()*23);
	      bannerADrotator.filters.revealTrans.apply();
	   }
	}
	 
	function playTransition(){
	   if (document.all)
	      bannerADrotator.filters.revealTrans.play()
	}
	 
	function nextAd(){
	   if(adNum<bannerAD.length-1)adNum++ ;
	      else adNum=0;
	   setTransition();
	   document.images.bannerADrotator.src=bannerAD[adNum];
	   playTransition();
	   theTimer=setTimeout("nextAd()", 5000);
	}
	 
	function jump2url(){
	   jumpUrl=bannerADlink[adNum];
	   jumpTarget='_blank';
	   if (jumpUrl != ''){
	      if (jumpTarget != '')window.open(jumpUrl,jumpTarget);
	      else location.href=jumpUrl;
	   }
	}
	function displayStatusMsg() { 
	   status=bannerADlink[adNum];
	   document.returnValue = true;
	}
	</SCRIPT>
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
		          <a class="nav-link" href="raiders.jsp">旅游攻略</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" href="QueryUsers.jsp">用户查询</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="path.jsp">路线查询</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="newplan.html">创建计划</a>
		        </li>
		      </ul>
			</div>
			<ul>
				<s:fielderror name="error"></s:fielderror>
			</ul>
			<A onmouseover="displayStatusMsg();return document.returnValue" href="javascript:jump2url()"><IMG style="FILTER: revealTrans(duration=2,transition=20)" src="http://image2.sina.com.cn/home/images/sina_logo2.gif" border=0 name=bannerADrotator></a>
			<SCRIPT language=JavaScript>nextAd()</SCRIPT>
		</div>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>