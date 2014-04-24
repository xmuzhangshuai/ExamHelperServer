package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Errorquestions;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�IErrorQuestionDao �������� ��Դ�����йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */

public interface IErrorQuestionDao extends IBasicDao {

	public List getErrorQuestions();

	/**
	 * ���ĳ���û������д���
	 * 
	 * @param userId
	 * @return
	 */
	public List getErrorQuestionByUser(int userId);

	/**
	 * Method getErrorQuestionCountByUser ��ȡĳλ�û�������Ϣ���ж���ҳ��
	 * 
	 * @param userId
	 * @return int
	 */
	public int getErrorQuestionCountByUser(int userId);

	/**
	 * Method getErrorQuestionByUser ��ҳ�õ�ĳλ�û�����
	 * 
	 * @param userId
	 * @param pageNow
	 * @return List
	 */
	public List getErrorQuestionByUser(int userId, int pageNow);

	/**
	 * Method addErrorQuestion ���Ӵ���
	 * 
	 * @param errorquestions
	 */
	public void addErrorQuestion(Errorquestions errorquestions);

	/**
	 * ��Ӷ��ErrorQuestion
	 * 
	 * @param errorquestionsList
	 */
	public void addErrorQuestionList(List<Errorquestions> errorquestionsList);

	
	/**
	 * Method delErrorQuestion
	 * 
	 * @param errorquestions
	 */
	public void delErrorQuestions(List<Errorquestions> errorQuestionList);
}
