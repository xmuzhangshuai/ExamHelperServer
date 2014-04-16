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

<title>My JSP 'ShowMaterialAnalysis.jsp' starting page</title>

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
			<td>材料</td>
			<td>题号</td>
			<td>问题1</td>
			<td>答案1</td>
			<td>分析1</td>
			<td>分值</td>
			<td>题号</td>
			<td>问题2</td>
			<td>答案2</td>
			<td>分析2</td>
			<td>分值</td>
			<td>题号</td>
			<td>问题3</td>
			<td>答案3</td>
			<td>分析3</td>
			<td>分值</td>
		</tr>

		<c:forEach items="${materialAnalysis}" var="each">

			<tr>

				<td>${each.material}</td>
				<c:forEach items="${each.questionsofmaterials}"
					var="item">
					
						<td>${item.questionNumber}</td>
						<td>${item.questionStem}</td>
						<td>${item.answer}</td>
						<td>${item.analysis}</td>
						<td>${item.score}</td>
					
				</c:forEach>
			</tr>

		</c:forEach>

	</table>
	<c:forEach begin="1" end="${pageCount}" var="i">
		<a
			href="${pageContext.request.contextPath}/question.do?flag=showQuestionByType&typeName=${typeName}&pageNow=${i}">${i}</a>
	</c:forEach>
</body>
</html>
