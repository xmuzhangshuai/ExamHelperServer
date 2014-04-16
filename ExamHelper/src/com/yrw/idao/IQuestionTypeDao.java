package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Questiontype;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�IQuestioTypeDao �������� ����������͵����ݿ����,�̳�IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-17 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface IQuestionTypeDao extends IBasicDao {

	/**�������QuestionTYpe
	 * @return
	 */
	public List getQuestionTypes();

	/**
	 * ͨ��id���
	 * 
	 * @param id
	 * @return
	 */
	public Questiontype getQuestiontypeById(int id);

	/**
	 * ��ʾ�½�
	 * 
	 * @param pageNow
	 * @return List
	 */
	public List getQuestionType(int pageNow);

	/**
	 * ��ȡ���ж���ҳ��section��Ϣ
	 * 
	 * @return pageCount
	 */
	public int getPageCount();

	/**
	 * �޸�������������
	 * 
	 * @param questionTypeId
	 * @return void
	 */
	public void modifyQuestionTypeName(int questionTypeId);

	/**
	 * Method delQuestionTypeɾ����������
	 * 
	 * @param questionTypeId
	 * @return void
	 */
	public void delQuestionType(Questiontype questiontype);

	/**
	 * ������������
	 * 
	 * @param questiontype
	 * @return void
	 */
	public void addQuestionType(Questiontype questiontype);

}
