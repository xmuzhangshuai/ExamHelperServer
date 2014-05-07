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

</script>
</head>

<body class="ContentBody" style="line-height: 150%">
	<form method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">材料分析题小题</th>
				</tr>
				<tr>
					<td><fieldset>
							<legend>小题</legend>
							<fieldset>
								<table cellspacing="10px">
									<tr>
										<td width="80px">小题编号：</td>
										<td><c:out value="${questionOfMaterial.questionNumber}"/><span class="red"> *</span></td>
									</tr>
									<tr>
										<td width="80px">小题题干:</td>
										<td><c:out value="${questionOfMaterial.questionStem}"/><span
											class="red"> *</span></td>
									</tr>
									<tr>
										<td width="80px">小题答案：</td>
										<td><c:out value="${questionOfMaterial.answer}"/></td>
									</tr>
									<tr>
										<td width="80px">小题分析：</td>
										<td><c:out value="${questionOfMaterial.analysis}"/></td>
									</tr>
									<tr>
										<td width="80px">小题分值：</td>
										<td><c:out value="${questionOfMaterial.score}"/></td>
									</tr>
								</table>
							</fieldset>
						</fieldset></td>
				</tr>
			</TABLE>

		</div>
	</form>
</body>

</html>
