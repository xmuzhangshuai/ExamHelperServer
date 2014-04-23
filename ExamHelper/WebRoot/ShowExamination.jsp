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

	function check() {
		document.getElementById("aa").style.display = "";
	}
	function editExamInfor() {
		document.getElementById("examName").readOnly=false;
		document.getElementById("subjectName").disabled=false;
		document.getElementById("examType").readOnly=false;
		document.getElementById("examTime").readOnly=false;
		document.getElementById("examRequest").readOnly=false;
	}
	function saveExamInfor(examId) {
	document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=editExaminationInfor&examinationId="+examId;

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
	function back() {

		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=showExamList";

		document.getElementById("fom").submit();
	}
</script>
</head>

<body class="ContentBody">
	<form
		action="${pageContext.request.contextPath}/question.do?flag=editSingleChoice&singleChoiceId=${singleChoice.id}"
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
							<table >
								<tr>
									<td>试卷名称：</td>
									<td><input type="text" name="examName" id="examName" readonly="readonly"
										value="${examination.examName}" style="width: 244px; " /></td>
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
										value="${examination.examType}" style="width: 246px; " readonly="readonly"/></td>
								</tr>
								<tr>
									<td>考试时间：</td>
									<td><input id="examTime" name="examTime" type="text" readonly="readonly"
										value="${examination.examTime}" style="width: 248px; " /></td>
								</tr>
								<tr>
									<td>考试要求：</td>
									<td style="height: 67px; width: 236px"><textarea
											id="examRequest" name="examRequest" readonly="readonly"
											style="width: 245px; height: 56px">${examination.examRequest}</textarea></td>
								</tr>

								<TR>
									<TD colspan="2" align="center" height="50px"><input
										type="button" value="编辑" class="button" style="width: 83px; "
										onclick="editExamInfor();" /> <input type="button" value="保存"
										type="submit" style="width: 77px;" onclick="saveExamInfor('${examination.id}');"
										class="button" /></TD>
								</TR>
							</table>
							<br />
						</fieldset>
					</TD>

				</TR>
				<tr>
					<td>
						<fieldset>
							<legend>小题信息</legend>
							<table>
								<c:forEach items="${examSections}" var="examSection">

									<tr>
										<td><img name="image" id="image${examSection.id}"
											src="./images/ico04.gif" width="8" height="11" /> <a
											href="#" onclick="showDetail('${examSection.id}');">${examSection.questiontype.typeName}信息</a></td>
									</tr>
									<tr>
										<td><table id="table${examSection.id}"
												style="display:none;">
												<tr>
													<td >题目要求：</td>
													<td><textarea rows="" cols=""
															id="request${examSection.questiontype.id}"
															style="width: 299px; height: 65px" readonly="readonly">${examSection.request}</textarea>

													</td>

												</tr>
												<tr>
													<td>题目分值：</td>
													<td><input type="text"
														value="${examSection.questionScore}"
														id="score${examSection.questiontype.id}" readonly="readonly"/></td>
												</tr>
												<tr>
													<TD colspan="2" align="center" height="50px"><input
														type="button" value="编辑" class="button"
														style="width: 83px; " onclick="edit();" /> <input
														type="button" value="保存" type="submit"
														style="width: 77px;" onclick="save();" class="button" /></TD>
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
							<table>
								<tr>
									<td>
										<fieldset>
											<legend>单项选择题</legend>
											<table>

												<tr>
													<td>
														<table>
															<%
																int singleChoiceNumber = 1;
															%>

															<c:forEach items="${singleChoices}" var="singleChoice">
																<tr>
																	<td><a
																		href="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoice&singleChoiceId=${singleChoice.id}">
																			<%
																				out.print((singleChoiceNumber++) + ":  ");
																			%>${singleChoice.questionStem}</a></td>
																</tr>
																<tr>
																	<td>
																		<table>
																			<tr>
																				<td>A:${singleChoice.optionA}</td>
																				<td>B:${singleChoice.optionB}</td>
																				<td>C:${singleChoice.optionC}</td>
																				<td>D:${singleChoice.optionD}</td>
																				<td>E:${singleChoice.optionE}</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</c:forEach>
														</table>
													</td>
												</tr>

											</table>
										</fieldset>
									</td>
								</tr>


								<tr>
									<td>
										<fieldset>
											<legend>多项选择题</legend>
											<table>

												<tr>
													<td>
														<table>
															<%
																int multiChoiceNumber = 1;
															%>
															<c:forEach items="${multiChoices}" var="mulitChoice">
																<tr>
																	<td><a
																		href="${pageContext.request.contextPath}/multiChoice.do?flag=showMultiChoice&multiChoiceId=${multiChoice.id}">
																			<%
																				out.print((multiChoiceNumber++) + ":  ");
																			%>${mulitChoice.questionStem}</a></td>
																</tr>
																<tr>
																	<td>
																		<table>
																			<tr>
																				<td>A:${mulitChoice.optionA}</td>
																				<td>B:${mulitChoice.optionB}</td>
																				<td>C:${mulitChoice.optionC}</td>
																				<td>D:${mulitChoice.optionD}</td>
																				<td>E:${mulitChoice.optionE}</td>
																				<td>F:${mulitChoice.optionF}</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</c:forEach>
														</table>
													</td>
												</tr>

											</table>
										</fieldset>
									</td>
								</tr>


								<tr>
									<td>
										<fieldset>
											<legend>判断题</legend>
											<table>

												<tr>
													<td>
														<table>
															<%
																int trueOrFalseNumber = 1;
															%>
															<c:forEach items="${trueOrFalses}" var="trueOrFalse">
																<tr>
																	<td><a
																		href="${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalse&trueOrFalseId=${trueOrFalse.id}">
																			<%
																				out.print((trueOrFalseNumber++) + ":  ");
																			%>${trueOrFalse.questionStem}</a></td>
																</tr>

															</c:forEach>
														</table>
													</td>
												</tr>
											</table>
										</fieldset>
									</td>
								</tr>


								<tr>
									<td>
										<fieldset>
											<legend>材料分析题</legend>
											<table>

												<tr>
													<td>
														<table>
															<%
																int materialAnalysisNumber = 1;
															%>
															<c:forEach items="${materialAnalysises}"
																var="materialAnalysis">
																<%
																	int questionOfMaterialNumber = 1;
																%>
																<tr>
																	<td><a
																		href="${pageContext.request.contextPath}/materialAnalysis.do?flag=showMaterialAnalysis&materialAnalysisId=${materialAnalysis.id}">
																			<%
																				out.print((materialAnalysisNumber++) + ":  ");
																			%>${materialAnalysis.material}</a></td>
																</tr>
																<tr>
																	<td><img src="${materialAnalysis.materialImage}"></img></td>
																</tr>
																<c:forEach
																	items="${materialAnalysis.questionsofmaterials}"
																	var="questionOfMaterial">
																	<tr>

																		<td><a
																			href="${pageContext.request.contextPath}/materialAnalysis.do?flag=showQuestionOfMaterial&questionOfMaterialId=${questionOfMaterial.id}">
																				<%
																					out.print("(" + (questionOfMaterialNumber++) + ")  ");
																				%> ${questionOfMaterial.questionStem}
																		</a></td>
																	</tr>
																</c:forEach>
															</c:forEach>
														</table>
													</td>
												</tr>
											</table>
										</fieldset>
									</td>
								</tr>

							</table>
						</fieldset></td>
				</tr>

			</TABLE>

		</div>
	</form>
</body>

</html>
