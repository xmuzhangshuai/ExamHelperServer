<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>添加试卷</title>

<link rel="stylesheet" type="text/css" href="./css/form.css" />
<link rel="stylesheet" href="./css/style.css" type="text/css" media="all" />
<script type="text/javascript">
	function back() {
		var subjectId = '${subjectId}';
		var noContent = "";
		if (subjectId == noContent)
			document.getElementById("contact_form").action = "${pageContext.request.contextPath}/examination.do?flag=showAllExamList";
		else
			document.getElementById("contact_form").action = "${pageContext.request.contextPath}/examination.do?flag=showExamListBySubject&subjectId="
					+ subjectId;

		document.getElementById("contact_form").submit();
	}
/*
	function saveExamInfor(examId) {
		var subjectName = document.getElementById("subjectName").value;
		if (subjectName == "null") {
			alert("请选择科目");
		} else {
			if (examId != null && examId != undefined)
				document.getElementById("contact_form").action = "${pageContext.request.contextPath}/examination.do?flag=addExamination&examinationId="
						+ examId;
			else
				document.getElementById("contact_form").action = "${pageContext.request.contextPath}/examination.do?flag=addExamination";
				document.getElementById("contact_form").submit();
		}
	}
	*/
</script>
</head>
  
<body style="margin: 0px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="62" background="./images/nav04.gif"></td>
		</tr>
		<tr>
			<td><input type="button" value="返回试卷列表" onclick="back();" class="button" /></td>
		</tr>
		
		<tr>
			<td style="border-style: none; border-width: medium;">
			<fieldset style="height:100%;">
				<legend>试卷信息</legend>
				<form class="contact_form" id="contact_form" target="mainFrame"
					action="${pageContext.request.contextPath}/examination.do?flag=addExamination" method="post" name="contact_form">
					<ul>
						<li>
             				<h2>添加试卷</h2>
        				</li>
        				<li>
             				<label for="examName">试卷名称:</label>
             				<input type="text" name="examName" id="examName" placeholder="试卷名称" required />
        				</li>
        				<li>
             				<label for="subjectName">科目名称:</label>
        					<select name="subjectName" id="subjectName" required>
        						<c:choose>
									<c:when test="${empty subjectId}">
										<option value="null" selected="selected">-请选择科目-</option>
										<c:forEach items="${subjects}" var="item">
											<option value="${item.subName}">${item.subName}</option>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach items="${subjects}" var="item">
											<c:choose>
												<c:when test="${item.id==subjectId}">
													<option value="${item.subName}" selected="selected">${item.subName}</option>
												</c:when>
												<c:otherwise>
													<option value="${item.subName}">${item.subName}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:otherwise>
								</c:choose>
        					</select>
        				</li>
        				<li>
             				<label for="examType">试卷类型:</label>
            				<input type="text" name="examType" id="examType" placeholder="试卷类型"  required />
        				</li>
        				
        				<li>
             				<label for="examTime">考试时间</label>
        					<input type="number" name="examTime" id="examTime" placeholder="考试时间(分钟)" required />
        				</li>
        				<li>
             				<label for="examRequest">考试要求</label>
        					<textarea rows="8" cols="40" id="examRequest" name="examRequest" placeholder="考试要求" required>${examination.examRequest}</textarea>
        				</li>
        				<li>
        					<button type="submit" class="submit">添     加</button>
        				</li>
					</ul>
				</form>
				</fieldset>
			</td>
		</tr>
	</table>
</body>
</html>
