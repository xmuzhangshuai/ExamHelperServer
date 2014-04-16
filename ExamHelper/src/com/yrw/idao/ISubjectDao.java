package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Subject;

/**
 * 
 * 项目名称：ExamHelper 类名称：ISubjectDao 类描述： 针对科目的有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注： z
 * 
 * @version
 * 
 */
public interface ISubjectDao extends IBasicDao {

	/**通过名字得到subject对象
	 * @param subjectName
	 * @return
	 */
	public Subject getSubjectByName(String subjectName);
	/**通过subjectId得到subject对象
	 * @param subjectId
	 * @return
	 */
	public Subject getSubjectById(int subjectId);
	/**
	 * Method getSubject 显示所有科目
	 * 
	 * @return List
	 */
	public List getSubject();

	/**
	 * Method getSubject 分页显示所有科目
	 * 
	 * @param pageNow
	 * @return List
	 */
	public List getSubject(int pageNow);

	/**
	 * @param subjectId
	 * @return
	 */
	public Subject getQuniqueSubject(int subjectId);

	/**
	 * 获取共有多少页的subject信息
	 * 
	 * @return pageCount
	 */
	public int getPageCount();

	/**
	 * 根据关键字查询得到共有多少页的subject信息
	 * 
	 * @param Name
	 * @return pageCount
	 */
	public int getPageCountLikeName(String Name);

	/**
	 * Method keyWordSearch 关键字查找
	 * 
	 * @param Name
	 * @param pageNow
	 * @return void
	 */
	public List getSubjectLikeName(String Name, int pageNow);

	/**通过科目名称得到subject对象
	 * @param subjectName
	 * @return
	 */
	public int getSubjectIdByName(String subjectName);
	/**
	 * Method delSubject 删除
	 * 
	 * @param subjectId
	 * @return void
	 */
	public void delSubject(int subjectId);

	/**
	 * Method delSubjects 删除多个subjects
	 * 
	 * @param subjectId
	 * @return void
	 */
	public void delSubjects(String params);

	/**
	 * Method delSubject 增加subject
	 * 
	 * @param subject
	 * @return void
	 */
	public void addSubject(Subject subject);
	/**
	 * Method modifySubject 修改subject
	 * 
	 * @param subject
	 * @return void
	 */
	public void modifySubject(Subject subject);

}
