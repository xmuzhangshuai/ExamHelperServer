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


<title>添加/修改科目信息</title>


<link rel="stylesheet" rev="stylesheet" href="./css/style.css"
	type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">
	function back(){
	document.getElementById("fom").action="${pageContext.request.contextPath}/subject.do?flag=listSubject&pageNow="+'${pageNow}';
		document.getElementById("fom").submit();
	}

	function save() {
	if(document.getElementById("subName").value.trim().length != 0){
		document.getElementById("fom").action = "${pageContext.request.contextPath}/subject.do?flag=addSubject&pageNow="+'${pageNow}';
		document.getElementById("fom").submit();
		}else
		alert("请填写科目名称")
	}
</script>
</head>

<body class="ContentBody">
	<form action="" method="post" enctype="multipart/form-data" name="fom"
		id="fom" target="mainFrame">
		<div class="MainDiv">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="CContent">
				<tr>
					<td height="62" style="background-image: url('./images/nav04.gif');"></td>
				</tr>
				<tr>
					<th class="tablestyle_title">科目增加页面</th>
				</tr>


				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>增加科目</legend>
							<table border="0" cellpadding="2" cellspacing="1" style="width:100%" >
								<tr>
									<td align="center" width="80px">科目名称:</td>
									<td><input name="subName" class="text" id="subName"
										style="width: 250px; height: 25px;" type="text" size="40" /> <span
										class="red"> *</span></td>
								</tr>
								<tr>
									<td><input type="hidden" name="paramsHidden"
										id="paramsHidden" value="${section}"/></td>
								</tr>
							</table>
							<br />
						</fieldset>
					</TD>
				</TR>
				<TR>
					<TD colspan="2" align="center" height="50px"><input
						type="button" name="Submit" value="保存" class="button"
						onclick="save();" /> <input type="button" name="Submit2"
						value="返回" class="button" onclick="back();" /></TD>
				</TR>
			</TABLE>

		</div>
	</form>
</body>

</html>
