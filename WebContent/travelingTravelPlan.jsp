<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>正在执行的计划</title>
    <style type="text/css">
        <!--
        body,div,p,ul,li,font,span,td,th{
            font-size:10pt;
            line-height:155%;
        }
        table{
            border-top-width: 1px;
            border-right-width: 1px;
            border-bottom-width: 0px;
            border-left-width: 1px;
            border-top-style: solid;
            border-right-style: solid;
            border-bottom-style: none;
            border-left-style: solid;
            border-top-color: #CCCCCC;
            border-right-color: #CCCCCC;
            border-bottom-color: #CCCCCC;
            border-left-color: #CCCCCC;
        }
        td{
            border-bottom-width: 1px;
            border-bottom-style: solid;
            border-bottom-color: #CCCCCC;
        }
        .EditCell_TextBox {
            width: 90%;
            border:1px solid #0099CC;
        }
        .EditCell_DropDownList {
            width: 90%;
        }
        -->
    </style>
    

    <title>我的旅游计划</title>
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
		          <a class="nav-link" href="GetMyTravelPlanList_getUnstart.action">待执行计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="GetMyTravelPlanList_getTraveling.action">正在执行计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="GetMyTravelPlanList_getOver.action">未评价计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="GetMyTravelPlanList_getRated.action">已评价计划</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="newPersonalTravelPlan.jsp">新建计划</a>
		        </li>
		        <li>
		          <a class="nav-link" href="NewTeam_show.action">新建团队</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="QueryTeam.action">我的团队</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="QueryApplyTeam.action">系统消息</a>
		        </li>
		      </ul>
			</div>
			<ul><s:fielderror name="error"/></ul>
			</div>

	<h4>我的计划</h4>
    <table width="1200" border="0" cellpadding="0" cellspacing="0" id="tabProduct">
        <tr>
            <td width="100" bgcolor="#EFEFEF" Name="TeamID" EditType="TextBox">计划名</td>
            <td width="100" bgcolor="#EFEFEF" Name="TeamID" EditType="TextBox">开始时间</td>
            <td width="400" bgcolor="#EFEFEF" Name="Path" EditType="TextBox">出发地 </td>
            <td width="400" bgcolor="#EFEFEF" Name="WishDate" EditType="TextBox">目的地</td>
            <td width="200" bgcolor="#EFEFEF" Name="WishDate" EditType="TextBox">操作</td>
        </tr>
		<s:iterator value="personalTravelingPlans">
			<form action="SetMyTravelPlan_globalChangeName">
			<tr>
				<th><s:property value="name"/></th>
				<th><s:property value="beginningDate"/></th>
				<th><s:property value="path.start.name"/></th>
				<th><s:property value="path.end.name"/></th>
				<th>
					<a href="GetMyTravelPlan.action?planId=${id}">查看</a>
				</th>
			</tr>
			<input type="hidden" name="planId" value="${id}"/>
			</form>
		</s:iterator>
	</table>
	
	<h4>我参与的计划</h4>
    <table width="1200" border="0" cellpadding="0" cellspacing="0" id="tabProduct">
        <tr>
            <td width="100" bgcolor="#EFEFEF" Name="TeamID" EditType="TextBox">计划名</td>
            <td width="100" bgcolor="#EFEFEF" Name="TeamID" EditType="TextBox">开始时间</td>
            <td width="400" bgcolor="#EFEFEF" Name="Path" EditType="TextBox">出发地 </td>
            <td width="400" bgcolor="#EFEFEF" Name="WishDate" EditType="TextBox">目的地</td>
            <td width="200" bgcolor="#EFEFEF" Name="WishDate" EditType="TextBox">操作</td>
        </tr>
		<s:iterator value="teamTravelingPlans">
			<tr>
				<th><s:property value="name"/></th>
				<th><s:property value="beginningDate"/></th>
				<th><s:property value="path.start.name"/></th>
				<th><s:property value="path.end.name"/></th>
				<th>
					<a href="GetMyTravelPlan.action?planId=${id}">查看</a>
				</th>
			</tr>
		</s:iterator>
	</table>




</body>
</html>