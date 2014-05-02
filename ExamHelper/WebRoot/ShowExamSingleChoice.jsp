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


<title>单项选择题</title>


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

	
	function back(){
	window.history.back(-1);
	}
	
	
</script>
</head>

<body class="ContentBody" >
	<form 
		
		method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent" >
				<tr>
					<th class="tablestyle_title">单项选择题</th>
				</tr>
				<tr>
					<td style="width: 485px; "><input type="button" value="返回单选题列表"
						style="width: 111px; " onclick="back();" class="button"/> </td>

				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>题干</legend>
							<table>

								<tr align="left">
									<td align="left" width="13%">题干内容:</td>
									<td style="width: 448px; "><c:out value="${singleChoice.questionStem}"/></td>

								</tr>

							</table>
							<br />
						</fieldset>
					</TD>

				</TR>
				<tr>
					<td><fieldset>
							<legend>选项</legend>

							<table>
								<tr>
									<td>
										<table>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项A:</td>
												<td width="43%"><c:out value="${singleChoice.optionA}"/></td>
											</tr>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项B:</td>
												<td width="43%"><c:out value="${singleChoice.optionB}"/></td>
											</tr>
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项C:</td>
												<td width="43%"><c:out value="${singleChoice.optionC}"/></td>
											</tr>
											<c:if test="${!empty singleChoice.optionD}">
											<tr> 
												<td align="right" width="13%" style="width: 41px; ">选项D:</td>
												<td width="43%"><c:out value="${singleChoice.optionD}" /></td>
											</tr>
											</c:if>
											<c:if test="${!empty singleChoice.optionE}">
											<tr>
												<td align="right" width="13%" style="width: 41px; ">选项E:</td>
												<td width="43%"><c:out value="${singleChoice.optionE}"/></td>
											</tr>
											</c:if>
										</table>
									</td>
									<td><table>
											<tr>
												<td>答案</td>
												<td><c:out value="${singleChoice.answer}"/></td>
											</tr>

										</table></td>
								</tr>
							</table>

						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>分析</legend>
							<table>
								<tr>
									<td>题目分析</td>
									<td><c:out value="${singleChoice.analysis}"/></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>备注</legend>
							<table>
								<tr>
									<td>题目备注</td>
									<td><c:out value="${singleChoice.remark}"/></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>所属科目、章节</legend>
							<table>
								<tr>
									<td>科目名称：</td>
									<td><c:out value="${singleChoice.section.subject.subName}" /></td>
								</tr>
								<tr>
									<td>章节名称:</td>
									<td><c:out value="${singleChoice.section.sectionName}"/></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
			</TABLE>

		</div>
	</form>
</body>

</html>
