<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	<title>个人计划-修改</title>
	<sx:head/>

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
	<table>
	<tr>
		<s:if test="#plan.team == false">
			<th>个人计划名:</th>
		</s:if>
		<s:else>
			<th>团队计划名:</th>
		</s:else>
		<th>${plan.name}</th></tr>
	<tr>
		<th>出发时间:</th>
		<th>${plan.beginningDate}</th>
	</tr>
	<tr>
		<th>状态 : </th>
		<th>${travelState}</th>
	</tr>
	</table>
	
	<table>
		<tr>
			<th>${plan.path.text}</th>
		</tr>
		<tr>
			<th>
			<s:if test="plan.unstart == true">
				<s:if test="plan.team == false">
					<a href="SetMyTravelPlan_show.action?planId=${planId}">修改</a>
				</s:if>
			</s:if>
			<s:elseif test="plan.rated == true">
				
			</s:elseif>
			<s:elseif test="plan.over == true">
			
			</s:elseif>
			<s:else>
				
			</s:else>
			</th>
		</tr>
	</table>
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
	var ac1 = new BMap.Autocomplete(    //建立一个自动完成的对象
		{"input" : "suggestId1"
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
	ac1.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
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
	var myValue1;
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
	ac1.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	var _value = e.item.value;
		myValue1 = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue1;
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