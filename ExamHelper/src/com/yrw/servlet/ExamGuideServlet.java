package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsonobjects.JExamGuide;
import com.jsonobjects.JExamGuideType;
import com.yrw.service.ExamGuideService;
import com.yrw.tools.FastJsonTools;

public class ExamGuideServlet extends BaseServlet {

	private static final long serialVersionUID = 109174335439235076L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";
		System.out.println("lalsjdfo");

		// ��ȡϵͳ��ҵ���߼����
		ExamGuideService examGuideService = (ExamGuideService) getApplicationContext().getBean("examGuideService");
		String type = request.getParameter("type");

		// ����ǻ�ȡ����ָ��Ŀ¼�б�
		if (type.equals("getExamGuideList")) {
			int examTypeId = Integer.parseInt(request.getParameter("examTypeId"));
			List<JExamGuide> jExamGuides = examGuideService.getExamGuideListByTypeId(examTypeId);
			msg = FastJsonTools.createJsonString(jExamGuides);
		}

		// ����Ǹ�������ID��ȡ�����б�
		else if (type.equals("getExamGuideTypeList")) {
			System.out.println(request.getParameter("subjectId"));
			int subjectId = Integer.parseInt(request.getParameter("subjectId"));
			List<JExamGuideType> jExamGuideTypes = examGuideService.getExamGuideTypeListBySubjectId(subjectId);
			msg = FastJsonTools.createJsonString(jExamGuideTypes);
		}

		out.write(msg);
		out.flush();
		out.close();
	}

}
