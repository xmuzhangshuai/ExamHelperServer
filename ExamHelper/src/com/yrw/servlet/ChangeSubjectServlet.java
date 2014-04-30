package com.yrw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsonobjects.JSubject;
import com.yrw.domains.Subject;
import com.yrw.service.SubjectService;
import com.yrw.service.UpdateLibraryService;
import com.yrw.tools.FastJsonTools;

public class ChangeSubjectServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";

		// 获取系统逻辑组件
		SubjectService subjectService = (SubjectService) getApplicationContext().getBean("subjectService");
		List<JSubject> jSubjectList = new ArrayList<JSubject>();
		List<Subject> subjects = subjectService.getSubjects();
		if (subjects != null) {
			for (Subject subject : subjects) {
				jSubjectList.add(JSubject.LocalToNet(subject));
			}
			msg = FastJsonTools.createJsonString(jSubjectList);
		}

		out.write(msg);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";
		// 获取系统的业务逻辑组件
		UpdateLibraryService updateLibraryService = (UpdateLibraryService) getApplicationContext().getBean(
				"updateLibraryService");
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		String questionType = request.getParameter("questionType");
		if (questionType != null) {
			// 如果是章节
			if (questionType.equals("section")) {
				msg = FastJsonTools.createJsonString(updateLibraryService.getJSections(subjectId));
			}

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

		out.write(msg);
		out.flush();
		out.close();
	}

}
