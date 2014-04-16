package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Multichoice;

/**
 * 
 * 项目名称：ExamHelper 类名称：IMultiChoiceDao 类描述： 针对多选题的有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface IMultiChoiceDao extends IBasicDao {
	
	
	/**根据章节得到题目列表
	 * @param pageNow
	 * @param sectionId
	 * @return
	 */
	public List getMultiChoiceBySection(int pageNow, int sectionId);
	
	 
	/**求出按页查询时，通过按章节查询的方式得到的多项选择题共有几页
	 * @param section
	 * @return
	 */
	public int getPageCountBySection( int sectionId);


	/**根据科目得到多选题
	 * @param pageNow
	 * @param subjectId
	 * @return
	 */
	public List getMultiChoiceBySubject(int pageNow, int subjectId);
	
	/**根据每个科目得到多选题
	 * @param subjectId
	 * @return
	 */
	public int getPageCountBySubject( int subjectId);

	/**
	 * Method getMultichoiceByStem 根据多选题题干得到多选题
	 * 
	 * @param questionStem
	 * @param pageNow
	 * @return List
	 */
	public List getMultiChoiceByStem(String questionStem, int pageNow);
	/**
	 * Method getPageCountByStem
	 * 根据题干得到共有多少页的Multichoice信息
	 * 
	 * @param questionStem
	 * @return pageCount
	 */
	public int getPageCountByStem( String questionStem);
	
	/**显示具个项选择题
	 * @param multiChoiceId
	 * @return
	 */
	public Multichoice showMultichoice(int multiChoiceId);
	/**
	 * Method delMultichoice 删除多选题
	 * 
	 * @param multichoiceId
	 * @return void
	 */
	public void delMultiChoice(int multichoiceId);
	/**
	 * Method addMultichoice 添加多选题
	 * 
	 * @param multichoice
	 * @return void
	 */
	public void addMultiChoice(Multichoice multichoice);
	/**修改多选题
	 * @param multichoice
	 */
	public void updateMultiChoice(Multichoice multichoice);
}
