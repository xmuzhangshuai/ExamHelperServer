package com.yrw.idao;

import java.util.List;

import com.yrw.dao.TrueOrFalseDao;
import com.yrw.domains.Trueorfalse;

/**
 * 
 * 项目名称：ExamHelper 类名称：ITrueOrFalseDao 类描述： 针对对错题的有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface ITrueOrFalseDao extends IBasicDao {



	
	/**通过章节得到对于判断题
	 * @param pageNow
	 * @param sectionId
	 * @return
	 */
	public List getTrueOrFalseBySection(int pageNow,int sectionId);

	/**
	 * 获取共有多少页的TrueOrFalse信息
	 * 
	 * @param  sectionId
	 * @return pageCount
	 */
	public int getPageCountBySection(int sectionId);

	/**根据科目得到对应题型
	 * @param pageNow
	 * @param subjectId
	 * @return
	 */
	public List getTrueOrFalseBySubject(int pageNow, int subjectId);

	
	/**根据科目得到对于题型页数
	 * @param subjectId
	 * @return
	 */
	public int getPageCountBySubject(int subjectId);
	/**
	 * 根据题干查询得到共有多少页的TrueOrFalse信息
	 * 
	 * @param stem
	 * @param int
	 */
	public int getPageCountByStem(String stem);

	/**
	 * Method getTrueOrFalseByStem 根据题干查找
	 * 
	 * @param stem
	 * @return List
	 */
	public List getTrueOrFalseByStem(String stem, int pageNow);

	/**显示具体某个判断题
	 * @param trueOrFalseId
	 * @return
	 */
	public Trueorfalse showTrueorfalse(int trueOrFalseId);
	
	/**删除判断题
	 * @param object
	 */
	public void delTrueOrFalse(Object object);

	/**
	 * 添加判断题
	 * 
	 * @param trueorfalse
	 */
	public void addTrueOrFalse(Trueorfalse trueorfalse);

	/**修改判断题
	 * @param trueorfalse
	 */
	public void updateTrueOrFalse(Trueorfalse trueorfalse);

}
