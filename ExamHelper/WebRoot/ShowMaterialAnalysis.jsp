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
	<form method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">

			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">材料分析题</th>
				</tr>
				<tr>
					<td><input type="button" value="返回材料分析题列表"onclick="back();"class="button" />
					</td>
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
													<td style="width: 448px; "><textarea rows="" cols=""
															id="material" name="material" readonly="readonly"
															style="width: 729px; height: 100px">${materialAnalysis.material}</textarea><span
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
													<td><img src="${materialAnalysis.materialImage}" alt="" /></td>
												</tr>
											</table>
										</fieldset></td>
								</tr>
								<tr>
									<td><fieldset>
											<table>
												<tr>
													<td>备注内容：</td>
													<td><textarea name="remark" id="remark" readonly="readonly"
															style="width: 731px; height: 85px">${materialAnalysis.remark}</textarea></td>
												</tr>
											</table>

										</fieldset></td>
								</tr>
								<tr>
									<td><fieldset>
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
									<TD colspan="2" align="center" height="50px">
										</TD>
								</TR>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>小题信息</legend>
							<table>
								<tr>
									<td style="width: 1070px; "><c:forEach
											items="${questionOfMaterials}" var="questionOfMaterial">
											<fieldset>
												<table style="width: 1031px; ">
													<tr>
														<td>
															<table>

																<tr>
																	<td>小题编号：</td>
																	<td><input type="text"
																		id="questionNumber${questionOfMaterial.id}"
																		name="questionNumber${questionOfMaterial.id}"
																		value="${questionOfMaterial.questionNumber}"  readonly="readonly"/></td>
																</tr>
																<tr>
																	<td>小题题干:</td>
																	<td><textarea readonly="readonly"
																			id="questionStem${questionOfMaterial.id}"
																			name="questionStem${questionOfMaterial.id}"
																			style="width: 721px; height: 93px">${questionOfMaterial.questionStem}</textarea></td>
																</tr>
																<tr>
																	<td>小题答案：</td>
																	<td><textarea id="answer${questionOfMaterial.id}" readonly="readonly"
																			name="answer${questionOfMaterial.id}"
																			style="width: 723px; height: 98px">${questionOfMaterial.answer}</textarea></td>
																</tr>
																<tr>
																	<td>小题分析：</td>
																	<td style="height: 84px; "><textarea
																			id="analysis${questionOfMaterial.id}" readonly="readonly"
																			name="analysis${questionOfMaterial.id}"
																			style="width: 720px; height: 89px">${questionOfMaterial.analysis}</textarea></td>
																</tr>
																<tr>
																	<td>小题分值：</td>
																	<td><input type="text"
																		id="score${questionOfMaterial.id}" readonly="readonly"
																		name="score${questionOfMaterial.id}"
																		value="${questionOfMaterial.score}" /></td>
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

				<TR>
					<TD colspan="2" align="center" height="50px"> </TD>
				</TR>
			</TABLE>

		</div>
	</form>
</body>

</html>
