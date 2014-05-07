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
	function saveMaterialAnalysis(materialAnalysisId) {

		if (document.getElementById("material").value.trim().length != 0) {

			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=saveMaterialAnalysis&materialAnalysisId="
					+ materialAnalysisId;
			document.getElementById("fom").submit();
		} else
			alert("请输入题干");
	}
	
	function saveQuestionOfMaterial(questionOfMaterialId) {

		if (document.getElementById("questionStem" + questionOfMaterialId).value
				.trim().length != 0) {

			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=saveQuestionOfMaterial&questionOfMaterialId="
					+ questionOfMaterialId;

			document.getElementById("fom").submit();
		} else
			alert("请输入题干");
	}
	function deleteQuestionOfMaterial(questionOfMaterialId) {
		document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=deleteQuestionOfMaterial&questionOfMaterialId="
				+ questionOfMaterialId;

		document.getElementById("fom").submit();
	}
	function addQuestionOfMaterial(){
	if (document.getElementById("material").value.trim().length != 0) {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=addQuestionOfMaterialUI&materialAnalysisId="+'${materialAnalysis.id}';
			document.getElementById("fom").submit();
		} else
			alert("请先完成题干输入");
	}
	function back() {
		var sectionName = document.getElementById("sectionName").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=showMaterialAnalysisList&sectionName="+sectionName+"&pageNow="+'${pageNow}';
			
		document.getElementById("fom").submit();
	
	}
</script>
</head>

<body class="ContentBody" >
	<form method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">

			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">材料分析题</th>
				</tr>
				<tr>
					<td>
						<input type="button" value="返回材料分析题列表" onclick="back();" class="button" />
					</td>
				</tr>
				<tr>
					<td width="100%"><fieldset>
							<legend> 大题信息</legend>
							<table style="width: 100%; ">
								<TR>
									<TD width="100%">
										<fieldset style="height:100%;">
											<table>

												<tr align="left">
													<td align="left" width="80px">题干内容:</td>
													<td><textarea rows="10" cols="120"
															id="material" name="material">${materialAnalysis.material}</textarea><span
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
													<td width="80px">题目图片:</td>
													<td><img src="${materialAnalysis.materialImage}" alt="" /></td>
												</tr>
											</table>
										</fieldset></td>
								</tr>
								<tr>
									<td><fieldset>
											<table>
												<tr>
													<td width="80px">备注内容：</td>
													<td><textarea name="remark" id="remark" rows="8" cols="120">${materialAnalysis.remark}</textarea></td>
												</tr>
											</table>

										</fieldset></td>
								</tr>
								<tr>
									<td><fieldset>
											<table cellspacing="10px">
												<tr>
													<td width="80px">科目名称：</td>
													<td><select name="subjectName" id="subjectName"
													style="width: 250px; ">
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
													<td width="80px">章节名称:</td>
													<td><select id="sectionName" name="sectionName" style="width: 250px; ">
											<c:forEach items="${sections}" var="section">
															<c:choose>
																<c:when test="${section.sectionName==sectionName}">
																	<option value="${section.sectionName}" selected="selected">${section.sectionName}</option>
																</c:when>
																<c:otherwise>
																	<option value="${section.sectionName}">${section.sectionName}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
									</select></td>
												</tr>
											</table>
										</fieldset></td>
								</tr>
								<TR>
									<TD colspan="2" align="center" height="50px">
										<input type="button" value="保存" onclick="saveMaterialAnalysis('${materialAnalysis.id}');" class="button" id="materialAnalysis_Save" />
									</TD>
								</TR>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>小题信息</legend>
							<table width="100%">
								<tr>
									<td style="width: 100%;">
									<c:forEach	items="${materialAnalysis.questionsofmaterials}" var="questionOfMaterial">
											<fieldset>
												<table style="width: 100%; ">
													<tr>
														<td>
															<table cellspacing="10px;">
																<tr>
																	<td width="80px">小题编号：</td>
																	<td><input type="text"
																		id="questionNumber${questionOfMaterial.id}"
																		name="questionNumber${questionOfMaterial.id}"
																		value="${questionOfMaterial.questionNumber}" /></td>
																</tr>
																<tr>
																	<td width="80px">小题题干:</td>
																	<td><textarea
																			id="questionStem${questionOfMaterial.id}"
																			name="questionStem${questionOfMaterial.id}"
																			rows="8" cols="120">${questionOfMaterial.questionStem}</textarea></td>
																</tr>
																<tr>
																	<td width="80px">小题答案：</td>
																	<td><textarea id="answer${questionOfMaterial.id}"
																			name="answer${questionOfMaterial.id}"
																			rows="8" cols="120">${questionOfMaterial.answer}</textarea></td>
																</tr>
																<tr>
																	<td width="80px">小题分析：</td>
																	<td ><textarea
																			id="analysis${questionOfMaterial.id}"
																			name="analysis${questionOfMaterial.id}"
																			rows="8" cols="120">${questionOfMaterial.analysis}</textarea></td>
																</tr>
																<tr>
																	<td width="80px">小题分值：</td>
																	<td><input type="text"
																		id="score${questionOfMaterial.id}"
																		name="score${questionOfMaterial.id}"
																		value="${questionOfMaterial.score}" />
																	</td>
																</tr>
															</table>
														</td>
														<td>
															<table cellspacing="10px;">
																<tr>
																	<td><a
																		href="${pageContext.request.contextPath}/materialAnalysis.do?flag=moveQuestionOfMaterial&type=decrease&questionOfMaterialId=${questionOfMaterial.id}">上移</a></td>
																	<td><a
																		href="${pageContext.request.contextPath}/materialAnalysis.do?flag=moveQuestionOfMaterial&type=increase&questionOfMaterialId=${questionOfMaterial.id}">下移</a></td>
																</tr>
															</table>
														</td>
													</tr>
													<TR>
														<TD colspan="2" align="center" height="50px"
															style="width: 257px; ">
															<input type="button" value="保存"
															onclick="saveQuestionOfMaterial('${questionOfMaterial.id}');"
															class="button" /><input type="button" value="删除"
															onclick="deleteQuestionOfMaterial('${questionOfMaterial.id}');"
															class="button" />
														</TD>
													</TR>
												</table>
											</fieldset>
										</c:forEach>
										</td>
								</tr>
								<tr>
									<td><input type="button"value="添加小题"  onclick="addQuestionOfMaterial();"class="button" style="margin-left: 12px;"/></td>
								</tr>
								<TR>
									<TD colspan="2" align="center" height="50px"> </TD>
								</TR>
							</table>

						</fieldset></td>
				</tr>


			</TABLE>

		</div>
	</form>
</body>

</html>
