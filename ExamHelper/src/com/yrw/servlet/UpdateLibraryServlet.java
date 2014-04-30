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
 * 类名称：UpdateLibraryServlet 类描述：用户检查更细题库 创建人： 张帅 创建时间：2014年4月29日 上午10:57:07
 */
public class UpdateLibraryServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";
		// 获取系统的业务逻辑组件
		UpdateLibraryService updateLibraryService = (UpdateLibraryService) getApplicationContext().getBean(
				"updateLibraryService");

		String type = request.getParameter("type");

		if (type != null) {
			// 如果是检查更新
			if (type.equals("check")) {
				String jsonString = request.getParameter("data");
				List<Map<String, Object>> data = FastJsonTools.createJsonToListMap(jsonString);

				// 如果有更新，返回SectionList
				if (updateLibraryService.checkUpdate(data)) {
					int subjectId = Integer.parseInt((String) data.get(0).get("subjectId"));
					msg = FastJsonTools.createJsonString(updateLibraryService.getJSections(subjectId));
				}
			}
			// 如果是下载更新
			else if (type.equals("get")) {
				int subjectId = Integer.parseInt(request.getParameter("subjectId"));
				String questionType = request.getParameter("questionType");
				// 如果是单选题
				if (questionType.equals("singleChoice")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJSingleChoices(subjectId));
				}
				// 如果是多选题
				else if (questionType.equals("multiChoice")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJMultiChoices(subjectId));
				}

				// 如果是材料题
				else if (questionType.equals("materialAnalisis")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJMaterias(subjectId));
				}

				// 如果是材料题小题
				else if (questionType.equals("questionOfMateria")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJQuestionsOfMaterial(subjectId));
				}

				// 如果是试卷
				else if (questionType.equals("examination")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJExaminationList(subjectId));
				}

				// 如果是试卷答题
				else if (questionType.equals("examSection")) {
					msg = FastJsonTools.createJsonString(updateLibraryService.getJExamSectionList(subjectId));
				}

				// 如果是试卷题目
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
