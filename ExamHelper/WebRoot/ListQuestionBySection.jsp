<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'listQuestionBySection.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>


	<table>
		<tr>
			<td>章节名称</td>
		</tr>
		
		<c:forEach items="${sections}" var="section">
			<tr>
				<td><a href="${pageContext.request.contextPath}/">${section.sectionName}</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	<c:forEach begin="1" end="${pageCount}" var="i">
		<a href="${pageContext.request.contextPath}/listQuestion.do?flag=listBySection&pageNow=${i}&id=${id}">${i}</a>
	</c:forEach> 
	
	
</body>

</html>
