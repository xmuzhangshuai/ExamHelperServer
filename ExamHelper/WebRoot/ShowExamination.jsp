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

		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=showExamList";
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
	function editExamInfor() {
		document.getElementById("examName").readOnly = false;
		document.getElementById("subjectName").disabled = false;
		document.getElementById("examType").readOnly = false;
		document.getElementById("examTime").readOnly = false;
		document.getElementById("examRequest").readOnly = false;
	}
	function saveExamInfor(examId) {
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=editExaminationInfor&examinationId="
				+ examId;

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
	function addExamSingleChoice() {
		var examSectionId = document.getElementById("singleChoiceSection").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamSingleChoiceUI&examSectionId="+
		examSectionId;
		alert(document.getElementById("fom").action)
		document.getElementById("fom").submit();
	}
	function InitList() {
		
		if (!'${singleChoices}')
			document.getElementById("singleChoiceList").style.display = "none";
		if (!'${multiChoices}')
			document.getElementById("multiChoiceList").style.display = "none";
		if (!'${trueOrFalses}')
			document.getElementById("trueOrFalseList").style.display = "none";
		if (!'${materialAnalysises}')
			document.getElementById("materialAnalysisList").style.display = "none"
	}
</script>

</head>

<body class="ContentBody" onload="InitList();">
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
						style="width: 111px; " onclick="back();" class="button" /></td>

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
														<option>${subject.subName}</option>
														<c:forEach items="${subjects}" var="item">
															<option>${item.subName}</option>
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
													type="button" value="编辑" class="button"
													style="width: 83px; " onclick="editExamInfor();" /> <input
													type="button" value="保存" type="submit" style="width: 77px;"
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
				<tr>
					<td>
						<fieldset>
							<legend>小题信息</legend>
							<table style="width: 100%">
								<c:forEach items="${examSections}" var="examSection">

									<tr>
										<td><img name="image" id="image${examSection.id}"
											src="./images/ico04.gif" width="8" height="11" /> <a
											href="#" onclick="showDetail('${examSection.id}');">${examSection.questiontype.typeName}信息</a></td>
									</tr>
									<tr>
										<td><c:choose>
												<c:when test="${examSection.questiontype.typeName=='单项选择题'}">
													<input type="hidden" id="singleChoiceSection"
														value="${examSection.id}" />
												</c:when>
												<c:when test="${examSection.questiontype.typeName=='多项选择题'}">
													<input type="hidden" id="multiChoiceSection"
														value="${examSection.id}" />
												</c:when>
												<c:when test="${examSection.questiontype.typeName=='判断题'}">
													<input type="hidden" id="trueOrFalseSection"
														value="${examSection.id}" />
												</c:when>
												<c:when test="${examSection.questiontype.typeName=='材料分析题'}">
													<input type="hidden" id="materialAnalysisSection"
														value="${examSection.id}" />
												</c:when>
											</c:choose></td>
									</tr>
									<tr>
										<td><table id="table${examSection.id}"
												style="display:none;">
												<tr>
													<td>题目要求：</td>
													<td><textarea rows="" cols=""
															id="request${examSection.id}"
															name="request${examSection.id}"
															style="width: 299px; height: 65px" readonly="readonly">${examSection.request}</textarea>

													</td>

												</tr>
												<tr>
													<td>题目分值：</td>
													<td><input type="text"
														value="${examSection.questionScore}"
														name="score${examSection.id}" id="score${examSection.id}"
														readonly="readonly" /></td>
												</tr>
												<tr>
													<TD colspan="2" align="center" height="50px"><input
														type="button" value="编辑" class="button"
														style="width: 83px; "
														onclick="editSectionInfor('${examSection.id}');" /> <input
														type="button" value="保存" style="width: 77px;"
														onclick="saveSectionInfor('${examSection.id}','${examination.id}');"
														class="button" /></TD>
												</tr>
											</table></td>
									</tr>
								</c:forEach>
							</table>
						</fieldset>
					</td>
				</tr>

				<tr>
					<td><fieldset>
							<legend>试卷内容</legend>
							<table style="width: 100%">
								<tr>
									<td>
										<fieldset id="singleChoiceList">
											<legend>单项选择题</legend>
											<table style="width: 100%">
												<tr>
													<td><input align="left" type="button" class="button"
														value="添加单项选择题" onclick="addExamSingleChoice();" /></td>
												</tr>
												<c:forEach items="${singleChoices}" var="singleChoice"
													varStatus="singleChoiceCounter">
													<tr
														<c:if test="${singleChoiceCounter.count%2==0}">bgcolor="#B2DFEE"</c:if>>
														<td>

															<table style="width: 100%">
																<tr>
																	<td><a
																		href="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoice&singleChoiceId=${singleChoice.id}">
																			${singleChoiceCounter.count}:
																			${singleChoice.questionStem}</a></td>
																</tr>
																<tr>
																	<td>
																		<table>
																			<tr>
																				<td
																					<c:if test="${empty singleChoice.optionA}">style="display:none;"</c:if>>A:${singleChoice.optionA}</td>
																			</tr>
																			<tr>
																				<td
																					<c:if test="${empty singleChoice.optionB}">style="display:none;"</c:if>>B:${singleChoice.optionB}</td>
																			</tr>
																			<tr>
																				<td
																					<c:if test="${empty singleChoice.optionC}">style="display:none;"</c:if>>C:${singleChoice.optionC}</td>
																			</tr>
																			<tr>
																				<td
																					<c:if test="${empty singleChoice.optionD}">style="display:none;"</c:if>>D:${singleChoice.optionD}</td>
																			</tr>
																			<tr>
																				<td
																					<c:if test="${empty singleChoice.optionE}">style="display:none;"</c:if>>E:${singleChoice.optionE}</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>

														<td width="15%"><c:choose>
																<c:when test="${singleChoiceCounter.first}">
																	<a href="#">上移</a>|
																	</c:when>
																<c:otherwise>
																	<a
																		href="${pageContext.request.contextPath}/examination.do?flag=moveSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}&type=decrease">上移</a>|
																	</c:otherwise>

															</c:choose> <a
															href="${pageContext.request.contextPath}/examination.do?flag=moveSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}&type=increase">下移|</a><a
															href="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoice&singleChoiceId=${singleChoice.id}">查看|</a><a
															href="${pageContext.request.contextPath}/examination.do?flag=deleteSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}">删除</a>
														</td>
													</tr>
												</c:forEach>
											</table>
										</fieldset>
									</td>
								</tr>




								<tr>
									<td>
										<fieldset id="multiChoiceList">
											<legend>多项选择题</legend>
											<table style="width: 100%">
												<tr>
													<td></td>
												</tr>
												<c:forEach items="${multiChoices}" var="mulitChoice"
													varStatus="multiChoiceCounter">
													<tr
														<c:if test="${multiChoiceCounter.count%2==0}">bgcolor="#B2DFEE"</c:if>>
														<td><table style="width: 100%">
																<tr>
																	<td><a
																		href="${pageContext.request.contextPath}/multiChoice.do?flag=showMultiChoice&multiChoiceId=${multiChoice.id}">
																			${multiChoiceCounter.count}:
																			${mulitChoice.questionStem}</a></td>
																</tr>
																<tr>
																	<td>
																		<table>
																			<tr>
																				<td
																					<c:if test="${empty mulitChoice.optionA}">style="display:none;"</c:if>>A:${mulitChoice.optionA}</td>
																			</tr>
																			<tr>
																				<td
																					<c:if test="${empty mulitChoice.optionB}">style="display:none;"</c:if>>B:${mulitChoice.optionB}</td>
																			</tr>
																			<tr>
																				<td
																					<c:if test="${empty mulitChoice.optionC}">style="display:none;"</c:if>>C:${mulitChoice.optionC}</td>
																			</tr>
																			<tr>
																				<td
																					<c:if test="${empty mulitChoice.optionD}">style="display:none;"</c:if>>D:${mulitChoice.optionD}</td>
																			</tr>
																			<tr>
																				<td
																					<c:if test="${empty mulitChoice.optionE}">style="display:none;"</c:if>>E:${mulitChoice.optionE}</td>
																			</tr>
																			<tr>
																				<td
																					<c:if test="${empty mulitChoice.optionF}">style="display:none;"</c:if>>F:${mulitChoice.optionF}</td>
																			</tr>
																		</table>
																	</td>
																</tr>

															</table></td>
														<td width="15%"><c:choose>
																<c:when test="${singleChoiceCounter.first}">
																	<a href="#">上移</a>|
																	</c:when>
																<c:otherwise>
																	<a
																		href="${pageContext.request.contextPath}/examination.do?flag=moveSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}&type=decrease">上移</a>|
																	</c:otherwise>

															</c:choose> <a
															href="${pageContext.request.contextPath}/examination.do?flag=moveSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}&type=increase">下移|</a><a
															href="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoice&singleChoiceId=${singleChoice.id}">查看|</a><a
															href="${pageContext.request.contextPath}/examination.do?flag=deleteSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}">删除</a></td>
													</tr>
												</c:forEach>
											</table>
										</fieldset>
									</td>
								</tr>




								<tr>
									<td>
										<fieldset id="trueOrFalseList">
											<legend>判断题</legend>
											<table style="width: 100%">
												<tr>
													<td></td>
												</tr>

												<c:forEach items="${trueOrFalses}" var="trueOrFalse"
													varStatus="trueOrFalseCounter">

													<tr
														<c:if test="${trueOrFalseCounter.count%2==0}">bgcolor="#B2DFEE"</c:if>>
														<td>
															<table style="width: 100%">
																<tr>
																	<td><a
																		href="${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalse&trueOrFalseId=${trueOrFalse.id}">
																			${trueOrFalseCounter.count}:
																			${trueOrFalse.questionStem}</a></td>
																</tr>
															</table>
														</td>
														<td style="width: 15%"><c:choose>
																<c:when test="${singleChoiceCounter.first}">
																	<a href="#">上移</a>|
																</c:when>
																<c:otherwise>
																	<a
																		href="${pageContext.request.contextPath}/examination.do?flag=moveSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}&type=decrease">上移</a>|
																	</c:otherwise>

															</c:choose> <a
															href="${pageContext.request.contextPath}/examination.do?flag=moveSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}&type=increase">下移|</a><a
															href="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoice&singleChoiceId=${singleChoice.id}">查看|</a><a
															href="${pageContext.request.contextPath}/examination.do?flag=deleteSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}">删除</a>
														</td>
													</tr>
												</c:forEach>
											</table>
										</fieldset>
									</td>
								</tr>



								<tr>
									<td>
										<fieldset id="materialAnalysisList">
											<legend>材料分析题</legend>
											<table style="width: 100%">
												<tr>
													<td></td>
												</tr>
												<c:forEach items="${materialAnalysises}"
													var="materialAnalysis" varStatus="materialAnalysisCounter">
													<tr
														<c:if test="${materialAnalysisCounter.count%2==0}">bgcolor="#B2DFEE"</c:if>>
														<td>
															<table style="width: 100%">
																<tr>
																	<td><a
																		href="${pageContext.request.contextPath}/materialAnalysis.do?flag=showMaterialAnalysis&materialAnalysisId=${materialAnalysis.id}">
																			${materialAnalysisCounter.count}:
																			${materialAnalysis.material}</a></td>
																</tr>
																<tr>
																	<td><img src="${materialAnalysis.materialImage}"></img></td>
																</tr>
																<c:forEach
																	items="${materialAnalysis.questionsofmaterials}"
																	var="questionOfMaterial"
																	varStatus="questionOfMaterialCounter">
																	<tr>

																		<td><a
																			href="${pageContext.request.contextPath}/materialAnalysis.do?flag=showQuestionOfMaterial&questionOfMaterialId=${questionOfMaterial.id}">
																				(${questionOfMaterialCounter.count}):
																				${questionOfMaterial.questionStem} </a></td>
																	</tr>
																</c:forEach>
															</table>
														</td>
														<TD style="width: 15%"><c:choose>
																<c:when test="${singleChoiceCounter.first}">
																	<a href="#">上移</a>|
																	</c:when>
																<c:otherwise>
																	<a
																		href="${pageContext.request.contextPath}/examination.do?flag=moveSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}&type=decrease">上移</a>|
																	</c:otherwise>

															</c:choose> <a
															href="${pageContext.request.contextPath}/examination.do?flag=moveSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}&type=increase">下移|</a><a
															href="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoice&singleChoiceId=${singleChoice.id}">查看|</a><a
															href="${pageContext.request.contextPath}/examination.do?flag=deleteSingleChoice&examinationId=${examination.id}&singleChoiceId=${singleChoice.id}">删除</a></TD>
													</tr>
												</c:forEach>
											</table>
										</fieldset>
									</td>
								</tr>


							</table>
						</fieldset></td>
				</tr>
			</table>
		</div>
	</form>
</body>

</html>
