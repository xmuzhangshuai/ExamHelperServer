<%@page import="com.yrw.domains.Section"%>
<%@page import="com.yrw.domains.Questiontype"%>
<%@page import="com.yrw.domains.Subject"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
         "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<title>科目管理</title>
<style type="text/css">
body {
	background-color: #ffffff;
	text-align: center;
	border: 0px;
	margin: 0px;
}
html { overflow-x: ; overflow-y: ; border:0;} 
</style>
<link href="./css/css.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">

	function search() {
		var singleChoice = "单项选择题"
		var multiChoice = "多项选择题"
		var trueOrFalse = "判断题"
		var analysis = "简答题"

		var subjectId = document.getElementById("subjectChoose").value;
		var sectionName = document.getElementById("sectionChoose").value;
		var questionType = document.getElementById("questionTypeChoose").value;
		if (subjectId == "null" || sectionName == "null"
				|| questionType == "null")
			alert("请完整选择科目、章节、题型");
		else {
			if (questionType == singleChoice)
				document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoiceList&sectionName="
						+ sectionName;
			else if (questionType == multiChoice)
				document.getElementById("fom").action = "${pageContext.request.contextPath}/multiChoice.do?flag=showMultiChoiceList&sectionName="
						+ sectionName;
			else if (questionType == trueOrFalse)
				document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalseList&sectionName="
						+ sectionName;
			else if (questionType == analysis)
				document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=showMaterialAnalysisList&sectionName="
						+ sectionName;

			document.getElementById("fom").submit();
		}
	}
	
	//根据科目加载对应section
	function loadSection() {
	   var subjectId=document.getElementById("subjectChoose").value;
	   if(subjectId!="null"){
	   document.getElementById("fom").action="${pageContext.request.contextPath}/question.do?flag=loadSectionList&subjectId="+subjectId;
	  document.getElementById("fom").submit();
	   }
	}
</script>

</head>

<body>
	<form name="fom" id="fom" method="post" action="" target="mainFrame">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" style="background-image:url('./images/nav04.gif'); ">
								<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td align="left">
											<table>
												<tr>
													<td width="38">科目：</td>
													<td><select name="subjectChoose" id="subjectChoose" onchange="loadSection();">
															<c:choose>
																<c:when test="${empty subjectId}">
																<option value="null" selected="selected">请选择科目</option>
																	<c:forEach items="${subjects}" var="subject">
																		<option value="${subject.id}">${subject.subName}</option>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${subjects}" var="subject">
																		<c:choose>
																			<c:when test="${subject.id==subjectId}">
																				<option value="${subject.id}"
																					selected="selected">${subject.subName}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${subject.id}">${subject.subName}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
													</select></td>

													<td style="width: 80px;text-align: right;">章节：</td>
													<td><select id="sectionChoose">
															<option value="null" selected="selected">-请选择章节-</option>
															<c:forEach items="${sections}" var="section">
															<option>${section.sectionName}</option>
															</c:forEach>
													</select></td>


													<td style="width: 80px;text-align: right;">题型：</td>
													<td><select id="questionTypeChoose">
															<c:choose>
																<c:when test="${empty questionTypeName}">
																	<option value="null" selected="selected">-请选择题型-</option>
																	<c:forEach items="${questionTypes}" var="type">
																		<option value="${type.typeName}">${type.typeName}</option>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${questionTypes}" var="type">
																		<c:choose>
																			<c:when test="${type.typeName==questionTypeName}">
																				<option value="${type.typeName}" selected="selected">${type.typeName}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${type.typeName}">${type.typeName}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
													</select></td>
													<td style="width: 80px;text-align: right;">
													<input type="button" value="查询" class="right-button02" onclick="search();" /></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><img src="./images/welcome.png" width="800" height="536" /></td>
			</tr>

		</table>
	</form>

</body>
</html>
