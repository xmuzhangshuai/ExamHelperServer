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

<title>多项选择题</title>

<link rel="stylesheet" rev="stylesheet" href="./css/style.css"
	type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">
	function check() {
		document.getElementById("aa").style.display = "";
	}
	function InitCheckBox() {
		var checked = "true";
		for (var i = 1; i < 7; i++) {
			if (document.getElementById("answer" + i).value == checked)
				document.getElementById("answer" + i).checked = true;
		}

	}
	
	function back() {
		window.history.back(-1);
	}
</script>
</head>

<body class="ContentBody" onload="InitCheckBox();" style="line-height: 150%">
	<form
		action="${pageContext.request.contextPath}/multiChoice.do?flag=editMultiChoice&multiChoiceId=${multiChoice.id}"
		method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
				<tr>
					<th class="tablestyle_title">多项选题</th>
				</tr>
				<tr>
					<td><input type="button" value="返回多选题列表" onclick="back();"class="button" /></td>
				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>题干</legend>
							<table>
								<tr align="left">
									<td align="left" width="80px">题干内容:</td>
									<td><c:out value="${multiChoice.questionStem}"/></td>
								</tr>
							</table>
							<br />
						</fieldset>
					</TD>

				</TR>
				<tr>
					<td><fieldset>
							<legend>选项</legend>
							<table width="100%">
								<tr>
									<td width="50%">
										<table>
											<tr>
												<td align="left"  width="80px">选项A:</td>
												<td><c:out value="${multiChoice.optionA}"/></td>
											</tr>
											<tr>
												<td align="left" width="80px">选项B:</td>
												<td><c:out value="${multiChoice.optionB}"/></td>
											</tr>
											<c:if test="${!empty  multiChoice.optionC}">
											<tr>
												<td align="left" width="80px">选项C:</td>
												<td><c:out value="${multiChoice.optionC}"/></td>
											</tr>
											</c:if>
											<c:if test="${!empty  multiChoice.optionD}">
											<tr>
												<td align="left" width="80px">选项D:</td>
												<td><c:out value="${multiChoice.optionD}"/></td>
											</tr>
											</c:if>
											<c:if test="${!empty  multiChoice.optionE}">
											<tr>
												<td align="left" width="80px">选项E:</td>
												<td><c:out value="${multiChoice.optionE}"/></td>
											</tr>
											</c:if>
											<c:if test="${!empty  multiChoice.optionF}">
											<tr>
												<td align="left" width="80px">选项F:</td>
												<td><c:out value="${multiChoice.optionF}"/></td>
											</tr>
											</c:if>
										</table>
									</td>
									<td><table>
											<tr>
												<td>答案</td>
												<td><input type="checkbox" id="answer1" name="answerA"
													disabled="disabled" value="${multiChoice.answerA}" />A</td>
												<td><input type="checkbox" id="answer2" name="answerB"
													disabled="disabled" value="${multiChoice.answerB}" />B</td>
												<td><input type="checkbox" id="answer3" name="answerC"
													disabled="disabled" value="${multiChoice.answerC}" />C</td>
												<td><input type="checkbox" id="answer4" name="answerD"
													disabled="disabled" value="${multiChoice.answerD}" />D</td>
												<td><input type="checkbox" id="answer5" name="answerE"
													disabled="disabled" value="${multiChoice.answerE}" />E</td>
												<td><input type="checkbox" id="answer6" name="answerF"
													disabled="disabled" value="${multiChoice.answerF}" />F</td>
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
									<td><c:out value="${multiChoice.analysis}"/></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>所属科目、章节</legend>
							<table>
								<tr>
									<td width="80px">科目名称：</td>
									<td><c:out value="${multiChoice.section.subject.subName}"/></td>
								</tr>
								<tr>
									<td width="80px">章节名称:</td>
									<td><c:out value="${multiChoice.section.sectionName}"/></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
				
			</TABLE>

		</div>
	</form>
</body>

</html>
