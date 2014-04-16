package com.yrw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrw.domains.Errorquestions;
import com.yrw.service.ErrorQuestionService;
import com.yrw.tools.FastJsonTools;

/**
 * ��������¼
 * 
 * @author ��˧
 * 
 */
public class ErrorQuestionServlet extends BaseServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		// ����
		String errorQuestionString = request.getParameter("errorQuestion");
		com.jsonobjects.JErrorQuestions net = FastJsonTools.createJsonBean(errorQuestionString,
				com.jsonobjects.JErrorQuestions.class);

		// ת��Ϊ���ش���Errorquestions
		Errorquestions local = net.NetToLocal();
		ErrorQuestionService errorQuestionService = (ErrorQuestionService) getApplicationContext().getBean(
				"errorQuestionService");
		errorQuestionService.addErrorQuestion(local);
	}

}
