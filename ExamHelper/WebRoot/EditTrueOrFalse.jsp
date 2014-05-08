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


<title>判断题</title>


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
		document.getElementById("fom").submit();

	}
	function back() {
		var sectionName = document.getElementById("sectionName").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}trueOrFalse.do?flag=showTrueOrFalseList&sectionName="+sectionName+"&pageNow="+'${pageNow}';
		document.getElementById("fom").submit();
	}
	function initAnswer(answer) {
		var checked = "true";
		var answers = document.getElementsByName("answer");
		if (answer == checked) {
			answers[0].checked = true;
			answers[1].checked = false;
		} else {
			answers[0].checked = false;
			answers[1].checked = true;
		}
	}
</script>
</head>

<body class="ContentBody" onload="initAnswer('${trueOrFalse.answer}')">
	<form
		action="${pageContext.request.contextPath}/trueOrFalse.do?flag=saveTrueOrFalse&trueOrFalseId=${trueOrFalse.id}&pageNow=${pageNow}"
		method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">判断题题</th>
				</tr>
				<tr>
					<td><input type="button" value="返回判断题列表" onclick="back();" class="button" />
				    </td>

				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>题干</legend>
							<table>

								<tr align="left">
									<td align="left" width="80px">题干内容:</td>
									<td><textarea rows="8" cols="80"
											id="questionStem" name="questionStem">${trueOrFalse.questionStem}</textarea></td>

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

									<td><table style="width: 341px; ">

											<tr>
												<td align="left" width="80px">答案：</td>
												<td><input id="answer" name="answer"
													value="true" class="text" style="width: 24px" type="radio"
													size="40" /></td>
												<td><img src="./images/image_right.png"
													style="width: 43px; " /></td>
												<td><input id="answer" name="answer"
													value="false" class="text" style="width: 24px;margin-left: 20px;" type="radio"
													size="40" /></td>
												<td><img src="./images/image_wrong.png" /></td>
											</tr>
										</table></td>
								</tr>
							</table>

						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>分析</legend>
							<table>
								<tr>
									<td width="80px">题目分析:</td>
									<td><textarea id="analysis" cols="80" rows="8"
											name="analysis">${trueOrFalse.analysis}</textarea></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>所属科目、章节</legend>
							<table cellspacing="10px">
								<tr>
									<td width="80px">科目名称：</td>
									<td><select name="subjectName" id="subjectName"
													style="width: 250px;height: 23px; ">
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
									<td><select id="sectionName" name="sectionName" style="width: 250px;height: 23px; ">
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
					<td> <input type="button" value="保存"
						type="submit"onclick="save();"
						class="button" /></TD>
				</TR>
			</TABLE>

		</div>
	</form>
</body>

</html>
