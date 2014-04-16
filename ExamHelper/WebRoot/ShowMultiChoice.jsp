<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowMultiChoice.jsp' starting page</title>
    
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
			<td>题干</td>
			<td>选项A</td>
			<td>选项B</td>
			<td>选项C</td>
			<td>选项D</td>
			<td>答案A</td>
			<td>答案B</td>
			<td>答案C</td>
			<td>答案D</td>
			<td>分析</td>
		</tr>
		<c:forEach items="${multiChoices}" var="each" >
			<tr>
				
				<td>${each.questionStem}</td>
				<td>${each.optionA}</td>
				<td>${each.optionB}</td>
				<td>${each.optionC}</td>
				<td>${each.optionD}</td>
				<td>${each.answerA}</td>
				<td>${each.answerB}</td>
				<td>${each.answerC}</td>
				<td>${each.answerD}</td>
				<td>${each.analysis}</td>
			</tr>
		</c:forEach>

	</table>
	<c:forEach begin="1" end="${pageCount}" var="i">
		<a
			href="${pageContext.request.contextPath}/question.do?flag=showQuestionByType&typeName=${typeName}&pageNow=${i}">${i}</a>
	</c:forEach>
  </body>
</html>
