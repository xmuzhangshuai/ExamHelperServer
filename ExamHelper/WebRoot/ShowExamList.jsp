<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>科目管理</title>
<link type="text/css" rel="stylesheet" href="./css/plug.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/dialog.js" charset="utf-8"></script>
<link href="./css/css.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">
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
	function changeSubject(){
 		var subjectId=document.getElementById("subjectChoose").value
 		if(subjectId!= undefined)
 		{
 		document.getElementById("fom").action ="${pageContext.request.contextPath}/examination.do?flag=showExamListBySubject&subjectId="+subjectId;
 		document.getElementById("fom").submit();
 		}
	}
	function addExamination() {
	var subjectId='${subjectId}';
	var noContent="";
	if(subjectId==noContent){
	document.getElementById("fom").action ="${pageContext.request.contextPath}/examination.do?flag=addExaminationUI";
	}
	else
	document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=addExaminationUI&subjectId="+subjectId;
	
	document.getElementById("fom").submit();
	
	}
	

//删除试卷
function deleteExam(examId,pageNow) {
	scscms_alert("确定要删除该试卷吗？","confirm",function(){
		document.getElementById("fom").action = "${pageContext.request.contextPath}/examination.do?flag=deleteExamination&examinationId="+examId+"&pageNow="+pageNow;
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

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td align="left">
											<table>
												<tr>
													<td width="538" style="width: 44px; ">科目：</td>
													<td style="width: 129px; "><select
														name="subjectChoose" id="subjectChoose"
														onchange="changeSubject();">
															<c:choose>
																<c:when test="${empty subjectId}">
																	<option selected="selected">请选择科目</option>
																	<c:forEach items="${subjects}" var="item">
																		<option value="${item.id}">${item.subName}</option>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${subjects}" var="item">
																		<c:choose>
																			<c:when test="${item.id==subjectId}">
																				<option value="${item.id}" selected="selected">${item.subName}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${item.id}">${item.subName}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																</c:otherwise>
															</c:choose>

													</select></td>
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
										<td height="20" style="padding-bottom: 5px;">
											<span class="newfont07">全选：
												<input type="checkbox" id="selectOrNot" onchange="selectOrUnSelect()"/>
											</span>
											<input name="Submit" type="button" class="right-button08" value="删除所选" onclick="delSelected();" /> 
											<input type="hidden" name="paramsHidden" id="paramsHidden" /> 
											<input name="Submit2" type="button" class="right-button08" value="添加试卷" onclick="addExamination();" />
										</td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px">试卷</td>
												</tr>
												<tr bgcolor="#EEEEEE" style="font-weight: bold;">
													<td width="10%" align="center" height="30">选择</td>
													<td width="70%" align="center">试卷名称</td>
													<td width="20%" align="center">操作</td>
												</tr>
												<c:forEach items="${examinations}" var="examination">
													<tr bgcolor="#FFFFFF">
														<td height="20" align="center"><input type="checkbox"
															name="delid${examination.id}" /></td>
														<td><a href="${pageContext.request.contextPath}/examination.do?flag=showExamination&examinationId=${examination.id}">${examination.examName}</a></td>
														<td align="center">
															<a href="${pageContext.request.contextPath}/examination.do?flag=showExamination&examinationId=${examination.id}&isEdit=true">
																<img alt="编辑" class="delete_img" src="./images/edit.png" style="height: 18px;" title="编辑"/>编辑</a>
															<a href="${pageContext.request.contextPath}/examination.do?flag=showExamination&examinationId=${examination.id}">
																<img alt="查看" class="delete_img" src="./images/more.png" style="height: 15px;" title="查看"/>查看</a>
															<a onclick="deleteExam(${examination.id},${pageNow});" id="" style="cursor: pointer;">
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
													<c:choose>
														<c:when test="${!empty subjectId}">
															<td width="49%" align="right">[<a
																class="right-font08"
																href="${pageContext.request.contextPath}/examination.do?flag=showExamListBySubject&subjectId=${subjectId}&pageNow=1">首页</a>
																| <a class="right-font08"
																href="${pageContext.request.contextPath}/examination.do?flag=showExamListBySubject&subjectId=${subjectId}&pageNow=${pageNow-1}">上一页</a>
																| <a class="right-font08"
																href="${pageContext.request.contextPath}/examination.do?flag=showExamListBySubject&subjectId=${subjectId}&pageNow=${pageNow+1}">下一页</a>
																| <a class="right-font08"
																href="${pageContext.request.contextPath}/examination.do?flag=showExamListBySubject&subjectId=${subjectId}&pageNow=${pageCount}">末页</a>]
																转至：
															</td>
														</c:when>
														<c:otherwise>
															<td width="49%" align="right">[<a
																class="right-font08"
																href="${pageContext.request.contextPath}/examination.do?flag=showAllExamList&pageNow=1">首页</a>
																| <a class="right-font08"
																href="${pageContext.request.contextPath}/examination.do?flag=showAllExamList&pageNow=${pageNow-1}">上一页</a>
																| <a class="right-font08"
																href="${pageContext.request.contextPath}/examination.do?flag=showAllExamList&pageNow=${pageNow+1}">下一页</a>
																| <a class="right-font08"
																href="${pageContext.request.contextPath}/examination.do?flag=showAllExamList&pageNow=${pageCount}">末页</a>]
																转至：
															</td>
														</c:otherwise>
													</c:choose>
													<td width="1%"><table width="20" border="0"
															cellspacing="0" cellpadding="0">
															<tr>
																<td width="1%"><input id="page" name="textfield3"
																	type="number" class="right-textfield03" size="1" /></td>
																<td width="87%"><input name="Submit23222"
																	type="submit" class="right-button06" value=" "
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
