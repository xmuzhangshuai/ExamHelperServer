package com.jsonobjects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.idao.IQuestionTypeDao;
import com.yrw.idao.IUserDao;

/**
 * Entity mapped to table STUDY_RECORD.
 */
public class JStudyRecord {

	private Long id;
	private long question_id;
	private String my_answer;
	private Boolean is_right;
	private java.util.Date record_time;
	private long user_id;
	private long questionType_id;

	public JStudyRecord() {
	}

	public JStudyRecord(Long id) {
		this.id = id;
	}

	/**
	 * �����Ϊ����
	 * 
	 * @return
	 */
	public com.yrw.domains.Studyrecord NetToLocal() {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao iUserDao = (IUserDao) applicationContext.getBean("userDao");
		IQuestionTypeDao iQuestionTypeDao = (IQuestionTypeDao) applicationContext.getBean("questionTypeDao");

		com.yrw.domains.Studyrecord local = new com.yrw.domains.Studyrecord(iUserDao.getUserById(new Long(user_id)
				.intValue()), iQuestionTypeDao.getQuestiontypeById(new Long(questionType_id).intValue()), new Long(
				question_id).intValue());
		local.setId(id.intValue());
		return local;
	}

	/**
	 * ���ر�Ϊ����
	 * 
	 * @return
	 */
	public static JStudyRecord LocalToNet(com.yrw.domains.Studyrecord local) {
		JStudyRecord net = new JStudyRecord((long) local.getId(), local.getQuestionId(), null, false, null, local
				.getUser().getId(), local.getQuestiontype().getId());
		return net;
	}

	public JStudyRecord(Long id, long question_id, String my_answer, Boolean is_right, java.util.Date record_time,
			long user_id, long questionType_id) {
		this.id = id;
		this.question_id = question_id;
		this.my_answer = my_answer;
		this.is_right = is_right;
		this.record_time = record_time;
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

	public String getMy_answer() {
		return my_answer;
	}

	public void setMy_answer(String my_answer) {
		this.my_answer = my_answer;
	}

	public Boolean getIs_right() {
		return is_right;
	}

	public void setIs_right(Boolean is_right) {
		this.is_right = is_right;
	}

	public java.util.Date getRecord_time() {
		return record_time;
	}

	public void setRecord_time(java.util.Date record_time) {
		this.record_time = record_time;
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
