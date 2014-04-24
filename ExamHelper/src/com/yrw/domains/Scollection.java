package com.yrw.domains;

/**
 * Scollection entity. @author MyEclipse Persistence Tools
 */

public class Scollection implements java.io.Serializable {

	// Fields

	private Integer id;
	private Questiontype questiontype;
	private Section section;
	private Integer questionId;
	private Integer collectionNum;

	// Constructors

	/** default constructor */
	public Scollection() {
	}

	/** minimal constructor */
	public Scollection(Questiontype questiontype, Section section, Integer questionId) {
		this.questiontype = questiontype;
		this.section = section;
		this.questionId = questionId;
	}

	/** full constructor */
	public Scollection(Questiontype questiontype, Section section, Integer questionId, Integer collectionNum) {
		this.questiontype = questiontype;
		this.section = section;
		this.questionId = questionId;
		this.collectionNum = collectionNum;
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

	public Integer getCollectionNum() {
		return this.collectionNum;
	}

	public void setCollectionNum(Integer collectionNum) {
		this.collectionNum = collectionNum;
	}

}