<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html {width: 100%;height: 100%; margin:0;font-family:"Ã¥Â¾Â®Ã¨Â½Â¯Ã©ÂÂÃ©Â»Â";}
        #allmap{height:500px;width:100%;}
        #r-result,#r-result table{width:100%;}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<title>新建计划</title>
<sx:head/>
</head>
<body>
	<form action="NewTravelPlan_newTravelPlan">
		<s:textfield name="name" label="计划名"/>
		<sx:datetimepicker name="date" label="出发日期"
			displayFormat="yyyy-MM-dd" value="%{'today'}"/>
		<div id="l-map"></div>
		<div id = "r-result">
			起点:<input type="text" name="start" id="suggestId3" value="百度"/>
			
		</div><br/>
		
		<div id = "r-result">
			终点:<input type="text" name="end" id="suggestId4" value="百度"/>
			
		</div><br/>
		<input type="submit" value="下一步"/>
	</form>
	
	
	<div id="allmap"></div>
<div id="driving_way">
    <div id="l-map"></div>
    <div id="r-result1">èµ·å§å°ç¹ï¼<input type="text" name = "location" id="suggestId" size="20" value="Ã§ÂÂ¾Ã¥ÂºÂ¦" style="width:150px;" /></div>
    <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
    <div id="2-map"></div>
    <div id="r-result2">ç»æ­¢å°ç¹:<input type="text" name = "location2" id="suggestId2" size="20" value="Ã§ÂÂ¾Ã¥ÂºÂ¦" style="width:150px;" /></div>
    <div id="searchResultPanel2" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
    <input type="button" id="result" value="Ã¦ÂÂ¥Ã¨Â¯Â¢" />
</div>
<div id="r-result"></div>
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
