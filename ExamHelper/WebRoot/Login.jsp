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
<title>登陆</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />

<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check() {
		if (document.getElementById("name").value.trim().length == 0
				&& document.getElementById("password").value.trim().length == 0) {
			alert("请输入用户名和密码 ");
			return false;
		} else if (document.getElementById("name").value.trim().length == 0) {
			alert("请输入用户名!");
			form.name.focus();
			return false;
		}
		else if (document.getElementById("password").value.trim().length == 0) {
			alert("请输入密码!");
			form.password.focus();
			return false;
		}
		document.getElementById("form").action="${path}/login.do?flag=login";
		document.getElementById("form").submit();
	}
</script>
</head>
  
<body>
<div class="login">
    <div class="box png">
		<div class="logo png"></div>
		<form action="" method="post" onsubmit="return check();" id="form">
		<div class="input">
			<div class="log">
				<div class="name">
					<label>用户名</label><input type="text" class="text" id="name" placeholder="用户名" name="name" tabindex="1">
				</div>
				<div class="pwd">
					<label>密　码</label><input type="password" class="text" id="password" placeholder="密码" name="password" tabindex="2">
					<input type="submit" class="submit" tabindex="3" onclick="isRightCode()" value="登录">
					<div class="check"></div>
				</div>
				<div class="tip">
				<c:if test="${!empty message}">
				${message}
				</c:if>
				</div>
			</div>
		</div>
		</form>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript" src="js/jQuerylog.js"></script>
<script type="text/javascript" src="js/fun.base.js"></script>
<script type="text/javascript" src="js/script.js"></script>

</body>
</html>
