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

<link rel="stylesheet" rev="stylesheet" href="./css/style.css" type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">
	function back(){
	window.history.back(-1);
	}
</script>
</head>

<body class="ContentBody" >
	<form method="post" enctype="multipart/form-data" name="fom" id="fom" target="mainFrame">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent" >
				<tr>
					<th class="tablestyle_title">单项选择题</th>
				</tr>
				<tr>
					<td><input type="button" value="返回单选题列表" onclick="back();" class="button"/> </td>

				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>题干</legend>
							<table>
								<tr align="left">
									<td align="left" width="80px">题干内容:</td>
									<td><textarea rows="8" cols="80"id="questionStem" readonly="readonly" name="questionStem">${singleChoice.questionStem}</textarea></td>
								</tr>
							</table>
							<br />
						</fieldset>
					</TD>

				</TR>
				<tr>
					<td width="100%"><fieldset>
							<legend>选项</legend>
							<table width="100%">
								<tr>
									<td width="60%">
										<table width="100%">
											<tr>
												<c:if test="${!empty singleChoice.optionA}">
													<td align="left" width="80px">选项A:</td>
													<td>
                                                		<c:out value="${singleChoice.optionA}"/>
                                                	</td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty singleChoice.optionB}">
													<td align="left" width="80px">选项B:</td>
													<td>
                                                		<c:out value="${singleChoice.optionB}"/>
                                                	</td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty singleChoice.optionC}">
													<td align="left" width="80px">选项C:</td>
											    	<td>
                                                		<c:out value="${singleChoice.optionC}"/>
                                               		 </td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty singleChoice.optionD}">
													<td align="left" width="80px">选项D:</td>
													<td>
                                                		<c:out value="${singleChoice.optionD}"/>
                                               		 </td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty singleChoice.optionE}">
													<td align="left" width="80px">选项E:</td>
													<td>
                                                		<c:out value="${singleChoice.optionE}"/>
                                                	</td>
                                             	</c:if>
											</tr>
										</table>
									</td>
									<td width="20%"><table>
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
									<td width="80px">题目分析:</td>
									<td><textarea id="analysis" cols="80" rows="8" name="analysis" readonly="readonly">${singleChoice.analysis}</textarea></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>备注</legend>
							<table>
								<tr>
									<td width="80px">题目备注:</td>
									<td><textarea id="remark" cols="80" rows="8"name="remark" readonly="readonly">${singleChoice.remark}</textarea></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>所属科目、章节</legend>
							<table>
								<tr>
									<td width="80px">科目名称：</td>
									<td><c:out value="${subject}"/></td>
								</tr>
								<tr>
									<td width="80px">章节名称:</td>
									<td><c:out value="${sectionName}"/></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
				<TR>
					<TD colspan="2" align="center" height="50px"> </TD>
				</TR>
			</TABLE>
		</div>
	</form>
</body>

</html>
