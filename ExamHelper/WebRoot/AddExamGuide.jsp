<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
    <base href="<%=basePath%>">
    
<title>添加考试指南文章</title>
<link rel="stylesheet" type="text/css" href="./css/examguide.css">
<link rel="stylesheet" type="text/css" href="./css/jquery-ui.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-datepicker.js"></script>
<script type="text/javascript">
$(function(){
	$("#date_1").datepicker();
});
</script>
</head>
  
<body>
	<div >
	<table border="1" style="border-width: 0px">
		<tr>
		<td style="border-style: none; border-width: medium">　
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
            			<input type="email" name="email" placeholder="url" required />
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
        				<input type="text" id="date_1" readonly />
        			</li>
        			<li>
            			<label for="message">留言:</label>
            			<textarea name="message" cols="40" rows="6" placeholder="内容" required ></textarea>
        			</li>
        			<li>
        				<button class="submit" type="submit">添    加</button>
        			</li>
    			</ul>
			</form>
		</td>
		</tr>
	</table>
	</div>
</body>
</html>
