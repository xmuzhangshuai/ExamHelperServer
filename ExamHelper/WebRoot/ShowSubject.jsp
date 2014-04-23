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
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 

</style>
<link href="./css/css.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">

	function deleteSubject(subjectId) {
   
   var id="deleteSingleSubject"+subjectId
   document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=deleteSubject&subjectId="+subjectId;
   document.getElementById("fom").submit();	
		alert("删除成功");
		window.parent.frames["leftFrame"].location.reload();
		//document.getElementById(id).href = "${pageContext.request.contextPath}/subject.do?flag=deleteSubject&subjectId="
				//+ subjectId
		
	//	var a = document.getElementById(id)
	//	a[0].click();
    //    alert("删除成功");
	//	window.parent.frames["leftFrame"].href="${pageContext.request.contextPath}/login.do?flag=loadLeft";
		
	}

	function sousuo() {
		window
				.open(
						"gaojisousuo.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
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

		document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=addSubjectUI";
		document.getElementById("fom").submit();
	}
	function goByPage() {
		int
		page = document.getElementById("page").value;
<%String keyword = (String) request.getAttribute("keyword");%>
	var keyword="<%=keyword%>"
	var nonContent="null";
	
	
		if (keyword==nonContent)

 {
			
			document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=listSubject&pageNow=${page}";
			document.getElementById("fom").submit();
		} else {
			
			document.getElementById("textfield").value=keyword;
			document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=searchSubjectByKeyWord&pageNow=${page}";
			document.getElementById("fom").submit();
			
			
		}
		
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

		document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=delSubjectByList&pageNow=${pageNow}";
		document.getElementById("fom").submit();	
		alert("删除成功");
		window.parent.frames["leftFrame"].location.reload();
		
	}
	function keywordSearch() {

		document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=searchSubjectByKeyWord";
		document.getElementById("fom").submit();
	}
	function firstPageClick() {
	

	}
	function lastPageClick(){
	<%String keyword2 = (String) request.getAttribute("keyword");%>
	var keyword="<%=keyword2%>"
	var nonContent="null";
	
	
		if (keyword==nonContent)

 {
			
			document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=listSubject&pageNow=${pageNow-1}";
			document.getElementById("fom").submit();
		} else {
			
			document.getElementById("textfield").value=keyword;
			document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=searchSubjectByKeyWord&pageNow=${pageNow-1}";
			document.getElementById("fom").submit();
			
			
		}
	
	}
	function nextPageClick(){
	<%String keyword3 = (String) request.getAttribute("keyword");%>
	var keyword="<%=keyword3%>"
	var nonContent="null";
	
	
		if (keyword==nonContent)

 {
			
			document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=listSubject&pageNow=${pageNow+1}";
			document.getElementById("fom").submit();
		} else {
			
			document.getElementById("textfield").value=keyword;
			document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=searchSubjectByKeyWord&pageNow=${pageNow+1}";
			document.getElementById("fom").submit();
			
			
		}
	
	}
	function endPageClick(){
	<%String keyword4 = (String) request.getAttribute("keyword");%>
	
	var keyword="<%=keyword4%>"
		var nonContent = "null";
		if (keyword == nonContent)

		{
			document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=listSubject&pageNow=${pageCount}";
			document.getElementById("fom").submit();
		} else {

			document.getElementById("textfield").value = keyword;
			document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=searchSubjectByKeyWord&pageNow=${pageCount}";
			document.getElementById("fom").submit();

		}

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
							<td height="62" style="background-image:url('./images/nav04.gif'); ">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="21"><img src="./images/ico07.gif" width="20"
											height="18" /></td>
										<td width="538">查看内容：按关键字： <input name="textfield"
											id="textfield" type="text" size="12" /> <input
											name="Submit4" type="button" class="right-button02"
											value="查 询" onclick="keywordSearch();" /></td>
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
											value="删除所选科目" onclick="delSelected();" /> <input
											type="hidden" name="paramsHidden" id="paramsHidden" /> <input
											name="Submit2" type="button" class="right-button08"
											value="添加科目" onclick="link();" /></td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px">科目列表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="4%" align="center" height="30">选择</td>
													<td width="10%">科目名称</td>
													<td width="12%">操作</td>
												</tr>
												<c:forEach items="${subjects}" var="subject">
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox"
															name="delid${subject.id}" /></td>
														<td><a
															href="${pageContext.request.contextPath}/section.do?flag=chooseType&subjectId=${subject.id}"
															onclick="" target="mainFrame">${subject.subName}</a></td>
														<td><a
															href="${pageContext.request.contextPath}/subject.do?flag=updateSubjectUI&subjectId=${subject.id}">编辑|</a><a
															href="${pageContext.request.contextPath}/section.do?flag=chooseType&subjectId=${subject.id}">查看|</a>
															<a onclick="deleteSubject('${subject.id}');"
															id="deleteSingleSubject${subject.id}">删除</a></td>
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
														onclick="firstPageClick();">首页</a> | <a
														class="right-font08" onclick="lastPageClick();">上一页</a> |
														<a class="right-font08" onclick="nextPageClick();">下一页</a>
														| <a class="right-font08" onclick="endPageClick();">末页</a>]
														转至：
													</td>
													<td width="1%"><table width="20" border="0"
															cellspacing="0" cellpadding="0">
															<tr>
																<td width="1%"><input id="page" name="textfield3"
																	type="text" class="right-textfield03" size="1" /></td>
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
