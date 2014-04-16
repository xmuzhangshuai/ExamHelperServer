package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Section;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�ISectionDao �������� ����½ڵ����ݿ���� �����ˣ�Ҷ��� ����ʱ�䣺2014-03-17 �޸��ˣ�
 * �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface ISectionDao extends IBasicDao {

	/**ͨ���½����ƻ���½ڶ���
	 * @param sectionName
	 * @return
	 */
	public Section getSectoinByName(String sectionName);
	
	/**ͨ��subjectId�õ�����section
	 * @param subjectId
	 * @return
	 */
	public List getSectionBySubjectId(int subjectId);
	
	/**��ȡĳ��section
	 * @param sectionId
	 * @return
	 */
	public Section getSectionById(int sectionId);
	/**
	 * Method getSectionBySubect���ݿ�Ŀ������ʾ�½�
	 * 
	 * @param pageNow
	 * @param subjectId
	 * @return List
	 */
	public List getSectionBySubject(int pageNow, int subjectId);

	/**
	 * ���ݿ�Ŀ���ƻ�ȡ���ж���ҳ��section��Ϣ
	 * 
	 * @param subjectId
	 * @return pageCount
	 */
	public int getPageCountBySubject(int subjectId);

	
	/**����section
	 * @param section
	 */
	public void updateSection(Section section);

	/**
	 * ɾ���½�
	 * 
	 * @param JSection
	 * @return void
	 */
	public void delSection(Section section);

	/**
	 * �����½�
	 * 
	 * @param JSection
	 * @return void
	 */
	public void addSection(Section section);
	
	/**ͨ��section�����ּ�subjectId�õ�section
	 * @param sectionName
	 * @param subjectName
	 * @return
	 */
	public Section getSectionByNameAndSubId(String sectionName,int subjectId);

}
