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


<title>单项选择题</title>


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
	function init() {
		var txtN = document.getElementsByTagName("input");
		for (i = 0; i < txtN.length; i++) {
			txtN[i].readOnly = true;
		}
		var txtArea = document.getElementsByTagName("textarea");
		for (i = 0; i < txtArea.length; i++)
			txtArea[i].readOnly = true;

		var txtSelect = document.getElementsByTagName("select");
		for (var i = 0; i < txtSelect.length; i++)
			txtSelect[i].disabled = true;
	}

	function editMaterialAnalysis() {
		document.getElementById("material").readOnly = false;
		document.getElementById("materialImage").readOnly = false;
		document.getElementById("remark").readOnly = false;
		var txtSelect = document.getElementsByTagName("select");
		for (var i = 0; i < txtSelect.length; i++)
			txtSelect[i].disabled = false;
	}
	function saveMaterialAnalysis(materialAnalysisId) {

		if (document.getElementById("questionStem" + questionNumber).value
				.trim().length != 0) {

			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=editMaterialAnalysis&materialAnalysisId="
					+ materialAnalysisId;
			document.getElementById("fom").submit();
		} else
			alert("请输入题干");
	}
	function editQuestionOfMaterial(questionNumber) {
		document.getElementById("questionStem" + questionNumber).readOnly = false;
		document.getElementById("analysis" + questionNumber).readOnly = false;
		document.getElementById("answer" + questionNumber).readOnly = false;
		document.getElementById("score" + questionNumber).readOnly = false;
	}
	function saveQuestionOfMaterial(questionOfMaterialId) {

		if (document.getElementById("material").value.trim().length != 0) {

			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=editQuestionOfMaterial&questionOfMaterialId="
					+ questionOfMaterialId;

			document.getElementById("fom").submit();
		} else
			alert("请输入题干");
	}
	function deleteQuestionOfMaterial(questionOfMaterialId) {
		document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=deletetQuestionMaterial&questionOfMaterialId="
				+ questionOfMaterialId;

		document.getElementById("fom").submit();
	}
	function back() {
		var sectionName = document.getElementById("sectionName").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/question.do?flag=showQuestionBySection&typeName=材料分析题&sectionName="
				+ sectionName;
		document.getElementById("fom").submit();
	}
</script>
</head>

<body class="ContentBody" onload="init();">
	<form method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">

			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">材料分析题</th>
				</tr>
				<tr>
					<td style="width: 485px; "><input type="button"
						value="返回材料分析题列表" style="width: 137px; " onclick="back();"
						class="button" /></td>

				</tr>
				<tr>
					<td width="100%"><fieldset>
							<legend> 大题信息</legend>
							<table style="width: 1124px; ">
								<TR>
									<TD width="100%">
										<fieldset style="height:100%;">
											<table>

												<tr align="left">
													<td align="left" width="13%" style="width: 58px; ">题干内容:</td>
													<td style="width: 448px; "><textarea rows="" cols=""
															id="material" name="material"
															style="width: 729px; height: 100px">${materialAnalysis.material}</textarea><span
														class="red"> *</span></td>

												</tr>

											</table>

										</fieldset>
									</TD>

								</TR>
								<tr>
									<td><fieldset>
											<table>
												<tr>
													<td>题目图片:</td>
													<td><input type="file" name="materialImage"
														id="materialImage" /></td>
												</tr>
											</table>
										</fieldset></td>
								</tr>
								<tr>
									<td><fieldset>
											<table>
												<tr>
													<td>备注内容：</td>
													<td><textarea name="remark" id="remark"
															style="width: 731px; height: 85px">${materialAnalysis.remark}</textarea></td>
												</tr>
											</table>

										</fieldset></td>
								</tr>
								<tr>
									<td><fieldset>
											<table>
												<tr>
													<td>科目名称：</td>
													<td><select name="subjectName">
															<c:forEach items="${subjects}" var="item">
																<option>${item.subName}</option>
															</c:forEach>
													</select></td>
												</tr>
												<tr>
													<td>章节名称:</td>
													<td><select id="sectionName" name="sectionName">
															<c:forEach items="${sections}" var="item">
																<option>${item.sectionName}</option>
															</c:forEach>
													</select></td>
													<td><input type="hidden" id="sectionId"
														value="${section.id}" /></td>
												</tr>
											</table>
										</fieldset></td>
								</tr>
								<TR>
									<TD colspan="2" align="center" height="50px"><input
										type="button" value="编辑" class="button" style="width: 83px; "
										onclick="editMaterialAnalysis();" id="materialAnalysis_Edit" />
										<input type="button" value="保存" style="width: 77px;"
										onclick="saveMaterialAnalysis('${materialAnalysis.id}');"
										class="button" id="materialAnalysis_Save" /></TD>
								</TR>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>小题信息</legend>
							<table>
								<tr>
									<td style="width: 1070px; "><c:forEach
											items="${questionOfMaterials}" var="questionOfMaterial">
											<fieldset>
												<table style="width: 1031px; ">
													<tr>
														<td>
															<table>

																<tr>
																	<td>小题编号：</td>
																	<td><input type="text"
																		id="questionNumber${questionOfMaterial.questionNumber}"
																		name="questionNumber${questionOfMaterial.questionNumber}"
																		value="${questionOfMaterial.questionNumber}" /></td>
																</tr>
																<br />
																<tr>
																	<td>小题题干:</td>
																	<td><textarea
																			id="questionStem${questionOfMaterial.questionNumber}"
																			name="questionStem${questionOfMaterial.questionNumber}"
																			style="width: 721px; height: 93px">${questionOfMaterial.questionStem}</textarea></td>
																</tr>
																<br />
																<tr>
																	<td>小题答案：</td>
																	<td><textarea
																			id="answer${questionOfMaterial.questionNumber}"
																			name="answer${questionOfMaterial.questionNumber}"
																			style="width: 723px; height: 98px">${questionOfMaterial.answer}</textarea></td>
																</tr>
																<br />
																<tr>
																	<td>小题分析：</td>
																	<td style="height: 84px; "><textarea
																			id="analysis${questionOfMaterial.questionNumber}"
																			name="analysis${questionOfMaterial.questionNumber}"
																			style="width: 720px; height: 89px">${questionOfMaterial.analysis}</textarea></td>
																</tr>
																<br />
																<tr>
																	<td>小题分值：</td>
																	<td><input type="text"
																		id="score${questionOfMaterial.questionNumber}"
																		name="score${questionOfMaterial.questionNumber}"
																		value="${questionOfMaterial.score}" /></td>
																</tr>


															</table>
														</td>
														<td><table>
																<tr>
																	<td><a
																		href="${pageContext.request.contextPath}/materialAnalysis.do?flag=moveQuestionOfMaterial&type=decrease&questionOfMaterialId=${questionOfMaterial.id}">上移</a></td>
																	<td><a
																		href="${pageContext.request.contextPath}/materialAnalysis.do?flag=moveQuestionOfMaterial&type=increase&questionOfMaterialId=${questionOfMaterial.id}">下移</a></td>
																</tr>
															</table></td>
													</tr>
													<TR>
														<TD colspan="2" align="center" height="50px"
															style="width: 257px; "><input type="button"
															value="编辑" class="button" style="width: 83px; "
															onclick="editQuestionOfMaterial('${questionOfMaterial.questionNumber}');" />
															<input type="button" value="保存" style="width: 77px;"
															onclick="saveQuestionOfMaterial('${questionOfMaterial.id}');"
															class="button" /><input type="button" value="删除"
															style="width: 77px;"
															onclick="deleteQuestionOfMaterial('${questionOfMaterial.id}');"
															class="button" /></TD>
													</TR>
												</table>

											</fieldset>
										</c:forEach></td>
								</tr>

							</table>

						</fieldset></td>
				</tr>


			</TABLE>

		</div>
	</form>
</body>

</html>
