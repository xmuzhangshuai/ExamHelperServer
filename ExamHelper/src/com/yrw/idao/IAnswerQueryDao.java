package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Answerquery;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�IAnswerQueryDao �������� �������ش��йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface IAnswerQueryDao extends IBasicDao {

	/**
	 * �õ����еĻش���Ϣ����ʱ������
	 * 
	 * @param pageNow
	 * @return List
	 */
	public List getAnswerQuery(int pageNow);

	/**
	 * �õ��ش���Ϣ����ʱ��Ҫ��ҳ��
	 * 
	 * @return int
	 */
	public int getPageCount();

	/**
	 * Method getAnswerQueryByUserId
	 * 
	 * @param pageNow
	 * @param userId
	 * @return
	 */
	public List getAnswerQueryByUserId(int pageNow, int userId);

	/**
	 * @param userId
	 * @return
	 */
	public int getPageCountByUserId(int userId);

	/**
	 * @param queryId
	 * @param pageNow
	 * @return
	 */
	public List getAnswerQueryByQueryId(int queryId, int pageNow);

	/**
	 * �־�����ID���ػش��б�
	 * 
	 * @param queryId
	 * @return
	 */
	public List<Answerquery> getAnswerQueryByQueryId(int queryId);

//	/**
//	 * �����û������ʷ��ػش��б�
//	 * @param userId
//	 * @param queryId
//	 * @return
//	 */
//	public List<Answerquery> getAnswerqueriesByUserAndQuery(int userId, int queryId);

	/**
	 * @param queryId
	 * @return
	 */
	public int getPageCountByQueryId(int queryId);

	/**
	 * ��ʾ����ĳ����Ϣ
	 * 
	 * @param answerQueryId
	 * @return Answerquery
	 */
	public Answerquery showAnswerQuery(int answerQueryId);

	/**
	 * @param answerquery
	 */
	public void addAnswerQuery(Answerquery answerquery);

	/**
	 * @param answerqueryId
	 */
	public void delAnswerQuery(int answerqueryId);

	/**
	 * ͬʱɾ��������Ϣ
	 * 
	 * @param answerqueryIds
	 */
	public void delAnswerQuerys(List<Integer> answerqueryIds);

	/**
	 * @param answerquery
	 */
	public void modifyAnswerQuery(Answerquery answerquery);
}
