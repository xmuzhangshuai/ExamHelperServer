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


<title>科目管理</title>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.tabfont01 {
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
</style>
<link href="./css/css.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="./css/plug.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/dialog.js" charset="utf-8"></script>
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
	function addSubject() {

		document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=addSubjectUI&pageNow="+'${pageNow}';
		document.getElementById("fom").submit();
	}

	function delSelected() {
		var obj = document.fom.elements;
		var name = /delid\d+/;
		var list="delid0"

		for (var i = 0; i < obj.length; i++) {
			if (name.test(obj[i].name) == true && obj[i].checked == true)
				list = list + obj[i].name;

		}
		document.getElementById("subjectList").value = list;

		document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=delSubjectByList&pageNow="+'${pageNow}';
		document.getElementById("fom").submit();
	}
	function goByPage() {
		var page = document.getElementById("page").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=listSubject&pageNow="
				+ page;
		document.getElementById("fom").submit();
	}

	function firstPageClick() {
		document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=listSubject&pageNow=" + 1;
		document.getElementById("fom").submit();
	}
	function lastPageClick(pageNow) {
		if (pageNow != 1) {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=listSubject&pageNow="
					+ (pageNow - 1);
			document.getElementById("fom").submit();
		}
	}
	function nextPageClick(pageNow, pageCount) {
		pageNow = parseInt(pageNow) + 1;
		pageCount = parseInt(pageCount);
		if (pageNow <= pageCount) {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=listSubject&pageNow="
					+ pageNow;
				
			document.getElementById("fom").submit();
		}
	}
	function endPageClick(pageCount) {
		document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=listSubject&pageNow="
				+ pageCount;
		document.getElementById("fom").submit();
	}

function deleteSubject(subjectId) {
	scscms_alert("确定要删除该科目吗？","confirm",function(){
		document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=deleteSubject&subjectId="+subjectId+"&pageNow="+'${pageNow}';
		document.getElementById("fom").submit();
		scscms_alert("删除成功！","ok");
	},function(){});
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
							<td height="62"
								style="background-image:url('./images/nav04.gif'); ">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td></td>
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
											<input name="Submit" type="button" class="right-button08"
											value="删除所选科目" onclick="delSelected();" /> <input
											type="hidden" name="subjectList" id="subjectList" /> <input
											name="Submit2" type="button" class="right-button08"
											value="添加科目" onclick="addSubject();" /></td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px">科目列表</td>
												</tr>
												<tr bgcolor="#EEEEEE" style="font-weight: bold;">
													<td width="15%" align="center" height="30">选择</td>
													<td width="60%" align="center">科目名称</td>
													<td width="25%" align="center">操作</td>
												</tr>
												<c:forEach items="${subjects}" var="subject">
													<tr bgcolor="#FFFFFF">
														<td height="20" align="center"><input type="checkbox"
															name="delid${subject.id}" /></td>
														<td><a
															href="${pageContext.request.contextPath}/section.do?flag=showSectionListBySubject&subjectId=${subject.id}"
															onclick="" target="mainFrame">${subject.subName}</a></td>
														<td align="center">
															<a href="${pageContext.request.contextPath}/subject.do?flag=updateSubjectUI&subjectId=${subject.id}&pageNow=${pageNow}">
																<img alt="编辑" class="delete_img" src="./images/edit.png" style="height: 18px;" title="编辑"/>编辑</a>
															<a href="${pageContext.request.contextPath}/section.do?flag=showSectionListBySubject&subjectId=${subject.id}" style="margin-left: 10px;">
																<img alt="查看" class="delete_img" src="./images/more.png" style="height: 15px;" title="查看"/>查看</a>
															<a id="deleteSingleSubject${subject.id}" onclick="deleteSubject(${subject.id});" style="cursor: pointer;margin-left: 10px;">
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
														onclick="firstPageClick();" href="#">首页</a> | <a
														class="right-font08" href="#"
														onclick="lastPageClick('${pageNow}');">上一页</a> | <a
														class="right-font08" href="#"
														onclick="nextPageClick('${pageNow}','${pageCount}');">下一页</a>
														| <a class="right-font08" href="#"
														onclick="endPageClick('${pageCount}');">末页</a>] 转至：
													</td>
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
