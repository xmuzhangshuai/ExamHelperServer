package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Errorquestions;
import com.yrw.domains.Serrorquestions;

public interface ISerrorQuestionDao extends IBasicDao {

	public void addSerrorQuestion(Serrorquestions serrorquestions);

	public void deleteSerrorQuestion(Serrorquestions serrorquestions);

	/**
	 * �����������ͼ�����Id�õ�Serrorquestion����
	 * 
	 * @param questionTypeId
	 * @param questionId
	 * @return
	 */
	public Serrorquestions getSerrorquestions(int questionTypeId, int questionId);

	/**
	 * ��ҳ�������еĴ���ͳ�����
	 * 
	 * @return
	 */
	public List<Serrorquestions> getSerrorquestions(int pageNow);

	/**
	 * ����ͳ��������ж���ҳ
	 * 
	 * @param pageNow
	 * @return
	 */
	public int getPageCount();

	/**
	 * ��ҳ����ͨ���½�Id���ҵ�������Ϣͳ��
	 * 
	 * @param sectionId
	 * @param pageNow
	 * @return
	 */
	public List<Serrorquestions> getSerrorquestionsBySectionId(int sectionId,
			int pageNow);

	/**
	 * ͨ���½�Id���ҵ�������Ϣͳ�ƹ��ж���ҳ
	 * 
	 * @param sectionId
	 * @return
	 */
	public int getPageCountBySectionId(int sectionId);

	/**
	 * ��ҳ����ͨ���������Ͳ��ҵõ��Ĵ�����Ϣͳ��
	 * 
	 * @param questionTypeId
	 * @param pageNow
	 * @return
	 */
	public List<Serrorquestions> getSerrorquestionsByQuestionTypeId(
			int questionTypeId, int pageNow);

	/**
	 * ͨ���������Ͳ��ҵõ��Ĵ�����Ϣͳ�ƹ��ж���ҳ
	 * 
	 * @param questionTypeId
	 * @return
	 */
	public int getPageCountByQuestionTypeId(int questionTypeId);
	/**ͨ����Ŀ�õ��������ͳ�ƣ�����ҳ����
	 * @param subjectId
	 * @param pageNow
	 * @return
	 */
	public List<Serrorquestions> getSerrorquestionsBySubjectId(int subjectId,int pageNow);
	/**ͨ����Ŀ��ѯ�õ��Ĵ�����Ϣͳ�ƹ���ҳ��
	 * @param subjectId
	 * @return
	 */
	public int getPageCountBySubejectId(int subjectId);
}