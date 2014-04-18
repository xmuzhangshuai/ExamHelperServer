package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Singlechoice;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�ISingleChoiceDao �������� ��Կ�Ŀ���йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface ISingleChoiceDao extends IBasicDao {
	
	/**
	 * Method addSingleChoice ����ĳ��
	 * 
	 * @param singleChoice
	 * @return void
	 */
	public void addSingleChoice(Singlechoice singlechoice);
	
	/**ɾ����ѡ��
	 * @param object
	 */
	public void delSingleChoice(Object object); 
	
	
	/**
	 * Method getSingleChoiceBySection �����½ڵõ���ѡ�⼯
	 * 
	 * @param sectionId
	 * @param pageNow
	 * @return List
	 */
	public List getSingleChoiceBySection(int pageNow, int sectionId);
	/**
	 * Method getPageCountBySection ��ȡ���ж���ҳ��SingleChoice��Ϣ
	 * 
	 * @param sectionId
	 * @return pageCount
	 */
	public int getPageCountBySection(int sectionId);

	/**���ݿ�Ŀ�õ���ѡ��
	 * @param pageNow
	 * @param subjectId
	 * @return
	 */
	public List getSingleChoiceBySubject(int pageNow,int subjectId);
	
	/**���ݿ�Ŀ�õ��ĵ�ѡ���ҳ��
	 * @param subjectId
	 * @return
	 */
	public int getPageCountBySubject(int subjectId);
	/**
	 * ���ݹؼ��ֲ�ѯ�õ����ж���ҳ��SingleChoice��Ϣ
	 * 
	 * @param singleChoiceName
	 * @return pageCount
	 */
	public int getPageCountByName(String singleChoiceName);

	/**
	 * Method keyWordSearch �ؼ��ֲ���
	 * 
	 * @param String
	 *            singleChoiceName
	 * @return void
	 */
	public List getSingleChoiceByName(String singleChoiceName, int pageNow);
	/**��ʾ�����ĳ����ѡ��
	 * @param singleChoiceId
	 * @return
	 */
	public Singlechoice showSinglechoice(int singleChoiceId);
	/**�޸�ѡ����
	 * @param singlechoice
	 */
	public void updateSinglechoice(Singlechoice singlechoice);
}
