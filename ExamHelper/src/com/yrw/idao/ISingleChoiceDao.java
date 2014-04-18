package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Singlechoice;

/**
 * 
 * 项目名称：ExamHelper 类名称：ISingleChoiceDao 类描述： 针对科目的有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface ISingleChoiceDao extends IBasicDao {
	
	/**
	 * Method addSingleChoice 增加某条
	 * 
	 * @param singleChoice
	 * @return void
	 */
	public void addSingleChoice(Singlechoice singlechoice);
	
	/**删除单选题
	 * @param object
	 */
	public void delSingleChoice(Object object); 
	
	
	/**
	 * Method getSingleChoiceBySection 根据章节得到单选题集
	 * 
	 * @param sectionId
	 * @param pageNow
	 * @return List
	 */
	public List getSingleChoiceBySection(int pageNow, int sectionId);
	/**
	 * Method getPageCountBySection 获取共有多少页的SingleChoice信息
	 * 
	 * @param sectionId
	 * @return pageCount
	 */
	public int getPageCountBySection(int sectionId);

	/**根据科目得到单选题
	 * @param pageNow
	 * @param subjectId
	 * @return
	 */
	public List getSingleChoiceBySubject(int pageNow,int subjectId);
	
	/**根据科目得到的单选题的页数
	 * @param subjectId
	 * @return
	 */
	public int getPageCountBySubject(int subjectId);
	/**
	 * 根据关键字查询得到共有多少页的SingleChoice信息
	 * 
	 * @param singleChoiceName
	 * @return pageCount
	 */
	public int getPageCountByName(String singleChoiceName);

	/**
	 * Method keyWordSearch 关键字查找
	 * 
	 * @param String
	 *            singleChoiceName
	 * @return void
	 */
	public List getSingleChoiceByName(String singleChoiceName, int pageNow);
	/**显示具体的某个单选题
	 * @param singleChoiceId
	 * @return
	 */
	public Singlechoice showSinglechoice(int singleChoiceId);
	/**修改选择题
	 * @param singlechoice
	 */
	public void updateSinglechoice(Singlechoice singlechoice);
}
