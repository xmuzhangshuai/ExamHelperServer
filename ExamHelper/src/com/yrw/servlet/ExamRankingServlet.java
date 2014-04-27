package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsonobjects.JScollection;
import com.yrw.domains.Scollection;
import com.yrw.domains.Serrorquestions;
import com.yrw.service.CollectionService;
import com.yrw.service.ErrorQuestionService;
import com.yrw.service.QueryService;
import com.yrw.tools.FastJsonTools;

public class ExamRankingServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";

		// ��ȡϵͳ�߼����
		CollectionService collectionService = (CollectionService) getApplicationContext().getBean("collectionService");
		ErrorQuestionService errorQuestionService = (ErrorQuestionService) getApplicationContext().getBean(
				"errorQuestionService");

		// ��ȡ����
		String type = request.getParameter("type");

		if (type != null) {

			// ����Ǹ����û�ID���ش����б�
			if (type.equals("getScollection")) {
				// ��ȡҳ��
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
		}

		out.write(msg);
		out.flush();
		out.close();
	}
}
