package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrw.domains.Systemnotice;
import com.yrw.service.SystemNoticeService;
import com.yrw.tools.FastJsonTools;

/**
 * 类名称：SystemNoticeServlet
 * 类描述：系统公告
 * 创建人： 张帅
 * 创建时间：2014年4月27日 上午9:18:59
 */
public class SystemNoticeServlet extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";

		// 获取系统的业务逻辑组件
		SystemNoticeService noticeService = (SystemNoticeService) getApplicationContext()
				.getBean("systemNoticeService");

		Systemnotice systemnotice = noticeService.getCurrentNotice();

		if (systemnotice != null) {
			msg = FastJsonTools.createJsonString(systemnotice);
		}

		out.write(msg);
		out.flush();
		out.close();
	}

}
