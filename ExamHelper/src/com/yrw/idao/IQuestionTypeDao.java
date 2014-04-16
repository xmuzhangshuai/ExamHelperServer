package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Questiontype;

/**
 * 
 * 项目名称：ExamHelper 类名称：IQuestioTypeDao 类描述： 针对问题类型的数据库操作,继承IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-17 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface IQuestionTypeDao extends IBasicDao {

	/**获得所有QuestionTYpe
	 * @return
	 */
	public List getQuestionTypes();

	/**
	 * 通过id获得
	 * 
	 * @param id
	 * @return
	 */
	public Questiontype getQuestiontypeById(int id);

	/**
	 * 显示章节
	 * 
	 * @param pageNow
	 * @return List
	 */
	public List getQuestionType(int pageNow);

	/**
	 * 获取共有多少页的section信息
	 * 
	 * @return pageCount
	 */
	public int getPageCount();

	/**
	 * 修改问题类型名称
	 * 
	 * @param questionTypeId
	 * @return void
	 */
	public void modifyQuestionTypeName(int questionTypeId);

	/**
	 * Method delQuestionType删除问题类型
	 * 
	 * @param questionTypeId
	 * @return void
	 */
	public void delQuestionType(Questiontype questiontype);

	/**
	 * 增加问题类型
	 * 
	 * @param questiontype
	 * @return void
	 */
	public void addQuestionType(Questiontype questiontype);

}
