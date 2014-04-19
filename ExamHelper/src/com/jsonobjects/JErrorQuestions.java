package com.jsonobjects;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.domains.Errorquestions;
import com.yrw.idao.IQuestionTypeDao;
import com.yrw.idao.ISectionDao;
import com.yrw.idao.IUserDao;

/**
 * Entity mapped to table ERROR_QUESTIONS.
 */
public class JErrorQuestions {

	private Long id;
	private long question_id;
	private java.util.Date error_time;
	private Integer error_num;
	private long user_id;
	private long questionType_id;
	private long section_id;

	public JErrorQuestions() {
	}

	public JErrorQuestions(Long id) {
		this.id = id;
	}

	public JErrorQuestions(Long id, long question_id, java.util.Date error_time, Integer error_num, long user_id,
			long questionType_id, long section_id) {
		this.id = id;
		this.question_id = question_id;
		this.error_time = error_time;
		this.error_num = error_num;
		this.user_id = user_id;
		this.questionType_id = questionType_id;
		this.section_id = section_id;
	}

	/**
	 * 网络变为本地
	 * 
	 * @return
	 */
	public com.yrw.domains.Errorquestions NetToLocal() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao iUserDao = (IUserDao) applicationContext.getBean("userDao");
		IQuestionTypeDao iQuestionTypeDao = (IQuestionTypeDao) applicationContext.getBean("questionTypeDao");
		ISectionDao iSectionDao = (ISectionDao) applicationContext.getBean("sectionDao");

		com.yrw.domains.Errorquestions localErrorquestions = new com.yrw.domains.Errorquestions(
				iUserDao.getUserById(new Long(user_id).intValue()), iQuestionTypeDao.getQuestiontypeById(new Long(
						questionType_id).intValue()), iSectionDao.getSectionById(new Long(section_id).intValue()),
				new Long(question_id).intValue(), new Timestamp(error_time.getTime()), error_num);

		if (id != null) {
			localErrorquestions.setId(id.intValue());
		}

		return localErrorquestions;
	}

	/**
	 * 本地变为网络
	 * 
	 * @return
	 */
	public static JErrorQuestions LocalToNet(Errorquestions local) {
		JErrorQuestions errorQuestions = new JErrorQuestions((long) local.getId(), (long) local.getQuestionId(),
				local.getErrorTime(), local.getErrorNum(), (long) local.getUser().getId(), (long) local
						.getQuestiontype().getId(), (long) local.getSection().getId());
		return errorQuestions;
	}

	@Override
	public String toString() {
		return "ErrorQuestions [id=" + id + ", question_id=" + question_id + ", error_time=" + error_time
				+ ", error_num=" + error_num + ", user_id=" + user_id + ", questionType_id=" + questionType_id
				+ ", section_id=" + section_id + "]";
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

	public java.util.Date getError_time() {
		return error_time;
	}

	public void setError_time(java.util.Date error_time) {
		this.error_time = error_time;
	}

	public Integer getError_num() {
		return error_num;
	}

	public void setError_num(Integer error_num) {
		this.error_num = error_num;
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

	public long getSection_id() {
		return section_id;
	}

	public void setSection_id(long section_id) {
		this.section_id = section_id;
	}

}
