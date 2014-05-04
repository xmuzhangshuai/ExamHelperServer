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


<title>试卷</title>


<link rel="stylesheet" rev="stylesheet" href="./css/style.css"
	type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">
	function tishi() {
		var a = confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
		if (a != true)
			return false;
		window
				.open(
						"冲突页.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}
	function back() {
		var subjectId = '${subjectId}'
		if(subjectId!=undefined)
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=showExamListBySubject&subjectId="
				+ subjectId;
				else
				document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=showAllExamList;
				
		document.getElementById("fom").submit();
	}
	function showExamInfor() {
		var examInfor = document.getElementById("examInfor");
		var examImage = document.getElementById("examImage");
		if (examInfor.style.display == "none") {
			examInfor.style.display = "";
			examImage.src = "./images/ico03.gif";
		} else {
			examInfor.style.display = "none";
			examImage.src = "./images/ico04.gif";
		}
	}

	function saveExamInfor(examId) {
	alert(examId);
	if(examId!=null&& examId!=undefined)
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamination&examinationId="
				+ examId;
    else
    document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamination";
		document.getElementById("fom").submit();
	}
	function showDetail(sectionId) {
		var tableId = "table" + sectionId;
		var imageId = "image" + sectionId;
		var table = document.getElementById(tableId);
		var image = document.getElementById(imageId);
		if (table.style.display == "none") {
			table.style.display = "";
			image.src = "./images/ico03.gif";
		} else {
			table.style.display = "none";
			image.src = "./images/ico04.gif";
		}

	}
	function editSectionInfor(sectionId) {
		document.getElementById("request" + sectionId).readOnly = false;
		document.getElementById("score" + sectionId).readOnly = false;
	}
	function saveSectionInfor(sectionId, examinationId) {
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=editExamSectionInfor&examSectionId="
				+ sectionId + "&examinationId=" + examinationId;

		document.getElementById("fom").submit();
	}
	function addExamQuestion(typeChoose) {
		var addSingleChoice = "添加单项选择题"
		var addMultiChoice = "添加多项选择题"
		var addTrueOrFalse = "添加判断题"
		var addMaterialAnalysis = "添加材料分析题"
		var option = typeChoose.value
		var questionTypeName;
		var examSectionId;
		if (option == addSingleChoice) {
			examSectionId = document.getElementById("singleChoiceSection").value;
		} else if (option == addMultiChoice) {
			examSectionId = document.getElementById("multiChoiceSection").value;
		} else if (option == addTrueOrFalse) {
			examSectionId = document.getElementById("trueOrFalseSection").value;
		} else if (option == addMaterialAnalysis) {
			examSectionId = document.getElementById("materialAnalysisSection").value;
		}

		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamQuestionUI&examSectionId="
				+ examSectionId;
		document.getElementById("fom").submit();
	}
	function removeExamQuestion(questionId, questionTypeName) {
		var SingleChoice = "单项选择题"
		var MultiChoice = "多项选择题"
		var TrueOrFalse = "判断题"
		var MaterialAnalysis = "材料分析题"

		if (questionTypeName == SingleChoice) {
			examSectionId = document.getElementById("singleChoiceSection").value;
		} else if (questionTypeName == MultiChoice) {
			examSectionId = document.getElementById("multiChoiceSection").value;
			alert(MultiChoice)
		} else if (questionTypeName == TrueOrFalse) {
			examSectionId = document.getElementById("trueOrFalseSection").value;
		} else if (questionTypeName == MaterialAnalysis) {
			examSectionId = document.getElementById("materialAnalysisSection").value;
		}

		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=removeExamQuestion&examSectionId="
				+ examSectionId + "&questionId=" + questionId;
		alert(document.getElementById("fom").action);
		document.getElementById("fom").submit();

	}

</script>

</head>

<body class="ContentBody">
	<form
		action="${pageContext.request.contextPath}/examination.do?flag=editExaminationInfor&examinationId=${examination.id}"
		method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">试卷</th>
				</tr>
				<tr>
					<td style="width: 485px; "><input type="button" value="返回试卷列表"
						onclick="back();" class="button" /></td>

				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>试卷信息</legend>
							<table>
								<tr>
									<td><img name="image" id="examImage"
										src="./images/ico04.gif" width="8" height="11" /><a href="#"
										onclick="showExamInfor();">试卷信息</a></td>
								</tr>
								<tr>
									<td><table id="examInfor"
											style="display: none;width: 100%;">
											<tr>
												<td>试卷名称：</td>
												<td><input type="text" name="examName" id="examName"
													readonly="readonly" value="${examination.examName}"
													style="width: 244px; " /></td>
											</tr>
											<tr align="left">
												<td>科目名称：</td>
												<td><select name="subjectName" id="subjectName"
													style="width: 243px; " disabled="disabled">


														<c:forEach items="${subjects}" var="subject">
															<c:choose>
																<c:when test="${empty subjectId}">
																	<option selected="selected">请选择科目</option>
																	<c:forEach items="${subjects}" var="item">
																		<option value="${item.id}">${item.subName}</option>
																	</c:forEach>
																</c:when>
																<c:when test="${subject.id==subjectId}">
																	<option value="${subject.subName}" selected="selected">${subject.subName}</option>
																</c:when>
																<c:otherwise>
																	<option value="${subject.subName}">${subject.subName}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
												</select></td>
											</tr>
											<tr>
												<td>试卷类型：</td>
												<td><input type="text" name="examType" id="examType"
													value="${examination.examType}" style="width: 246px; "
													readonly="readonly" /></td>
											</tr>
											<tr>
												<td>考试时间：</td>
												<td><input id="examTime" name="examTime" type="text"
													readonly="readonly" value="${examination.examTime}"
													style="width: 248px; " /></td>
											</tr>
											<tr>
												<td>考试要求：</td>
												<td style="height: 67px; width: 236px"><textarea
														id="examRequest" name="examRequest" readonly="readonly"
														style="width: 245px; height: 56px">${examination.examRequest}</textarea></td>
											</tr>

											<TR>
												<TD colspan="2" align="center" height="50px"><input
													type="button" value="保存" type="submit"
													onclick="saveExamInfor('${examination.id}');"
													class="button" /></TD>
											</TR>
										</table></td>
								</tr>
							</table>
							<br />
						</fieldset>
					</TD>

				</TR>

			</table>
		</div>
	</form>
</body>

</html>
