package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Examination;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�IExaminationDao �������� ����Ծ���йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface IExaminationDao extends IBasicDao {

	/**
	 * Method getExam �õ��Ծ��б�
	 * 
	 * @param pageNow
	 * @return exams
	 */
	public List getExam(int pageNow);

	/**
	 * Method getpageCount �����Ծ��б�ҳ��
	 * 
	 * @return pageCount
	 */
	public int getPageCount();

	/**
	 * Method getExamByName ͨ�����ֲ��ҵ��Ծ�
	 * 
	 * @param examName
	 * @param pageNow
	 * @return exams
	 */
	public List getExamByName(String examName, int pageNow);

	/**
	 * Method getPageCountByName
	 * 
	 * @param examName
	 * @return pageCount
	 */
	public int getPageCountByName(String examName);

	/**
	 * Method getExamBySubject �õ�ĳ����Ŀ�������Ծ��б�
	 * 
	 * @param pageNow
	 * @param subjectId
	 * @return exams
	 */
	public List getExamBySubject(int subjectId, int pageNow);

	/**
	 * Method getPageCountBySubject
	 * 
	 * @param subjectId
	 * @return pageCount
	 */
	public int getPageCountBySubject(int subjectId);

	/**
	 * Method addExam
	 * 
	 * @param examId
	 * @return List
	 */
	public List showExam(int examId);

	/**
	 * Method addExam
	 * 
	 * @param examination
	 */
	public void addExam(Examination examination);

	/**
	 * Method delExam
	 * 
	 * @param examination
	 */
	public void delExam(Examination examination);
	/**
	 * Method delExams
	 * 
	 * @param examination
	 */
	public void delExam(List<Examination> examinations);
	/**
	 * Method delExam
	 * 
	 * @param examination
	 */
	public void modifyExam(Examination examination);
	

}
