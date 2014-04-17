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
	function InitCheckBox() {
      var checked="true";
     
      if(document.getElementById("answerA").value==checked)
      document.getElementById("answerA").checked=true
     if(document.getElementById("answerB").value==checked)
      document.getElementById("answerB").checked=true
       if(document.getElementById("answerC").value==checked)
      document.getElementById("answerC").checked=true
       if(document.getElementById("answerD").value==checked)
      document.getElementById("answerD").checked=true
       if(document.getElementById("answerE").value==checked)
      document.getElementById("answerE").checked=true
       if(document.getElementById("answerF").value==checked)
      document.getElementById("answerF").checked=true
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
		document.getElementById("fom").action = "${pageContext.request.contextPath}/question.do?flag=showQuestionBySection&typeName=多项选择题&sectionName="
				+ sectionName;
		document.getElementById("fom").submit();
	}
</script>
</head>

<body class="ContentBody" onload="InitCheckBox();">
	<form
		action="${pageContext.request.contextPath}/question.do?flag=editMultiChoice&multiChoiceId=${multiChoice.id}"
		method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">多项选题</th>
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
											id="questionStem" readonly="readonly" name="questionStem"
											style="width: 376px; height: 100px">${multiChoice.questionStem}</textarea></td>

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
										<table>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项A:</td>
												<td width="43%"><input id="optionA" name="optionA"
													class="text" style="width:250px" type="text" size="40"
													readonly="readonly" value="${multiChoice.optionA}" /></td>
											</tr>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项B:</td>
												<td width="43%"><input id="optionB" name="optionB"
													class="text" style="width:250px" type="text" size="40"
													readonly="readonly" value="${multiChoice.optionB}" /></td>
											</tr>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项C:</td>
												<td width="43%"><input id="optionC" class="text"
													style="width:250px" type="text" size="40" name="optionC"
													readonly="readonly" value="${multiChoice.optionC}" /></td>
											</tr>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项D:</td>
												<td width="43%"><input id="optionD" class="text"
													style="width:250px" type="text" size="40" name="optionD"
													readonly="readonly" value="${multiChoice.optionD}" /></td>
											</tr>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项E:</td>
												<td width="43%"><input id="optionE" name="optionE"
													class="text" style="width:250px" type="text" size="40"
													name="optionE" readonly="readonly"
													value="${multiChoice.optionE}" /></td>
											</tr>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项F:</td>
												<td width="43%"><input id="optionE" name="optionE"
													class="text" style="width:250px" type="text" size="40"
													name="optionE" readonly="readonly"
													value="${multiChoice.optionF}" /></td>
											</tr>
										</table>
									</td>
									<td><table>
											<tr>
												<td>答案</td>
												<td><input type="radio" id="answerA" name="answerA"
													readonly="readonly" value="${multiChoice.answerA}"/>A</td>
												<td><input type="radio" id="answerB" name="answerB"
													readonly="readonly" value="${multiChoice.answerB}"/>B</td>
												<td><input type="radio" id="answerC" name="answerC"
													readonly="readonly" value="${multiChoice.answerC}"/>C</td>
												<td><input type="radio" id="answerD" name="answerD"
													readonly="readonly" value="${multiChoice.answerD}"/>D</td>
												<td><input type="radio" id="answerE" name="answerE"
													readonly="readonly" value="${multiChoice.answerE}"/>E</td>
												<td><input type="radio" id="answerF" name="answerF"
													readonly="readonly" value="${multiChoice.answerF}"/>F</td>
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
									<td>题目分析</td>
									<td><textarea id="analysis" cols="" rows=""
											name="analysis" readonly="readonly"
											style="height: 119px; width: 394px">${singleChoice.analysis}</textarea></td>
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
									<td><select name="subjectName" disabled="disabled">
											<option selected="selected">${subject.subName}</option>
											<c:forEach items="${subjects}" var="item">
												<option>${item.subName}</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td>章节名称:</td>
									<td><select id="sectionName" disabled="disabled"
										name="sectionName">
											<option selected="selected">${section.sectionName}</option>
											<c:forEach items="${sections}" var="item">
												<option>${item.sectionName}</option>
											</c:forEach>
									</select></td>
									<td><input type="hidden" id="sectionId"
										value="${section.sectionName}" /></td>
								</tr>
							</table>
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
