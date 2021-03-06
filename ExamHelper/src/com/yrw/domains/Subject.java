package com.yrw.domains;

import java.util.HashSet;
import java.util.Set;

/**
 * Subject entity. @author MyEclipse Persistence Tools
 */

public class Subject implements java.io.Serializable {

	// Fields

	private Integer id;
	private String subName;
	private Set examinations = new HashSet(0);
	private Set sections = new HashSet(0);
	private Set examguidetypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Subject() {
	}

	/** minimal constructor */
	public Subject(String subName) {
		this.subName = subName;
	}

	/** full constructor */
	public Subject(String subName, Set examinations, Set sections, Set examguidetypes) {
		this.subName = subName;
		this.examinations = examinations;
		this.sections = sections;
		this.examguidetypes = examguidetypes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubName() {
		return this.subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public Set getExaminations() {
		return this.examinations;
	}

	public void setExaminations(Set examinations) {
		this.examinations = examinations;
	}

	public Set getSections() {
		return this.sections;
	}

	public void setSections(Set sections) {
		this.sections = sections;
	}

	public Set getExamguidetypes() {
		return this.examguidetypes;
	}

	public void setExamguidetypes(Set examguidetypes) {
		this.examguidetypes = examguidetypes;
	}

}