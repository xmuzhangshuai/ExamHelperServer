package com.jsonobjects;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.idao.IQuestionTypeDao;
import com.yrw.idao.IUserDao;

/**
 * Entity mapped to table NOTE.
 */
public class JNote {

	private Long id;
	private long question_id;
	private java.util.Date note_time;
	private String note_content;
	private long user_id;
	private long questionType_id;

	public JNote() {
	}

	public JNote(Long id) {
		this.id = id;
	}

	/**
	 * 网络变为本地
	 * 
	 * @return
	 */
	public com.yrw.domains.Note NetToLocal() {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao iUserDao = (IUserDao) applicationContext.getBean("userDao");
		IQuestionTypeDao iQuestionTypeDao = (IQuestionTypeDao) applicationContext.getBean("questionTypeDao");

		com.yrw.domains.Note local = new com.yrw.domains.Note(iUserDao.getUserById(new Long(user_id).intValue()),
				iQuestionTypeDao.getQuestiontypeById(new Long(questionType_id).intValue()),
				new Long(question_id).intValue(), new Timestamp(note_time.getTime()), note_content);
		return local;
	}

	/**
	 * 本地变为网络
	 * 
	 * @return
	 */
	public static JNote LocalToNet(com.yrw.domains.Note local) {
		JNote net = new JNote((long) local.getId(), local.getQuestionId(), local.getNoteTime(), local.getNoteContent(),
				local.getUser().getId(), local.getQuestiontype().getId());
		return net;
	}

	public JNote(Long id, long question_id, java.util.Date note_time, String note_content, long user_id,
			long questionType_id) {
		this.id = id;
		this.question_id = question_id;
		this.note_time = note_time;
		this.note_content = note_content;
		this.user_id = user_id;
		this.questionType_id = questionType_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(long question_id) {
		this.question_id = question_id;
	}

	public java.util.Date getNote_time() {
		return note_time;
	}

	public void setNote_time(java.util.Date note_time) {
		this.note_time = note_time;
	}

	public String getNote_content() {
		return note_content;
	}

	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getQuestionType_id() {
		return questionType_id;
	}

	public void setQuestionType_id(long questionType_id) {
		this.questionType_id = questionType_id;
	}

}
