package com.yrw.domains;

import java.util.HashSet;
import java.util.Set;

/**
 * Examguidetype entity. @author MyEclipse Persistence Tools
 */

public class Examguidetype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Subject subject;
	private String typeName;
	private Set examguides = new HashSet(0);

	// Constructors

	/** default constructor */
	public Examguidetype() {
	}

	/** minimal constructor */
	public Examguidetype(Subject subject) {
		this.subject = subject;
	}

	/** full constructor */
	public Examguidetype(Subject subject, String typeName, Set examguides) {
		this.subject = subject;
		this.typeName = typeName;
		this.examguides = examguides;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set getExamguides() {
		return this.examguides;
	}

	public void setExamguides(Set examguides) {
		this.examguides = examguides;
	}

}