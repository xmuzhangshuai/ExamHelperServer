<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>


<title>后台管理系统</title>

</head>
<frameset rows="59,*" cols="*" style="border-style: none;" >
	<frame src="./Top.jsp" name="topFrame" 
		noresize="noresize" id="topFrame" title="topFrame" scrolling="no" />
	<frameset cols="213,*" style="border-style: none;">
		<frame src="${pageContext.request.contextPath}/login.do?flag=loadLeft" name="leftFrame" scrolling="no"
			noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="./Welcome.jsp" name="mainFrame" id="mainFrame"
			title="mainFrame" />
	</frameset>
</frameset>

</html>
