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


<title>判断题</title>


<link rel="stylesheet" rev="stylesheet" href="./css/style.css"
	type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">
	
	function back() {
	window.history.back(-1);
	}
	function initAnswer(answer) {
		var checked = "true";
		var answers = document.getElementsByName("answer");
		if (answer == checked) {
			answers[0].checked = true;
			answers[1].checked = false;
		} else {
			answers[0].checked = false;
			answers[1].checked = true;
		}

	}
</script>
</head>

<body class="ContentBody" onload="initAnswer('${trueOrFalse.answer}');">
	<form
		method="post" enctype="multipart/form-data" name="fom" id="fom"
		target="mainFrame">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">判断题</th>
				</tr>
				<tr>
					<td><input type="button" value="返回判断题列表" onclick="back();" class="button" /></td>
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
											style="width: 376px; height: 100px">${trueOrFalse.questionStem}</textarea></td>

								</tr>

							</table>
							<br />
						</fieldset>
					</TD>

				</TR>
				<tr>
					<td><fieldset>
							<legend>答案</legend>

							<table>
								<tr>

									<td><table style="width: 341px; ">

											<tr>
												<td align="left" width="13%"
													style="height: 42px; width: 40px">答案：</td>
												<td width="43%"><input id="answer" name="answer"
													value="true" disabled="disabled" class="text"
													style="width: 24px" type="radio" size="40" /></td>
												<td><img src="./images/image_right.png"
													style="width: 43px; " /></td>
												<td width="43%"><input id="answer" name="answer"
													value="false" class="text" style="width: 24px" type="radio"
													size="40" disabled="disabled" /></td>
												<td><img src="./images/image_wrong.png" /></td>
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
											style="height: 119px; width: 394px">${trueOrFalse.analysis}</textarea></td>
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
