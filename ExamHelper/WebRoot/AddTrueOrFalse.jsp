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


<title>添加判断题</title>


<link rel="stylesheet" rev="stylesheet" href="./css/style.css"
	type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">
	function save() {

		if (document.getElementById("questionStem").value.trim().length != 0) {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=addTrueOrFalse"

			document.getElementById("fom").submit();
		} else
			alert("请输入题干");

	}
	function back() {
		var sectionName = document.getElementById("sectionName").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalseList&typeName=判断题&sectionName="
				+ sectionName+"&pageNow="+'${pageNow}';
		document.getElementById("fom").submit();
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
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="CContent">
				<tr>
					<th class="tablestyle_title">判断题</th>
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
											id="questionStem" name="questionStem"></textarea><span
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
												<td align="left"  width="80px">答案：</td>
												<td><input id="answerR" name="answer" value="true"
													onclick="right();" class="text" style="width: 24px"
													type="radio" size="40" /></td>
												<td><img src="./images/image_right.png"
													style="width: 43px; " /></td>
												<td><input id="answerW" name="answer"
													class="text" style="width: 24px;margin-left: 20px;" type="radio" size="40"
													onclick="wrong();" value="false"/></td>
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
									<td align="left" width="80px">题目分析:</td>
									<td><textarea id="analysis" cols="80" rows="8" name="analysis" ></textarea></td>
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
										style="width: 250px;height: 23px; " >
											<c:forEach items="${subjects}" var="subject">
												<c:choose>
													<c:when test="${subject.id==subjectId}">
														<option value="${subject.id}" selected="selected">${subject.subName}</option>
													</c:when>
													<c:otherwise>
														<option value="${subject.id}">${subject.subName}</option>
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
									<td></td>
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
