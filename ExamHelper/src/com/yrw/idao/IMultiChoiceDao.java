package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Multichoice;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�IMultiChoiceDao �������� ��Զ�ѡ����йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface IMultiChoiceDao extends IBasicDao {
	
	
	/**�����½ڵõ���Ŀ�б�
	 * @param pageNow
	 * @param sectionId
	 * @return
	 */
	public List getMultiChoiceBySection(int pageNow, int sectionId);
	
	 
	/**�����ҳ��ѯʱ��ͨ�����½ڲ�ѯ�ķ�ʽ�õ��Ķ���ѡ���⹲�м�ҳ
	 * @param section
	 * @return
	 */
	public int getPageCountBySection( int sectionId);


	/**���ݿ�Ŀ�õ���ѡ��
	 * @param pageNow
	 * @param subjectId
	 * @return
	 */
	public List getMultiChoiceBySubject(int pageNow, int subjectId);
	
	/**����ÿ����Ŀ�õ���ѡ��
	 * @param subjectId
	 * @return
	 */
	public int getPageCountBySubject( int subjectId);

	/**
	 * Method getMultichoiceByStem ���ݶ�ѡ����ɵõ���ѡ��
	 * 
	 * @param questionStem
	 * @param pageNow
	 * @return List
	 */
	public List getMultiChoiceByStem(String questionStem, int pageNow);
	/**
	 * Method getPageCountByStem
	 * ������ɵõ����ж���ҳ��Multichoice��Ϣ
	 * 
	 * @param questionStem
	 * @return pageCount
	 */
	public int getPageCountByStem( String questionStem);
	
	/**��ʾ�߸���ѡ����
	 * @param multiChoiceId
	 * @return
	 */
	public Multichoice showMultichoice(int multiChoiceId);
	/**
	 * Method delMultichoice ɾ����ѡ��
	 * 
	 * @param multichoiceId
	 * @return void
	 */
	public void delMultiChoice(int multichoiceId);
	/**
	 * Method addMultichoice ��Ӷ�ѡ��
	 * 
	 * @param multichoice
	 * @return void
	 */
	public void addMultiChoice(Multichoice multichoice);
	/**�޸Ķ�ѡ��
	 * @param multichoice
	 */
	public void updateMultiChoice(Multichoice multichoice);
}
