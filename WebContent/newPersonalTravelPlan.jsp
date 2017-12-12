<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">

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
	<title>新建计划</title>
	<sx:head/>
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
		      </ul>
			</div>
			<ul><s:fielderror name="error"/></ul>
			</div>
	<form action="NewTravelPlan_newTravelPlan">
	
		<div id="l-map"></div>
		计划名:<s:textfield name="name"/>
		<br/>出发日期:<sx:datetimepicker name="date"
				displayFormat="yyyy-MM-dd" value="%{'today'}"/>
		<br/>起点:<s:textfield name="start" id="suggestId" value="百度"/>
		<br/>终点:<s:textfield name="end" id="suggestId2" value="百度"/>
		<input type="submit" value="下一步"/>
		
	</form>

</body>
</html>

<script type="text/javascript">
	
	// 百度地图API功能
	function G(id) {
		return document.getElementById(id);
	}
	
	var map = new BMap.Map("l-map");
	map.centerAndZoom("北京",12);                   // 初始化地图,设置城市和地图级别。

	var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
		{"input" : "suggestId"
		,"location" : map
	});
  	var ac2 = new BMap.Autocomplete(    //建立一个自动完成的对象
		{"input" : "suggestId2"
		,"location" : map
	});
  	var ac3 = new BMap.Autocomplete(    //建立一个自动完成的对象
  			{"input" : "suggestId3"
  			,"location" : map
  		});
  	var ac4 = new BMap.Autocomplete(    //建立一个自动完成的对象
  			{"input" : "suggestId4"
  			,"location" : map
  		});
  	var ac5 = new BMap.Autocomplete(    //建立一个自动完成的对象
  			{"input" : "suggestId5"
  			,"location" : map
  		});
  	var ac6 = new BMap.Autocomplete(    //建立一个自动完成的对象
  			{"input" : "suggestId6"
  			,"location" : map
  		});
  	var ac7 = new BMap.Autocomplete(    //建立一个自动完成的对象
  			{"input" : "suggestId7"
  			,"location" : map
  		});

	ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
	var str = "";
		var _value = e.fromitem.value;
		var value = "";
		if (e.fromitem.index > -1) {
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
		
		value = "";
		if (e.toitem.index > -1) {
			_value = e.toitem.value;
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
		G("searchResultPanel").innerHTML = str;
	});
  
  	ac2.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
	var str = "";
		var _value = e.fromitem.value;
		var value = "";
		if (e.fromitem.index > -1) {
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
		
		value = "";
		if (e.toitem.index > -1) {
			_value = e.toitem.value;
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
		G("searchResultPanel").innerHTML = str;
	});
  	
  	ac3.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
  		var str = "";
  			var _value = e.fromitem.value;
  			var value = "";
  			if (e.fromitem.index > -1) {
  				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			}    
  			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
  			
  			value = "";
  			if (e.toitem.index > -1) {
  				_value = e.toitem.value;
  				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			}    
  			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
  			G("searchResultPanel").innerHTML = str;
  		});

  	ac4.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
  		var str = "";
  			var _value = e.fromitem.value;
  			var value = "";
  			if (e.fromitem.index > -1) {
  				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			}    
  			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
  			
  			value = "";
  			if (e.toitem.index > -1) {
  				_value = e.toitem.value;
  				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			}    
  			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
  			G("searchResultPanel").innerHTML = str;
  		});

  	ac5.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
  		var str = "";
  			var _value = e.fromitem.value;
  			var value = "";
  			if (e.fromitem.index > -1) {
  				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			}    
  			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
  			
  			value = "";
  			if (e.toitem.index > -1) {
  				_value = e.toitem.value;
  				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			}    
  			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
  			G("searchResultPanel").innerHTML = str;
  		});

  	ac6.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
  		var str = "";
  			var _value = e.fromitem.value;
  			var value = "";
  			if (e.fromitem.index > -1) {
  				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			}    
  			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
  			
  			value = "";
  			if (e.toitem.index > -1) {
  				_value = e.toitem.value;
  				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			}    
  			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
  			G("searchResultPanel").innerHTML = str;
  		});

  	ac7.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
  		var str = "";
  			var _value = e.fromitem.value;
  			var value = "";
  			if (e.fromitem.index > -1) {
  				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			}    
  			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
  			
  			value = "";
  			if (e.toitem.index > -1) {
  				_value = e.toitem.value;
  				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			}    
  			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
  			G("searchResultPanel").innerHTML = str;
  		});


	var myValue;
  	var myValue2;
  	var myValue3;
  	var myValue4;
  	var myValue5;
  	var myValue6;
  	var myValue7;
	ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	var _value = e.item.value;
		myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
		setPlace();
	});
  	ac2.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	var _value = e.item.value;
		myValue2 = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue2;
		setPlace();
	});
  	ac3.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
  		var _value = e.item.value;
  			myValue3 = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue2;
  			setPlace();
  		});
  	ac4.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
  		var _value = e.item.value;
  			myValue4 = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue2;
  			setPlace();
  		});
  	ac5.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
  		var _value = e.item.value;
  			myValue5 = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue2;
  			setPlace();
  		});
  	ac6.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
  		var _value = e.item.value;
  			myValue6 = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue2;
  			setPlace();
  		});
  	ac7.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
  		var _value = e.item.value;
  			myValue7 = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
  			G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue2;
  			setPlace();
  		});
</script>
