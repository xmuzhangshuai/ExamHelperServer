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
		var subjectId = '${subjectId}';
		var noContent = "";
		if (subjectId == noContent)
			document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=showAllExamList";
		else
			document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=showExamListBySubject&subjectId="
					+ subjectId;

		document.getElementById("fom").submit();
	}

	function saveExamInfor(examId) {
		var subjectName = document.getElementById("subjectName").value;
		if (subjectName == "null") {
			alert("请选择科目");
		} else {

			if (examId != null && examId != undefined)
				document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamination&examinationId="
						+ examId;
			else
				document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamination";
			document.getElementById("fom").submit();
		}
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
									<td><a href="#" onclick="showExamInfor();">试卷信息</a></td>
								</tr>
								<tr>
									<td><table id="examInfor" style="width: 100%;">
											<tr>
												<td>试卷名称：</td>
												<td><input type="text" name="examName" id="examName"
													value="${examination.examName}" style="width: 244px; " /></td>
											</tr>
											<tr align="left">
												<td>科目名称：</td>
												<td style="width: 264px; "><select name="subjectName"
													id="subjectName" style="width: 243px; " required>
														<c:choose>
															<c:when test="${empty subjectId}">
																<option value="null" selected="selected">请选择科目</option>
																<c:forEach items="${subjects}" var="item">
																	<option value="${item.subName}">${item.subName}</option>
																</c:forEach>
															</c:when>
															<c:otherwise>
																<c:forEach items="${subjects}" var="item">
																	<c:choose>
																		<c:when test="${item.id==subjectId}">
																			<option value="${item.subName}" selected="selected">${item.subName}</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${item.subName}">${item.subName}</option>
																		</c:otherwise>
																	</c:choose>
																</c:forEach>
															</c:otherwise>
														</c:choose>
												</select><span class="red">*</span></td>
											</tr>
											<tr>
												<td>试卷类型：</td>
												<td><input type="text" name="examType" id="examType"
													value="${examination.examType}" style="width: 246px; " /></td>
											</tr>
											<tr>
												<td>考试时间：</td>
												<td><input id="examTime" name="examTime" type="text"
													value="${examination.examTime}" style="width: 248px; " /></td>
											</tr>
											<tr>
												<td>考试要求：</td>
												<td style="height: 67px; width: 236px"><textarea
														id="examRequest" name="examRequest"
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
						</fieldset>
					</TD>

				</TR>

			</table>
		</div>
	</form>
</body>

</html>
