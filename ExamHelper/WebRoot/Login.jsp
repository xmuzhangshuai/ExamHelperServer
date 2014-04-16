<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Login</title>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<link href="./css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./js/verifyCode.js"></script>
<script type="text/javascript" src="./js/jquery.js"></script>

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
<body style="text-align: center;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		align="center">
		<tr>
			<td style="height:147;background-image:url(./images/top02.gif)"><img
				src="./images/top03.gif" width="776" height="147" /></td>
		</tr>
	</table>

	<table width="562" border="0" align="center" cellpadding="0"
		cellspacing="0" class="right-table03">
		<tr>
			<td style="width:221;"><table width="95%" border="0"
					cellpadding="0" cellspacing="0" class="login-text01">

					<tr>
						<td><table width="100%" border="0" cellpadding="0"
								cellspacing="0" class="login-text01" align="center">
								<tr>
									<td align="center"><img src="./images/ico13.gif"
										width="107" height="97" /></td>
								</tr>
								<tr>
									<td style="height:40;" align="center">&nbsp;</td>
								</tr>

							</table></td>
						<td><img src="./images/line01.gif" width="5" height="292" /></td>
					</tr>
				</table></td>
			<td>
				<form action="" method="post"
					onsubmit="return check();" id="form">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						align="center">
						<tr>
							<td style="width:31%;height:35;w" class="login-text02">用户名称：<br /></td>
							<td style="width:69%;"><input id="name" name="name"
								type="text" size="30" style="width: 256px; " /></td>
						</tr>
						<tr>
							<td style="height:35;" class="login-text02">密 码：<br /></td>
							<td><input id="password" name="password" type="password"
								size="33" /></td>
						</tr>


						<tr>
							<td style="height:35;">&nbsp;</td>
							<td><input type="submit" class="right-button01" value="确认登陆"
								onclick="isRightCode()" /> <input name="Submit232" type="reset"
								class="right-button02" value="重 置" /></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>

</body>




</html>
