<%@ page contentType="text/html;charset=GBK" language="java" %> 
<%@ taglib prefix="s" uri="/struts-tags" %> 
<% 
    request.setAttribute("decorator", "none"); 
//ǿ������������汾ҳ������ 
    response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 
    //��ֹ�����ֱ�ӴӴ��������ȡ�ñ�ҳ������ 
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
%> 

ע�⣺<s:property value="none"/> <br> 
