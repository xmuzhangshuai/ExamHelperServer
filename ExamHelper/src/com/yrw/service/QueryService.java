package com.yrw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yrw.domains.Answerquery;
import com.yrw.domains.Query;
import com.yrw.idao.IAnswerQueryDao;
import com.yrw.idao.IQueryDao;

/**
 * 针对疑问广场的操作
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
	 * 根据页码返回疑问列表
	 * 
	 * @author 张帅
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
	 * 根据疑问ID返回回答列表
	 * 
	 * @author 张帅
	 * @param queryID
	 * @return
	 */
	public List<Answerquery> getAnswerListByQueryID(int queryID) {
		return iAnswerQueryDao.getAnswerQueryByQueryId(queryID);
	}

	/**
	 * 根据用户id分页返回疑问列表 张帅
	 * 
	 * @author 张帅
	 * @param userId
	 * @param pageNowString
	 * @return
	 */
	public List<Query> getQueryByUserId(int userId, int pageNow) {
		pageNow++;
		int pageCount = iQueryDao.getPageCountByUser(userId);
		if (pageNow < 1)
			pageNow = 1;
		else if (pageNow > pageCount)
			pageNow = pageCount;

		List<Query> queryList = iQueryDao.getQueryByUser(userId, pageNow);

		return queryList;
	}

	/**
	 * 根据用户ID分页返回回答
	 * 
	 * @author 张帅
	 * @param userId
	 * @param pageNow
	 * @return
	 */
	public List<Answerquery> getAnswerQueryByUserId(int userId, int pageNow) {
		pageNow++;
		int pageCount = iAnswerQueryDao.getPageCountByUserId(userId);

		if (pageNow < 1)
			pageNow = 1;
		else if (pageNow > pageCount)
			pageNow = pageCount;

		List<Answerquery> answerQueryList = iAnswerQueryDao.getAnswerQueryByUserId(pageNow, userId);

		return answerQueryList;
	}

	/**
	 * 根据疑问ID返回疑问
	 * 
	 * @author张帅
	 * @param queryID
	 * @return
	 */
	public Query getQueryByID(int queryID) {
		return (Query) iQueryDao.findById(Query.class, queryID);
	}

	/**
	 * 根据疑问ID返回回答列表数量
	 * 
	 * @author张帅
	 * @param queryID
	 * @return
	 */
	public int getAnswerCountByQueryID(int queryID) {
		List<Answerquery> temp = iAnswerQueryDao.getAnswerQueryByQueryId(queryID);
		if (temp == null) {
			return 0;
		}
		return temp.size();
	}

	/**
	 * 返回某个疑问某个用户的所有回答
	 * 
	 * @author张帅
	 * @param userId
	 * @param queryId
	 * @return
	 */
	public List<Answerquery> getAnswerQueriesByUserAndQuery(int userId, int queryId) {
		List<Answerquery> temp = new ArrayList<Answerquery>();
		List<Answerquery> byQuery = iAnswerQueryDao.getAnswerQueryByQueryId(queryId);
		for (Answerquery answerquery : byQuery) {
			if (answerquery.getUser().getId() == userId) {
				temp.add(answerquery);
			}
		}
		return temp;
	}

	/**
	 * 根据疑问ID返回回答页码
	 * @param queryId
	 * @return
	 */
	public int getAnswerQueryPageCount(int queryId){
		return iAnswerQueryDao.getPageCountByQueryId(queryId);
	}
	
	/**
	 * 罗列所有疑问
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
	
	public int getQueryPageCount(){
		return iQueryDao.getPageCount();
	}

	/**
	 * 根据提问内容得到疑问列表
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
	 * 根据用户id得到所有疑问列表
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
	 * 根据被采用答案的用户id得到疑问列表
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
	 * 显示某条疑问的具体内容及所有回答
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
	 * 得到某个用户的所有回答
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

	/**
	 * @param query
	 */
	public void addQuery(Query query) {
		iQueryDao.addQuery(query);
	}

	/**
	 * 
	 * @param answerquery
	 */
	public void addAnswerQuery(Answerquery answerquery) {
		iAnswerQueryDao.addAnswerQuery(answerquery);
	}
	
	/**
	 * 删除疑问
	 * @param queryId
	 */
	public void deleteQuery(int queryId){
		iQueryDao.delQuery(queryId);
	}
	
	/**
	 * 删除疑问
	 * @param queryId
	 */
	public void deleteQueryAnswer(int answerId){
		iAnswerQueryDao.delAnswerQuery(answerId);
	}
}
