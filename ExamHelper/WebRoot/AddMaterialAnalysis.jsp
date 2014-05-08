<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>

<title>单项选择题</title>

<link type="text/css" rel="stylesheet" href="./css/plug.css"/>
<script type="text/javascript" src="js/dialog.js" charset="utf-8"></script>
<link rel="stylesheet" rev="stylesheet" href="./css/style.css" type="text/css" media="all" />
<script id="jquery_172" type="text/javascript" class="library" src="js/jquery-1.7.1.min.js"></script>
<script language="JavaScript" type="text/javascript">
	function save() {
		if (document.getElementById("material").value.trim().length != 0) {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=addMaterialAnalysis&imageUrl="+getValue();
			document.getElementById("fom").submit();
		} else
			scscms_alert("请先输入题干","warn");

	}
	function back() {
	var sectionName = document.getElementById("sectionName").value;
	
	document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=showMaterialAnalysisList&typeName=材料分析题&sectionName="
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
	        var imageUrl = ofrm1.getElementById("imageUrl");
	        if(imageUrl==undefined) return null;
	        else return imageUrl.value;
	    }
	    else
	    {
	        var ieImageUrl = document.frames["imageFrame"].document.getElementById("imageUrl");
	        if(ieImageUrl==undefined) return null;
	        return ieImageUrl.value;
	    }
	}
	function addQuestionOfMaterial(){
	if (document.getElementById("material").value.trim().length != 0) {
			document.getElementById("fom").action = "${pageContext.request.contextPath}/materialAnalysis.do?flag=firstTimeAddQuestionOfMaterial&imageUrl="+getValue();
			document.getElementById("fom").submit();
		} else
			scscms_alert("请先输入题干","warn");
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
									<td width="80px">题干内容:</td>
									<td><textarea rows="10" cols="120" id="material" name="material"></textarea><span
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
							<table cellspacing="10px;">
								<tr>
									<td width="80px">科目名称：</td>
									<td><select name="subjectName" id="subjectName"
										style="width: 250px; " >
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
									<td width="80px">章节名称:</td>
									<td><select id="sectionName" name="sectionName" style="width: 250px; ">
											
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
											<td width="80px">小题编号：</td>
											<td><input type="text"
												id="questionOfMaterial${questionOfMaterial.questionNumber}"
												readonly="readonly" value="${questionOfMaterial.questionNumber}"" /></td>
										</tr>
										<tr>
											<td width="80px">小题题干:</td>
											<td><textarea  rows="8" cols="80"
													id="questionStem${questionOfMaterial.questionNumber}" >${questionOfMaterial.questionStem}</textarea></td>
										</tr>
										<tr>
											<td width="80px">小题答案：</td>
											<td><textarea  rows="8" cols="80"
													id="answer${questionOfMaterial.questionNumber}">${questionOfMaterial.answer}</textarea></td>
										</tr>
										<tr>
										<td width="80px">小题分析：</td>
											<td><textarea  rows="8" cols="80"
													id="analysis${questionOfMaterial.questionNumber}">${questionOfMaterial.analysis}</textarea></td>
										</tr>
										<tr>
										<td width="80px">小题分值：</td>
											<td><input type="number"
												id="score${questionOfMaterial.questionNumber}"
												readonly="readonly" value="${questionOfMaterial.score}"/></td>
										</tr>
									</table>
								</fieldset>
							</c:forEach>
							<input type="button" value="添加小题"  onclick="addQuestionOfMaterial();"class="button" style="margin-left: 12px;"/>
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
