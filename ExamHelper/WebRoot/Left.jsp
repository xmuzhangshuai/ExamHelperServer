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
<title>后台管理系统</title>
<link href="./css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">
	function tupian(idt) {
		var nametu = "xiaotu" + idt;
		var tp = document.getElementById(nametu);
		tp.src = "./images/ico05.gif";//图片ico04为白色的正方形

		for (var i = 1; i < 30; i++) {

			var nametu2 = "xiaotu" + i;
			if (i != idt * 1) {
				var tp2 = document.getElementById('xiaotu' + i);
				if (tp2 != undefined) {
					tp2.src = "./images/ico06.gif";
				}//图片ico06为蓝色的正方形
			}
		}
	}

	function list(idstr) {
		var name1 = "subtree" + idstr;
		var name2 = "img" + idstr;
		var objectobj = document.all(name1);
		var imgobj = document.all(name2);

		//alert(imgobj);

		if (objectobj.style.display == "none") {
			for (i = 1; i < 10; i++) {
				var name3 = "img" + i;
				var name = "subtree" + i;
				var o = document.all(name);
				if (o != undefined) {
					o.style.display = "none";
					var image = document.all(name3);
					//alert(image);
					image.src = "./images/ico04.gif";
				}
			}
			objectobj.style.display = "";
			imgobj.src = "./images/ico03.gif";
		} else {
			objectobj.style.display = "none";
			imgobj.src = "./images/ico04.gif";
		}
		;
	};
</script>
</head>



<body>
	<table style="width: 198;border: 0;" cellpadding="0" cellspacing="0"
		class="left-table01">
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="207" height="55"
							style="background-image:url(./images/nav01.gif)">
							<table width="90%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="25%" rowspan="2"><img src="./images/ico02.gif"
										width="35" height="35" /></td>
									<td width="75%" height="22" class="left-font01">您好，<span
										class="left-font02">${managerInfor.name}</span></td>
								</tr>
								<tr>
									<td height="22" class="left-font01">[&nbsp;<a
										href="${pageContext.request.contextPath}/login.do?flag=logout"
										target="_top" class="left-font01">退出</a>&nbsp;]
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				
				 <!--  管理题库系统开始    -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img6" id="img6"
										src="./images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a 
										href="${pageContext.request.contextPath}/subject.do?flag=listSubject&pageNow=1"
										target="mainFrame" class="left-font03" onclick="list('6');">管理题库</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table id="subtree6" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<c:forEach  items="${subjects}" var="subject">
						<tr>

							<td width="9%" height="20"><img id="xiaotu${subject.id+16}"
								src="./images/ico06.gif" width="8" height="12" /></td>
							<td width="91%"><a
								href="${pageContext.request.contextPath}/listQuestion.do?flag=chooseType&subjectId=${subject.id}"
								target="mainFrame" class="left-font03"
								onclick="tupian('${subject.id+16}');">${subject.subName}</a></td>
						</tr>

					</c:forEach>
				</table> <!--  管理题库系统结束    -->
				
				 <!--  文档管理系统开始    -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img1" id="img1"
										src="./images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onclick="list('1');">文档管理</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table id="subtree1" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<tr>
						<td width="9%" height="20"><img id="xiaotu1"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="sendxiaoxi.htm" target="mainFrame"
							class="left-font03" onclick="tupian('1');">管理考试政策文档</a></td>
					</tr>
					<tr>
						<td width="9%" height="20"><img id="xiaotu2"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="listtakexiaoxi.htm"
							target="mainFrame" class="left-font03" onclick="tupian('2');">管理考试指南文档</a></td>
					</tr>
					<tr>
						<td width="9%" height="20"><img id="xiaotu3"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="listsendxiaoxi.htm"
							target="mainFrame" class="left-font03" onclick="tupian('3');">管理考试经验文档
						</a></td>
					</tr>
					<tr>
						<td width="9%" height="20"><img id="xiaotu4"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="listxiaoxi.htm" target="mainFrame"
							class="left-font03" onclick="tupian('4');">管理报考大纲文档 </a></td>
					</tr>
					<tr>
						<td width="9%" height="20"><img id="xiaotu5"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="listxiaoxi.htm" target="mainFrame"
							class="left-font03" onclick="tupian('5');">管理考试动态文档 </a></td>
					</tr>
				</table> <!--  管理文档系统结束    --> <!--  发布信息系统开始    -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img2" id="img2"
										src="./images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onclick="list('2');">发布信息</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table id="subtree2" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<tr>
						<td width="9%" height="20"><img id="xiaotu6"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="sendxiaoxi.htm" target="mainFrame"
							class="left-font03" onclick="tupian('6');">发布客户端系统信息</a></td>
					</tr>
					<tr>
						<td width="9%" height="20"><img id="xiaotu7"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="listtakexiaoxi.htm"
							target="mainFrame" class="left-font03" onclick="tupian('7');">发布答疑广场公告</a></td>
					</tr>
					<tr>
						<td width="9%" height="20"><img id="xiaotu8"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="listsendxiaoxi.htm"
							target="mainFrame" class="left-font03" onclick="tupian('8');">发布用户通知
						</a></td>
					</tr>

				</table> <!--  发布信息系统结束    -->
				
				 <!--  统计分析系统开始    -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img3" id="img3"
										src="./images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onclick="list('3');">统计分析</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table id="subtree3" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<tr>
						<td width="9%" height="20"><img id="xiaotu9"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="sendxiaoxi.htm" target="mainFrame"
							class="left-font03" onclick="tupian('9');">用户统计</a></td>
					</tr>
					<tr>
						<td width="9%" height="20"><img id="xiaotu10"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="listtakexiaoxi.htm"
							target="mainFrame" class="left-font03" onclick="tupian('10');">题库下载统计</a></td>
					</tr>
					<tr>
						<td width="9%" height="20"><img id="xiaotu11"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="listsendxiaoxi.htm"
							target="mainFrame" class="left-font03" onclick="tupian('11');">收藏统计
						</a></td>
					</tr>
					<tr>
						<td width="9%" height="20"><img id="xiaotu12"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="listxiaoxi.htm" target="mainFrame"
							class="left-font03" onclick="tupian('12');">笔记统计 </a></td>
					</tr>
					<tr>
						<td width="9%" height="20"><img id="xiaotu13"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="listxiaoxi.htm" target="mainFrame"
							class="left-font03" onclick="tupian('13');">分享统计 </a></td>
					</tr>
					<tr>
						<td width="9%" height="20"><img id="xiaotu14"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="listxiaoxi.htm" target="mainFrame"
							class="left-font03" onclick="tupian('14');">学习记录统计 </a></td>
					</tr>
				</table> <!--  统计分析系统结束    -->
				
				
				 <!--  用户留言系统开始    -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img4" id="img4"
										src="./images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onclick="list('4');">用户留言</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table id="subtree4" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<tr>
						<td width="9%" height="20"><img id="xiaotu15"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="sendxiaoxi.htm" target="mainFrame"
							class="left-font03" onclick="tupian('15');">用户留言列表</a></td>
					</tr>
				</table> <!--  用户留言系统结束    -->
				
				 <!--  答疑广场系统开始    -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img5" id="img5"
										src="./images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onclick="list('5');">答疑广场</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table id="subtree5" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<tr>
						<td width="9%" height="20"><img id="xiaotu16"
							src="./images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="sendxiaoxi.htm" target="mainFrame"
							class="left-font03" onclick="tupian('16');">答疑问题列表</a></td>
					</tr>
				</table> <!--  答疑广场系统结束    -->
				
			</td>
		</tr>
	</table>
</body>
</html>
