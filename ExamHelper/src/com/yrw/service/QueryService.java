package com.yrw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsonobjects.JQuerys;
import com.yrw.domains.Answerquery;
import com.yrw.domains.Query;
import com.yrw.idao.IAnswerQueryDao;
import com.yrw.idao.IQueryDao;

/**
 * ������ʹ㳡�Ĳ���
 * 
 * @author Administrator
 * 
 */
public class QueryService {

	private IQueryDao iQueryDao;
	private IAnswerQueryDao iAnswerQueryDao;

	public void setiQueryDao(IQueryDao iQueryDao) {
		this.iQueryDao = iQueryDao;
	}

	public void setiAnswerQueryDao(IAnswerQueryDao iAnswerQueryDao) {
		this.iAnswerQueryDao = iAnswerQueryDao;
	}

	/**
	 * ����ҳ�뷵�������б�
	 * 
	 * @author ��˧
	 * @param pageNow
	 * @return
	 */
	public List<Query> getJQueryListByPage(int pageNow) {
		pageNow++;
		List<Query> temp = new ArrayList<Query>();
		int pageCount = iQueryDao.getPageCount();
		if (pageNow < 1)
			pageNow = 1;
		else if (pageNow > pageCount)
			pageNow = pageCount;

		temp = iQueryDao.getQuery(pageNow);

		return temp;
	}

	/**
	 * ��������ID���ػش��б�
	 * 
	 * @author ��˧
	 * @param queryID
	 * @return
	 */
	public List<Answerquery> getAnswerListByQueryID(int queryID) {
		List<Answerquery> temp = new ArrayList<Answerquery>();

		return temp;
	}

	/**
	 * ������������
	 * 
	 * @param pageNowString
	 * @return
	 */
	public List getQueryList(String pageNowString) {
		int pageNow = 1;
		int pageCount = iQueryDao.getPageCount();
		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;

		}
		List queryList = iQueryDao.getQuery(pageNow);

		Map<String, Integer> map = new HashMap();
		map.put("pageCount", pageCount);
		map.put("pageNow", pageNow);

		List collection = new ArrayList();
		collection.add(map);
		collection.add(queryList);

		return collection;
	}

	/**
	 * �����������ݵõ������б�
	 * 
	 * @param queryStem
	 * @param pageNowString
	 * @return
	 */
	public List getQueryByQueryStem(String queryStem, String pageNowString) {
		int pageNow = 1;
		int pageCount = iQueryDao.getPageCountByQueryStem(queryStem);
		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;

		}
		List queryList = iQueryDao.getQueryByQueryStem(queryStem, pageNow);

		Map<String, Integer> map = new HashMap();
		map.put("pageCount", pageCount);
		map.put("pageNow", pageNow);

		List collection = new ArrayList();
		collection.add(map);
		collection.add(queryList);

		return collection;
	}

	/**
	 * �����û�id�õ����������б�
	 * 
	 * @param userId
	 * @param pageNowString
	 * @return
	 */
	public List getQueryByUserId(int userId, String pageNowString) {
		int pageNow = 1;
		int pageCount = iQueryDao.getPageCountByUser(userId);
		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;

		}
		List queryList = iQueryDao.getQueryByUser(userId, pageNow);

		Map<String, Integer> map = new HashMap();
		map.put("pageCount", pageCount);
		map.put("pageNow", pageNow);

		List collection = new ArrayList();
		collection.add(map);
		collection.add(queryList);

		return collection;
	}

	/**
	 * ���ݱ����ô𰸵��û�id�õ������б�
	 * 
	 * @param adoptUserId
	 * @param pageNowString
	 * @return
	 */
	public List getQueryByAdoptUserID(int adoptUserId, String pageNowString) {
		int pageNow = 1;
		int pageCount = iQueryDao.getPageCountByAdoptUserId(adoptUserId);
		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;

		}
		List queryList = iQueryDao.getQueryByAdoptUserId(adoptUserId, pageNow);

		Map<String, Integer> map = new HashMap();

		map.put("pageCount", pageCount);
		map.put("pageNow", pageNow);

		List collection = new ArrayList();
		collection.add(map);
		collection.add(queryList);

		return collection;
	}

	/**
	 * ��ʾĳ�����ʵľ������ݼ����лش�
	 * 
	 * @param queryId
	 * @param pageNowString
	 * @return
	 */
	public List showQuery(int queryId, String pageNowString) {

		int pageNow = 1;
		int pageCount = iAnswerQueryDao.getPageCountByQueryId(queryId);

		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;

		}

		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("pageCount", pageCount);
		pageMap.put("pageNow", pageNow);

		Query query = iQueryDao.showQuery(queryId);

		List answerQueryList = iAnswerQueryDao.getAnswerQueryByQueryId(queryId, pageNow);

		List collection = new ArrayList();
		collection.add(pageMap);
		collection.add(query);
		collection.add(answerQueryList);

		return collection;
	}

	/**
	 * �õ�ĳ���û������лش�
	 * 
	 * @param userId
	 * @param pageNow
	 * @return
	 */
	public List getAnswerQueryByUserId(int userId, String pageNowString) {
		int pageNow = 1;
		int pageCount = iAnswerQueryDao.getPageCountByUserId(userId);

		if (pageNowString != null) {
			pageNow = Integer.parseInt(pageNowString);
			if (pageNow < 1)
				pageNow = 1;
			else if (pageNow > pageCount)
				pageNow = pageCount;

		}

		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("pageCount", pageCount);
		pageMap.put("pageNow", pageNow);

		List answerQueryList = iAnswerQueryDao.getAnswerQueryByUserId(pageNow, userId);

		List collection = new ArrayList();
		collection.add(pageMap);
		collection.add(answerQueryList);

		return collection;
	}

	public void addQuery(Query query) {
		iQueryDao.addQuery(query);
	}
}
