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

		// ��ȡϵͳ�߼����
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
		// ��ȡϵͳ��ҵ���߼����
		UpdateLibraryService updateLibraryService = (UpdateLibraryService) getApplicationContext().getBean(
				"updateLibraryService");
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		String questionType = request.getParameter("questionType");
		if (questionType != null) {
			// ������½�
			if (questionType.equals("section")) {
				msg = FastJsonTools.createJsonString(updateLibraryService.getJSections(subjectId));
			}

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

		out.write(msg);
		out.flush();
		out.close();
	}

}
