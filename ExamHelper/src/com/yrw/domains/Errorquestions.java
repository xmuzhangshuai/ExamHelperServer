package com.yrw.domains;

import java.sql.Timestamp;

/**
 * Errorquestions entity. @author MyEclipse Persistence Tools
 */

public class Errorquestions implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Questiontype questiontype;
	private Section section;
	private Integer questionId;
	private Timestamp errorTime;
	private Integer errorNum;

	// Constructors

	/** default constructor */
	public Errorquestions() {
	}

	/** minimal constructor */
	public Errorquestions(User user, Questiontype questiontype,
			Section section, Integer questionId) {
		this.user = user;
		this.questiontype = questiontype;
		this.section = section;
		this.questionId = questionId;
	}

	/** full constructor */
	public Errorquestions(User user, Questiontype questiontype,
			Section section, Integer questionId, Timestamp errorTime,
			Integer errorNum) {
		this.user = user;
		this.questiontype = questiontype;
		this.section = section;
		this.questionId = questionId;
		this.errorTime = errorTime;
		this.errorNum = errorNum;
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

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Timestamp getErrorTime() {
		return this.errorTime;
	}

	public void setErrorTime(Timestamp errorTime) {
		this.errorTime = errorTime;
	}

	public Integer getErrorNum() {
		return this.errorNum;
	}

	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}

}