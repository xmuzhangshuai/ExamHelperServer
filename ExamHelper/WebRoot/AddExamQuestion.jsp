<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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


<title>科目管理</title>
<link type="text/css" rel="stylesheet" href="./css/plug.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/dialog.js" charset="utf-8"></script>
<link href="./css/css.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">
	function search() {
		var sectionName = document.getElementById("sectionChoose").value;
		var questionTypeName = '${questionTypeName}';
		if (sectionName == "null")
			scscms_alert("请选择章节","warn");
		else {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamQuestionUI&sectionName="
					+ sectionName + "&questionTypeName=" + questionTypeName;
			document.getElementById("fom").submit();
		}
	}
	function selectAll() {

		var obj = document.fom.elements;
		var name = /delid\d+/;
		for (var i = 0; i < obj.length; i++)
			if (name.test(obj[i].name) == true)
				obj[i].checked = true;
	}
	function unselectAll() {
		var obj = document.fom.elements;
		var list
		for (var i = 0; i < obj.length; i++) {
			var name = /delid\d+/;
			if (name.test(obj[i].name) == true) {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}
	
	function selectOrUnSelect(){
	if(document.getElementById("selectOrNot").checked){
    	 selectAll();
    }else{
    	unselectAll();
    }
}
	function addExistQuestion() {
		var obj = document.fom.elements;
		var name = /delid\d+/;
		var flag = 'true';

		for (var i = 0; i < obj.length; i++) {
			if (name.test(obj[i].name) == true && obj[i].checked == true) {
				if (flag == 'true') {
					var list = obj[i].value + ",";
					flag = 'false';
				} else
					list = list + obj[i].value + ",";
					
			}
		}
		if(flag=='false'){
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamQuestion&questionId="
				+ list;
		document.getElementById("fom").submit();
		}
	}

	function goByPage() {
		var sectionName = document.getElementById("sectionChoose").value;
		var pageNow = document.getElementById("page").value;
		var questionTypeName = document.getElementById("questionTypeChoose").value;

		if (sectionName == "null")
			scscms_alert("请选择章节","warn");
		else {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamQuestionUI&sectionName="
					+ sectionName
					+ "&questionTypeName="
					+ questionTypeName
					+ "&pageNow=" + pageNow;
			document.getElementById("fom").submit();
		}
	}
	function lastPage(pageNow) {
		var sectionName = document.getElementById("sectionChoose").value;

		if (sectionName == "null")
			scscms_alert("请选择章节","warn");
		else {
			if (pageNow == 1)
				alert("当前页为第一页")
			else {

				var questionTypeName = document
						.getElementById("questionTypeChoose").value;
				document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamQuestionUI&sectionName="
						+ sectionName
						+ "&questionTypeName="
						+ questionTypeName
						+ "&pageNow=" + (pageNow - 1);
				document.getElementById("fom").submit();
			}
		}
	}
	function nextPage(pageNow, pageCount) {
		pageCount = parseInt(pageCount);
		pageNow = parseInt(pageNow) + 1;
		var sectionName = document.getElementById("sectionChoose").value;
		if (sectionName == "null")
			scscms_alert("请选择章节","warn");
		else {
			if (pageNow > pageCount)
				alert("当前为最后一页");
			else {

				var questionTypeName = document
						.getElementById("questionTypeChoose").value;
				document.getElementById("sectionChoose").value;
				document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamQuestionUI&sectionName="
						+ sectionName
						+ "&questionTypeName="
						+ questionTypeName
						+ "&pageNow=" + pageNow
				document.getElementById("fom").submit();
			}
		}
	}
	function firstPage() {
		var sectionName = document.getElementById("sectionChoose").value;
		if (sectionName == "null")
			scscms_alert("请选择章节","warn");
		else {
			var questionTypeName = document
					.getElementById("questionTypeChoose").value;
			document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamQuestionUI&sectionName="
					+ sectionName
					+ "&questionTypeName="
					+ questionTypeName
					+ "&pageNow=1"
			document.getElementById("fom").submit();
		}
	}
	function endPage(pageCount) {

		var sectionName = document.getElementById("sectionChoose").value;
		if (sectionName == "null")
			scscms_alert("请选择章节","warn");
		else {
			var questionTypeName = document
					.getElementById("questionTypeChoose").value;
			document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExamQuestionUI&sectionName="
					+ sectionName
					+ "&questionTypeName="
					+ questionTypeName
					+ "&pageNow=" + pageCount;
			document.getElementById("fom").submit();
		}

	}
</script>

</head>

<body style="line-height: 130%;">
	<form name="fom" id="fom" method="post" action="" target="mainFrame">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" style="background-image:url('./images/nav04.gif'); ">
								<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td><table><tr>
										<td width="38">科目：</td>
										<td><select name="subjectChoose"id="subjectChoose" onchange="loadSection();">
												<option selected="selected">${subject.subName}</option>
										</select></td>


										<td width="80px" align="right">章节：</td>
										<td><select id="sectionChoose" onchange="search();">
												<c:choose>
													<c:when test="${empty sectionName}">
														<option value="null" selected="selected">请选择章节</option>
														<c:forEach items="${sections}" var="section">
															<option value="${section.sectionName}">${section.sectionName}</option>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<c:forEach items="${sections}" var="section">
															<c:choose>
																<c:when test="${section.sectionName==sectionName}">
																	<option value="${section.sectionName}"
																		selected="selected">${section.sectionName}</option>
																</c:when>
																<c:otherwise>
																	<option value="${section.sectionName}">${section.sectionName}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</c:otherwise>
												</c:choose>
										</select></td>

										<td width="80px" align="right">题型：</td>
										<td><select id="questionTypeChoose">
												<option value="${questionTypeName}" selected="selected">${questionTypeName}</option>
										</select></td>

									</tr>
								</table>
							</td>
							</tr></table></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td height="20" style="padding-bottom: 5px;">
											<span class="newfont07">全选：
												<input type="checkbox" id="selectOrNot" onchange="selectOrUnSelect()"/>
											</span>
											<input name="Submit" type="button" class="right-button03"
											value="添加所选${questionTypeName}" onclick="addExistQuestion();" /></td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px">${questionTypeName}列表</td>
												</tr>
												<tr bgcolor="#EEEEEE" style="font-weight: bold;">
													<td width="15%" align="center" height="30">选择</td>
													<td width="65%" align="center">题目名</td>
													<td width="20%" align="center">操作</td>
												</tr>
												<c:forEach items="${questions}" var="question">
													<tr bgcolor="#FFFFFF">
														<td height="20" align="center"><input type="checkbox"
															name="delid${question.id}" value="${question.id}" /></td>

														<c:if test="${questionTypeName=='材料分析题'}">
															<td><a
																href="${pageContext.request.contextPath}/examination.do?flag=showExamQuestionDetail&questionId=${question.id}&questionTypeName=${questionTypeName}">
																	<c:set var="testStr" value="${question.material}" /> <c:choose>
																		<c:when test="${fn:length(testStr) > 80}">
																			<c:out value="${fn:substring(testStr, 0, 80)}......" />
																		</c:when>
																		<c:otherwise>
																			<c:out value="${testStr}" />
																		</c:otherwise>
																	</c:choose>


															</a></td>
														</c:if>
														<c:if test="${questionTypeName!='材料分析题'}">
															<td><a
																href="${pageContext.request.contextPath}/examination.do?flag=showExamQuestionDetail&questionId=${question.id}&questionTypeName=${questionTypeName}">
																	<c:set var="testStr" value="${question.questionStem}" />
																	<c:choose>
																		<c:when test="${fn:length(testStr) > 80}">
																			<c:out value="${fn:substring(testStr, 0, 80)}......" />
																		</c:when>
																		<c:otherwise>
																			<c:out value="${testStr}" />
																		</c:otherwise>
																	</c:choose>


															</a></td>
														</c:if>
														<td align="center">
															<a href="${pageContext.request.contextPath}/examination.do?flag=showExamQuestionDetail&questionId=${question.id}&questionTypeName=${questionTypeName}" style="margin-left: 10px;">
																<img alt="查看" class="delete_img" src="./images/more.png" style="height: 15px;" title="查看"/>查看</a>
															<a href="${pageContext.request.contextPath}/examination.do?flag=addExamQuestion&questionId=${question.id}" style="margin-left: 10px;">
																<img alt="添加" class="delete_img" src="./images/add.png" style="height: 15px;" title="添加"/>添加</a>
														</td>

													</tr>
												</c:forEach>
											</table>
										</td>
									</tr>
								</table>
								<table width="95%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="6"><img src="./images/spacer.gif" width="1"
											height="1" /></td>
									</tr>
									<tr>
										<td height="33"><table width="100%" border="0"
												align="center" cellpadding="0" cellspacing="0"
												class="right-font08">
												<tr>
													<td width="50%">共 <span class="right-text09">${pageCount}</span>
														页 | 第 <span class="right-text09">${pageNow}</span> 页
													</td>
													<td width="49%" align="right">[<a class="right-font08"
														onclick="firstPage();" href="#">首页</a> | <a
														class="right-font08" onclick="lastPage('${pageNow}');"
														href="#">上一页</a> | <a class="right-font08"
														onclick="nextPage('${pageNow}','${pageCount}');" href="#">下一页</a>
														| <a class="right-font08"
														onclick="endPage('${pageCount}');" href="#">末页</a>] 转至：
													</td>
													<td width="1%"><table width="20" border="0"
															cellspacing="0" cellpadding="0">
															<tr>
																<td width="1%"><input id="page" name="textfield3"
																	type="number" class="right-textfield03" size="1" /></td>
																<td width="87%"><input name="Submit23222"
																	type="button" class="right-button06"
																	onclick="goByPage();" /></td>
															</tr>
														</table></td>
												</tr>
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table></td>

			</tr>
			<tr>
				<td><input type="hidden" id="questionIds" name="questionIds" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
