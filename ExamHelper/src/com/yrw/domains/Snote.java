package com.yrw.domains;

/**
 * Snote entity. @author MyEclipse Persistence Tools
 */

public class Snote implements java.io.Serializable {

	// Fields

	private Integer id;
	private Questiontype questiontype;
	private Integer questionId;
	private Integer noteNum;

	// Constructors

	/** default constructor */
	public Snote() {
	}

	/** minimal constructor */
	public Snote(Questiontype questiontype, Integer questionId) {
		this.questiontype = questiontype;
		this.questionId = questionId;
	}

	/** full constructor */
	public Snote(Questiontype questiontype, Integer questionId, Integer noteNum) {
		this.questiontype = questiontype;
		this.questionId = questionId;
		this.noteNum = noteNum;
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

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getNoteNum() {
		return this.noteNum;
	}

	public void setNoteNum(Integer noteNum) {
		this.noteNum = noteNum;
	}

}