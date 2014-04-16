package com.yrw.dao;

import java.util.List;

import com.jsonobjects.JQuestion;
import com.yrw.domains.Note;
import com.yrw.domains.Questiontype;
import com.yrw.idao.INoteDao;

public class NoteDao extends BasicDao implements INoteDao {

	@Override
	public List getNoteByUserId(int userId) {
		// TODO Auto-generated method stub
		String hql = "from Note as n where n.user.id=" + userId;
		return this.executeQuery(hql, null);
	}

	@Override
	public List showNote(int noteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNote(Note note) {
		this.add(note);

	}

	@Override
	public void delNote(Note note) {
		// TODO Auto-generated method stub
		this.deletById(Note.class, note.getId());
	}

	@Override
	public void modifyNote(Note note) {
		// TODO Auto-generated method stub

	}

	@Override
	public List getNoteByQuestion(int questiontypeId, int questionId) {
		// TODO Auto-generated method stub
		String hql = "from Note as n where n.questiontype.id=" + questiontypeId
				+ " and n.questionId=" + questionId;
		return this.executeQuery(hql, null);
	}

}
