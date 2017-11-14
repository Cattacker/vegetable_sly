<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
 request.setAttribute("decorator", "none");
 response.setHeader("Cache-Control", "no-cache");
 response.setHeader("Pragma", "no-cache");
 response.setDateHeader("Expires", 0);
%>
${param.data}
<script type="text/javascript">
var table = document.createElement("result");
var a=document.createElement("table");
a.borber=1;
var caption=a.createCaption();
a.style.backgroundColor="#ddd";
caption.innerHTML="详细信息";
users="#users";
for(var i=0;i<users.lenth;i=i+2)
{
	var tr=a.insertRow(i);
	var td=tr.insertCell(0);
	td.innerHTML=users[i];
	var td1=tr.innerCell(1);
	td1.innerHTML=users[i+1];
}
document.body.appendChild(a);
</script>
	