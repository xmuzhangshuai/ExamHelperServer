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


<title>修改章节信息</title>

<link rel="stylesheet" rev="stylesheet" href="./css/style.css"
	type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
	function back(){
	var subjectId=document.getElementById("subjectName").value;
		document.getElementById("fom").action="${pageContext.request.contextPath}/section.do?flag=showSectionListBySubject&subjectId="+subjectId+"&pageNow="+'${pageNow}';
		document.getElementById("fom").submit();
	}
	function save(){
	if(document.getElementById("sectionName").value.trim().length != 0){
			document.getElementById("fom").action="${pageContext.request.contextPath}/section.do?flag=updateSection&sectionId="+'${section.id}';
			document.getElementById("fom").submit();
		}else
			alert("请输入章节名称");
	}
</script>
</head>

<body class="ContentBody">
	<form
		id="fom"
		method="post" enctype="multipart/form-data" name="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<td height="62" style="background-image: url('./images/nav04.gif');"></td>
				</tr>
				<tr>
					<th class="tablestyle_title">修改章节信息</th>
				</tr>
				<tr>
					<td class="CPanel">

						<table border="0" cellpadding="0" cellspacing="0"
							style="width:100%">

							<TR>
								<TD width="100%">
									<fieldset style="height:100%;">
										<legend>修改章节信息</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">


											<tr>
												<td align="center" width="80px">章节名称:</td>
												<td><input id="sectionName"
													name="sectionName" type="text" class="text"
													style="width: 250px; height: 25px;" value="${section.sectionName}" /></td>

												<td align="right" width="25%">&nbsp;</td>
												<td width="37%">&nbsp;</td>
											</tr>



											<tr>
												<td width="80px" align="center">所属科目:</td>
												<td>
													<select name="subjectName" id="subjectName" style="width: 250px; height: 25px;">
														<c:forEach items="${subjects}" var="subject">
																		<c:choose>
																			<c:when test="${subject.id==subjectId}">
																				<option value="${subject.id}"
																					selected="selected">${subject.subName}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${subject.id}">${subject.subName}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
												</select>
												</td>

											</tr>
											
										</table>

									</fieldset>
								</TD>
							</TR>
						</TABLE>
					</td>
				</tr>

				<TR>
					<TD colspan="2" align="center" height="50px">
						<input type="button" name="Submit" value="保存" class="button" onclick="save();"/> 
						<input type="button" name="Submit2" value="返回" class="button" onclick="back();"/>
					</TD>
				</TR>
			</TABLE>

		</div>
	</form>
</body>
</html>
