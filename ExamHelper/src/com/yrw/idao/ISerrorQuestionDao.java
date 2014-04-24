package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Errorquestions;
import com.yrw.domains.Serrorquestions;

public interface ISerrorQuestionDao extends IBasicDao {

	public void addSerrorQuestion(Serrorquestions serrorquestions);

	public void deleteSerrorQuestion(Serrorquestions serrorquestions);

	/**
	 * 根据问题类型及问题Id得到Serrorquestion对象
	 * 
	 * @param questionTypeId
	 * @param questionId
	 * @return
	 */
	public Serrorquestions getSerrorquestions(int questionTypeId, int questionId);

	/**
	 * 分页返回所有的错题统计情况
	 * 
	 * @return
	 */
	public List<Serrorquestions> getSerrorquestions();

	/**
	 * 错题统计情况共有多少页
	 * 
	 * @param pageNow
	 * @return
	 */
	public int getPageCount(int pageNow);

	/**
	 * 分页返回通过章节Id查找到错题信息统计
	 * 
	 * @param sectionId
	 * @param pageNow
	 * @return
	 */
	public List<Serrorquestions> getSerrorquestionsBySectionId(int sectionId,
			int pageNow);

	/**
	 * 通过章节Id查找到错题信息统计共有多少页
	 * 
	 * @param sectionId
	 * @return
	 */
	public int getPageCountBySectionId(int sectionId);

	/**
	 * 分页返回通过问题类型查找得到的错题信息统计
	 * 
	 * @param questionTypeId
	 * @param pageNow
	 * @return
	 */
	public List<Serrorquestions> getSerrorquestionsByQuestionTypeId(
			int questionTypeId, int pageNow);

	/**
	 * 通过问题类型查找得到的错题信息统计共有多少页
	 * 
	 * @param questionTypeId
	 * @return
	 */
	public int getPageCountByQuestionTypeId(int questionTypeId);
}
