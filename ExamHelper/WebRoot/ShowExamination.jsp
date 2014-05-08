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
<link type="text/css" rel="stylesheet" href="./css/plug.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/dialog.js" charset="utf-8"></script>
<link rel="stylesheet" rev="stylesheet" href="./css/style.css" type="text/css" media="all" />
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
		var subjectId = '${examination.subject.id}'
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=showExamListBySubject&subjectId="
				+ subjectId;
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
	function deleteSectionInfor(sectionId,examinationId) {
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=deleteExamSectionInfor&examSectionId="
				+ sectionId + "&examinationId=" + examinationId;

		document.getElementById("fom").submit();
	}
	function editSectionInfor(sectionId,examinationId) {
		document.getElementById("request" + sectionId).readOnly = false;
		document.getElementById("score" + sectionId).readOnly = false;
		document.getElementById("delete" + sectionId).disabled = false;
	}
	function saveSectionInfor(sectionId, examinationId) {
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=editExamSectionInfor&examSectionId="
				+ sectionId+ "&examinationId=" + examinationId ;

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

		scscms_alert("确定要把该题目从试卷中移除吗？","confirm",function(){
			if (questionTypeName == SingleChoice) {
				examSectionId = document.getElementById("singleChoiceSection").value;
			} else if (questionTypeName == MultiChoice) {
				examSectionId = document.getElementById("multiChoiceSection").value;
			} else if (questionTypeName == TrueOrFalse) {
				examSectionId = document.getElementById("trueOrFalseSection").value;
			} else if (questionTypeName == MaterialAnalysis) {
				examSectionId = document.getElementById("materialAnalysisSection").value;
			}
			document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=removeExamQuestion&examSectionId="
				+ examSectionId + "&questionId=" + questionId;
			document.getElementById("fom").submit();
			scscms_alert("删除成功！","ok");
		},function(){});
	
		

	}
	function addExamSectionInfor() {
		var examId = '${examination.id}'
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamSectionInforUI&examinationId="
				+ examId;
		document.getElementById("fom").submit();

	}
	function Init() {
		var isEdit = '${isEdit}';
		if (isEdit == "true") {
			var txtN = document.getElementsByTagName("input");
			for (i = 0; i < txtN.length; i++)
				txtN[i].readOnly = false;

			var txtArea = document.getElementsByTagName("textarea");
			for (i = 0; i < txtArea.length; i++)
				txtArea[i].readOnly = false;

			var txtSelect = document.getElementsByTagName("select");
			for (var i = 0; i < txtSelect.length; i++)
				txtSelect[i].disabled = false;
		}

	}
</script>

</head>

<body class="ContentBody" onload="Init();">
	<form
		action="${pageContext.request.contextPath}/examination.do?flag=editExaminationInfor&examinationId=${examination.id}"
		method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">试卷</th>
				</tr>
				<tr>
					<td><input type="button" value="返回试卷列表" onclick="back();" class="button" /></td>
				</tr>
				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>试卷信息</legend>
							<table >
								<tr>
									<td><img name="image" id="examImage"
										src="./images/ico04.gif" width="8" height="11" /><a href="#"
										onclick="showExamInfor();">试卷信息</a></td>
								</tr>
								<tr>
									<td><table id="examInfor" cellspacing="10px" style="display: none;width: 100%;">
											<tr>
												<td width="60px">试卷名称：</td>
												<td><input type="text" name="examName" id="examName"
													readonly="readonly" value="${examination.examName}"
													style="width: 400px;height: 22px; " /></td>
											</tr>
											<tr align="left">
												<td width="60px">科目名称：</td>
												<td><select name="subjectName" id="subjectName"
													style="width: 405px;height: 22px;" disabled="disabled">
														<c:forEach items="${subjects}" var="subject">
															<c:choose>
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
												<td width="60px">试卷类型：</td>
												<td><input type="text" name="examType" id="examType"
													value="${examination.examType}" style="width: 400px;height: 22px; "
													readonly="readonly" /></td>
											</tr>
											<tr>
												<td width="60px">考试时间：</td>
												<td><input id="examTime" name="examTime" type="text"
													readonly="readonly" value="${examination.examTime}"
													style="width: 400px;height: 22px; " /></td>
											</tr>
											<tr>
												<td width="60px">考试要求：</td>
												<td><textarea
														id="examRequest" name="examRequest" readonly="readonly"
														cols="63" rows="4">${examination.examRequest}</textarea></td>
											</tr>

											<TR>
												<TD colspan="2" align="center" height="50px"><input
													type="button" value="编辑" class="button"
													onclick="editExamInfor();" /> <input type="button"
													value="保存" type="submit"
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
								<tr>
									<td><input align="left" type="button" class="button" style="margin-bottom: 10px;" value="添加考试章节" onclick="addExamSectionInfor();" /></td>
								</tr>
								<c:forEach items="${examination.examsections}" var="examSection">

									<tr>
										<td><img name="image" id="image${examSection.id}"
											src="./images/ico04.gif" width="8" height="11" /> <a
											href="#" onclick="showDetail('${examSection.id}');">${examSection.questiontype.typeName}信息</a></td>
									</tr>
									<tr>
										<td><c:choose>
												<c:when test="${examSection.questiontype.typeName=='单项选择题'}">
													<input type="hidden" id="singleChoiceSection" value="${examSection.id}" />
												</c:when>
												<c:when test="${examSection.questiontype.typeName=='多项选择题'}">
													<input type="hidden" id="multiChoiceSection" value="${examSection.id}" />
												</c:when>
												<c:when test="${examSection.questiontype.typeName=='判断题'}">
													<input type="hidden" id="trueOrFalseSection" value="${examSection.id}" />
												</c:when>
												<c:when test="${examSection.questiontype.typeName=='材料分析题'}">
													<input type="hidden" id="materialAnalysisSection" value="${examSection.id}" />
												</c:when>
											</c:choose></td>
									</tr>
									<tr>
										<td><table id="table${examSection.id}"
												style="display:none;">
												<tr>
													<td width="60px">题目要求:</td>
													<td><textarea cols="63" rows="4" id="request${examSection.id}"
															name="request${examSection.id}" readonly="readonly">${examSection.request}</textarea>
													</td>
												</tr>
												<tr>
													<td width="60px">题目分值:</td>
													<td><input type="text" style="width: 400px;height: 22px; " 
														value="${examSection.questionScore}" name="score${examSection.id}" id="score${examSection.id}"
														readonly="readonly" /></td>
												</tr>
												<tr>
													<TD colspan="2" align="center" height="50px"><input
														type="button" value="编辑" class="button"
														onclick="editSectionInfor('${examSection.id}');" /> <input
														type="button" value="保存"
														onclick="saveSectionInfor('${examSection.id}','${examination.id}');"
														class="button" /><input id="delete${examSection.id}"
														type="button" value="删除"	onclick="deleteSectionInfor('${examSection.id}','${examination.id}');"
														class="button" disabled="disabled" /></TD>

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
							<table style="width: 100% ">
								<tr>
									<td>
										<fieldset id="singleChoiceList">
											<legend>单项选择题</legend>
											<table style="width: 100%;" cellpadding="10px">
												<tr>
													<td><input align="left" type="button" class="button" style="margin-bottom: 10px;" value="添加单项选择题" onclick="addExamQuestion(this);" /></td>
												</tr>
												<c:forEach items="${singleChoices}" var="singleChoice" varStatus="singleChoiceCounter">
													<tr style="background-color:#EDEDED;line-height: 180%;">
														<td>
															<table style="width: 100%">
																<tr>
																	<td><a href="${pageContext.request.contextPath}/examination.do?flag=showExamQuestionDetail&questionId=${singleChoice.id}&questionTypeName=单项选择题 ">
																			${singleChoiceCounter.count}:${singleChoice.questionStem}</a></td>
																</tr>
																<tr>
																	<td>
																		<table>
																			<tr>
																				<td <c:if test="${empty singleChoice.optionA}">style="display:none;"</c:if>>A:${singleChoice.optionA}</td>
																			</tr>
																			<tr>
																				<td <c:if test="${empty singleChoice.optionB}">style="display:none;"</c:if>>B:${singleChoice.optionB}</td>
																			</tr>
																			<tr>
																				<td <c:if test="${empty singleChoice.optionC}">style="display:none;"</c:if>>C:${singleChoice.optionC}</td>
																			</tr>
																			<tr>
																				<td <c:if test="${empty singleChoice.optionD}">style="display:none;"</c:if>>D:${singleChoice.optionD}</td>
																			</tr>
																			<tr>
																				<td <c:if test="${empty singleChoice.optionE}">style="display:none;"</c:if>>E:${singleChoice.optionE}</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
														<td width="12%" align="center">
															<a href="${pageContext.request.contextPath}/examination.do?flag=showExamQuestionDetail&questionId=${singleChoice.id}&questionTypeName=单项选择题 ">
																<img alt="查看" class="delete_img" src="./images/more.png" style="height: 15px;" title="查看"/>查看</a>
															<a onclick="removeExamQuestion('${singleChoice.id}','单项选择题');" id="" style="cursor: pointer;margin-left: 10px;">
																<img alt="删除" class="delete_img" src="./images/delete.png" style="height: 15px;" title="删除"/>删除</a>
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
													<td><input align="left" type="button" class="button" style="margin-bottom: 10px;"
														value="添加多项选择题" onclick="addExamQuestion(this);" /></td>
												</tr>
												<c:forEach items="${multiChoices}" var="multiChoice"
													varStatus="multiChoiceCounter">
													<tr style="background-color:#EDEDED;line-height: 180%;">
														<td><table style="width: 100%" cellpadding="10px">
																<tr>
																	<td><a href="${pageContext.request.contextPath}/examination.do?flag=showExamQuestionDetail&questionId=${multiChoice.id}&questionTypeName=多项选择题">
																			${multiChoiceCounter.count}:${multiChoice.questionStem}</a></td>
																</tr>
																<tr>
																	<td>
																		<table>
																			<tr>
																				<td <c:if test="${empty multiChoice.optionA}">style="display:none;"</c:if>>A:${multiChoice.optionA}</td>
																			</tr>
																			<tr>
																				<td <c:if test="${empty multiChoice.optionB}">style="display:none;"</c:if>>B:${multiChoice.optionB}</td>
																			</tr>
																			<tr>
																				<td <c:if test="${empty multiChoice.optionC}">style="display:none;"</c:if>>C:${multiChoice.optionC}</td>
																			</tr>
																			<tr>
																				<td <c:if test="${empty multiChoice.optionD}">style="display:none;"</c:if>>D:${multiChoice.optionD}</td>
																			</tr>
																			<tr>
																				<td <c:if test="${empty multiChoice.optionE}">style="display:none;"</c:if>>E:${multiChoice.optionE}</td>
																			</tr>
																			<tr>
																				<td <c:if test="${empty multiChoice.optionF}">style="display:none;"</c:if>>F:${multiChoice.optionF}</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table></td>
														<td width="12%" align="center">
															<a href="${pageContext.request.contextPath}/examination.do?flag=showExamQuestionDetail&questionId=${multiChoice.id}&questionTypeName=多项选择题 ">
																<img alt="查看" class="delete_img" src="./images/more.png" style="height: 15px;" title="查看"/>查看</a>
															<a onclick="removeExamQuestion('${multiChoice.id}','多项选择题');" id="" style="cursor: pointer;margin-left: 10px;">
																<img alt="删除" class="delete_img" src="./images/delete.png" style="height: 15px;" title="删除"/>删除</a>
														</td>
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
													<td><input align="left" type="button" class="button" style="margin-bottom: 10px;"
														value="添加判断题" onclick="addExamQuestion(this);" /></td>
												</tr>
												<c:forEach items="${trueOrFalses}" var="trueOrFalse"
													varStatus="trueOrFalseCounter">
													<tr style="background-color:#EDEDED;line-height: 180%;">
														<td>
															<table style="width: 100%" cellpadding="10px">
																<tr>
																	<td><a href="${pageContext.request.contextPath}/examination.do?flag=showExamQuestionDetail&questionId=${trueOrFalse.id}&questionTypeName=判断题">
																			${trueOrFalseCounter.count}:${trueOrFalse.questionStem}</a></td>
																</tr>
															</table>
														</td>
														<td style="width: 12%" align="center">
															<a href="${pageContext.request.contextPath}/examination.do?flag=showExamQuestionDetail&questionId=${trueOrFalse.id}&questionTypeName=判断题">
																<img alt="查看" class="delete_img" src="./images/more.png" style="height: 15px;" title="查看"/>查看</a>
															<a onclick="removeExamQuestion('${trueOrFalse.id}','判断题');" id="" style="cursor: pointer;margin-left: 10px;">
																<img alt="删除" class="delete_img" src="./images/delete.png" style="height: 15px;" title="删除"/>删除</a>
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
											<table style="width: 100%"  cellpadding="10px">
												<tr>
													<td><input align="left" type="button" class="button" style="margin-bottom: 10px;"
														value="添加材料分析题" onclick="addExamQuestion(this);" /></td>
												</tr>
												<c:forEach items="${materialAnalysises}" var="materialAnalysis" varStatus="materialAnalysisCounter">
													<tr style="background-color:#EDEDED;line-height: 200%;">
														<td>
															<table style="width: 100%">
																<tr>
																	<td><a href="${pageContext.request.contextPath}/examination.do?flag=showExamQuestionDetail&questionId=${materialAnalysis.id}&questionTypeName=材料分析题">
																			${materialAnalysisCounter.count}:${materialAnalysis.material}</a></td>
																</tr>
																<tr>
																	<td><img src="${materialAnalysis.materialImage}"></img></td>
																</tr>
																<c:forEach
																	items="${materialAnalysis.questionsofmaterials}"
																	var="questionOfMaterial"
																	varStatus="questionOfMaterialCounter">
																	<tr>

																		<td><a href="${pageContext.request.contextPath}/materialAnalysis.do?flag=showQuestionOfMaterial&questionOfMaterialId=${questionOfMaterial.id}">
																				(${questionOfMaterialCounter.count}):${questionOfMaterial.questionStem} </a></td>
																	</tr>
																</c:forEach>
															</table>
														</td>
														<TD style="width: 12%" align="center"> 
															<a href="${pageContext.request.contextPath}/examination.do?flag=showExamQuestionDetail&questionId=${materialAnalysis.id}&questionTypeName=材料分析题">
																<img alt="查看" class="delete_img" src="./images/more.png" style="height: 15px;" title="查看"/>查看</a>
															<a onclick="removeExamQuestion('${materialAnalysis.id}','材料分析题');" id="" style="cursor: pointer;margin-left: 10px;">
																<img alt="删除" class="delete_img" src="./images/delete.png" style="height: 15px;" title="删除"/>删除</a>
														</TD>
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
