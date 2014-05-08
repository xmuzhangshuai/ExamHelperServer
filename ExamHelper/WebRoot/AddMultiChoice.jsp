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
<link type="text/css" rel="stylesheet" href="./css/plug.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/dialog.js" charset="utf-8"></script>
<link rel="stylesheet" rev="stylesheet" href="./css/style.css" type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">
	function check() {
		document.getElementById("aa").style.display = "";
	}

	
	function save() {

		if (document.getElementById("questionStem").value.trim().length != 0) {

			document.getElementById("fom").action = "${pageContext.request.contextPath}/multiChoice.do?flag=addMultiChoice"

			document.getElementById("fom").submit();
		} else
			scscms_alert("请先输入题干","warn");

	}
	function back() {
		var sectionName = document.getElementById("sectionName").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/multiChoice.do?flag=showMultiChoiceList&typeName=多项选择题&sectionName="
				+ sectionName+"&pageNow="+'${pageNow}';
		document.getElementById("fom").submit();
	}
</script>
</head>

<body class="ContentBody" >
	<form method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="CContent">
				<tr>
					<th class="tablestyle_title">多项选择题</th>
				</tr>
				<tr>
					<td><input type="button" value="返回多选题列表"onclick="back();"class="button" /></td>
				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>题干</legend>
							<table>

								<tr align="left">
									<td align="left" width="80px">题干内容:</td>
									<td><textarea rows="8" cols="80" id="questionStem" name="questionStem"></textarea><span
										class="red"> *</span></td>

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
													class="text" style="width:300px;height: 22px;" type="text" size="40" /></td>
											</tr>
											<tr>
												<td align="center" width="80px">选项B:</td>
												<td><input id="optionB" name="optionB"
													class="text" style="width:300px;height: 22px;" type="text" size="40" /></td>
											</tr>
											<tr>
												<td align="center" width="80px">选项C:</td>
												<td><input id="optionC" class="text"
													style="width:300px;height: 22px;" type="text" size="40" name="optionC" /></td>
											</tr>
											<tr>
												<td align="center" width="80px">选项D:</td>
												<td><input id="optionD" class="text"
													style="width:300px;height: 22px;" type="text" size="40" name="optionD" /></td>
											</tr>
											<tr>
												<td align="center" width="80px">选项E:</td>
												<td><input id="optionE" name="optionE"
													class="text" style="width:300px;height: 22px;" type="text" size="40"
													name="optionE" /></td>
											</tr>
											<tr>
												<td align="center" width="80px">选项F:</td>
												<td><input id="optionE" name="optionE"
													class="text" style="width:300px;height: 22px;" type="text" size="40"
													name="optionF" /></td>
											</tr>
										</table>
									</td>
									<td><table style="margin-left: 10px;">
											<tr>
												<td>答案:</td>
												<td><input type="checkbox" id="answerA" name="answerA" style="height: 20px;width: 20px;"
													value="${multiChoice.answerA}" />A</td>
												<td><input type="checkbox" id="answerB" name="answerB" style="height: 20px;width: 20px;"
													value="${multiChoice.answerB}" onselect="" />B</td>
												<td><input type="checkbox" id="answerC" name="answerC" style="height: 20px;width: 20px;"
													value="${multiChoice.answerC}" />C</td>
												<td><input type="checkbox" id="answerD" name="answerD" style="height: 20px;width: 20px;"
													value="${multiChoice.answerD}" />D</td>
												<td><input type="checkbox" id="answerE" name="answerE" style="height: 20px;width: 20px;"
													value="${multiChoice.answerE}" />E</td>
												<td><input type="checkbox" id="answerF" name="answerF" style="height: 20px;width: 20px;"
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
									<td><textarea id="analysis" cols="80" rows="8"name="analysis" ></textarea></td>
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
					<TD colspan="2" align="center" height="50px"> <input type="button" value="保存"
						type="submit" onclick="save();"
						class="button" /></TD>
				</TR>
			</TABLE>

		</div>
	</form>
</body>

</html>
