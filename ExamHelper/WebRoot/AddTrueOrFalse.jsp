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


<title>单线选择题</title>


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

	function save() {

		if (document.getElementById("questionStem").value.trim().length != 0) {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=addSingleChoice"

			document.getElementById("fom").submit();
		} else
			alert("请输入题干");

	}
	function back() {
		var sectionId = document.getElementById("sectionId").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/question.do?flag=showQuestionBySection&typeName=单项选择题&sectionId="
				+ sectionId;
	}
	function right() {
		var right = document.getElementById("answerR");
		var wrong = document.getElementById("answerW")
		if (wrong.checked == true)
				wrong.checked = false;
		
	}
	function wrong(){
	var right = document.getElementById("answerR");
		var wrong = document.getElementById("answerW")

			if (right.checked == true)
				right.checked = false;
		
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
					<th class="tablestyle_title">单选题</th>
				</tr>
				<tr>
					<td style="width: 485px; "><input type="button"
						value="返回单选题列表" style="width: 111px; " onclick="back();"
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
											id="questionStem" name="questionStem"
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
							<legend>答案</legend>

							<table>
								<tr>
									<td>
										<table style="width: 341px; ">

											<tr>
												<td align="left" width="13%"
													style="height: 42px; width: 40px">答案：</td>
												<td width="43%"><input id="answerR" name="answerR"
													onclick="right();" class="text" style="width: 24px"
													type="radio" size="40" /></td>
												<td><img src="./images/image_right.png"
													style="width: 43px; " /></td>
												<td width="43%"><input id="answerW" name="answerW"
													class="text" style="width: 24px" type="radio" size="40"
													onclick="wrong();" /></td>
												<td><img src="./images/image_wrong.png" /></td>
											</tr>
										</table>
									</td>

								</tr>
							</table>

						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>分析</legend>
							<table>
								<tr>
									<td>题目分析</td>
									<td><textarea id="analysis" cols="" rows=""
											name="analysis" style="height: 119px; width: 394px"></textarea></td>
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
				<TR>
					<TD colspan="2" align="center" height="50px"><input
						type="button" value="保存" type="submit" style="width: 77px;"
						onclick="save();" class="button" /></TD>
				</TR>
			</TABLE>

		</div>
	</form>
</body>

</html>
