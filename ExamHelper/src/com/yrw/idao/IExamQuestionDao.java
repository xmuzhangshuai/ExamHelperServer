package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Examquestion;

/**
 * 
 * 项目名称：ExamHelper 类名称：IExamQuestionDao 类描述： 针对试卷问题的有关操作的接口类，继承了IBasicDao
 * 创建人：叶睿雯 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface IExamQuestionDao extends IBasicDao {

	/**
	 * Method getExamQuestionBySection 得到试卷大题下的小题列表
	 * 
	 * @param examSectionId
	 * @param pageNow
	 * @return List
	 */
	public List getExamQuestionBySection(int examSectionId, int pageNow);

	/**
	 * Method pageCountBySection
	 * 
	 * @param examSectionId
	 * @return pageCount
	 */
	public int getPageCountBySection(int examSectionId);

	/**
	 * Method addExamQuestion 增加试卷大题下的小题
	 * 
	 * @param examquestion
	 * @return void
	 */
	public void addExamQuestion(Examquestion examquestion);

	/**
	 * Method addExamQuestion 删除试卷大题下的小题
	 * 
	 * @param Examquestion
	 * @return void
	 */
	public void delExamQuestion(Examquestion examquestion);

	/**
	 * Method delExamQuestions 删除多条试卷大题下的小题
	 * 
	 * @param Examquestion
	 * @return void
	 */
	public void delExamQuestions(List<Examquestion> examquestions);

	/**
	 * Method modifyExamQuestion 修改试卷大题下的小题
	 * 
	 * @param Examquestion
	 * @return void
	 */
	public void modifyExamQuestion(Examquestion examquestion);
	
	
	/**得到某个类型的题目下的总题目数
	 * @param examSectionId
	 * @return
	 */
	public int getMaxQuestionNumberByExamSection(int examSectionId);
	/**更新数量
	 * @param examQuestionId
	 */
	public void updateQuestionNumber(int examQuestionId,int questionNumber);
	/**
	 * @param examquestion
	 * @return
	 */
	public int addQuestionNumberWithReturn(Examquestion examquestion);
}
