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

<link href="./css/css.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">
	function sousuo() {
		window
				.open(
						"gaojisousuo.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}
	function chooseQuestionType() {

		
		var questionType = document.getElementById("chooseQT").value;
		var sectionName = document.getElementById("hiddenValue").value;
		var singleChoice = "单项选择题";
		var multiChoice = "多项选择题";
		var trueOrFalse = "判断题";
		var analysis = "简答题";

		if (questionType == singleChoice)
			document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoiceList&sectionName="
					+ sectionName;
		else if (questionType == multiChoice) {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/multiChoice.do?flag=showMultiChoiceList&sectionName="
					+ sectionName;
			alert(document.getElementById("fom").action);
		} else if (questionType == trueOrFalse)
			document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalseList&sectionName="
					+ sectionName;
		else if (questionType == analysis)
			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=showMaterialAnalysisList&sectionName="
					+ sectionName;

		document.getElementById("fom").submit();
	}
	function selectAll() {

		var obj = document.fom.elements;
		var name = /delid\d+/;
		for (var i = 0; i < obj.length; i++) {
			if (name.test(obj[i].name) == true) {
				obj[i].checked = true;
			}
			;
		}
		;
	}

	function unselectAll() {
		var obj = document.fom.elements;
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

	function link() {
		document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=addSingleChoiceUI";
		document.getElementById("fom").submit();
	}

	function delSelected() {
		var obj = document.fom.elements;
		var name = /delid\d+/;
		var list

		for (var i = 0; i < obj.length; i++) {
			if (name.test(obj[i].name) == true && obj[i].checked == true)
				list = list + obj[i].name;

		}
		document.getElementById("paramsHidden").value = list;

		document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=delSubjectByList&pageNow=${pageNow}";
		document.getElementById("fom").submit();
	}
	function keywordSearch() {

		document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=searchSubjectByKeyWord";
		document.getElementById("fom").submit();
	}
	function goByPage(){
		var sectionName=document.getElementById("hiddenValue").value;
		var page=document.getElementById("page").value;
		<%String keyword = (String) request.getAttribute("keyword");%>
	var keyword="<%=keyword%>"
		var nonContent = "null";

		if (keyword == nonContent)

		{
			document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoiceList&pageNow="
					+ page+"&sectionName="+sectionName;
					alert(document.getElementById("fom").action);
			document.getElementById("fom").submit();
		} else {

			document.getElementById("textfield").value = keyword;
			document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=searchSubjectByKeyWord&pageNow="
			+ page+"&sectionName="+sectionName;
			document.getElementById("fom").submit();

		}

	}
	function lastPage(pageNow){
	if(pageNow==1)
	alert("当前页为第一页")
	else{
	var sectionName=document.getElementById("hiddenValue").value;
		<%String keywordLP = (String) request.getAttribute("keyword");%>
	var keyword="<%=keywordLP%>"
			var nonContent = "null";
			if (keyword == nonContent)

			{
				document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoiceList&pageNow="
						+ (pageNow - 1) + "&sectionName=" + sectionName;
				alert(document.getElementById("fom").action);
				document.getElementById("fom").submit();
			} else {

				document.getElementById("textfield").value = keyword;
				document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=searchSubjectByKeyWord&pageNow="
			+ (pageNow - 1) + "&sectionName=" + sectionName;
				document.getElementById("fom").submit();

			}

		}

	}
	function nextPage(pageNow, pageCount) {
		if (pageNow + 1 > pageCount)
			alert(当前为最后一页)
		else {
		var sectionName=document.getElementById("hiddenValue").value;
		<%String keywordNP = (String) request.getAttribute("keyword");%>
		var keyword="<%=keywordNP%>"
			var nonContent = "null";
			if (keyword == nonContent)

			{
				document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoiceList&pageNow="
						+ (pageNow + 1) + "&sectionName=" + sectionName;
				alert(document.getElementById("fom").action);
				document.getElementById("fom").submit();
			} else {

				document.getElementById("textfield").value = keyword;
				document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=searchSubjectByKeyWord&pageNow="
				+ (pageNow + 1) + "&sectionName=" + sectionName;
				document.getElementById("fom").submit();
			}
		}
	}
	function firstPage() {
	var sectionName=document.getElementById("hiddenValue").value;
		<%String keywordFP = (String) request.getAttribute("keyword");%>
		var keyword="<%=keywordFP%>"
			var nonContent = "null";
			if (keyword == nonContent)

			{
				document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoiceList&pageNow=1"
						 + "&sectionName=" + sectionName;
				alert(document.getElementById("fom").action);
				document.getElementById("fom").submit();
			} else {

				document.getElementById("textfield").value = keyword;
				document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=searchSubjectByKeyWord&pageNow=1"
				+"&sectionName=" + sectionName;
				document.getElementById("fom").submit();
			}
	}
	function endPage(pageCount) {
	
		var sectionName=document.getElementById("hiddenValue").value;
		<%String keywordEP = (String) request.getAttribute("keyword");%>
		var keyword="<%=keywordEP%>"
		
		var nonContent = "null";
		if (keyword == nonContent)

		{
			document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoiceList&pageNow="
					+ pageCount + "&sectionName=" + sectionName;
			alert(document.getElementById("fom").action);
			document.getElementById("fom").submit();
		} else {

			document.getElementById("textfield").value = keyword;
			document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=searchSubjectByKeyWord&pageNow="
					+ pageCount + "&sectionName=" + sectionName;
			document.getElementById("fom").submit();
		}
	}
</script>

</head>

<body>
	<form name="fom" id="fom" method="post" action="" target="mainFrame">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" style="background-image:./images/nav04.gif">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td align="left">
											<table style="height: 126px; width: 439px; ">
												<tr>
													<td width="538" style="width: 154px; height: 48px">题型选择：
														<select id="chooseQT" onchange="chooseQuestionType();">
															<option selected="selected">${questionType.typeName}</option>
															<c:forEach items="${questionTypes}" var="type">
																<option>${type.typeName}</option>
															</c:forEach>
													</select>
													</td>
												</tr>
											</table>
										</td>
										<td align="left">
											<table>
												<tr>
													<td width="21" style="width: 13px;"><img
														src="./images/ico07.gif" width="20" height="18" /></td>
													<td style="width: 233px; ">按关键字： <input
														name="textfield" id="textfield" type="text" size="12" />
														<input name="Submit4" type="button" class="right-button02"
														value="查 询" onclick="keywordSearch();" /></td>
												</tr>
											</table>
										</td>
									</tr>

								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="20"><span class="newfont07">选择：<a
												href="#" class="right-font08" onclick="selectAll();">全选</a>-<a
												href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
											<input name="Submit" type="button" class="right-button08"
											value="删除所选题目" onclick="delSelected();" /> <input
											type="hidden" name="paramsHidden" id="paramsHidden" /> <input
											name="Submit2" type="button" class="right-button08"
											value="添加单项选择题" onclick="link();" /></td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px">单项选择题列表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="4%" align="center" height="30">选择</td>
													<td width="10%">题目名</td>
													<td width="12%">操作</td>
												</tr>
												<c:forEach items="${singleChoices}" var="singleChoice">
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox"
															name="delid${singleChoice.id}" /></td>
														<td><a
															href="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoice&singleChoiceId=${singleChoice.id}">
																<c:set var="testStr"
																	value="${singleChoice.questionStem}" /> <c:choose>
																	<c:when test="${fn:length(testStr) > 50}">
																		<c:out value="${fn:substring(testStr, 0, 50)}......"
																			escapeXml="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoice&singleChoiceId=${singleChoice.id}" />
																	</c:when>
																	<c:otherwise>
																		<c:out value="${testStr}" />
																	</c:otherwise>
																</c:choose>


														</a></td>
														<td><a
															href="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoice&singleChoiceId=${singleChoice.id}&edit=true">编辑|</a><a
															href="${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoice&singleChoiceId=${singleChoice.id}">查看|</a>
															<a
															href="${pageContext.request.contextPath}/singleChoice.do?flag=deleteSingleChoice&singleChoiceId=${singleChoice.id}">删除</a></td>

													</tr>
												</c:forEach>
											</table>
										</td>
										<td><input id="hiddenValue" type="hidden"
											value="${sectionName}" /></td>
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
														onclick="firstPage();">首页</a> | <a class="right-font08"
														onclick="lastPage('${pageNow}');">上一页</a> | <a
														class="right-font08"
														onclick="nextPage('${pageNow}','${pageCount}');">下一页</a> |
														<a class="right-font08" onclick="endPage('${pageCount}');">末页</a>]
														转至：
													</td>
													<td width="1%"><table width="20" border="0"
															cellspacing="0" cellpadding="0">
															<tr>
																<td width="1%"><input id="page" name="textfield3"
																	type="text" class="right-textfield03" size="1" /></td>
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

		</table>
	</form>

</body>
</html>
