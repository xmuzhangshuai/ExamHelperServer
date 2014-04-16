package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Subject;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�ISubjectDao �������� ��Կ�Ŀ���йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע�� z
 * 
 * @version
 * 
 */
public interface ISubjectDao extends IBasicDao {

	/**ͨ�����ֵõ�subject����
	 * @param subjectName
	 * @return
	 */
	public Subject getSubjectByName(String subjectName);
	/**ͨ��subjectId�õ�subject����
	 * @param subjectId
	 * @return
	 */
	public Subject getSubjectById(int subjectId);
	/**
	 * Method getSubject ��ʾ���п�Ŀ
	 * 
	 * @return List
	 */
	public List getSubject();

	/**
	 * Method getSubject ��ҳ��ʾ���п�Ŀ
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
	 * ��ȡ���ж���ҳ��subject��Ϣ
	 * 
	 * @return pageCount
	 */
	public int getPageCount();

	/**
	 * ���ݹؼ��ֲ�ѯ�õ����ж���ҳ��subject��Ϣ
	 * 
	 * @param Name
	 * @return pageCount
	 */
	public int getPageCountLikeName(String Name);

	/**
	 * Method keyWordSearch �ؼ��ֲ���
	 * 
	 * @param Name
	 * @param pageNow
	 * @return void
	 */
	public List getSubjectLikeName(String Name, int pageNow);

	/**ͨ����Ŀ���Ƶõ�subject����
	 * @param subjectName
	 * @return
	 */
	public int getSubjectIdByName(String subjectName);
	/**
	 * Method delSubject ɾ��
	 * 
	 * @param subjectId
	 * @return void
	 */
	public void delSubject(int subjectId);

	/**
	 * Method delSubjects ɾ�����subjects
	 * 
	 * @param subjectId
	 * @return void
	 */
	public void delSubjects(String params);

	/**
	 * Method delSubject ����subject
	 * 
	 * @param subject
	 * @return void
	 */
	public void addSubject(Subject subject);
	/**
	 * Method modifySubject �޸�subject
	 * 
	 * @param subject
	 * @return void
	 */
	public void modifySubject(Subject subject);

}
