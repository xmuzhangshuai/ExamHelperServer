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


<title>多项选择题</title>


<link rel="stylesheet" rev="stylesheet" href="./css/style.css"
	type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">

	function back(){
	window.history.back(-1);
	}
</script>
</head>

<body class="ContentBody" style="line-height: 150%">
	<form method="post" enctype="multipart/form-data" name="fom" id="fom" target="mainFrame">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">多项选题</th>
				</tr>
				<tr>
					<td><input type="button" value="返回多选题列表" onclick="back();" class="button" /></td>
				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>题干</legend>
							<table>
								<tr align="left">
									<td align="left" width="80px">题干内容:</td>
									<td>
									  <textarea rows="8" cols="80" id="questionStem"  name="questionStem" readonly="readonly">${multiChoice.questionStem}
										</textarea>
									</td>
								</tr>
							</table>
						</fieldset>
					</TD>
				</TR>
				
				
				<tr>
					<td><fieldset>
							<legend>选项</legend>
							<table width="100%">
								<tr>
									<td  width="50%">
										<table>
											<tr>
												<c:if test="${!empty multiChoice.optionA}">
													<td align="left" style="width: 80px; ">选项A:</td>
													<td>
                                                		<c:out value="${multiChoice.optionA}"/>
                                                	</td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty multiChoice.optionB}">
													<td align="left" width="13%" style="width: 80px; ">选项B:</td>
													<td>
                                                		<c:out value="${multiChoice.optionB}"/>
                                                	</td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty multiChoice.optionC}">
													<td align="left" width="13%" style="width: 80px; ">选项C:</td>
													<td>
                                                		<c:out value="${multiChoice.optionC}"/>
                                                	</td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty multiChoice.optionD}">
													<td align="left" width="13%" style="width: 80px; ">选项D:</td>
													<td>
                                                		<c:out value="${multiChoice.optionD}"/>
                                                	</td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty multiChoice.optionE}">
													<td align="left" width="13%" style="width: 80px; ">选项E:</td>
													<td>
                                                		<c:out value="${multiChoice.optionE}"/>
                                                	</td>
                                                </c:if>
											</tr>
											<tr>
												<c:if test="${!empty multiChoice.optionF}">
													<td align="left" width="13%" style="width: 80px; ">选项F:</td>
													<td>
                                                		<c:out value="${multiChoice.optionF}"/>
                                                	</td>
                                                </c:if>
											</tr>
										</table>
									</td>
									<td><table>
											<tr>
												<td>答案</td>
												<c:if test="${multiChoice.answerA}">
												<td><input type="checkbox" id="answer1" name="answerA" checked="checked"
													disabled="disabled" value="${multiChoice.answerA}" />A</td>
												</c:if>
													<c:if test="${multiChoice.answerB}">
												<td><input type="checkbox" id="answer2" name="answerB" checked="checked"
													disabled="disabled" value="${multiChoice.answerB}" />B</td>
													</c:if>
													<c:if test="${multiChoice.answerC}">
												<td><input type="checkbox" id="answer3" name="answerC" checked="checked"
													disabled="disabled" value="${multiChoice.answerC}" />C</td>
													</c:if>
													<c:if test="${multiChoice.answerD}">
												<td><input type="checkbox" id="answer4" name="answerD" checked="checked"
													disabled="disabled" value="${multiChoice.answerD}" />D</td>
													</c:if>
													<c:if test="${multiChoice.answerE}">
												<td><input type="checkbox" id="answer5" name="answerE" checked="checked"
													disabled="disabled" value="${multiChoice.answerE}" />E</td>
													</c:if>
													<c:if test="${multiChoice.answerF}">
												<td><input type="checkbox" id="answer6" name="answerF" checked="checked"
													disabled="disabled" value="${multiChoice.answerF}" />F</td>
													</c:if>
											</tr>

										</table>
									</td>
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
									<td><textarea id="analysis" cols="80" rows="8" name="analysis" readonly="readonly">${multiChoice.analysis}</textarea></td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			
				<tr>
					<td>
					   <fieldset>
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
						</fieldset>
					</td>
				</tr>
				<TR>
					<TD colspan="2" align="center" height="50px"> </TD>
				</TR>
			</table>
		</div>
	</form>
</body>

</html>
