package com.yrw.service;

import java.sql.Timestamp;
import java.util.List;

import com.yrw.domains.Note;
import com.yrw.domains.Snote;
import com.yrw.idao.INoteDao;
import com.yrw.idao.ISnoteDao;

/**
 * @author Administrator
 * 
 */
public class NoteService {
	private INoteDao iNoteDao;
	private ISnoteDao iSnoteDao;

	public void setiSnoteDao(ISnoteDao iSnoteDao) {
		this.iSnoteDao = iSnoteDao;
	}

	public void setiNoteDao(INoteDao iNoteDao) {
		this.iNoteDao = iNoteDao;
	}

	/**
	 * ��ӱʼ�
	 * 
	 * @param note
	 */
	public void addNote(Note note) {
		iNoteDao.addNote(note);
	}

	/**
	 * ɾ��note
	 * 
	 * @param note
	 */
	public void delNote(Note note) {
		iNoteDao.delNote(note);
	}

	/**
	 * �޸�Note
	 * 
	 * @param note
	 */
	public void updateNote(Note note) {
		iNoteDao.modifyNote(note);
	}

	/**
	 * ����һ��Note
	 * 
	 * @param note
	 * @return
	 */
	public Note getNote(Note note) {
	return iNoteDao.getNoteByUserAndQustion(note);
	}

	/**
	 * �������ͼ���Ŀ����Note�б�
	 * 
	 * @param questionTypeId
	 * @param questionId
	 * @return
	 */
	public List<Note> getNoteList(int questionTypeId, int questionId) {
		return iNoteDao.getNoteByQuestion(questionTypeId,questionId);
	}

	/**
	 * �����û�ID���رʼ��б�
	 * 
	 * @param userID
	 * @return
	 */
	public List<Note> getNoteList(int userID) {
		List<Note> noteList = iNoteDao.getNoteByUserId(userID);
		return noteList;
	}

	
	public List<Snote> getSnoteListByQuestionType(int questionTypeId,int pageNow){
		return iSnoteDao.getSnotesByQuestionTypeId(questionTypeId, pageNow);
	}
	public int getSnotePageCountByQuestionType(int questionTypeId){
		return iSnoteDao.getPageCountByQuestionTypeId(questionTypeId);
	}
	public List<Snote> getSnoteListByPage(int pageNow){
		return iSnoteDao.getSnotes(pageNow);
	}
	public int getSnotePageCount(){
		return iSnoteDao.getPageCount();
	}
}
