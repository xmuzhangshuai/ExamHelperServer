package com.jsonobjects;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.domains.Query;
import com.yrw.idao.IQueryDao;
import com.yrw.idao.IUserDao;

/**
 * Entity mapped to table ANSWER_QUERY.
 */
public class JAnswerQuery {

	private Long id;
	private String answer_content;
	private java.util.Date answer_time;
	private long user_id;
	private long query_id;

	public JAnswerQuery() {
	}

	public JAnswerQuery(Long id) {
		this.id = id;
	}

	public JAnswerQuery(Long id, String answer_content, java.util.Date answer_time, long user_id, long query_id) {
		this.id = id;
		this.answer_content = answer_content;
		this.answer_time = answer_time;
		this.user_id = user_id;
		this.query_id = query_id;
	}

	/**
	 * 将网络传回的AnswerQuery变为本地AnswerQuery
	 * 
	 * @return
	 */
	public com.yrw.domains.Answerquery NetToLocal() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao iUserDao = (IUserDao) applicationContext.getBean("userDao");
		IQueryDao iQueryDao = (IQueryDao) applicationContext.getBean("queryDao");
		
		com.yrw.domains.Answerquery answerquery = new com.yrw.domains.Answerquery(iUserDao.getUserById(id.intValue()),
				(Query) iQueryDao.findById(Query.class, this.query_id), this.answer_content, new Timestamp(answer_time.getTime()));
		answerquery.setId(id.intValue());
		return answerquery;
	}

	/**
	 * 本地AnswerQuery变为网络AnswerQuery
	 * 
	 * @param localAnswerquery
	 * @return
	 */
	public static JAnswerQuery LocalToNet(com.yrw.domains.Answerquery localAnswerquery) {
		JAnswerQuery netAnswerQuery = new JAnswerQuery((long) localAnswerquery.getId(),
				localAnswerquery.getAnswerContent(), localAnswerquery.getAnswerTime(), localAnswerquery.getUser()
						.getId(), localAnswerquery.getQuery().getId());
		return netAnswerQuery;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer_content() {
		return answer_content;
	}

	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}

	public java.util.Date getAnswer_time() {
		return answer_time;
	}

	public void setAnswer_time(java.util.Date answer_time) {
		this.answer_time = answer_time;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getQuery_id() {
		return query_id;
	}

	public void setQuery_id(long query_id) {
		this.query_id = query_id;
	}

}
