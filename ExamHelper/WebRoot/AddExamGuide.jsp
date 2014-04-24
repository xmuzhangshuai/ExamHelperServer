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
<style>
    .contact_form{padding-top:20px;}
 </style>
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
								<td width="21"><img src="./images/ico07.gif" width="20" height="18" /></td>
								<td width="80">
									<select>
										<option>按邮箱</option>
										<option>按昵称</option>
										<option>按地区</option>
									</select>
								</td>
								<td width="300" align="left">
									<input name="textfield" id="textfield" type="text" size="20" /> 
									<input name="Submit4" type="button" class="right-button02"
									       value="查 询" onclick="keywordSearch();" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		
		
		<tr>
			<td style="border-style: none; border-width: medium;">
				<form class="contact_form" action="#" method="post" name="contact_form">
					<ul>
						<li>
             				<h2>添加文章</h2>
        				</li>
        				<li>
             				<label for="name">题目:</label>
             				<input type="text"  placeholder="文章题目" required />
        				</li>
        				<li>
             				<label for="email">文章URL:</label>
            				<input type="text" name="email" placeholder="url" required />
        				</li>
        				<li>
             				<label>文章类型:</label>
        					<select>
        						<optgroup label="北海道">
	    							<option value="01">北海道</option>
	    						</optgroup>
	    						<optgroup label="東北">
	    							<option value="02">青森県</option>
	    							<option value="03">岩手県</option>	
	    							<option value="04">宮城県</option>
	    							<option value="05">秋田県</option>
	    							<option value="06">山形県</option>
	    							<option value="07">福島県</option>
	    						</optgroup>
	    						<optgroup label="関東">
	    							<option value="08">東京都</option>
	    							<option value="09">茨城県</option>
	    							<option value="10">栃木県</option>
	    							<option value="11">群馬県</option>
	    							<option value="12">埼玉県</option>
	    							<option value="13">千葉県</option>
	    							<option value="14">神奈川県</option>
	    						</optgroup>
        					</select>
        				</li>
        				<li>
             				<label>日期:</label>
        					<input type="text" id="date_1" required />
        				</li>
        				<li>
        					<button type="submit" class="submit">添    加</button>
        				</li>
					</ul>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
