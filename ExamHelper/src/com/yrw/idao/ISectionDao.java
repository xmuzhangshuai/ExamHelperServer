package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Section;

/**
 * 
 * 项目名称：ExamHelper 类名称：ISectionDao 类描述： 针对章节的数据库操作 创建人：叶睿雯 创建时间：2014-03-17 修改人：
 * 修改时间： 修改备注：
 * 
 * @version
 * 
 */
public interface ISectionDao extends IBasicDao {

	/**通过章节名称获得章节对象
	 * @param sectionName
	 * @return
	 */
	public Section getSectoinByName(String sectionName);
	
	/**通过subjectId得到所有section
	 * @param subjectId
	 * @return
	 */
	public List getSectionBySubjectId(int subjectId);
	
	/**获取某个section
	 * @param sectionId
	 * @return
	 */
	public Section getSectionById(int sectionId);
	/**
	 * Method getSectionBySubect根据科目名称显示章节
	 * 
	 * @param pageNow
	 * @param subjectId
	 * @return List
	 */
	public List getSectionBySubject(int pageNow, int subjectId);

	/**
	 * 根据科目名称获取共有多少页的section信息
	 * 
	 * @param subjectId
	 * @return pageCount
	 */
	public int getPageCountBySubject(int subjectId);

	
	/**更新section
	 * @param section
	 */
	public void updateSection(Section section);

	/**
	 * 删除章节
	 * 
	 * @param JSection
	 * @return void
	 */
	public void delSection(Section section);

	/**
	 * 增加章节
	 * 
	 * @param JSection
	 * @return void
	 */
	public void addSection(Section section);
	
	/**通过section的名字及subjectId得到section
	 * @param sectionName
	 * @param subjectName
	 * @return
	 */
	public Section getSectionByNameAndSubId(String sectionName,int subjectId);

}
