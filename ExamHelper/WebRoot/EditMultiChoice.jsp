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
	function checkedAnswer(answer) {
		if(answer.checked == true)
		answer.value=true;
		else answer.value=false;
		
		alert(answer);
	}
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
	function InitCheckBox() {
		var checked = "true";

		var checked = "true";
		for (var i = 1; i < 7; i++) {
			if (document.getElementById("answer" + i).value == checked)
				document.getElementById("answer" + i).checked = true;
		}
	}

	function save() {
		document.getElementById("fom").submit();

	}
	function back() {
		var sectionName=document.getElementById("sectionName").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/multiChoice.do?flag=showMultiChoiceList&sectionName="+sectionName;
			
		document.getElementById("fom").submit();
	}
	
</script>
</head>

<body class="ContentBody" onload="InitCheckBox();">
	<form
		action="${pageContext.request.contextPath}/multiChoice.do?flag=saveMultiChoice&multiChoiceId=${multiChoice.id}&pageNow=${pageNow}"
		method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">多项选择题</th>
				</tr>
				<tr>
					<td><input type="button" value="返回多选题列表" onclick="back();" class="button" />
					</td>
				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>题干</legend>
							<table>
								<tr align="left">
									<td align="left" width="80px">题干内容:</td>
									<td><textarea rows="" cols=""
											id="questionStem" name="questionStem"
											rows="8" cols="80">${multiChoice.questionStem}</textarea></td>

								</tr>

							</table>
							<br />
						</fieldset>
					</TD>

				</TR>
				<tr>
					<td><fieldset>
							<legend>选项</legend>

							<table>
								<tr>
									<td>
										<table cellspacing="10px;">
											<tr>
												<td align="center" width="80px">选项A:</td>
												<td><input id="optionA" name="optionA"
													class="text" style="width:300px;height: 22px;" type="text" size="40"
													value="${multiChoice.optionA}" /></td>
											</tr>
											<tr>
												<td align="center" width="80px">选项B:</td>
												<td><input id="optionB" name="optionB"
													class="text" style="width:300px;height: 22px;" type="text" size="40"
													value="${multiChoice.optionB}" /></td>
											</tr>
											<tr>
												<td align="center"width="80px">选项C:</td>
												<td><input id="optionC" class="text"
													style="width:300px;height: 22px;" type="text" size="40" name="optionC"
													value="${multiChoice.optionC}" /></td>
											</tr>
											<tr>
												<td align="center"width="80px">选项D:</td>
												<td><input id="optionD" class="text"
													style="width:300px;height: 22px;" type="text" size="40" name="optionD"
													readonly="readonly" value="${multiChoice.optionD}" /></td>
											</tr>
											<tr>
												<td align="center" width="80px">选项E:</td>
												<td><input id="optionE" name="optionE"
													class="text" style="width:300px;height: 22px;" type="text" size="40"
													name="optionE" value="${multiChoice.optionE}" /></td>
											</tr>
											<tr>
												<td align="center" width="80px">选项F:</td>
												<td><input id="optionE" name="optionE"
													class="text" style="width:300px;height: 22px;" type="text" size="40"
													name="optionF" value="${multiChoice.optionF}" /></td>
											</tr>
										</table>
									</td>
									<td><table>
											<tr>
												<td>答案</td>
												<td><input type="checkbox" id="answer1" name="answerA" style="height: 20px;width: 20px;"
													 value="${multiChoice.answerA}" />A</td>
												<td><input type="checkbox" id="answer2" name="answerB"style="height: 20px;width: 20px;"
													 value="${multiChoice.answerB}" />B</td>
												<td><input type="checkbox" id="answer3" name="answerC"style="height: 20px;width: 20px;"
													 value="${multiChoice.answerC}" />C</td>
												<td><input type="checkbox" id="answer4" name="answerD"style="height: 20px;width: 20px;"
													 value="${multiChoice.answerD}" />D</td>
												<td><input type="checkbox" id="answer5" name="answerE"style="height: 20px;width: 20px;"
													 value="${multiChoice.answerE}" />E</td>
												<td><input type="checkbox" id="answer6" name="answerF"style="height: 20px;width: 20px;"
													 value="${multiChoice.answerF}" />F</td>
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
									<td><textarea id="analysis" cols="80" rows="8" name="analysis">${singleChoice.analysis}</textarea></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>所属科目、章节</legend>
							<table cellspacing="10px;">
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
					<TD colspan="2" align="center" height="50px"><input
						type="button" value="保存" type="submit"
						onclick="save();" class="button" /></TD>
				</TR>
			</TABLE>

		</div>
	</form>
</body>

</html>
