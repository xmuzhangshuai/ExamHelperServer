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
					<td><input type="button" value="返回单选题列表" onclick="back();" class="button"/> </td>

				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>题干</legend>
							<table>

								<tr align="left">
									<td align="left" width="13%">题干内容:</td>
									<td style="width: 448px; "><textarea rows="" cols=""
											id="questionStem" readonly="readonly" name="questionStem"
											style="width: 376px; height: 100px">${singleChoice.questionStem}</textarea></td>

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
												<c:if test="${!empty singleChoice.optionA}">
													<td align="right" width="13%" style="width: 41px; ">选项A:</td>
													<td width="43%">
                                                		<c:out value="${singleChoice.optionA}"/>
                                                	</td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty singleChoice.optionB}">
													<td align="right" width="13%" style="width: 41px; ">选项B:</td>
													<td width="43%">
                                                		<c:out value="${singleChoice.optionB}"/>
                                                	</td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty singleChoice.optionC}">
													<td align="right" width="13%" style="width: 41px; ">选项C:</td>
											    	<td width="43%">
                                                		<c:out value="${singleChoice.optionC}"/>
                                               		 </td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty singleChoice.optionD}">
													<td align="right" width="13%" style="width: 41px; ">选项D:</td>
													<td width="43%">
                                                		<c:out value="${singleChoice.optionD}"/>
                                               		 </td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty singleChoice.optionE}">
													<td align="right" width="13%" style="width: 41px; ">选项E:</td>
													<td width="43%">
                                                		<c:out value="${singleChoice.optionE}"/>
                                                	</td>
                                             	</c:if>
											</tr>
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
									<td><textarea id="analysis" cols="" rows=""
											name="analysis" readonly="readonly"
											style="height: 119px; width: 394px">${singleChoice.analysis}</textarea></td>
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
									<td><textarea id="remark" cols="" rows=""
											name="remark" readonly="readonly"
											style="height: 119px; width: 394px">${singleChoice.remark}</textarea></td>
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
									<td><c:out value="${subject}"/></td>
								</tr>
								<tr>
									<td>章节名称:</td>
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
