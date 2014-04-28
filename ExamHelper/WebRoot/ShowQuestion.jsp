<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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

<link href="./css/css.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">
	function sousuo() {
		window
				.open(
						"gaojisousuo.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}
	function search() {
		var singleChoice = "单项选择题"
		var multiChoice = "多项选择题"
		var trueOrFalse = "判断题"
		var analysis = "简答题"

		var subjectId = document.getElementById("subjectChoose").value;
		var sectionName = document.getElementById("sectionChoose").value;
		var questionType = document.getElementById("questionTypeChoose").value;
		if (subjectId == undefined || sectionName == undefined
				|| questionType == undefined)
			alert("请完整选择科目、章节、题型")
		else {
       		 if(questionType==singleChoice)
       			 document.getElementById("fom").action="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoiceList&sectionName="sectionName;
      		else if(questionType==multiChoice)
				document.getElementById("fom").action="${pageContext.request.contextPath}/multiChoice.do?flag=showMultiChoiceList&sectionName="+sectionName;
			else if(questionType==trueOrFalse)
				document.getElementById("fom").action="${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalseList&sectionName="+sectionName;
			else if(questionType==analysis)
				document.getElementById("fom").action="${pageContext.request.contextPath}/materialAnalysis.do?flag=showMaterialAnalysisList&sectionName="+sectionName;
		document.getElementById("fom").submit();
       
			}
	}
	
	function changeSubject(){
	 int index = document.getElementById("subjectChoose").value;
	 return index;
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
							<td height="62"
								style="background-image:url('./images/nav04.gif'); ">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td align="left">
											<table>
												<tr>
													<td width="538" style="width: 88px; ">科目：</td>
													<td style="width: 129px; "><select
														name="subjectChoose" id="subjectChoose"
														onchange="changeSubject();">
															<c:choose>
																<c:when test="${empty subjectId}">
																	<option selected="selected">请选择科目</option>
																	<c:forEach items="${subjects}" var="subject" varStatus="index">
																		<option value="${index.index}">${subject.subName}</option>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${subjects}" var="subject">
																		<c:choose>
																			<c:when test="${subject.id==subjectId}">
																				<option value="${index.index}" selected="selected">${subject.subName}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${index.index}">${subject.subName}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																</c:otherwise>
															</c:choose>

													</select></td>
													<td><input type="hidden" id="sectionIndex" value="changeSubject();"/></td>
													<td>章节：</td>
													<td><select id="sectionChoose"
														onchange="changeSection();">
															<c:choose>
																<c:when test="${empty sectionName}">
																	<option selected="selected">请选择题型</option>
																	<c:forEach items="" var="section">
																		<option value="${section.sectionName}">${section.sectionName}</option>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${subjects[javascript:changeSubject();].sections }" var="section">
																		<c:choose>
																			<c:when test="${section.sectionName==sectionName}">
																				<option value="${section.sectionName}"
																					selected="selected">${section.sectionName}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${section.sectionName}">${section.sectionName}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
													</select></td>
													<td>题型：</td>
													<td><select id="questionTypeChoose"
														onchange="changeQuestionType();">
															<c:choose>
																<c:when test="${empty questionTypeName}">
																	<option selected="selected">请选择题型</option>
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
												</tr>
											</table>
										</td>
										<td><input type="button" value="查询"
											class="right-button02" onclick="search();" /></td>
									</tr>

								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><img id="informImage" src="./images/404.png" alt="" /></td>
			</tr>

		</table>
	</form>

</body>
</html>
