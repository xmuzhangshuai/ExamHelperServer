package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Answerquery;

/**
 * 
 * 项目名称：ExamHelper 类名称：IAnswerQueryDao 类描述： 针对问题回答有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface IAnswerQueryDao extends IBasicDao {

	/**
	 * 得到所有的回答信息，按时间排序
	 * 
	 * @param pageNow
	 * @return List
	 */
	public List getAnswerQuery(int pageNow);

	/**
	 * 得到回答信息呈现时需要的页数
	 * 
	 * @return int
	 */
	public int getPageCount();

	/**
	 * Method getAnswerQueryByUserId
	 * 
	 * @param pageNow
	 * @param userId
	 * @return
	 */
	public List getAnswerQueryByUserId(int pageNow, int userId);

	/**
	 * @param userId
	 * @return
	 */
	public int getPageCountByUserId(int userId);

	/**
	 * @param queryId
	 * @param pageNow
	 * @return
	 */
	public List getAnswerQueryByQueryId(int queryId, int pageNow);

	/**
	 * 分局疑问ID返回回答列表
	 * 
	 * @param queryId
	 * @return
	 */
	public List<Answerquery> getAnswerQueryByQueryId(int queryId);

//	/**
//	 * 根据用户和疑问返回回答列表
//	 * @param userId
//	 * @param queryId
//	 * @return
//	 */
//	public List<Answerquery> getAnswerqueriesByUserAndQuery(int userId, int queryId);

	/**
	 * @param queryId
	 * @return
	 */
	public int getPageCountByQueryId(int queryId);

	/**
	 * 显示具体某条信息
	 * 
	 * @param answerQueryId
	 * @return Answerquery
	 */
	public Answerquery showAnswerQuery(int answerQueryId);

	/**
	 * @param answerquery
	 */
	public void addAnswerQuery(Answerquery answerquery);

	/**
	 * @param answerqueryId
	 */
	public void delAnswerQuery(int answerqueryId);

	/**
	 * 同时删除多条信息
	 * 
	 * @param answerqueryIds
	 */
	public void delAnswerQuerys(List<Integer> answerqueryIds);

	/**
	 * @param answerquery
	 */
	public void modifyAnswerQuery(Answerquery answerquery);
}
