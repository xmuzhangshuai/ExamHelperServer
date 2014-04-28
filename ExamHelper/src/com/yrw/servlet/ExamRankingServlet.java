package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsonobjects.JScollection;
import com.jsonobjects.JSerrorQuestion;
import com.yrw.domains.Scollection;
import com.yrw.domains.Serrorquestions;
import com.yrw.service.CollectionService;
import com.yrw.service.ErrorQuestionService;
import com.yrw.tools.FastJsonTools;

public class ExamRankingServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";

		// 获取系统逻辑组件
		CollectionService collectionService = (CollectionService) getApplicationContext().getBean("collectionService");
		ErrorQuestionService errorQuestionService = (ErrorQuestionService) getApplicationContext().getBean(
				"errorQuestionService");

		// 获取类型
		String type = request.getParameter("type");

		if (type != null) {

			// 如果是返回收藏列表
			if (type.equals("getScollection")) {
				// 获取页数
				int pageNow = Integer.parseInt(request.getParameter("pageNow").trim());
				List<JScollection> jScollections = new ArrayList<JScollection>();
				List<Scollection> scollections = collectionService.getSCollectionListByPageNow(pageNow + 1);
				if (scollections != null) {
					for (Scollection scollection : scollections) {
						JScollection jScollection = new JScollection(scollection.getId(), scollection.getQuestiontype()
								.getId(), scollection.getSection().getId(), scollection.getQuestionId(),
								scollection.getCollectionNum());
						jScollections.add(jScollection);
					}
					msg = FastJsonTools.createJsonString(jScollections);
				}
			}

			// 如果是返回错题列表
			if (type.equals("getSerrors")) {
				// 获取页数
				int pageNow = Integer.parseInt(request.getParameter("pageNow").trim());
				List<JSerrorQuestion> jSerrorQuestionList = new ArrayList<JSerrorQuestion>();
				List<Serrorquestions> serrorquestionList = errorQuestionService.getSErrorQuestionListByPageNow(pageNow);
				if (serrorquestionList != null) {
					for (Serrorquestions serrorquestion : serrorquestionList) {
						JSerrorQuestion jSerrorQuestion = new JSerrorQuestion(serrorquestion.getId(), serrorquestion
								.getQuestiontype().getId(), serrorquestion.getSection().getId(),
								serrorquestion.getQuestionId(), serrorquestion.getErrorNum());
						jSerrorQuestionList.add(jSerrorQuestion);
					}
					msg = FastJsonTools.createJsonString(jSerrorQuestionList);
				}
			}

		}
		out.write(msg);
		out.flush();
		out.close();
	}
}
