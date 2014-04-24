package com.yrw.domains;

/**
 * Serrorquestions entity. @author MyEclipse Persistence Tools
 */

public class Serrorquestions implements java.io.Serializable {

	// Fields

	private Integer id;
	private Questiontype questiontype;
	private Section section;
	private Integer questionId;
	private Integer errorNum;

	// Constructors

	/** default constructor */
	public Serrorquestions() {
	}

	/** minimal constructor */
	public Serrorquestions(Questiontype questiontype, Section section, Integer questionId) {
		this.questiontype = questiontype;
		this.section = section;
		this.questionId = questionId;
	}

	/** full constructor */
	public Serrorquestions(Questiontype questiontype, Section section, Integer questionId, Integer errorNum) {
		this.questiontype = questiontype;
		this.section = section;
		this.questionId = questionId;
		this.errorNum = errorNum;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getErrorNum() {
		return this.errorNum;
	}

	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}

}