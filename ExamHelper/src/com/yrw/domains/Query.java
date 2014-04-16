package com.yrw.domains;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Query entity. @author MyEclipse Persistence Tools
 */

public class Query implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Questiontype questiontype;
	private Integer questionId;
	private String queryStem;
	private Timestamp queryTime;
	private Integer integral;
	private Integer adoptUserId;
	private String queryImage;
	private Set answerqueries = new HashSet(0);

	// Constructors

	/** default constructor */
	public Query() {
	}

	/** minimal constructor */
	public Query(User user, Questiontype questiontype, Integer questionId) {
		this.user = user;
		this.questiontype = questiontype;
		this.questionId = questionId;
	}

	/** full constructor */
	public Query(User user, Questiontype questiontype, Integer questionId,
			String queryStem, Timestamp queryTime, Integer integral,
			Integer adoptUserId, String queryImage, Set answerqueries) {
		this.user = user;
		this.questiontype = questiontype;
		this.questionId = questionId;
		this.queryStem = queryStem;
		this.queryTime = queryTime;
		this.integral = integral;
		this.adoptUserId = adoptUserId;
		this.queryImage = queryImage;
		this.answerqueries = answerqueries;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Questiontype getQuestiontype() {
		return this.questiontype;
	}

	public void setQuestiontype(Questiontype questiontype) {
		this.questiontype = questiontype;
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQueryStem() {
		return this.queryStem;
	}

	public void setQueryStem(String queryStem) {
		this.queryStem = queryStem;
	}

	public Timestamp getQueryTime() {
		return this.queryTime;
	}

	public void setQueryTime(Timestamp queryTime) {
		this.queryTime = queryTime;
	}

	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getAdoptUserId() {
		return this.adoptUserId;
	}

	public void setAdoptUserId(Integer adoptUserId) {
		this.adoptUserId = adoptUserId;
	}

	public String getQueryImage() {
		return this.queryImage;
	}

	public void setQueryImage(String queryImage) {
		this.queryImage = queryImage;
	}

	public Set getAnswerqueries() {
		return this.answerqueries;
	}

	public void setAnswerqueries(Set answerqueries) {
		this.answerqueries = answerqueries;
	}

}