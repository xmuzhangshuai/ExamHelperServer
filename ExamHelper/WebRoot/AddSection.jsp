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


<title>增加章节</title>

<link rel="stylesheet" rev="stylesheet" href="./css/style.css"
	type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
	function tishi() {
		var a = confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
		if (a != true)
			return false;
		window
				.open(
						"冲突页.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}

	function check() {
		document.getElementById("aa").style.display = "";
	}
	function toAddNewSubject() {

		var sectionInfor = document.getElementById("sectionName").value + ","
				+ ${section.id};
		document.getElementById("addNewSubject").href = "${pageContext.request.contextPath}/subject.do?flag=addSubjectUI&sectionInfor="
				+ sectionInfor;
		alert(document.getElementById("addNewSubject").href)
		var a = document.getElementById("addNewSubject");
		a[0].click();

	}
</script>
</head>

<body class="ContentBody">
	<form
		action="${pageContext.request.contextPath}/listQuestion.do?flag=addSection"
		method="post" enctype="multipart/form-data" name="form"
		target="mainFrame">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">增加章节</th>
				</tr>
				<tr>
					<td class="CPanel">

						<table border="0" cellpadding="0" cellspacing="0"
							style="width:100%">

							<TR>
								<TD width="100%">
									<fieldset style="height:100%;">
										<legend>增加章节</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">


											<tr>
												<td nowrap align="right" width="11%">章节名称:</td>
												<td width="27%"><input id="sectionName"
													name="sectionName" type="text" class="text"
													style="width:154px" value="${section.sectionName}" /></td>

												<td align="right" width="25%">&nbsp;</td>
												<td width="37%">&nbsp;</td>
											</tr>



											<tr>
												<td width="11%" align="right" nowrap>所属科目:</td>
												<td colspan="3">
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select
													name="subjectName">
														<option selected="selected">${subject.subName}</option>
														<c:forEach items="${subjects}" var="item">
															<option>${item.subName}</option>
														</c:forEach>
												</select>
												</td>

											</tr>
											<tr>
												<td align="left"><a onclick="toAddNewSubject();"
													id="addNewSubject">增添新科目</a></td>
											</tr>
										</table>

									</fieldset>
								</TD>
							</TR>
						</TABLE>
					</td>
				</tr>

				<TR>
					<TD colspan="2" align="center" height="50px"><input
						type="submit" name="Submit" value="发送" class="button"
						style="width: 94px; " /> <input type="button" name="Submit2"
						value="返回" class="button" onclick="window.history.go(-1);"
						style="width: 94px; " /></TD>
				</TR>
			</table>

		</div>
	</form>
</body>
</html>

