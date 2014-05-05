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

	function back(materialAnalysisId) {
window.history.back(-1);

	}
	function save(materialAnalysisId) {

		if (document.getElementById("questionStem").value.trim().length != 0) {

			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=addQuestionOfMaterial&materialAnalysisId="+materialAnalysisId;

			document.getElementById("fom").submit();
		} else
			alert("请输入题干");

	}
</script>
</head>

<body class="ContentBody">
	<form method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">材料分析题小题</th>
				</tr>
				<tr>
					<td><fieldset>
							<legend>小题</legend>

							<fieldset>
								<table>
									
									<tr>
										<td>小题编号：</td>
										<td><input type="text" id="questionNumber"
											name="questionNumber" value="${questionOfMaterial.questionNumber}"
											disabled="disabled" /><span class="red"> *</span></td>
									</tr>
									<tr>
										<td>小题题干:</td>
										<td><textarea id="questionStem" name="questionStem" 
												style="width: 304px; height: 93px">${questionOfMaterial.questionStem}</textarea><span
											class="red"> *</span></td>
									</tr>
									<tr>
										<td>小题答案：</td>
										<td><textarea name="answer" id="answer"
												style="width: 302px; height: 98px">${questionOfMaterial.answer}</textarea></td>
									</tr>
									<tr>
										<td>小题分析：</td>
										<td style="height: 84px; "><textarea id="analysis"
												name="analysis" style="width: 305px; height: 89px">${questionOfMaterial.analysis}</textarea></td>
									</tr>
									<tr>
										<td>小题分值：</td>
										<td><input type="text" id="score" name="score" value="${questionOfMaterial.score}" /></td>
									</tr>
								</table>
							</fieldset>


						</fieldset></td>
				</tr>

				<TR>
					<TD colspan="2" align="center" height="50px"><input
						type="button" value="保存"
						onclick="save('${materialAnalysisId}');" class="button" /><input type="button"
						value="返回" class="button" onclick="back('${materialAnalysisId}');" /></TD>
				</TR>
			</TABLE>

		</div>
	</form>
</body>

</html>
