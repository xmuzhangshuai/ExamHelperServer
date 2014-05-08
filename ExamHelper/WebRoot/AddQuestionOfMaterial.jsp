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
<link type="text/css" rel="stylesheet" href="./css/plug.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/dialog.js" charset="utf-8"></script>
<link rel="stylesheet" rev="stylesheet" href="./css/style.css"
	type="text/css" media="all" />

<script language="JavaScript" type="text/javascript">

	function check() {
		document.getElementById("aa").style.display = "";
	}

	function back(materialAnalysisId) {
document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=editMaterialAnalysis&materialAnalysisId="+materialAnalysisId;

			document.getElementById("fom").submit();

	}
	function save(materialAnalysisId) {

		if (document.getElementById("questionStem").value.trim().length != 0) {

			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=addQuestionOfMaterial&materialAnalysisId="+materialAnalysisId;

			document.getElementById("fom").submit();
		} else
			scscms_alert("请先输入题干","warn");

	}
</script>
</head>

<body class="ContentBody">
	<form method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="CContent">
				<tr>
					<td height="62" background="./images/nav04.gif"></td>
				</tr>
				<tr>
					<th class="tablestyle_title">材料分析题小题</th>
				</tr>
				<tr>
					<td><fieldset>
							<legend>小题</legend>

							<fieldset>
								<table cellspacing="10px;">
									
									<tr>
										<td>小题编号：</td>
										<td><input type="text" id="questionNumber"
											name="questionNumber" value="${questionNumber}"
											readonly="readonly" /><span class="red"> *</span></td>
									</tr>
									<tr>
										<td>小题题干:</td>
										<td><textarea id="questionStem" name="questionStem"  rows="8" cols="80"></textarea><span
											class="red"> *</span></td>
									</tr>
									<tr>
										<td>小题答案：</td>
										<td><textarea name="answer" id="answer"  rows="8" cols="80"></textarea></td>
									</tr>
									<tr>
										<td>小题分析：</td>
										<td><textarea id="analysis" name="analysis"  rows="8" cols="80"></textarea></td>
									</tr>
									<tr>
										<td>小题分值：</td>
										<td><input type="text" id="score" name="score" /></td>
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
