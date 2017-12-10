<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>个人计划-修改</title>
	<sx:head/>
</head>
<body>
	<form action="SetMyTravelPlan_changeName">
		<s:textfield name="newName" label="计划名:" value="${plan.name}"/>
		<input name="planId" type="hidden" value="${planId}"/>
		<input type="submit" value="提交修改"/>
	</form>
	<form action="SetMyTravelPlan_changeBeginningDate">
		<sx:datetimepicker name="newBeginningDate" label="出发日期"
			displayFormat="yyyy-MM-dd" value="${plan.beginningDate}"/>
		<input name="planId" type="hidden" value="${planId}"/>
		<input type="submit" value="提交修改"/>
	</form>
	<table>
		<tr>
			<th>
				${plan.path.start}
			</th>
			
			<s:iterator value="plan.path" id="location" status="status">
				<th>
					<form action="SetMyTravelPlan_newLocation">
						<div id = "r-result">
						<input type="text" name="newLocation" id="suggestId3" value="百度"/>
						<a href="#" rel="external nofollow" rel="external nofollow" 
								rel="external nofollow" class="removeclass"></a>
						</div>
						<input name="planId" type="hidden" value="${planId}"/>
						<input name="locationIndex" type="hidden" value="${status.index}"/>
						<input type="submit" value="添加地点"/>
					</form>
				</th>
				<th>
					<s:property value="location.name"/>
					<form action="SetMyTravelPlan_deleteLocation">
						<input name="locationIndex" type="hidden" value="${status.index}"/>
						<input name="planId" type="hidden" value="${planId}"/>
						<input type="submit" value="删除"/>
					</form>
				</th>
			</s:iterator>
			
			<th>
				<form action="SetMyTravelPlan_newLocation">
				<div id = "r-result">
					<input type="text" name="newLocation" id="suggestId3" value="百度"/>
					<a href="#" rel="external nofollow" rel="external nofollow" 
						rel="external nofollow" class="removeclass"></a>
				</div>
				<input name="planId" type="hidden" value="${planId}"/>
				<input name="locationIndex" type="hidden" value="${plan.size}"/>
				<input type="submit" value="添加地点"/>
				</form>
			</th>
			
			<th>
				${plan.path.end}
			</th>
			
		</tr>
	</table>
</body>
</html>


<script type="text/javascript">
$(document).ready(function() {
	var MaxInputs    = 8; //maximum input boxes allowed
	var InputsWrapper  = $("#InputsWrapper"); //Input boxes wrapper ID
	var AddButton    = $("#AddMoreFileBox"); //Add button ID
	var x = InputsWrapper.length; //initlal text box count
	var FieldCount=4; //to keep track of text box added
	$(AddButton).click(function (e) //on add input button click
	{
	    if(x <= MaxInputs) //max input box allowed
	    {
	      FieldCount++; //text box added increment
	      //add input box
	      $(InputsWrapper).append('<div id="l-map"></div><div id = "r-result"><input type="text" name="mytext[]" id="suggestId4" value="百度"/><a href="#" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="removeclass"><input type="button" value="删除"></a></div>');
	      x++; //text box increment
	    }
	return false;
	});
	$("body").on("click",".removeclass", function(e){ //user click on remove text
	    if( x > 1 ) {
	        $(this).parent('div').remove(); //remove text box
	        x--; //decrement textbox
	    }
	return false;
	})
	});
	
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