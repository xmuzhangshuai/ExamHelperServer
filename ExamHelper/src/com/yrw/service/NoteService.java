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
	 * 添加笔记
	 * 
	 * @param note
	 */
	public void addNote(Note note) {
		iNoteDao.addNote(note);
	}

	/**
	 * 删除note
	 * 
	 * @param note
	 */
	public void delNote(Note note) {
		iNoteDao.delNote(note);
	}

	/**
	 * 修改Note
	 * 
	 * @param note
	 */
	public void updateNote(Note note) {
		iNoteDao.modifyNote(note);
	}

	/**
	 * 查找一条Note
	 * 
	 * @param note
	 * @return
	 */
	public Note getNote(Note note) {
	return iNoteDao.getNoteByUserAndQustion(note);
	}

	/**
	 * 根据题型及题目返回Note列表
	 * 
	 * @param questionTypeId
	 * @param questionId
	 * @return
	 */
	public List<Note> getNoteList(int questionTypeId, int questionId) {
		return iNoteDao.getNoteByQuestion(questionTypeId,questionId);
	}

	/**
	 * 根据用户ID返回笔记列表
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
