<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>考试指南信息查看</title>
<link href="./css/css.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.lightbox-0.5.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.lightbox-0.5.css" media="screen" />
<script type="text/javascript" language="javascript">
function selectAll() {
	var obj = document.fom.elements;
	var name = /delid\d+/;
	for (var i = 0; i < obj.length; i++) {
		if (name.test(obj[i].name) == true) {
			obj[i].checked = true;
		}
	}
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

function firstPage(){
	alert("首页");
}

function lastPage(pageNow){
	arg = pageNow;
	if(arg == 0)
		alert("已经是首页！");
}

function nextPage(pageNow,pageCount){
	if(pageNow>pageCount)
		alert("已经是最后一页！");
}

function endPage(){
	alert("末页");
}

$(function() {
	$('#gallery a').lightBox();
});

function link() {
	document.getElementById("fom").action = "${pageContext.request.contextPath}/user.do?flag=addSubjectUI";
	document.getElementById("fom").submit();
}
</script>
</head>
  
<body>
<form name="fom" id="fom" method="post" action="">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="62" background="./images/nav04.gif">
						<table width="30%" border="0" align="left" cellpadding="0" cellspacing="0">
							<tr>
								<td width="21"><img src="./images/ico07.gif" width="20" height="18" /></td>
								<td width="80">
									<select>
										<option>按科目</option>
										<option>按类型</option>
										<option>按题目</option>
									</select>
								</td>
								<td width="300" align="left">
									<input name="textfield" id="textfield" type="text" size="20" /> 
									<input name="Submit4" type="button" class="right-button02"
									       value="查 询" onclick="keywordSearch();" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		
		
		<tr>
		<td>
		<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
			<td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td height="35">
						<span class="newfont07">全选：
							<input type="checkbox" id="selectOrNot" onchange="selectOrUnSelect()"/>
						</span>
						<input name="Submit" type="button" class="right-button08" value="删除所选文章" onclick="delSelected();" /> 
						<input type="hidden" name="paramsHidden" id="paramsHidden" /> 
					</td>
				</tr>
				
				<tr>
				<td height="40" class="font42">
					<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
						<tr class="CTitle">
							<td height="22" colspan="13" align="center" style="font-size:16px">考试指南列表</td>
						</tr>
						<tr bgcolor="#EEEEEE">
							<td width="6%" align="center" height="30">选择</td>
							<td width="8%" align="center" height="30">唯一编号</td>
							<td width="10%" align="center" height="30">科目</td>
							<td width="10%" align="center" height="30">类型</td>
							<td width="24%" align="center" height="30">题目</td>
							<td width="24%" align="center" height="30">链接</td>
							<td width="10%" align="center" height="30">时间</td>
							<td width="10%" align="center" height="30">操作</td>
						</tr>
						<c:forEach items="${examGuideList}" var="examGuide">
							<tr id="listbg">
								<td height="20" align="center" ><input  type="checkbox" name="delid${examGuide.id}" /></td>
								<td height="20" align="center" ><label>${examGuide.id}</label></td>
								<td height="30" ><label>${examGuide.examguidetype.subject.subName}</label></td>
								<td height="20" ><label>${examGuide.examguidetype.typeName}</label></td>
								<td height="20" ><label>${examGuide.title}</label></td>
								<td height="20" ><a href="${examGuide.url}" target="mainFrame">${examGuide.url}</a></td>
								<td height="20" ><label>${examGuide.time}</label></td>
								<td height="20" ><a href="">编辑|</a>
								    <a href="">查看|</a>
									<a href="#" onclick="" id="deleteSingleSubject${subject.id}">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
				</tr>
			</table>
			
			
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td height="6"><img src="./images/spacer.gif" width="1" height="1" /></td>
				</tr>
				<tr>
					<td height="33">
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
							<tr>
								<td width="50%">共 <span class="right-text09" id="pageCount">${pageCount}</span>
									页 | 第 <span class="right-text09" id="pageNowId">${pageNow}</span> 页
								</td>
								<td width="49%" align="right">[<a href="${pageContext.request.contextPath}/examGuide.do?flag=showExamGuideList&pageNow=1&id=${id}" class="right-font08">首页</a> | 
															   <a href="${pageContext.request.contextPath}/examGuide.do?flag=showExamGuideList&pageNow=${pageNow-1}&id=${id}" 
															      onclick="lastPage(${pageNow-1});"  class="right-font08">上一页</a> |
														       <a href="${pageContext.request.contextPath}/examGuide.do?flag=showExamGuideList&pageNow=${pageNow+1}&id=${id}" 
														          onclick="nextPage(${pageNow+1},${pageCount});" class="right-font08">下一页</a>| 
														       <a href="${pageContext.request.contextPath}/examGuide.do?flag=showExamGuideList&pageNow=${pageCount}&id=${id}" class="right-font08">末页</a>] 转至：
								</td>
								<td width="1%">
									<table width="20" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="1%"><input id="page" name="textfield3" type="text" class="right-textfield03" size="1" /></td>
											<td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " onclick="goByPage();" /></td>
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
		</table>
		</td>
		</tr>
	</table>
</form>
</body>
</html>