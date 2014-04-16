package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrw.tools.FastJsonTools;

public class ExamGuideServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		ExamGuideService examGuideService = new ExamGuideService();
		String msg = "";

		List<ExamGuideType> examGuideTypes = examGuideService.getExamGuideTypeList();
		msg = FastJsonTools.createJsonString(examGuideTypes);

		out.write(msg);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		Long typeId = Long.parseLong(request.getParameter("ExamGuideTypeId"));

		ExamGuideService examGuideService = new ExamGuideService();

		String msg = "";

		List<ExamGuide> examGuides = examGuideService.getExamGuideList(typeId);
		msg = FastJsonTools.createJsonString(examGuides);

		out.write(msg);
		out.flush();
		out.close();
	}
}
