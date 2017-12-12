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
		<th>计划名:</th>
		<th>${plan.name}</th></tr>
	<tr>
	<form action="SetMyTravelPlan_changeName">
		<th>新计划名:</th>
		<th>
			<s:textfield name="newName"></s:textfield>
			<input name="planId" type="hidden" value="${planId}"/>
			<s:submit type="submit" value="提交修改"/>
		</th>
	</form>
	</tr>
	<tr>
		<th>出发时间:</th>
		<th>${plan.beginningDate}</th>
	</tr>
	<tr>
		<th>新出发日期:</th>
		<th>
		<form action="SetMyTravelPlan_changeBeginningDate">
			<sx:datetimepicker name="newBeginningDate"
				displayFormat="yyyy-MM-dd"></sx:datetimepicker>
			<input name="planId" type="hidden" value="${planId}"/>
			<s:submit value="提交修改"/>
		</form>
		</th>
	</tr>
	</table>
	<table>
		<tr>
			<th>
				${plan.path.start.name}
			</th>
			
			<s:iterator value="plan.path.locations" id="location" status="status">
			<s:if test="#status.first == false">
			<s:if test="#status.last == false">
				<th>
					<form action="SetMyTravelPlan_newLocation">
						<div id="l-map"></div>
						<input type="text" name="newLocation" id="suggestId${status.index}" value="百度"/>
						<input name="planId" type="hidden" value="${planId}"/>
						<input name="locationIndex" type="hidden" value="${status.index}"/>
						<input type="submit" value="添加地点"/>
					</form>
				</th>
				<th>
					${name}
					<form action="SetMyTravelPlan_deleteLocation">
						<input name="locationIndex" type="hidden" value="${status.index}"/>
						<input name="planId" type="hidden" value="${planId}"/>
						<input type="submit" value="删除"/>
					</form>
				</th>
			</s:if>
			</s:if>
			</s:iterator>
			
			<th>
				<form action="SetMyTravelPlan_newLocation">
					<div id="l-map"></div>
					<input type="text" name="newLocation" id="suggestId" value="百度"/>
					<input name="planId" type="hidden" value="${planId}"/>
					<input name="locationIndex" type="hidden" value="${plan.size - 1}"/>
					<input type="submit" value="添加地点"/>
				</form>
			</th>
			
			<th>
				${plan.path.end.name}
			</th>
			
		</tr>
		<tr>
			<th><a href="GetMyTravelPlan.action?planId=${planId}">完成修改</a></th>
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