<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户信息查看</title>
<link href="./css/css.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="./css/plug.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
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

function position(elem,l,t){
	var isIE6 = !-[1,] && !window.XMLHttpRequest;
	if(isIE6){
		var style = elem.style,
		dom  = '(document.documentElement)',
        left = l - document.documentElement.scrollLeft,
        top  = t - document.documentElement.scrollTop;
		style.position = 'absolute';
		style.removeExpression('left');
		style.removeExpression('top');
		style.setExpression('left', 'eval(' + dom + '.scrollLeft + ' + left + ') + "px"');
		style.setExpression('top', 'eval(' + dom + '.scrollTop + ' + top + ') + "px"');
	}else{
		elem.style.position = 'fixed';
	}
}		
function scscms_alert(msg,sign,ok,can){
	var c_=false;//是否已经关闭窗口，解决自动关闭与手动关闭冲突
	sign=sign||"";
	var s="<div id='mask_layer'></div><div id='scs_alert'><div id='alert_top'></div><div id='alert_bg'><table width='260' align='center' border='0' cellspacing='0' cellpadding='1'><tr>";
	if (sign!="")s+="<td width='45'><div id='inco_"+sign+"'></div></td>";
	s+="<td id='alert_txt'>"+msg+"</td></tr></table>";
	if (sign=="confirm"){
		s+="<a href='javascript:void(0)' id='confirm_ok'>确 定</a><a href='javascript:void(0)' id='confirm_cancel'>取 消</a>";
	}else{
		s+="<a href='javascript:void(0)' id='alert_ok'>确 定</a>"
	}
	s+="</div><div id='alert_foot'></div></div>";
	$("body").append(s);
	$("#scs_alert").css("margin-top",-($("#scs_alert").height()/2)+"px"); //使其垂直居中
	$("#scs_alert").focus(); //获取焦点，以防回车后无法触发函数
	position(document.getElementById('mask_layer'),0,0);
	position(document.getElementById('scs_alert'),$(window).width()/2,$(window).height()/2);
	if (typeof can == "number"){
	//定时关闭提示
		setTimeout(function(){
			close_info();
		},can*1000);
	}
	function close_info(){
	//关闭提示窗口
		if(!c_){
		$("#mask_layer").fadeOut("fast",function(){
			$("#scs_alert").remove();
			$(this).remove();
		});
		c_=true;
		}
	}
	$("#alert_ok").click(function(){
		close_info();
		if(typeof(ok)=="function")ok();
	});
	$("#confirm_ok").click(function(){
		close_info();
		if(typeof(ok)=="function")ok();
	});
	$("#confirm_cancel").click(function(){
		close_info();
		if(typeof(can)=="function")can();
	});
	function modal_key(e){	
		e = e||event;
		close_info();
		var code = e.which||event.keyCode;
		if (code == 13 || code == 32){if(typeof(ok)=="function")ok()}
		if (code == 27){if(typeof(can)=="function")can()}		
	}
	//绑定回车与ESC键
	if (document.attachEvent)
		document.attachEvent("onkeydown", modal_key);
	else
		document.addEventListener("keydown", modal_key, true);
}

function deleteUser(userId,userName,pageNow) {
	scscms_alert("确定要删除用户 "+userName+" 吗？","confirm",function(){
		document.getElementById("fom").action = "${pageContext.request.contextPath}/user.do?flag=deleteUser&pageNow="+pageNow+"&userId="+userId;
		document.getElementById("fom").submit();
		scscms_alert("删除成功！","ok");
	},function(){});
}

function freezeUser(userId,userName) {
	scscms_alert("确定要冻结用户 "+userName+" 吗？","confirm",function(){
		scscms_alert("冻结成功！","ok");
	},function(){});
}

function delSelected(){
	scscms_alert("确定要删除所选用户吗？","confirm",function(){
		scscms_alert("删除成功！","ok");
	},function(){});
}

function freezeSelected(){
	scscms_alert("确定要冻结所选用户吗？","confirm",function(){
		scscms_alert("冻结成功！","ok");
	},function(){});
}

function search() {
	if(document.getElementById('content').value==undefined || document.getElementById('content').value==null || document.getElementById('content').value=="")
		scscms_alert("请填写要查询内容！","warn");
	else {
		var type = document.getElementById('typeSelect').value;
		var content = document.getElementById('content').value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/user.do?flag=searchUser&type="+type+"&content="+content;
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
					<td height="62" background="./images/nav04.gif">
						<table width="30%" border="0" align="left" cellpadding="0" cellspacing="0">
							<tr>
								<td width="21"><img src="./images/ico07.gif" width="20" height="18" /></td>
								<td width="80">
									<select id="typeSelect">
										<option>按邮箱</option>
										<option>按昵称</option>
									</select>
								</td>
								<td width="300" align="left">
									<input name="content" id="content" type="text" size="20" /> 
									<input name="Submit4" type="button" class="right-button02"
									       value="查 询" onclick="search();" />
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
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" id="gallery">
				<tr>
					<td height="35">
						<span class="newfont07">全选：
							<input type="checkbox" id="selectOrNot" onchange="selectOrUnSelect()"/>
						</span>
						<input name="Submit" type="button" class="right-button08" value="删除所选" onclick="delSelected();" /> 
						<input type="hidden" name="paramsHidden" id="paramsHidden" /> 
						<input name="Submit2" type="button" class="right-button08" value="冻结所选" onclick="freezeSelected();" />
					</td>
				</tr>
				
				<tr>
				<td height="40" class="font42">
					<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
						<tr class="CTitle">
							<td height="22" colspan="13" align="center" style="font-size:16px">用户</td>
						</tr>
						<tr bgcolor="#EEEEEE">
							<td width="4%" align="center" height="30">选择</td>
							<td width="10%" align="center" height="30">头像</td>
							<td width="12%" align="center" height="30">邮箱</td>
							<td width="10%" align="center" height="30">昵称</td>
							<td width="6%" align="center" height="30">真实姓名</td>
							<td width="6%" align="center" height="30">年龄</td>
							<td width="10%" align="center" height="30">手机</td>
							<td width="8%" align="center" height="30">职业</td>
							<td width="12%" align="center" height="30">区域</td>
							<td width="6%" align="center" height="30">积分</td>
							<td width="6%" align="center" height="30">个性签名</td>
							<td width="10%" align="center" height="30">操作</td>
						</tr>
						<c:forEach items="${userList}" var="user">
							<tr id="listbg">
								<td height="20" align="center" ><input type="checkbox" name="delid${user.id}"/></td>
								<td height="30" align="center" ><a href="${user.avatar}" title="${user.nickname}"><img id ="headImage" height="80px" src="${user.avatar}" alt="" /></a></td>
								<td height="20" ><label>${user.mail}</label></td>
								<td height="20" ><label>${user.nickname}</label></td>
								<td height="20" ><label>${user.realname}</label></td>
								<td height="20" align="center" ><label>${user.age}</label></td>
								<td height="20" ><label>${user.phone}</label></td>
								<td height="20" ><label>${user.profession}</label></td>
								<td height="20" ><label>${user.area}</label></td>
								<td height="20" align="center" ><label>${user.integral}</label></td>
								<td height="20" ><label>${user.userState}</label></td>
								<td height="20" align="center">
									<img src="./images/delete.png" style="height: 15px;" alt="删除" onclick="deleteUser(${user.id},'${user.nickname}',${pageNow});" title="删除"/>删除
									<img src="./images/freeze.png" style="height: 15px;margin-left: 5px;" alt="冻结用户" onclick="freezeUser(${user.id},'${user.nickname}');" title="冻结用户"/>冻结
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
								<td width="49%" align="right">[<a href="${pageContext.request.contextPath}/user.do?flag=showUserList&pageNow=1" class="right-font08">首页</a> | 
															   <a href="${pageContext.request.contextPath}/user.do?flag=showUserList&pageNow=${pageNow-1}" 
															      onclick="lastPage(${pageNow-1});"  class="right-font08">上一页</a> |
														       <a href="${pageContext.request.contextPath}/user.do?flag=showUserList&pageNow=${pageNow+1}" 
														          onclick="nextPage(${pageNow+1},${pageCount});" class="right-font08">下一页</a>| 
														       <a href="${pageContext.request.contextPath}/user.do?flag=showUserList&pageNow=${pageCount}" class="right-font08">末页</a>] 转至：
								</td>
								<td width="1%">
									<table width="20" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="1%"><input id="page" name="textfield3" type="number" class="right-textfield03" size="1" /></td>
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
