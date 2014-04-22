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
		document.getElementById("fom").submit();

	}
	function back() {
		var sectionName = document.getElementById("sectionName").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/question.do?flag=showQuestionBySection&typeName=单项选择题&sectionName="
				+ sectionName;
		document.getElementById("fom").submit();
	}
</script>
</head>

<body class="ContentBody">
	<form
		action="${pageContext.request.contextPath}/question.do?flag=editSingleChoice&singleChoiceId=${singleChoice.id}"
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
						style="width: 111px; " onclick="back();" class="button" /></td>

				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>试卷信息</legend>
							<table>
								<tr>
									<td>试卷名称：</td>
									<td><input type="text" name="examName" id="examName"
										value="${examination.examName}" /></td>
								</tr>
								<tr align="left">
									<td>科目名称：</td>
									<td><select name="subjectName" id="subjectName">
											<option>${subject.subName}</option>
											<c:forEach items="${subjects}" var="item">
												<option>${item.subName}</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td>试卷类型：</td>
									<td><input type="text" name="examType" id="examType"
										value="${examination.examType}" /></td>
								</tr>
								<tr>
									<td>考试要求：</td>
									<td><textarea id="examRequest" name="examRequest">${examination.examRequest}</textarea></td>
								</tr>
								<tr>
									<td>考试时间：</td>
									<td><input id="examTime" name="examTime" type="text"
										value="${examination.examTime}" /></td>
								</tr>
							</table>
							<br />
						</fieldset>
					</TD>

				</TR>
				<tr>
					<td>
						<fieldset>
							<legend>小题信息</legend>
							<table>
								<c:forEach items="${examSections}" var="examSection">

									<tr>
										<td><img name="img1" id="img1" src="./images/ico04.gif"
											width="8" height="11" />
											${examSection.questionType.typeName}信息</td>
									</tr>
									<tr>
										<td><table style="display:none;">
												<tr>
													<td>题目要求：</td>
													<td><input type="text" value="${examSection.request}"
														id="request${examSection.questiontype.id}" /></td>
												</tr>
												<tr>
													<td>题目分值：</td>
													<td><input type="text"
														value="${examSection.questionScore}"
														id="score${examSection.questiontype.id}" /></td>
												</tr>
											</table></td>
									</tr>
							</table>
					</td>
				</tr>
				</c:forEach>

			</table>
			</fieldset>

			</td>

			</tr>
			<tr>
				<td><fieldset>
						<legend>试卷内容</legend>
						<table>
							<tr>
								<td>
									<fieldset style="display:none; ">
										<legend>单项选择题</legend>
										<table>

											<tr>
												<td>
													<table>
														<c:forEach items="${singleChoices}" var="singleChoice">
															<tr>
																<td><a
																	href="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoice&singleChoiceId=${singleChoice.id}">${singleChoice.questionStem}</a>
																</td>
															</tr>
															<tr>
																<td>
																	<table>
																		<tr>
																			<td>A:${singleChoice.optionA}</td>
																			<td>B:${singleChoice.optionB}</td>
																			<td>C:${singleChoice.optionC}</td>
																			<td>D:${singleChoice.optionD}</td>
																			<td>E:${singleChoice.optionE}</td>
																		</tr>
																	</table>
																</td>
															</tr>
														</c:forEach>
													</table>
												</td>
											</tr>

										</table>
									</fieldset>
								</td>
							</tr>
						</table>
					</fieldset></td>
			</tr>

			<TR>
				<TD colspan="2" align="center" height="50px"><input
					type="button" value="编辑" class="button" style="width: 83px; "
					onclick="edit();" /> <input type="button" value="保存" type="submit"
					style="width: 77px;" onclick="save();" class="button" /></TD>
			</TR>
			</TABLE>

		</div>
	</form>
</body>

</html>
