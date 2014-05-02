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

	function check() {
		document.getElementById("aa").style.display = "";
	}

	function edit() {
		var txtN = document.getElementsByTagName("input");
		for (i = 0; i < txtN.length; i++) {
			txtN[i].readOnly = false;
		}

		var txtArea = document.getElementsByTagName("textarea");
		for (i = 0; i < txtArea.length; i++)
			txtArea[i].readOnly = false;

		var txtSelect = document.getElementsByTagName("select");
		for (var i = 0; i < txtSelect.length; i++)
			txtSelect[i].disabled = false;
	}
	function save() {

		if (document.getElementById("material").value.trim().length != 0) {

			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=addMaterialAnalysis"

			document.getElementById("fom").submit();
		} else
			alert("请输入题干");

	}
	function back() {
		var sectionName = document.getElementById("sectionName").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/question.do?flag=showQuestionBySection&typeName=材料分析题&sectionName="
				+ sectionName;
		document.getElementById("fom").submit();
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
					<th class="tablestyle_title">材料分析题</th>
				</tr>
				<tr>
					<td style="width: 485px; "><input type="button"
						value="返回材料分析题列表" style="width: 137px; " onclick="back();"
						class="button" /></td>

				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>题干</legend>
							<table>

								<tr align="left">
									<td align="left" width="13%">题干内容:</td>
									<td style="width: 448px; "><textarea rows="" cols=""
											id="material" name="material"
											style="width: 376px; height: 100px"></textarea><span
										class="red"> *</span></td>

								</tr>

							</table>
							<br />
						</fieldset>
					</TD>

				</TR>
				<tr>
					<td><fieldset>
							<legend>题目图片:</legend>
							<table>
								<tr>
									<td><jsp:include page="UploadImage.jsp" /></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>所属科目、章节</legend>
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
				<tr>
					<td><fieldset>
							<legend>小题</legend>
							<c:forEach items="${questionOfMaterials}"
								var="questionOfMaterial">
								<fieldset>
									<table>
										<tr>
											<td>小题编号：</td>
											<td><input type="text"
												id="questionOfMaterial${questionOfMaterial.questionNumber}"
												readonly="readonly" value="${questionOfMaterial.questionNumber}"" /></td>
										</tr>
										<tr>
											<td>小题题干:</td>
											<td><textarea
													id="questionStem${questionOfMaterial.questionNumber}" style="width: 304px; height: 93px">${questionOfMaterial.questionStem}</textarea></td>
										</tr>
										<tr>
											<td>小题答案：</td>
											<td><textarea
													id="answer${questionOfMaterial.questionNumber}" style="width: 302px; height: 98px">${questionOfMaterial.answer}</textarea></td>
										</tr>
										<tr>
										<td>小题分析：</td>
											<td style="height: 84px; "><textarea
													id="analysis${questionOfMaterial.questionNumber}" style="width: 305px; height: 89px">${questionOfMaterial.analysis}</textarea></td>
										</tr>
										<tr>
										<td>小题分值：</td>
											<td><input type="text"
												id="score${questionOfMaterial.questionNumber}"
												readonly="readonly" value="${questionOfMaterial.score}"/></td>
										</tr>
									</table>
								</fieldset>
							</c:forEach>
							<a href="${pageContext.request.contextPath}/materialAnalysis.do?flag=addQuestionOfMaterial" style="font-size: small;">添加小题</a>
						</fieldset></td>
				</tr>

				<TR>
					<TD colspan="2" align="center" height="50px"><input
						type="button" value="编辑" class="button" style="width: 83px; "
						onclick="edit();" /> <input type="button" value="保存"
						type="submit" style="width: 77px;" onclick="save();"
						class="button" /></TD>
				</TR>
			</TABLE>

		</div>
	</form>
</body>

</html>
