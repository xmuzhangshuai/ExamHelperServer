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
<title>疑问详情</title>
<link href="./css/query_detail.css" rel="stylesheet" type="text/css" />
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

//点击列表进入疑问详情
function goQueryDetail(id){
	document.getElementById("fom").action = "${pageContext.request.contextPath}/query.do?flag=showQueryDetail&id="+id;
	document.getElementById("fom").submit();
}

</script>
</head>
<body>
<form name="fom" id="fom" method="post" action="">
	<div  style="width: 100%;  height:62px; background-image: url('./images/nav04.gif');">
		<button id="gobackButton" >返回</button>
	</div>
	<table id="gallery" border="0" width="100%" bgcolor="#F0F8FF" class="newfont03" cellpadding="4" cellspacing="1" style="padding: 5px;" >
		<tr>
			<td width="10%">
				<a href="${query.user.avatar}" title="${query.user.nickname}">
					<img id ="headImage" src="${query.user.avatar}" alt="${query.user.nickname}" /></a>
			</td>
			<td width="20%">
				<p class="userInfo">用户名： ${query.user.nickname}</p>
				<p class="userInfo2">提问时间：${query.queryTime}</p> 
				<p class="userInfo3">用户区域：${query.user.area}</p>
			</td>
			<td width="40%" class="queryInfo">
				<p >提问内容：</p>
				<p>${query.queryStem}</p>
			</td>
			<td width="30%" class="queryInfo">
				<p>疑问图片：</p>
				<a href="${query.queryImage}" title="${query.queryStem}">
					<img id ="headImage" height="100px" src="${query.queryImage}" alt="" /></a>
			</td>
		</tr>
	</table>
	
	<div style="height: 35px;margin-top: 10px;margin-left: 10px;">
		<span class="newfont07">全选：
			<input type="checkbox" id="selectOrNot" onchange="selectOrUnSelect()"/>
		</span>
		<input name="Submit" type="button" class="right-button08" value="删除所选疑问" onclick="delSelected();" /> 
		<input type="hidden" name="paramsHidden" id="paramsHidden" /> 
	</div>
	
	<table border="0" width="100%" bgcolor="#EDEDED" class="newfont03" cellpadding="4" cellspacing="1" >
		<caption class="answerTitle"><b>用户回答</b></caption>
		<thead>
			<tr>
				<th width="6%" align="center" height="30">选择</th>
				<th width="8%" align="center" height="30">唯一编号</th>
				<th width="10%" align="center" height="30">用户头像</th>
				<th width="10%" align="center" height="30">用户昵称</th>
				<th width="46%" align="center" height="30">回答内容</th>
				<th width="10%" align="center" height="30">回答时间</th>
				<th width="10%" align="center" height="30">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${answerqueryList}" var="answer">
				<tr id="listbg">
					<td height="20" align="center" ><input  type="checkbox" name="delid${answer.id}" /></td>
					<td height="20" align="center" ><label>${answer.id}</label></td>
					<td height="30" align="center" ><img id ="headImage" height="60px" src="${answer.user.avatar}" alt="${answer.user.nickname}" /></td>
					<td height="20" ><label>${answer.user.nickname}</label></td>
					<td height="20" ><label>${answer.answerContent}</label></td>
					<td height="20" align="center" ><label>${answer.answerTime}</label></td>
					<td height="20" >
							<a href="">编辑|</a>
							<a href="">查看|</a>
							<a href="#" onclick="" id="deleteSingleSubject${query.id}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="6"><img src="./images/spacer.gif" width="1" height="1" /></td>
		</tr>
		<tr>
			<td height="33">
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
					<tr>
						<td width="50%">共 <span class="right-text09" id="pageCount">${aPageCount}</span>
								页 | 第 <span class="right-text09" id="pageNowId">${aPageNow}</span> 页
						</td>
						<td width="49%" align="right">[<a href="${pageContext.request.contextPath}/query.do?flag=showQueryDetail&aPageNow=1&id=${id}" class="right-font08">首页</a> | 
							<a href="${pageContext.request.contextPath}/query.do?flag=showQueryDetail&aPageNow=${aPageNow-1}&id=${id}" 
									onclick="lastPage(${aPageNow-1});"  class="right-font08">上一页</a> |
							<a href="${pageContext.request.contextPath}/query.do?flag=showQueryDetail&aPageNow=${aPageNow+1}&id=${id}" 
									onclick="nextPage(${aPageNow+1},${aPageCount});" class="right-font08">下一页</a>| 
							<a href="${pageContext.request.contextPath}/query.do?flag=showQueryDetail&aPageNow=${aPageCount}&id=${id}" class="right-font08">末页</a>] 转至：
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
</form>
</body>
</html>
