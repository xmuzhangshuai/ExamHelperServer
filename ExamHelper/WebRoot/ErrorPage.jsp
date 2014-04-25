<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>404 Not Found</title>
  </head>
  
  <body  style="margin: 0px;padding: 0px;babackground-position: center;background-color: #f7f7f7;text-align: center;">
  		<img alt="" src="./images/404.png" >
  </body>
</html>
