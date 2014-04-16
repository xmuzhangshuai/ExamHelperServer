package com.yrw.service;

import java.sql.Timestamp;
import java.util.List;

import com.yrw.domains.Note;
import com.yrw.idao.INoteDao;

/**
 * @author Administrator
 * 
 */
public class NoteService {
	private INoteDao iNoteDao;

	public void setiNoteDao(INoteDao iNoteDao) {
		this.iNoteDao = iNoteDao;
	}

	/**
	 * ��ӱʼ�
	 * 
	 * @param note
	 */
	public void addNote(Note note) {
		String hql = "from Note as n where n.user.id=" + note.getUser().getId() + " and n.questiontype.id="
				+ note.getQuestiontype().getId() + " and n.questionId=" + note.getQuestionId();
		Note existNote = (Note) iNoteDao.uniqueQuery(hql, null);
		if (existNote != null) {
			existNote.setNoteTime(new Timestamp(System.currentTimeMillis()));
			existNote.setNoteContent(note.getNoteContent());
			existNote.setQuestionId(note.getQuestionId());
			existNote.setQuestiontype(note.getQuestiontype());
			existNote.setUser(note.getUser());
			iNoteDao.update(existNote);
		} else
			iNoteDao.add(note);
	}

	/**
	 * ɾ��note
	 * 
	 * @param note
	 */
	public void delNote(Note note) {
		String hql = "from Note as n where n.user.id=" + note.getUser().getId() + " and n.questiontype.id="
				+ note.getQuestiontype().getId() + " and n.questionId=" + note.getQuestionId();
		Note existNote = (Note) iNoteDao.uniqueQuery(hql, null);
		if (existNote != null) {
			iNoteDao.deletById(Note.class, existNote.getId());
		}
	}

	/**
	 * �޸�Note
	 * 
	 * @param note
	 */
	public void updateNote(Note note) {
		String hql = "from Note as n where n.user.id=" + note.getUser().getId() + " and n.questiontype.id="
				+ note.getQuestiontype().getId() + " and n.questionId=" + note.getQuestionId();
		Note existNote = (Note) iNoteDao.uniqueQuery(hql, null);
		if (existNote != null) {
			existNote.setNoteTime(new Timestamp(System.currentTimeMillis()));
			existNote.setNoteContent(note.getNoteContent());
			existNote.setQuestionId(note.getQuestionId());
			existNote.setQuestiontype(note.getQuestiontype());
			existNote.setUser(note.getUser());
			iNoteDao.update(existNote);
		}
	}

	/**
	 * ����һ��Note
	 * 
	 * @param note
	 * @return
	 */
	public Note getNote(Note note) {
		String hql = "from Note as n where n.user.id=" + note.getUser().getId() + " and n.questiontype.id="
				+ note.getQuestiontype().getId() + " and n.questionId=" + note.getQuestionId();
		Note existNote = (Note) iNoteDao.uniqueQuery(hql, null);
		if (existNote != null)
			return existNote;
		else
			return null;
	}

	/**
	 * �������ͼ���Ŀ����Note�б�
	 * 
	 * @param questionTypeId
	 * @param questionId
	 * @return
	 */
	public List<Note> getNoteList(int questionTypeId, int questionId) {
		String hql = "from Note as n where n.questiontype.id=" + questionTypeId + " and n.questionId=" + questionId
				+ "order by n.noteTime desc";
		List<Note> noteList = iNoteDao.executeQuery(hql, null);
		return noteList;

	}

}
