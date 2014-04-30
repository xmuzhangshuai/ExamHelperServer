package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsonobjects.JSingleChoice;
import com.yrw.service.UpdateLibraryService;
import com.yrw.tools.FastJsonTools;

/**
 * �����ƣ�UpdateLibraryServlet ���������û�����ϸ��� �����ˣ� ��˧ ����ʱ�䣺2014��4��29�� ����10:57:07
 */
public class UpdateLibraryServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";
		// ��ȡϵͳ��ҵ���߼����
		UpdateLibraryService updateLibraryService = (UpdateLibraryService) getApplicationContext().getBean(
				"updateLibraryService");

		String type = request.getParameter("type");

		if (type != null) {
			// ����Ǽ�����
			if (type.equals("check")) {
				String jsonString = request.getParameter("data");
				List<Map<String, Object>> data = FastJsonTools.createJsonToListMap(jsonString);

				// ����и��£�����SectionList
				if (updateLibraryService.checkUpdate(data)) {
					int subjectId = Integer.parseInt((String) data.get(0).get("subjectId"));
					msg = FastJsonTools.createJsonString(updateLibraryService.getJSections(subjectId));
				}
			}
			// ��������ظ���
			else if (type.equals("get")) {
				int subjectId = Integer.parseInt(request.getParameter("subjectId"));
				String questionType = request.getParameter("questionType");
				// ����ǵ�ѡ��
				if (questionType.equals("singleChoice")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJSingleChoices(subjectId));
				}
				// ����Ƕ�ѡ��
				else if (questionType.equals("multiChoice")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJMultiChoices(subjectId));
				}

				// ����ǲ�����
				else if (questionType.equals("materialAnalisis")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJMaterias(subjectId));
				}

				// ����ǲ�����С��
				else if (questionType.equals("questionOfMateria")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJQuestionsOfMaterial(subjectId));
				}

				// ������Ծ�
				else if (questionType.equals("examination")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJExaminationList(subjectId));
				}

				// ������Ծ����
				else if (questionType.equals("examSection")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJExamSectionList(subjectId));
				}

				// ������Ծ���Ŀ
				else if (questionType.equals("examQuestion")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJExamQuestionList(subjectId));
				}
			}
		}

		out.write(msg);
		out.flush();
		out.close();
	}

}
