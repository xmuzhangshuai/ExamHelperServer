package com.yrw.idao;

import java.util.Date;
import java.util.List;

import com.yrw.domains.Query;

/**
 * 
 * 项目名称：ExamHelper 类名称：IQueryDao 类描述： 针对疑问的有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public interface IQueryDao extends IBasicDao {

	/**
	 * Method getQuery 得到疑问列表
	 * 
	 * @param pageNow
	 * @return List
	 * 
	 */
	public List getQuery(int pageNow);

	

	/**
	 * Method getQueryByUser 得到某位用户的提问列表
	 * 
	 * @param pageNow
	 * @param userId
	 * @return List
	 */
	public List getQueryByUser(int userId, int pageNow);

	/**
	 * Method getQueryByQueryStem 通过问题题干得到疑问列表
	 * 
	 * @param pageNow
	 * @param queryStem
	 * @return List
	 */
	public List getQueryByQueryStem(String queryStem, int pageNow);
	
	/**根据采用答案的客户id获取疑问列表
	 * @param adoptUserId
	 * @param pageNow
	 * @return
	 */
	public List getQueryByAdoptUserId(int adoptUserId,int pageNow);

	
	/**根据采用答案的客户id获取的问题共有页数
	 * @param adoptUserId
	 * @return
	 */
	public int getPageCountByAdoptUserId(int adoptUserId);
	/**
	 * Method getPageCountByUser 根据用户id获取的疑问共有多少页的
	 * 
	 * @param userId
	 * @return pageCount
	 */
	public int getPageCountByUser(int userId);

	/**
	 * Method getPageCountByQueryStem 根据题干查询得到共有多少页的query信息
	 * 
	 * @param String
	 *            questionStem
	 * @return pageCount
	 */
	public int getPageCountByQueryStem(String queryStem);

	

	/**
	 * Method getPageCount 共有疑问列表的页数
	 * 
	 * 
	 * @return pageCount
	 */
	public int getPageCount();

	/**
	 * Method addQuery 增加疑问信息
	 * 
	 * @param query
	 */
	public void addQuery(Query query);

	/**
	 * Method addQuery 删除错题信息
	 * 
	 * @param queryId
	 * @return void
	 */
	public void delQuery(int queryId);
	
	/**修改疑问
	 * @param query
	 */
	public void modifyQuery(Query query);
	
	/**具体显示某条疑问
	 * @param queryId
	 * @return
	 */
	public Query showQuery(int queryId);
	
	/**
	 * 根据用户昵称返回疑问列表
	 * @return
	 */
	public List<Query> getQueryListByName(String name);
}
