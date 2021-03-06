package com.yrw.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Multichoice;
import com.yrw.domains.Questiontype;
import com.yrw.domains.Scollection;
import com.yrw.domains.Singlechoice;
import com.yrw.domains.Subject;
import com.yrw.service.CollectionService;
import com.yrw.service.QuestionService;
import com.yrw.service.SubjectService;

public class CollectionAction extends DispatchAction {

	private CollectionService collectionService;
	private QuestionService questionService;
	private SubjectService subjectService;

	public void setCollectionService(CollectionService collectionService) {
		this.collectionService = collectionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	/**
	 * 显示收藏列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showCollectionList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int pageNow = 1;
		int pageCount = collectionService.getSCollectionListPageCount();
		String pageNowString = request.getParameter("pageNow");
		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;
		}
		List<String> questionStemList = new ArrayList<String>();
		List<Scollection> scollectionList = collectionService.getSCollectionListByPageNow(pageNow);
		if (scollectionList != null) {
			for (Scollection scollection : scollectionList) {
				questionStemList.add(getQuestionName(scollection.getQuestionId(), scollection.getQuestiontype()
						.getTypeName()));
			}
		}

		List<Subject> subjectList = subjectService.getSubjects();
		List<Questiontype> questiontypeList = questionService.showQuestiontypes();

		request.setAttribute("scollectionList", scollectionList);
		request.setAttribute("questionStemList", questionStemList);
		request.setAttribute("questiontypeList", questiontypeList);
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		return mapping.findForward("showCollection");
	}

	/**
	 * 查找显示列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward searchCollectionList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int pageNow = 1;
		int pageCount = 0;

		List<String> questionStemList = new ArrayList<String>();
		List<Scollection> scollectionList = new ArrayList<Scollection>();
		List<Subject> subjectList = subjectService.getSubjects();
		List<Questiontype> questiontypeList = questionService.showQuestiontypes();
		String type = request.getParameter("type");
		int index = Integer.parseInt(request.getParameter("index"));
		if (type != null) {
			if (type.equals("subject")) {
				int subjectId = subjectList.get(index).getId();
				pageCount = collectionService.getSCollectionListPageCountBySubject(subjectId);
				String pageNowString = request.getParameter("pageNow");
				if (pageNowString != null) {
					pageNow = Integer.parseInt(pageNowString);
					if (pageNow < 1)
						pageNow = 1;
					else if (pageNow > pageCount)
						pageNow = pageCount;
				}
				scollectionList = collectionService.getSCollectionListBySubject(subjectId, pageNow);
			} else if (type.equals("questionType")) {
				int questionTypeId = questiontypeList.get(index).getId();
				pageCount = collectionService.getSCollectionListPageCountByQuestionType(questionTypeId);
				String pageNowString = request.getParameter("pageNow");
				if (pageNowString != null) {
					pageNow = Integer.parseInt(pageNowString);
					if (pageNow < 1)
						pageNow = 1;
					else if (pageNow > pageCount)
						pageNow = pageCount;
				}

				scollectionList = collectionService.getSCollectionListByQuestionType(pageNow, questionTypeId);
			}

		}

		if (scollectionList != null) {
			for (Scollection scollection : scollectionList) {
				questionStemList.add(getQuestionName(scollection.getQuestionId(), scollection.getQuestiontype()
						.getTypeName()));
			}
		}

		request.setAttribute("scollectionList", scollectionList);
		request.setAttribute("questionStemList", questionStemList);
		request.setAttribute("questiontypeList", questiontypeList);
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		return mapping.findForward("showCollection");
	}

	/**
	 * 根据ID返回question
	 * 
	 * @return
	 */
	public String getQuestionName(int questionID, String questionType) {
		Object object = questionService.getQuestion(questionID, questionType);
		if (object.getClass().equals(Singlechoice.class)) {
			Singlechoice singlechoice = (Singlechoice) object;
			return singlechoice.getQuestionStem();
		} else if (object.getClass().equals(Multichoice.class)) {
			Multichoice multichoice = (Multichoice) object;
			return multichoice.getQuestionStem();
		} else if (object.getClass().equals(Materialanalysis.class)) {
			Materialanalysis materialanalysis = (Materialanalysis) object;
			if (materialanalysis.getMaterial().length() >= 100) {
				return materialanalysis.getMaterial().substring(0, 100) + "...";
			} else {
				return materialanalysis.getMaterial();
			}
		}
		return null;
	}
}
