<%@ page contentType="text/html;charset=GBK" language="java" %> 
<%@ taglib prefix="s" uri="/struts-tags" %> 
<% 
    request.setAttribute("decorator", "none"); 
//强制浏览器不缓存本页面内容 
    response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 
    //阻止浏览器直接从代理服务器取得本页面内容 
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
%> 

注意：<s:property value="none"/> <br> 
