package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Errorquestions;

/**
 * 
 * 项目名称：ExamHelper 类名称：IErrorQuestionDao 类描述： 针对错题的有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */

public interface IErrorQuestionDao extends IBasicDao {

	public List getErrorQuestions();

	/**
	 * 获得某个用户的所有错题
	 * 
	 * @param userId
	 * @return
	 */
	public List getErrorQuestionByUser(int userId);

	/**
	 * Method getErrorQuestionCountByUser 获取某位用户错题信息共有多少页的
	 * 
	 * @param userId
	 * @return int
	 */
	public int getErrorQuestionCountByUser(int userId);

	/**
	 * Method getErrorQuestionByUser 分页得到某位用户错题
	 * 
	 * @param userId
	 * @param pageNow
	 * @return List
	 */
	public List getErrorQuestionByUser(int userId, int pageNow);

	/**
	 * Method addErrorQuestion 增加错题
	 * 
	 * @param errorquestions
	 */
	public void addErrorQuestion(Errorquestions errorquestions);

	/**
	 * 添加多个ErrorQuestion
	 * 
	 * @param errorquestionsList
	 */
	public void addErrorQuestionList(List<Errorquestions> errorquestionsList);

	
	/**
	 * Method delErrorQuestion
	 * 
	 * @param errorquestions
	 */
	public void delErrorQuestions(List<Errorquestions> errorQuestionList);
}
