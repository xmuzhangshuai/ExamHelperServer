<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>出错了</TITLE>
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px;
	FONT-FAMILY: Tahoma;
	BACKGROUND-COLOR: #f7f7f7;
}

TD {
	FONT-SIZE: 12px;
	FONT-FAMILY: Tahoma
}

A:link {
	COLOR: #636363;
	TEXT-DECORATION: none
}

A:visited {
	COLOR: #838383;
	TEXT-DECORATION: none
}

A:hover {
	COLOR: #a3a3a3;
	TEXT-DECORATION: underline
}

</STYLE>

</HEAD>
<BODY style="TABLE-LAYOUT: fixed; WORD-BREAK: break-all" >
	<TABLE height="95%" cellSpacing=0 cellPadding=0 width="100%" bgcolor="#f7f7f7"
		align=center border=0>
		<TBODY  style="background-color: #f7f7f7">
			<TR vAlign=center align=middle bgcolor="#f7f7f7">
				<TD bgcolor="#f7f7f7">
					<TABLE cellSpacing=0 cellPadding=0 width=468 bgColor=#ffffff
						border=0>
						<TBODY>
							<TR>
								<TD width=20 background="images/rbox_1.gif" height=20></TD>
								<TD width=108 background="images/rbox_2.gif" height=20></TD>
								<TD width=56><IMG height=20 src="images/rbox_ring.gif"
									width=56></TD>
								<TD width=100 background="images/rbox_2.gif"></TD>
								<TD width=56><IMG height=20 src="images/rbox_ring.gif"
									width=56></TD>
								<TD width=108 background="images/rbox_2.gif"></TD>
								<TD width=20 background="images/rbox_3.gif" height=20></TD>
							</TR>
							<TR>
								<TD align=left background="images/rbox_4.gif" rowSpan=2></TD>
								<TD align=middle bgColor=#eeeeee colSpan=5 height=50>
									<P style="font-size: 20px">
										<br>
										<strong>———出错啦！———<br><br> </strong>
									</P>
								</TD>
								<TD align=left background="images/rbox_6.gif" rowSpan=2></TD>
							</TR>
							<TR>
								<TD align=left colSpan=5 height=80>
									<P align=center><br>
									<P id=LID2>错误原因</P>
									<UL>
										<LI id=list1 style="padding-bottom: 5px;">您所查看的页面无法浏览或不错在<BR>
										<LI id=list1 style="padding-bottom: 5px;">输入网址不正确<BR>
										<LI id=list1 style="padding-bottom: 5px;">页面重定向或程序出错<BR>
										<LI id=list2 style="padding-bottom: 5px;">转到 <A href="./Welcome.jsp" target="mainFrame">欢迎页面</A>
										<LI id=list3 style="padding-bottom: 5px;">单击<A href="javascript:history.back(1)">后退</A>按钮，尝试其他链接。
										</LI>
									</UL>
									<DIV align=right>
										<BR> 考试助手
									</DIV>
								</TD>
							</TR>
							<TR>
								<TD align=left background="images/rbox_7.gif" height=20></TD>
								<TD align=left background="images/rbox_8.gif" colSpan=5
									height=20></TD>
								<TD align=left background="images/rbox_9.gif" height=20></TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
</BODY>
</HTML>

