<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<table>
  		<tr>
  			<td><img alt="" src="${imageUrl}" width="15%"></td>
  			<td style="font-family: fantasy;">
  				<div>状态：<%=request.getAttribute("state") %></div>
  				<div style="margin-top: 20px;">图片路径为：<%=request.getAttribute("imageUrl") %></div>
  				<input type="text" id="imageUrl" style="display: none;" value="${imageUrl}">
  			</td>
  		</tr>
  	</table>
  </body>
</html>
