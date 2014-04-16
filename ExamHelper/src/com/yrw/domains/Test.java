package com.yrw.domains;

/**
 * Test entity. @author MyEclipse Persistence Tools
 */

public class Test implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sectionId;
	private String questionStem;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String optionE;
	private String optionF;
	private Short answerA;
	private Short answerB;
	private Short answerC;
	private Short answerD;
	private Short answerE;
	private Short answerF;
	private String analysis;
	private String remark;

	// Constructors

	/** default constructor */
	public Test() {
	}

	/** minimal constructor */
	public Test(String questionStem) {
		this.questionStem = questionStem;
	}

	/** full constructor */
	public Test(Integer sectionId, String questionStem, String optionA,
			String optionB, String optionC, String optionD, String optionE,
			String optionF, Short answerA, Short answerB, Short answerC,
			Short answerD, Short answerE, Short answerF, String analysis,
			String remark) {
		this.sectionId = sectionId;
		this.questionStem = questionStem;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.optionE = optionE;
		this.optionF = optionF;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.answerE = answerE;
		this.answerF = answerF;
		this.analysis = analysis;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public String getQuestionStem() {
		return this.questionStem;
	}

	public void setQuestionStem(String questionStem) {
		this.questionStem = questionStem;
	}

	public String getOptionA() {
		return this.optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return this.optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return this.optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return this.optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getOptionE() {
		return this.optionE;
	}

	public void setOptionE(String optionE) {
		this.optionE = optionE;
	}

	public String getOptionF() {
		return this.optionF;
	}

	public void setOptionF(String optionF) {
		this.optionF = optionF;
	}

	public Short getAnswerA() {
		return this.answerA;
	}

	public void setAnswerA(Short answerA) {
		this.answerA = answerA;
	}

	public Short getAnswerB() {
		return this.answerB;
	}

	public void setAnswerB(Short answerB) {
		this.answerB = answerB;
	}

	public Short getAnswerC() {
		return this.answerC;
	}

	public void setAnswerC(Short answerC) {
		this.answerC = answerC;
	}

	public Short getAnswerD() {
		return this.answerD;
	}

	public void setAnswerD(Short answerD) {
		this.answerD = answerD;
	}

	public Short getAnswerE() {
		return this.answerE;
	}

	public void setAnswerE(Short answerE) {
		this.answerE = answerE;
	}

	public Short getAnswerF() {
		return this.answerF;
	}

	public void setAnswerF(Short answerF) {
		this.answerF = answerF;
	}

	public String getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}