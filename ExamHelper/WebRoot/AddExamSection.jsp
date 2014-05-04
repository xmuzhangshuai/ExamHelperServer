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
		var examinationId = '${examinatioId}'
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=showExamination&examinationId="
				+ examinationId;
		document.getElementById("fom").submit();
	}

	function saveSectionInfor() {
		var questionType = document.getElementById("questionType").value;
		var examinationId='${examinationId}'
		if (questionType == "null")
			alert("请选择题目类型")
		else {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamSectionInfor"
					+ "&examinationId=" + examinationId;

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


				</TR>
				<tr>
					<td>
						<fieldset>
							<legend>小题信息</legend>
							<table style="width: 100%">


								<tr>
									<td><table id="table">
											<tr>
												<td>题型类型：</td>
												<td><select id="questionType" name="questionType">
														<option value="null" selected="selected">请选择题目类型</option>
														<c:forEach items="${questionTypes}" var="questionType">
															<option value="${questionType.id}">${questionType.typeName}</option>
														</c:forEach>
												</select></td>
											</tr>
											<tr>
												<td>题目要求：</td>
												<td><textarea rows="" cols="" id="request"
														name="request" style="width: 299px; height: 65px"></textarea>

												</td>

											</tr>
											<tr>
												<td>题目分值：</td>
												<td><input type="text" name="score" id="score" /></td>
											</tr>
											<tr>
												<TD colspan="2" align="center" height="50px"><input
													type="button" value="保存"
													onclick="saveSectionInfor();"
													class="button" /></TD>
											</tr>
										</table>
								</td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>

</html>
