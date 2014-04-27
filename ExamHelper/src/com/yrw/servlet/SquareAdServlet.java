package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrw.service.AdImagesService;
import com.yrw.tools.FastJsonTools;

public class SquareAdServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";

		// 获取系统的业务逻辑组件
		AdImagesService adImagesService = (AdImagesService) getApplicationContext().getBean("adImagesService");

		List<String> iamgeUrlList = adImagesService.getAdImageUrlListByTime();
		if (iamgeUrlList != null) {
			msg = FastJsonTools.createJsonString(iamgeUrlList);
		}
		out.write(msg);
		out.flush();
		out.close();
	}
}
