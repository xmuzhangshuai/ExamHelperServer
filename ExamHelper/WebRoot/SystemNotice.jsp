<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<title>发布系统通知</title>
<link rel="stylesheet" type="text/css" href="./css/examguide.css"/>
<link rel="stylesheet" type="text/css" href="./css/jquery-ui.css" />
<link href="./css/css.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-datepicker.js"></script>
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
</script>
</head>
  
<body style="margin: 0px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="62" background="./images/nav04.gif">
						<table width="30%" border="0" align="left" cellpadding="0" cellspacing="0">
							<tr>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		
		
		<tr>
			<td style="border-style: none; border-width: medium;">
				<form class="contact_form" action="${pageContext.request.contextPath}/systemNotice.do?flag=addSystemNotice" method="post" name="contact_form">
					<ul>
						<li>
             				<h2>发布系统通知</h2>
        				</li>
        				<li>
             				<label for="">公告内容</label>
        					<textarea rows="8" cols="40" name="content" placeholder="系统公告内容" required></textarea>
        				</li>
        				<li>
             				<label for="website">跳转URL:</label>
            				<input type="text" name="url" placeholder="url" />
        				</li>
        				<li>
             				<label for="website">是否立即发布：</label>
            				<input type="checkbox" name="valided" title="用户点击是否跳转"/>
        				</li>
        				<li>
             				<label for="website">点击跳转：</label>
            				<input type="checkbox" name="haveDetail" title="用户点击是否跳转"/>
        				</li>
        				
        				<li>
        					<!--  <button type="submit" class="submit">发         布</button>-->
        				</li>
					</ul>
				</form>
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
						<input name="Submit" type="button" class="right-button08" value="删除所选错题记录" onclick="delSelected();" /> 
						<input type="hidden" name="paramsHidden" id="paramsHidden" /> 
					</td>
				</tr>
				
				<tr>
				<td height="40" class="font42">
					<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
						<tr class="CTitle">
							<td height="22" colspan="13" align="center" style="font-size:18px">历史公告</td>
						</tr>
						<tr bgcolor="#EEEEEE">
							<td width="6%" align="center" height="30">选择</td>
							<td width="8%" align="center" height="30">唯一编号</td>
							<td width="32%" align="center" height="30">公告内容</td>
							<td width="10%" align="center" height="30">添加时间</td>
							<td width="6%" align="center" height="30">是否跳转</td>
							<td width="20%" align="center" height="30">跳转路径</td>
							<td width="8%" align="center" height="30">是否过时</td>
							<td width="10%" align="center" height="30">操作</td>
						</tr>
						<c:forEach items="${systemnoticeList}" var="systemNotice" varStatus="loop">
							<tr id="listbg" onclick="goCollectionDetail(${systemNotice.id});" >
								<td height="20" align="center" ><input  type="checkbox" name="delid${systemNotice.id}" /></td>
								<td height="20" align="center" ><label>${systemNotice.id}</label></td>
								<td height="30" align="center" ><a>${systemNotice.noticeContent}</a></td>
								<td height="20" >${systemNotice.time}</td>
								<td height="20" ><c:choose><c:when test="${systemNotice.haveDetail}">跳转</c:when>
												 <c:otherwise>不跳转</c:otherwise></c:choose></td>
								<td style="padding: 5px;">${systemNotice.url}</td>
								<td height="20" ><c:choose><c:when test="${systemNotice.valid}">正在执行</c:when>
												 <c:otherwise>已过时</c:otherwise></c:choose></td>
								<td height="20" >
									<a href="">编辑|</a>
								    <a href="">查看|</a>
									<a href="#" onclick="" id="deleteSingleSubject${query.id}">删除</a>
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
								<td width="49%" align="right">[<a href="${pageContext.request.contextPath}/systemNotice.do?flag=showNoticeList&pageNow=1" class="right-font08">首页</a> | 
															   <a href="${pageContext.request.contextPath}/systemNotice.do?flag=showNoticeList&pageNow=${pageNow-1}" 
															      onclick="lastPage(${pageNow-1});"  class="right-font08">上一页</a> |
														       <a href="${pageContext.request.contextPath}/systemNotice.do?flag=showNoticeList&pageNow=${pageNow+1}" 
														          onclick="nextPage(${pageNow+1},${pageCount});" class="right-font08">下一页</a>| 
														       <a href="${pageContext.request.contextPath}/systemNotice.do?flag=showNoticeList&pageNow=${pageCount}" class="right-font08">末页</a>] 转至：
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
</body>
</html>
