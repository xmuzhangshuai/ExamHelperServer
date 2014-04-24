<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<title>添加考试指南</title>
<link rel="stylesheet" type="text/css" href="./css/examguide.css"/>
<link rel="stylesheet" type="text/css" href="./css/jquery-ui.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-datepicker.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	$("#date_1").datepicker();
});
</script>
</head>
  
<body style="margin: 0px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="62" background="./images/nav04.gif">
						<table width="30%" border="0" align="left" cellpadding="0" cellspacing="0">
							<tr>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		
		
		<tr>
			<td style="border-style: none; border-width: medium;">
				<form class="contact_form" action="${pageContext.request.contextPath}/examGuide.do?flag=addExamGuide" method="post" name="contact_form">
					<ul>
						<li>
             				<h2>添加文章</h2>
        				</li>
        				<li>
             				<label for="name">题目:</label>
             				<input type="text" name="title"  placeholder="文章题目" required />
        				</li>
        				<li>
             				<label for="website">文章URL:</label>
            				<input type="text" name="url" placeholder="url" required />
        				</li>
        				<li>
             				<label>文章类型:</label>
        					<select name="type" required>
        						<option></option>
        						<c:forEach items="${subjectList}" var="subject">
        							<optgroup label="${subject.subName}">
        								<c:forEach items="${subject.examguidetypes}" var="examGuideType">
        									<option value="${examGuideType.id}">${examGuideType.typeName}</option>
        								</c:forEach>
        							</optgroup>
        						</c:forEach>
        					</select>
        				</li>
        				<li>
             				<label>日期:</label>
        					<input type="text" name="date" id="date_1" required />
        				</li>
        				<li>
        					<button type="submit" class="submit">添     加</button>
        				</li>
					</ul>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
