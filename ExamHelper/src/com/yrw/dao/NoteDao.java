package com.yrw.dao;

import java.sql.Timestamp;
import java.util.List;

import com.jsonobjects.JQuestion;
import com.yrw.domains.Note;
import com.yrw.domains.Questiontype;
import com.yrw.domains.Snote;
import com.yrw.idao.INoteDao;
import com.yrw.idao.ISnoteDao;

public class NoteDao extends BasicDao implements INoteDao {

	private ISnoteDao iSnoteDao;

	public void setiSnoteDao(ISnoteDao iSnoteDao) {
		this.iSnoteDao = iSnoteDao;
	}

	@Override
	public List<Note> getNoteByUserId(int userId) {
		// TODO Auto-generated method stub
		String hql = "from Note as n where n.user.id=" + userId;
		return this.executeQuery(hql, null);
	}

	@Override
	public Note showNote(int noteId) {
		// TODO Auto-generated method stub
		return (Note) this.findById(Note.class, noteId);

	}

	@Override
	public void addNote(Note note) {
		String hql = "from Note as n where n.user.id=" + note.getUser().getId()
				+ " and n.questiontype.id=" + note.getQuestiontype().getId()
				+ " and n.questionId=" + note.getQuestionId();
		Note existNote = (Note) this.uniqueQuery(hql, null);
		Snote snote = null;
		if (existNote != null) {
			existNote.setNoteTime(new Timestamp(System.currentTimeMillis()));
			existNote.setNoteContent(note.getNoteContent());
			existNote.setQuestionId(note.getQuestionId());
			existNote.setQuestiontype(note.getQuestiontype());
			existNote.setUser(note.getUser());
			this.update(existNote);
		} else {
			this.add(note);

			snote = iSnoteDao.getSnote(note.getQuestiontype().getId(),
					note.getQuestionId());
			if (snote != null) {
				snote.setNoteNum(snote.getNoteNum() + 1);
				iSnoteDao.update(snote);
			} else {
				snote = new Snote();
				snote.setNoteNum(1);
				snote.setQuestionId(note.getQuestionId());
				snote.setQuestiontype(note.getQuestiontype());
				iSnoteDao.addSNote(snote);
			}
		}
	}

	@Override
	public void delNote(Note note) {
		// TODO Auto-generated method stub
		String hql = "from Note as n where n.user.id=" + note.getUser().getId()
				+ " and n.questiontype.id=" + note.getQuestiontype().getId()
				+ " and n.questionId=" + note.getQuestionId();
		Note existNote = (Note) this.uniqueQuery(hql, null);
		if (existNote != null) {
			this.deletById(Note.class, existNote.getId());

			Snote snote = iSnoteDao.getSnote(note.getQuestiontype().getId(),
					note.getQuestionId());
			snote.setNoteNum(snote.getNoteNum() - 1);
			iSnoteDao.update(snote);
		}
	}

	@Override
	public void modifyNote(Note note) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Note> getNoteByQuestion(int questiontypeId, int questionId) {
		// TODO Auto-generated method stub
		String hql = "from Note as n where n.questiontype.id=" + questiontypeId
				+ " and n.questionId=" + questionId;
		return this.executeQuery(hql, null);
	}

}
