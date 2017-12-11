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
    <title>待执行计划</title>
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
    <script>
        /**
         * JS实现可编辑的表格
         * 用法:EditTables(tb1,tb2,tb2,......);
         * Create by Senty at 2008-04-12
         **/

//设置多个表格可编辑
        function EditTables(){
            for(var i=0;i<arguments.length;i++){
                SetTableCanEdit(arguments[i]);
            }
        }

        //设置表格是可编辑的
        function SetTableCanEdit(table){
            for(var i=1; i<table.rows.length;i++){
                SetRowCanEdit(table.rows[i]);
            }
        }

        //设置行是可编辑的
        function SetRowCanEdit(row){
            for(var j=0;j < row.cells.length; j++){

                //如果当前单元格指定了编辑类型，则表示允许编辑
                var editType = row.cells[j].getAttribute("EditType");
                if(!editType){
                    //如果当前单元格没有指定，则查看当前列是否指定
                    editType = row.parentNode.rows[0].cells[j].getAttribute("EditType");
                }
                if(editType){
                    row.cells[j].onclick = function (){
                        EditCell(this);
                    }
                }
            }

        }

        //设置指定单元格可编辑
        function EditCell(element, editType){

            var editType = element.getAttribute("EditType");
            if(!editType){
                //如果当前单元格没有指定，则查看当前列是否指定
                editType = element.parentNode.parentNode.rows[0].cells[element.cellIndex].getAttribute("EditType");
            }

            switch(editType){
                case "TextBox":
                    CreateTextBox(element, element.innerHTML);
                    break;
                case "DropDownList":
                    CreateDropDownList(element);
                    break;
                default:
                    break;
            }
        }

        //为单元格创建可编辑输入框
        function CreateTextBox(element, value){
//检查编辑状态，如果已经是编辑状态，跳过
            var editState = element.getAttribute("EditState");
            if(editState != "true"){
                //创建文本框
                var textBox = document.createElement("INPUT");
                textBox.type = "text";
                textBox.className="EditCell_TextBox";


                //设置文本框当前值
                if(!value){
                    value = element.getAttribute("Value");
                }
                textBox.value = value;

                //设置文本框的失去焦点事件
                textBox.onblur = function (){
                    CancelEditCell(this.parentNode, this.value);
                }
                //向当前单元格添加文本框
                ClearChild(element);
                element.appendChild(textBox);
                textBox.focus();
                textBox.select();

                //改变状态变量
                element.setAttribute("EditState", "true");
                element.parentNode.parentNode.setAttribute("CurrentRow", element.parentNode.rowIndex);
            }

        }


        //为单元格创建选择框
        function CreateDropDownList(element, value){
//检查编辑状态，如果已经是编辑状态，跳过
            var editState = element.getAttribute("EditState");
            if(editState != "true"){
                //创建下接框
                var downList = document.createElement("Select");
                downList.className="EditCell_DropDownList";

                //添加列表项
                var items = element.getAttribute("DataItems");
                if(!items){
                    items = element.parentNode.parentNode.rows[0].cells[element.cellIndex].getAttribute("DataItems");
                }

                if(items){
                    items = eval("[" + items + "]");
                    for(var i=0; i<items.length; i++){
                        var oOption = document.createElement("OPTION");
                        oOption.text = items[i].text;
                        oOption.value = items[i].value;
                        downList.options.add(oOption);
                    }
                }

                //设置列表当前值
                if(!value){
                    value = element.getAttribute("Value");
                }
                downList.value = value;

                //设置创建下接框的失去焦点事件
                downList.onblur = function (){
                    CancelEditCell(this.parentNode, this.value, this.options[this.selectedIndex].text);
                }

                //向当前单元格添加创建下接框
                ClearChild(element);
                element.appendChild(downList);
                downList.focus();

                //记录状态的改变
                element.setAttribute("EditState", "true");
                element.parentNode.parentNode.setAttribute("LastEditRow", element.parentNode.rowIndex);
            }

        }


        //取消单元格编辑状态
        function CancelEditCell(element, value, text){
            element.setAttribute("Value", value);
//            var objdbConn = new ActiveXObject("ADODB.Connection");
//            var strdsn = "Driver={com.mysql.jdbc.Driver};SERVER=(jdbc:mysql://localhost:3306/traveldb);UID=root;PWD=7374;DATABASE=traveldb";   // 需要修改自己的服务器地址,用户名,密码
//            objdbConn.Open(strdsn);
//            var sql = "update travelplan set teamid = '" + element.parentNode.cells[1].getAttribute("Value") + "', path = '" +
//                element.parent.cells[2].getAttribute("Value") + "', wishdate = '" + element.parent.cells[3].getAttribute("Value") + "' where id = '"+
//                element.parent.cells[0].getAttribute("Value") + "'";
//            objdbConn.Execute(sql);                    // 请写入自己的执行语句
//            document.write(" 更新数据成功!");
//            objdbConn.Close();
            if(text){
                element.innerHTML = text;
            }else{
                element.innerHTML = value;
            }
            element.setAttribute("EditState", "false");

//检查是否有公式计算
            CheckExpression(element.parentNode);
        }

        //清空指定对象的所有字节点
        function ClearChild(element){
            element.innerHTML = "";
        }

        //添加行
        function AddRow(table, index){
            var lastRow = table.rows[table.rows.length-1];
            var newRow = lastRow.cloneNode(true);
//计算新增加行的序号，需要引入jquery 的jar包-----------------------------------------------------------------------
            var startIndex = $.inArray(lastRow,table.rows);
            var endIndex = table.rows;
            nbsp;table.tBodies[0].appendChild(newRow);
            newRow.cells[0].innerHTML=endIndex-startIndex;
            SetRowCanEdit(newRow);
            return newRow;

        }


        //删除行
        function DeleteRow(table, index){
            for(var i=table.rows.length - 1; i>0;i--){
                var chkOrder = table.rows[i].cells[0].firstChild;
                if(chkOrder){
                    if(chkOrder.type = "CHECKBOX"){
                        if(chkOrder.checked){
                            //执行删除
                            table.deleteRow(i);
                        }
                    }
                }
            }
        }

        //提取表格的值,JSON格式
        function GetTableData(table){
            var tableData = new Array();
            alert("行数：" + table.rows.length);
            for(var i=1; i<table.rows.length;i++){
                tableData.push(GetRowData(tabProduct.rows[i]));
            }

            return tableData;

        }
        //提取指定行的数据，JSON格式
        function GetRowData(row){
            var rowData = {};
            for(var j=0;j<row.cells.length; j++){
                name = row.parentNode.rows[0].cells[j].getAttribute("Name");
                if(name){
                    var value = row.cells[j].getAttribute("Value");
                    if(!value){
                        value = row.cells[j].innerHTML;
                    }

                    rowData[name] = value;
                }
            }
//alert("ProductName:" + rowData.ProductName);
//或者这样：alert("ProductName:" + rowData["ProductName"]);
            return rowData;

        }

        //检查当前数据行中需要运行的字段
        function CheckExpression(row){
            for(var j=0;j<row.cells.length; j++){
                expn = row.parentNode.rows[0].cells[j].getAttribute("Expression");
                //如指定了公式则要求计算
                if(expn){
                    var result = Expression(row,expn);
                    var format = row.parentNode.rows[0].cells[j].getAttribute("Format");
                    if(format){
                        //如指定了格式，进行字值格式化
                        row.cells[j].innerHTML = formatNumber(Expression(row,expn), format);
                    }else{
                        row.cells[j].innerHTML = Expression(row,expn);
                    }
                }
            }
        }

        //计算需要运算的字段
        function Expression(row, expn){
            var rowData = GetRowData(row);
//循环代值计算
            for(var j=0;j<row.cells.length; j++){
                name = row.parentNode.rows[0].cells[j].getAttribute("Name");
                if(name){
                    var reg = new RegExp(name, "i");
                    expn = expn.replace(reg, rowData[name].replace(/\,/g, ""));
                }
            }
            return eval(expn);
        }
    </script>

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
		<s:iterator value="personalUnstartPlans">
			<tr>
				<th><s:property value="name"/></th>
				<th><s:property value="beginningDate"/></th>
				<th><s:property value="path.start.name"/></th>
				<th><s:property value="path.end.name"/></th>
				<th>
					<a href="SetMyTravelPlan_show.action?planId=${id}">修改</a>
					<a href="GetMyTravelPlan.action?planId=${id}">查看</a>
				</th>
			</tr>
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
		<s:iterator value="teamUnstartPlans">
			<tr>
				<th><s:property value="name"/></th>
				<th><s:property value="beginningDate"/></th>
				<th><s:property value="path.start.name"/></th>
				<th><s:property value="path.end.name"/></th>
			</tr>
		</s:iterator>
	</table>



</body>
</html>