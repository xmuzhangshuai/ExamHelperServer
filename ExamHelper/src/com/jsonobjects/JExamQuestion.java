package com.jsonobjects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.domains.Examsection;
import com.yrw.idao.IExamSectionDao;

/**
 * Entity mapped to table EXAM_QUESTION.
 */
public class JExamQuestion {

	private Long id;
	private int question_number;
	private long question_id;
	private long exanSection_id;

	public JExamQuestion() {
	}

	public JExamQuestion(Long id) {
		this.id = id;
	}

	public JExamQuestion(Long id, int question_number, long question_id, long exanSection_id) {
		this.id = id;
		this.question_number = question_number;
		this.question_id = question_id;
		this.exanSection_id = exanSection_id;
	}

	/**
	 * 网络变为本地
	 * 
	 * @return
	 */
	public com.yrw.domains.Examquestion NetToLocal() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IExamSectionDao iExamSectionDao = (IExamSectionDao) applicationContext.getBean("examSectionDao");

		com.yrw.domains.Examquestion local = new com.yrw.domains.Examquestion((Examsection) iExamSectionDao.findById(
				Examsection.class, id.intValue()), question_number, new Long(question_id).intValue());
		local.setId(id.intValue());
		return local;
	}

	/**
	 * 本地变为网络
	 * 
	 * @return
	 */
	public static JExamQuestion LocalToNet(com.yrw.domains.Examquestion local) {
		JExamQuestion net = new JExamQuestion((long) local.getId(), local.getQuestionNumber(), local.getQuestionId(),
				local.getExamsection().getId());
		return net;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuestion_number() {
		return question_number;
	}

	public void setQuestion_number(int question_number) {
		this.question_number = question_number;
	}

	public long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(long question_id) {
		this.question_id = question_id;
	}

	public long getExanSection_id() {
		return exanSection_id;
	}

	public void setExanSection_id(long exanSection_id) {
		this.exanSection_id = exanSection_id;
	}

}
