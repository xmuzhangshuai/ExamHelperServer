package com.yrw.domains;

import java.sql.Timestamp;

/**
 * Answerquery entity. @author MyEclipse Persistence Tools
 */

public class Answerquery implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Query query;
	private String answerContent;
	private Timestamp answerTime;

	// Constructors

	/** default constructor */
	public Answerquery() {
	}

	/** minimal constructor */
	public Answerquery(User user, Query query) {
		this.user = user;
		this.query = query;
	}

	/** full constructor */
	public Answerquery(User user, Query query, String answerContent,
			Timestamp answerTime) {
		this.user = user;
		this.query = query;
		this.answerContent = answerContent;
		this.answerTime = answerTime;
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

	public Query getQuery() {
		return this.query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public String getAnswerContent() {
		return this.answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Timestamp getAnswerTime() {
		return this.answerTime;
	}

	public void setAnswerTime(Timestamp answerTime) {
		this.answerTime = answerTime;
	}

}