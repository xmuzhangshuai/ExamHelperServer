package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Studyrecord;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�IStudyRecordDao �������� ���ѧϰ��¼���йز����Ľӿ��࣬�̳���IBasicDao �����ˣ�Ҷ���
 * ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public interface IStudyRecordDao extends IBasicDao {

	/**
	 * @param pageNow
	 * @param userId
	 * @return
	 */
	public List getStudyRecordByUserId(int pageNow,int userId);
	/**
	 * @param userId
	 * @return
	 */
	public int getPageCountByUserId(int userId);
	
	/**
	 * @param studyRecordId
	 * @return
	 */
	public List showStudyRecord(int studyRecordId);
	/**
	 * @param studyrecord
	 */
	public void addStudyRecord(Studyrecord studyrecord);
	/**
	 * @param studyrecord
	 */
	public void delStudyRecord(Studyrecord studyrecord);
}
