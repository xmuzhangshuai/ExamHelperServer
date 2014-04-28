/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yrw.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yrw.domains.Answerquery;
import com.yrw.domains.Query;
import com.yrw.service.QueryService;

/**
 * 类名称：QueryAction 类描述： 创建人： 张帅 创建时间：2014年4月22日 下午11:09:08
 */
public class QueryAction extends DispatchAction {
	private QueryService queryService;

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	/**
	 * Method execute 展示疑问列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward showQueryList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int pageNow = 1;
		int pageCount = queryService.getQueryPageCount();
		String pageNowString = request.getParameter("pageNow");
		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;
		}

		List<Query> querieList = queryService.getJQueryListByPage(pageNow - 1);
		request.setAttribute("queryList", querieList);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		return mapping.findForward("querySquare");
	}

	/**
	 * 根据点击的疑问显示回答详情
	 */
	public ActionForward showQueryDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		int aPageNow = 1;
		int pageNow = 1;
		pageNow = Integer.parseInt(request.getParameter("pageNow"));

		int queryId = Integer.parseInt(request.getParameter("id"));
		int aPageCount = queryService.getAnswerQueryPageCount(queryId);
		String pageNowString = request.getParameter("aPageNow");
		if (pageNowString != null) {
			aPageNow = Integer.parseInt(pageNowString);
			if (aPageNow < 1)
				aPageNow = 1;
			else if (aPageNow > aPageCount)
				aPageNow = aPageCount;
		}

		Query query = queryService.getQueryByID(queryId);
		if (query != null) {
			request.setAttribute("query", query);
			request.setAttribute("id", queryId);
			request.setAttribute("answerqueryList", query.getAnswerqueries());
			request.setAttribute("aPageCount", aPageCount);
			request.setAttribute("aPageNow", aPageNow);
			request.setAttribute("pageNow", pageNow);
		}
		return mapping.findForward("queryDetail");
	}

}
