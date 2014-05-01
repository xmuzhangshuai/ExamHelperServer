<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>收藏统计</title>
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

//点击列表进入疑问详情
function goCollectionDetail(id){
	//document.getElementById("fom").action = "${pageContext.request.contextPath}/query.do?flag=showQueryDetail&id="+id;
	//document.getElementById("fom").submit();
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
										<option>按章节</option>
										<option>按科目</option>
										<option>按题型</option>
									</select>
								</td>
								<td width="300" align="left">
									<select>
									<c:forEach items="${subjectList}" var="subject">
										<option>${subject.subName}</option>
									</c:forEach>
									</select>
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
		<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0" >
			<tr>
			<td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td height="35">
						<span class="newfont07">全选：
							<input type="checkbox" id="selectOrNot" onchange="selectOrUnSelect()"/>
						</span>
						<input name="Submit" type="button" class="right-button08" value="删除所选笔记" onclick="delSelected();" /> 
						<input type="hidden" name="paramsHidden" id="paramsHidden" /> 
					</td>
				</tr>
				
				<tr>
				<td height="40" class="font42">
					<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
						<tr class="CTitle">
							<td height="22" colspan="13" align="center" style="font-size:18px">收藏列表</td>
						</tr>
						<tr bgcolor="#EEEEEE">
							<td width="6%" align="center" height="30">选择</td>
							<td width="8%" align="center" height="30">唯一编号</td>
							<td width="10%" align="center" height="30">题型</td>
							<td width="34%" align="center" height="30">题目内容</td>
							<td width="8%" align="center" height="30">添加笔记条数</td>
							<td width="10%" align="center" height="30">操作</td>
						</tr>
						<c:forEach items="${snoteList}" var="snote" varStatus="loop">
							<tr id="listbg" onclick="goNoteDetail(${snote.id});" >
								<td height="20" align="center" ><input  type="checkbox" name="delid${snote.id}" /></td>
								<td height="20" align="center" ><label>${snote.id}</label></td>
								<td height="20" ><a>${snote.questiontype.typeName}</a></td>
								<td style="padding: 5px;"><a>${questionStemList[loop.count-1]}</a></td>
								<td height="20" align="center" ><label>${snote.noteNum}</label></td>
								<td height="20" align="center">
									<a  onclick="alert('删除');" id="">
									<img alt="删除" class="delete_img" src="./images/delete.png" style="height: 15px;" title="删除">删除</a>
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
								<td width="49%" align="right">[<a href="${pageContext.request.contextPath}/note.do?flag=showNoteList&pageNow=1" class="right-font08">首页</a> | 
															   <a href="${pageContext.request.contextPath}/note.do?flag=showNoteList&pageNow=${pageNow-1}" 
															      onclick="lastPage(${pageNow-1});"  class="right-font08">上一页</a> |
														       <a href="${pageContext.request.contextPath}/note.do?flag=showNoteList&pageNow=${pageNow+1}" 
														          onclick="nextPage(${pageNow+1},${pageCount});" class="right-font08">下一页</a>| 
														       <a href="${pageContext.request.contextPath}/note.do?flag=showNoteList&pageNow=${pageCount}" class="right-font08">末页</a>] 转至：
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
