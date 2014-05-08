package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Examquestion;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�IExamQuestionDao �������� ����Ծ�������йز����Ľӿ��࣬�̳���IBasicDao
 * �����ˣ�Ҷ��� ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface IExamQuestionDao extends IBasicDao {

	/**
	 * Method getExamQuestionBySection �õ��Ծ�����µ�С���б�
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
	 * Method addExamQuestion �����Ծ�����µ�С��
	 * 
	 * @param examquestion
	 * @return void
	 */
	public void addExamQuestion(Examquestion examquestion);

	/**
	 * Method addExamQuestion ɾ���Ծ�����µ�С��
	 * 
	 * @param Examquestion
	 * @return void
	 */
	public void delExamQuestion(Examquestion examquestion);

	/**
	 * Method delExamQuestions ɾ�������Ծ�����µ�С��
	 * 
	 * @param Examquestion
	 * @return void
	 */
	public void delExamQuestions(List<Examquestion> examquestions);

	/**
	 * Method modifyExamQuestion �޸��Ծ�����µ�С��
	 * 
	 * @param Examquestion
	 * @return void
	 */
	public void modifyExamQuestion(Examquestion examquestion);
	
	
	/**�õ�ĳ�����͵���Ŀ�µ�����Ŀ��
	 * @param examSectionId
	 * @return
	 */
	public int getMaxQuestionNumberByExamSection(int examSectionId);
	/**��������
	 * @param examQuestionId
	 */
	public void updateQuestionNumber(int examQuestionId,int questionNumber);
	/**
	 * @param examquestion
	 * @return
	 */
	public int addQuestionNumberWithReturn(Examquestion examquestion);
}
