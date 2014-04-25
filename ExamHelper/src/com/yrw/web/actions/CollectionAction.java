package com.yrw.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yrw.domains.Examguidetype;
import com.yrw.domains.Scollection;
import com.yrw.service.CollectionService;
import com.yrw.service.SubjectService;

public class CollectionAction extends DispatchAction {

	private CollectionService collectionService;
	private SubjectService subjectService;

	public void setCollectionService(CollectionService collectionService) {
		this.collectionService = collectionService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
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

		List<Scollection> scollectionList = collectionService.getScollectionListByPageNow(pageNow);
		request.setAttribute("scollectionList", scollectionList);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		return mapping.findForward("showCollection");
	}
}
