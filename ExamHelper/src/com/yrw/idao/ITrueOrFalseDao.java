package com.yrw.idao;

import java.util.List;

import com.yrw.dao.TrueOrFalseDao;
import com.yrw.domains.Trueorfalse;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�ITrueOrFalseDao �������� ��ԶԴ�����йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface ITrueOrFalseDao extends IBasicDao {



	
	/**ͨ���½ڵõ������ж���
	 * @param pageNow
	 * @param sectionId
	 * @return
	 */
	public List getTrueOrFalseBySection(int pageNow,int sectionId);

	/**
	 * ��ȡ���ж���ҳ��TrueOrFalse��Ϣ
	 * 
	 * @param  sectionId
	 * @return pageCount
	 */
	public int getPageCountBySection(int sectionId);

	/**���ݿ�Ŀ�õ���Ӧ����
	 * @param pageNow
	 * @param subjectId
	 * @return
	 */
	public List getTrueOrFalseBySubject(int pageNow, int subjectId);

	
	/**���ݿ�Ŀ�õ���������ҳ��
	 * @param subjectId
	 * @return
	 */
	public int getPageCountBySubject(int subjectId);
	/**
	 * ������ɲ�ѯ�õ����ж���ҳ��TrueOrFalse��Ϣ
	 * 
	 * @param stem
	 * @param int
	 */
	public int getPageCountByStem(String stem);

	/**
	 * Method getTrueOrFalseByStem ������ɲ���
	 * 
	 * @param stem
	 * @return List
	 */
	public List getTrueOrFalseByStem(String stem, int pageNow);

	/**��ʾ����ĳ���ж���
	 * @param trueOrFalseId
	 * @return
	 */
	public Trueorfalse showTrueorfalse(int trueOrFalseId);
	
	/**ɾ���ж���
	 * @param object
	 */
	public void delTrueOrFalse(Object object);

	/**
	 * ����ж���
	 * 
	 * @param trueorfalse
	 */
	public void addTrueOrFalse(Trueorfalse trueorfalse);

	/**�޸��ж���
	 * @param trueorfalse
	 */
	public void updateTrueOrFalse(Trueorfalse trueorfalse);

}
