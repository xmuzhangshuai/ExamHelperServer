<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
         "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>单项选择题</title>


<link rel="stylesheet" rev="stylesheet" href="./css/style.css" type="text/css" media="all" />
<script id="jquery_172" type="text/javascript" class="library" src="js/jquery-1.7.1.min.js"></script>
<script language="JavaScript" type="text/javascript">
	function save() {
		if (document.getElementById("material").value.trim().length != 0) {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=addMaterialAnalysis&imageUrl="+getValue();
			document.getElementById("fom").submit();
		} else
			alert("请输入题干");

	}
	function back() {
		var sectionName = document.getElementById("sectionName").value;
		document.getElementById("fom").action = "${pageContext.request.contextPath}/question.do?flag=showQuestionBySection&typeName=材料分析题&sectionName="
				+ sectionName+"&pageNow="+'${pageNow}';
		document.getElementById("fom").submit();
	}
	
	//获得图片路径
	function getValue()
	{
	    var ofrm1 = document.getElementById("imageFrame").document;   
	    if (ofrm1==undefined)
	    {
	        ofrm1 = document.getElementById("imageFrame").contentWindow.document;
	        var ff = ofrm1.getElementById("imageUrl").value;
	        return ff;
	    }
	    else
	    {
	        var ie = document.frames["imageFrame"].document.getElementById("imageUrl").value;
	         return ie;
	    }
	}
	function addQuestionOfMaterial(){
	if (document.getElementById("material").value.trim().length != 0) {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=firstTimeAddQuestionOfMaterial&imageUrl="+getValue();
			document.getElementById("fom").submit();
		} else
			alert("请先完成题干输入");
	}
</script>
</head>

<body class="ContentBody">
	<form method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="CContent">
				<tr>
					<th class="tablestyle_title">材料分析题</th>
				</tr>
				<tr>
					<td><input type="button"value="返回材料分析题列表"  onclick="back();"class="button" style="margin-left: 12px;"/></td>
				</tr>

				<TR>
					<TD width="100%">
						<fieldset style="height:100%;">
							<legend>题干</legend>
							<table>

								<tr align="left">
									<td align="left" width="13%">题干内容:</td>
									<td style="width: 448px; "><textarea rows="" cols=""
											id="material" name="material"
											style="width: 376px; height: 100px"></textarea><span
										class="red"> *</span></td>

								</tr>

							</table>
							<br />
						</fieldset>
					</TD>

				</TR>
				<tr>
					<td ><fieldset>
							<legend>题目图片:</legend>
							<table style="width: 100%;">
								<tr>
									<td>
										 <iframe id="imageFrame" src="UploadImage.jsp" width="100%"  scrolling="auto" frameborder="0"></iframe>
									</td>
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
									<td><select name="subjectName" id="subjectName"
										style="width: 243px; " >
											<c:forEach items="${subjects}" var="subject">
												<c:choose>
													<c:when test="${subject.id==subjectId}">
														<option value="${subject.id}" selected="selected">${subject.subName}</option>
													</c:when>
													<c:otherwise>
														<option value="${subject.id}">${subject.subName}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td>章节名称:</td>
									<td><select id="sectionName" name="sectionName">
														<c:forEach items="${sections}" var="section">
															<c:choose>
																<c:when test="${section.sectionName==sectionName}">
																	<option value="${section.sectionName}" selected="selected">${section.sectionName}</option>
																</c:when>
																<c:otherwise>
																	<option value="${section.sectionName}">${section.sectionName}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
									</select></td>
								</tr>
							</table>
						</fieldset></td>
				</tr>
				<tr>
					<td><fieldset>
							<legend>小题</legend>
							<c:forEach items="${questionOfMaterials}"
								var="questionOfMaterial">
								<fieldset>
									<table>
										<tr>
											<td>小题编号：</td>
											<td><input type="text"
												id="questionOfMaterial${questionOfMaterial.questionNumber}"
												readonly="readonly" value="${questionOfMaterial.questionNumber}"" /></td>
										</tr>
										<tr>
											<td>小题题干:</td>
											<td><textarea
													id="questionStem${questionOfMaterial.questionNumber}" style="width: 304px; height: 93px">${questionOfMaterial.questionStem}</textarea></td>
										</tr>
										<tr>
											<td>小题答案：</td>
											<td><textarea
													id="answer${questionOfMaterial.questionNumber}" style="width: 302px; height: 98px">${questionOfMaterial.answer}</textarea></td>
										</tr>
										<tr>
										<td>小题分析：</td>
											<td style="height: 84px; "><textarea
													id="analysis${questionOfMaterial.questionNumber}" style="width: 305px; height: 89px">${questionOfMaterial.analysis}</textarea></td>
										</tr>
										<tr>
										<td>小题分值：</td>
											<td><input type="text"
												id="score${questionOfMaterial.questionNumber}"
												readonly="readonly" value="${questionOfMaterial.score}"/></td>
										</tr>
									</table>
								</fieldset>
							</c:forEach>
							<input type="button"value="添加小题"  onclick="addQuestionOfMaterial();"class="button" style="margin-left: 12px;"/>
						</fieldset></td>
				</tr>

				<TR>
					<TD colspan="2" align="center" height="50px" style="padding-bottom: 10px;"> <input type="button" value="保存"
						type="submit"  onclick="save();"
						class="button" /></TD>
				</TR>
			</TABLE>

		</div>
	</form>
</body>

</html>
