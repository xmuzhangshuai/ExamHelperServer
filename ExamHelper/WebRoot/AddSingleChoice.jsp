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
	
	function save() {

		if (document.getElementById("questionStem").value.trim().length != 0) {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=addSingleChoice"

			document.getElementById("fom").submit();
		} else
			alert("请输入题干");

	}
	function back() {
		var sectionName = document.getElementById("sectionName").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoiceList&typeName=单项选择题&sectionName="
				+ sectionName+"&pageNow="+'${pageNow}';
		document.getElementById("fom").submit();
	}
</script>
</head>

<body class="ContentBody">
	<form method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<td height="62" background="./images/nav04.gif"></td>
				</tr>
				<tr>
					<th class="tablestyle_title">单选题</th>
				</tr>
				<tr>
					<td><input type="button" value="返回单选题列表" onclick="back();"
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
							<legend>选项</legend>

							<table>
								<tr>
									<td>
										<table>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项A:</td>
												<td width="43%"><input id="optionA" name="optionA"
													class="text" style="width:250px" type="text" size="40" /></td>
											</tr>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项B:</td>
												<td width="43%"><input id="optionB" name="optionB"
													class="text" style="width:250px" type="text" size="40" /></td>
											</tr>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项C:</td>
												<td width="43%"><input id="optionC" class="text"
													style="width:250px" type="text" size="40" name="optionC" /></td>
											</tr>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项D:</td>
												<td width="43%"><input id="optionD" class="text"
													style="width:250px" type="text" size="40" name="optionD" /></td>
											</tr>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项E:</td>
												<td width="43%"><input id="optionE" name="optionE"
													class="text" style="width:250px" type="text" size="40"
													name="optionE" /></td>
											</tr>
										</table>
									</td>
									<td><table>
											<tr>
												<td>答案</td>
												<td><input type="text" id="answer" name="answer" /></td>
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
									<td><select name="subjectName" id="subjectName"
										style="width: 243px; " >
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
									<td>章节名称:</td>
									<td><select id="sectionName" name="sectionName">
											
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
						type="button" value="保存" type="submit" onclick="save();"
						class="button" /></TD>
				</TR>
			</TABLE>

		</div>
	</form>
</body>

</html>
