package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsonobjects.JErrorQuestions;
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

	private static final long serialVersionUID = 866465795529169652L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";

		ErrorQuestionService errorQuestionService = (ErrorQuestionService) getApplicationContext().getBean(
				"errorQuestionService");

		// ��ȡ����
		String type = request.getParameter("type");

		// �������Ӵ���
		if (type == null) {
			// ����
			String errorQuestionString = request.getParameter("errorQuestion");
			JErrorQuestions net = FastJsonTools.createJsonBean(errorQuestionString, JErrorQuestions.class);

			// ת��Ϊ���ش���Errorquestions
			Errorquestions local = net.NetToLocal();
			errorQuestionService.addErrorQuestion(local);
		}

		// ����Ǹ����û�ID���ش����б�
		else if (type.equals("getErrorListByUser")) {
			Integer userID = Integer.parseInt(request.getParameter("userId"));

			List<JErrorQuestions> temp = new ArrayList<JErrorQuestions>();
			List<Errorquestions> errorquestionList = errorQuestionService.getErrorquestionsByUser(userID);
			if (errorquestionList != null) {
				for (Errorquestions errorquestions : errorquestionList) {
					JErrorQuestions jErrorQuestion = JErrorQuestions.LocalToNet(errorquestions);
					temp.add(jErrorQuestion);
				}
				msg = FastJsonTools.createJsonString(temp);
			}
		}

		out.write(msg);
		out.flush();
		out.close();
	}

}
