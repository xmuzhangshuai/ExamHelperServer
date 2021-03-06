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
		var singleChoice = "单项选择题"
		var multiChoice = "多项选择题"
		var trueOrFalse = "判断题"
		var analysis = "材料分析题"

		var subjectId = document.getElementById("subjectChoose").value;
		var sectionName = document.getElementById("sectionChoose").value;
		var questionType = document.getElementById("questionTypeChoose").value;
		if (subjectId == "null" || sectionName == "null"
				|| questionType == "null")
			alert("请完整选择科目、章节、题型");
		else {
			if (questionType == singleChoice)
				document.getElementById("fom").action = "${pageContext.request.contextPath}/singleChoice.do?flag=showSingleChoiceList&sectionName="
						+ sectionName;
			else if (questionType == multiChoice)
				document.getElementById("fom").action = "${pageContext.request.contextPath}/multiChoice.do?flag=showMultiChoiceList&sectionName="
						+ sectionName;
			else if (questionType == trueOrFalse)
				document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalseList&sectionName="
						+ sectionName;
			else if (questionType == analysis)
				document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=showMaterialAnalysisList&sectionName="
						+ sectionName;

			document.getElementById("fom").submit();
		}
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
	
function selectOrUnSelect(){
	if(document.getElementById("selectOrNot").checked){
    	 selectAll();
    }else{
    	unselectAll();
    }
}
function loadSection() {
	  var subjectId=document.getElementById("subjectChoose").value;
	  var questionType=document.getElementById("questionTypeChoose").value
	   if(subjectId!="null" ){
	   document.getElementById("fom").action="${pageContext.request.contextPath}/trueOrFalse.do?flag=loadSectionList&subjectId="+subjectId+"&questionTypeName="+questionType;
	  document.getElementById("fom").submit();
	   }
	}
	function addTrueOrFalse() {
	var sectionName = document.getElementById("sectionChoose").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=addTrueOrFalseUI&pageNow="+'${pageNow}'+"&sectionName="+sectionName;
		document.getElementById("fom").submit();
	}

	function delSelected() {
		var obj = document.fom.elements;
		var name = /delid\d+/;
		var list="delid0";

		for (var i = 0; i < obj.length; i++) {
			if (name.test(obj[i].name) == true && obj[i].checked == true)
				list = list + obj[i].name;

		}
		document.getElementById("trueOrFalseList").value = list;
		var sectionName=document.getElementById("sectionChoose").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=delSubjectByList&pageNow="+'${pageNow}'+"&sectionName="+sectionName;
		document.getElementById("fom").submit();
	}
	
	function goByPage(){
		var sectionName=document.getElementById("sectionChoose").value;
		var page=document.getElementById("page").value;
		
			document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalseList&pageNow="
					+ page+"&sectionName="+sectionName;
			document.getElementById("fom").submit();
	}
	function lastPage(pageNow){
		if(pageNow==1)
			alert("当前页为第一页")
		else{
				var sectionName=document.getElementById("sectionChoose").value;
		
				document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalseList&pageNow="
						+ (pageNow - 1) + "&sectionName=" + sectionName;
				document.getElementById("fom").submit();
		}

	}
	function nextPage(pageNow, pageCount) {
		pageCount=parseInt(pageCount);
		pageNow=parseInt(pageNow)+1;
		
		if (pageNow> pageCount)
			alert(当前为最后一页);
		else {
		var sectionName=document.getElementById("sectionChoose").value;
		
				document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalseList&pageNow="
						+ pageNow + "&sectionName=" + sectionName;
				document.getElementById("fom").submit();
		}
	}
	function firstPage() {
	var sectionName=document.getElementById("sectionChoose").value;
	
				document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalseList&pageNow=1"
						 + "&sectionName=" + sectionName;
				document.getElementById("fom").submit();
	}
	function endPage(pageCount) {
	
		var sectionName=document.getElementById("sectionChoose").value;
	
			document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalseList&pageNow="
					+ pageCount + "&sectionName=" + sectionName;
			document.getElementById("fom").submit();
		
	}
function deleteTureOrFalse(tureOrFalseId,pageNow) {
	scscms_alert("确定要删除该判断题吗？","confirm",function(){
		document.getElementById("fom").action = "${pageContext.request.contextPath}/trueOrFalse.do?flag=deleteTrueOrFalse&trueOrFalseId="+tureOrFalseId+"&pageNow="+pageNow;
		document.getElementById("fom").submit();
		scscms_alert("删除成功！","ok");
	},function(){});
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
							<td height="62"
								style="background-image:url('./images/nav04.gif'); ">

								<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
												<tr>
												<td><table><tr>
													<td width="38">科目：</td>
													<td><select name="subjectChoose" id="subjectChoose"
														onchange="loadSection();">
															<c:choose>
																<c:when test="${empty subjectId}">
																	<option value="null" selected="selected">请选择科目</option>
																	<c:forEach items="${subjects}" var="subject">
																		<option value="${subject.id}">${subject.subName}</option>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${subjects}" var="subject">
																		<c:choose>
																			<c:when test="${subject.id==subjectId}">
																				<option value="${subject.id}"
																					selected="selected">${subject.subName}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${subject.id}">${subject.subName}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
													</select></td>


														<td style="width: 80px;text-align: right;">章节：</td>
										<td><select id="sectionChoose">
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
																	<option value="${section.sectionName}" selected="selected">${section.sectionName}</option>
																</c:when>
																<c:otherwise>
																	<option value="${section.sectionName}">${section.sectionName}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</c:otherwise>
												</c:choose>
										</select></td>

													<td style="width: 80px;text-align: right;">题型：</td>
													<td><select id="questionTypeChoose">
															<c:choose>
																<c:when test="${empty questionTypeName}">
																	<option value="null" selected="selected">请选择题型</option>
																	<c:forEach items="${questionTypes}" var="type">
																		<option value="${type.typeName}">${type.typeName}</option>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${questionTypes}" var="type">
																		<c:choose>
																			<c:when test="${type.typeName==questionTypeName}">
																				<option value="${type.typeName}" selected="selected">${type.typeName}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${type.typeName}">${type.typeName}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
													</select></td>
													<td style="width: 80px;text-align: right;">
													<input type="button" value="查询"
											class="right-button02" onclick="search();" /></td>
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
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="20" style="padding-bottom: 5px;">
											<span class="newfont07">全选：
												<input type="checkbox" id="selectOrNot" onchange="selectOrUnSelect()"/>
											</span>
											<input name="Submit" type="button" class="right-button08"
											value="删除所选" onclick="delSelected();" /> <input
											type="hidden" name="trueOrFalseList" id="trueOrFalseList" /> <input
											name="Submit2" type="button" class="right-button08"
											value="添加判断题" onclick="addTrueOrFalse();" /></td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px">判断题</td>
												</tr>
												<tr bgcolor="#EEEEEE" style="font-weight: bold;">
													<td width="15%" align="center" height="30">选择</td>
													<td width="60%"  align="center">题目名</td>
													<td width="25%"  align="center">操作</td>
												</tr>
												<c:forEach items="${trueOrFalses}" var="trueOrFalse">
													<tr bgcolor="#FFFFFF">
														<td height="20"  align="center"><input type="checkbox"
															name="delid${trueOrFalse.id}" /></td>
														<td><a
															href="${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalse&trueOrFalseId=${trueOrFalse.id}">
																<c:set var="testStr" value="${trueOrFalse.questionStem}" />
																<c:choose>
																	<c:when test="${fn:length(testStr) > 50}">
																		<c:out value="${fn:substring(testStr, 0, 50)}......" />
																	</c:when>
																	<c:otherwise>
																		<c:out value="${testStr}" />
																	</c:otherwise>
																</c:choose>


														</a></td>
														<td align="center">
															<a href="${pageContext.request.contextPath}/trueOrFalse.do?flag=showTrueOrFalse&trueOrFalseId=${trueOrFalse.id}">
																<img alt="查看" class="delete_img" src="./images/more.png" style="height: 18px;" title="查看"/>查看</a>
															<a onclick="deleteTureOrFalse(${trueOrFalse.id},${pageNow});" style="cursor: pointer;margin-left: 10px;">
																<img alt="删除" class="delete_img" src="./images/delete.png" style="height: 15px;" title="删除"/>删除</a>
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
														onclick="firstPage();" href="#">首页</a> | <a class="right-font08"
														onclick="lastPage('${pageNow}');" href="#">上一页</a> | <a
														class="right-font08"
														onclick="nextPage('${pageNow}','${pageCount}');" href="#">下一页</a> |
														<a class="right-font08" onclick="endPage('${pageCount}');" href="#">末页</a>]
														转至：
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

		</table>
	</form>

</body>
</html>
