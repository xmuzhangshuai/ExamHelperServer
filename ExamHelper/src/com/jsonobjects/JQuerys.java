package com.jsonobjects;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.idao.IQuestionTypeDao;
import com.yrw.idao.IUserDao;

/**
 * Entity mapped to table QUERYS.
 */
public class JQuerys {

	private Long id;
	private long question_id;
	private java.util.Date query_time;
	private String query_stem;
	private Integer integral;
	private Long adopt_user_id;
	private String query_image;
	private long user_id;
	private long questionType_id;

	public JQuerys() {
	}

	public JQuerys(Long id) {
		this.id = id;
	}

	public JQuerys(Long id, long question_id, Date query_time, String query_stem, Integer integral, Long adopt_user_id,
			String query_image, long user_id, long questionType_id) {
		super();
		this.id = id;
		this.question_id = question_id;
		this.query_time = query_time;
		this.query_stem = query_stem;
		this.integral = integral;
		this.adopt_user_id = adopt_user_id;
		this.query_image = query_image;
		this.user_id = user_id;
		this.questionType_id = questionType_id;
	}

	/**
	 * �����Ϊ����
	 * 
	 * @return
	 */
	public com.yrw.domains.Query NetToLocal() {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao iUserDao = (IUserDao) applicationContext.getBean("userDao");
		IQuestionTypeDao iQuestionTypeDao = (IQuestionTypeDao) applicationContext.getBean("questionTypeDao");
		Integer adoptUserID = null;
		Integer netId = null;
		if (adopt_user_id != null) {
			adoptUserID = adopt_user_id.intValue();
		}

		if (id != null) {
			netId = id.intValue();
		}

		com.yrw.domains.Query local = new com.yrw.domains.Query(iUserDao.getUserById(new Long(user_id).intValue()),
				iQuestionTypeDao.getQuestiontypeById(new Long(questionType_id).intValue()),
				new Long(question_id).intValue(), query_stem, new Timestamp(query_time.getTime()), integral,
				adoptUserID, query_image, null);
		local.setId(netId);
		return local;
	}

	/**
	 * ���ر�Ϊ����
	 * 
	 * @return
	 */
	public static JQuerys LocalToNet(com.yrw.domains.Query local) {
		Long adoptUserID = null;
		if (local.getAdoptUserId() != null) {
			adoptUserID = local.getAdoptUserId().longValue();
		}

		JQuerys net = new JQuerys((long) local.getId(), local.getQuestionId(), local.getQueryTime(),
				local.getQueryStem(), local.getIntegral(), adoptUserID, local.getQueryImage(), local.getUser().getId(),
				local.getQuestiontype().getId());
		return net;
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

	public java.util.Date getQuery_time() {
		return query_time;
	}

	public void setQuery_time(java.util.Date query_time) {
		this.query_time = query_time;
	}

	public String getQuery_stem() {
		return query_stem;
	}

	public void setQuery_stem(String query_stem) {
		this.query_stem = query_stem;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Long getAdopt_user_id() {
		return adopt_user_id;
	}

	public void setAdopt_user_id(Long adopt_user_id) {
		this.adopt_user_id = adopt_user_id;
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

	public String getQuery_image() {
		return query_image;
	}

	public void setQuery_image(String query_image) {
		this.query_image = query_image;
	}

}
