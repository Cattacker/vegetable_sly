<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html {width: 100%;height: 100%; margin:0;font-family:"å¾®è½¯éé»";}
        #allmap{height:500px;width:100%;}
        #r-result,#r-result table{width:100%;}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BG9q7yWsanxwi7twxs95xyv3KtEvfWna"></script>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <title>路线查询</title>
</head>
<body>
<div id="allmap"></div>
<div id="driving_way">
    <div id="l-map"></div>
    <div id="r-result1">起始地点：<input type="text" name = "location" id="suggestId" size="20" value="ç¾åº¦" style="width:150px;" /></div>
    <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
    <div id="2-map"></div>
    <div id="r-result2">终止地点:<input type="text" name = "location2" id="suggestId2" size="20" value="ç¾åº¦" style="width:150px;" /></div>
    <div id="searchResultPanel2" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
    <select>
        <option value="0">最短时间</option>
        <option value="1">最短距离</option>
        <option value="2">避开高速</option>
    </select>
    <input type="button" id="result" value="æ¥è¯¢" />
</div>
<div id="r-result"></div>
</body>
</html>
<script type="text/javascript">
    // ç¾åº¦å°å¾APIåè½
    //è¾å¥æç¤º
    function G(id) {
        return document.getElementById(id);
    }

    //    var map = new BMap.Map("l-map");
    //    map.centerAndZoom("åäº¬",12);                   // åå§åå°å¾,è®¾ç½®åå¸åå°å¾çº§å«ã

    var ac = new BMap.Autocomplete(    //å»ºç«ä¸ä¸ªèªå¨å®æçå¯¹è±¡
        {"input" : "suggestId"
//            ,"location" : map
        });

    var ac2 = new BMap.Autocomplete(    //å»ºç«ä¸ä¸ªèªå¨å®æçå¯¹è±¡
        {"input" : "suggestId2"
//            ,"location" : map
        });

    var myValue;
    var myValue2;
    ac.addEventListener("onhighlight", function(e) {  //é¼ æ æ¾å¨ä¸æåè¡¨ä¸çäºä»¶
        myValue = "";
        myValue2 = "";
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

    ac2.addEventListener("onhighlight", function(e) {  //é¼ æ æ¾å¨ä¸æåè¡¨ä¸çäºä»¶
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

    //è·åç¹å»çå°ç¹

    ac.addEventListener("onconfirm", function(e) {    //é¼ æ ç¹å»ä¸æåè¡¨åçäºä»¶
        myValue = "";
        var _value = e.item.value;
        myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

//        setPlace();
    });

    ac2.addEventListener("onconfirm", function(e) {    //é¼ æ ç¹å»ä¸æåè¡¨åçäºä»¶
        myValue2 = "";
        var _value = e.item.value;
        myValue2 = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue2;

//        setPlace();
    });

    // é©¾è½¦è·¯çº¿æ¥è¯¢
    var map = new BMap.Map("allmap");
    map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
    //ä¸ç§é©¾è½¦ç­ç¥ï¼æå°æ¶é´ï¼æç­è·ç¦»ï¼é¿å¼é«é
    var routePolicy = [BMAP_DRIVING_POLICY_LEAST_TIME,BMAP_DRIVING_POLICY_LEAST_DISTANCE,BMAP_DRIVING_POLICY_AVOID_HIGHWAYS];
    $("#result").click(function(){
        map.clearOverlays();
        var i=$("#driving_way select").val();
        var start = $("#r-result1 input").val();
        var end = $("#r-result2 input").val();
        search(start,end,routePolicy[i]);
        function search(start,end,route){
            var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true},policy: route});
            driving.search(start,end);
        }
    });
</script>
