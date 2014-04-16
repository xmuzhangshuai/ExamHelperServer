package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Note;

/**
 * ��Ŀ���ƣ�ExamHelper �����ƣ�INoteDao �������� ��Աʼǵ��йز����Ľӿ��࣬�̳���IBasicDao
 * �����ˣ�Ҷ��� ����ʱ�䣺2014-03-15 �޸��ˣ� �޸�ʱ�䣺 �޸ı�ע��
 * 
 */
public interface INoteDao extends IBasicDao {

	
	/**������Ŀ�õ�note�б�
	 * @param questiontypeId
	 * @param questionId
	 * @return
	 */
	public List getNoteByQuestion(int questiontypeId,int questionId);

	/**
	 * @param userId
	 * @return
	 */
	public List getNoteByUserId(int userId);

	

	/**
	 * @param noteId
	 * @return
	 */
	
	public List showNote(int noteId);
	/**
	 * @param note
	 */
	public void addNote(Note note);
	/**
	 * @param note
	 */
	public void delNote(Note note);

	/**
	 * @param note
	 */
	public void modifyNote(Note note);
}
