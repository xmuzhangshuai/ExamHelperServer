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

	function back() {
	window.history.back(-1);
	}
</script>
</head>

<body class="ContentBody">
	<form method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">

			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">材料分析题</th>
				</tr>
				<tr>
					<td style="width: 485px; "><input type="button"
						value="返回材料分析题列表" style="width: 137px; " onclick="back();"
						class="button" /></td>
				</tr>
				<tr>
					<td width="100%"><fieldset>
							<legend> 大题信息</legend>
							<table style="width: 1124px; ">
								<TR>
									<TD width="100%">
										<fieldset style="height:100%;">
											<table>

												<tr align="left">
													<td align="left" width="13%" style="width: 58px; ">题干内容:</td>
													<c:out value="${materialAnalysis.material}"></c:out>
													<td style="width: 448px; "><span
														class="red"> *</span></td>
												</tr>

											</table>

										</fieldset>
									</TD>

								</TR>
								<tr>
									<td><fieldset>
											<table>
												<tr>
													<td>题目图片:</td>
													<td><input type="file" name="materialImage"
														id="materialImage" /></td>
												</tr>
											</table>
										</fieldset></td>
								</tr>
								<tr>
									<td><fieldset>
											<table>
												<tr>
													<td>备注内容：</td>
													<td><c:out value="${materialAnalysis.remark}" />
														</td>
												</tr>
											</table>

										</fieldset></td>
								</tr>
								<tr>
									<td><fieldset>
											<table>
												<tr>
													<td>科目名称：</td>
													<td><c:out value="${materialAnalysis.section.subject.subName}" /></td>
												</tr>
												<tr>
													<td>章节名称:</td>
													<td><c:out value="${materialAnalysis.section.sectionName}" /></td>

												</tr>
											</table>
										</fieldset></td>
								</tr>

							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>小题信息</legend>
							<table>
								<tr>
									<td style="width: 1070px; ">
									   <c:forEach
											items="${materialAnalysis.questionsofmaterials}" var="questionOfMaterial">
											<fieldset>
												<table style="width: 1031px; ">
													<tr>
														<td>
															<table>

																<tr>
																	<td>小题编号：</td>
																	<td><c:out
																			value="${questionOfMaterial.questionNumber}" /></td>
																</tr>
																
																<tr>
																	<td>小题题干:</td>
																	<td><c:out
																			value="${questionOfMaterial.questionStem}"></c:out></td>
																</tr>
																
																<tr>
																	<td>小题答案：</td>
																	<td><c:out value="${questionOfMaterial.answer}" /></td>
																</tr>
																<tr>
																	<td>小题分析：</td>
																	<td style="height: 84px; "><c:out value="${questionOfMaterial.analysis}" /></td>
																</tr>
																<tr>
																	<td>小题分值：</td>
																	<td><c:out value="${questionOfMaterial.score}" /></td>
																</tr>


															</table>
														</td>
													</tr>

												</table>

											</fieldset>
										</c:forEach></td>
								</tr>

							</table>

						</fieldset></td>
				</tr>


			</TABLE>

		</div>
	</form>
</body>

</html>
