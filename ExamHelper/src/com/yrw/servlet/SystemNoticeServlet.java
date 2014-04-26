package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrw.domains.Systemnotice;
import com.yrw.service.SystemNoticeService;
import com.yrw.tools.FastJsonTools;

public class SystemNoticeServlet extends BaseServlet {

//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset = utf-8");
//		response.setCharacterEncoding("utf-8");
//		request.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		String msg = "";
//
//		// ��ȡϵͳ��ҵ���߼����
//		SystemNoticeService noticeService = (SystemNoticeService) getApplicationContext().getBean("systemNoticeService");
//
//		Systemnotice systemnotice = noticeService.getCurrentNotice();
//
//		if (systemnotice != null) {
//			msg = FastJsonTools.createJsonString(systemnotice);
//		}
//
//		out.write(msg);
//		out.flush();
//		out.close();
//	}
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		SystemNoticeService noticeService = (SystemNoticeService) getApplicationContext().getBean("systemNoticeService");
	
			Systemnotice systemnotice = noticeService.getSystemnoticeByMaxTime();
		System.out.println(systemnotice);
	}
}
