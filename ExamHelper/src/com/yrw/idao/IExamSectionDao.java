package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Examsection;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�IExamSectionDao �������� ����Ծ������йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface IExamSectionDao extends IBasicDao {
	/**
	 * Method getExamBySection �õ�ĳ���Ծ��������
	 * 
	 * @param pageNow
	 * @param examId
	 * @return List
	 */
	public List getExamBySection(int examId, int pageNow);

	/**
	 * Method getPageCount �õ�ĳ���Ծ���������б�ҳ��
	 * 
	 * @param examId
	 * @return List
	 */
	public List getPageCount(int examId);

	/**�õ�examSection����
	 * @param examSectioId
	 * @return
	 */
	public Examsection showExamsection(int examSectioId);
	/**
	 * Method addExamSection �����Ծ����
	 * 
	 * @param examSection
	 * @return void
	 */
	public void addExamSection(Examsection examSection);

	/**
	 * Method delExamSection �����Ծ����
	 * 
	 * @param examSection
	 * @return void
	 */
	public void delExamSection(Examsection examsection);
	/**
	 * Method modifyExamSection �޸��Ծ����
	 * 
	 * @param examsection
	 * @return void
	 */
	public void modifyExamSection(Examsection examsection);
	
	/**���ĳ���Ծ��½������ͬһ�Ծ��½�
	 * @param examId
	 * @param examSectionId
	 * @return
	 */
	public List<Examsection> getExamsectionsByExamIdAndExamSectionId(int examId,int examSectionId);
}
