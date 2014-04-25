package com.yrw.domains;

import java.util.HashSet;
import java.util.Set;

/**
 * Section entity. @author MyEclipse Persistence Tools
 */

public class Section implements java.io.Serializable {

	// Fields

	private Integer id;
	private Subject subject;
	private String sectionName;
	private Set scollections = new HashSet(0);
	private Set groups = new HashSet(0);
	private Set singlechoices = new HashSet(0);
	private Set trueorfalses = new HashSet(0);
	private Set multichoices = new HashSet(0);
	private Set collections = new HashSet(0);
	private Set materialanalysises = new HashSet(0);
	private Set errorquestionses = new HashSet(0);
	private Set serrorquestionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Section() {
	}

	/** minimal constructor */
	public Section(Subject subject, String sectionName) {
		this.subject = subject;
		this.sectionName = sectionName;
	}

	/** full constructor */
	public Section(Subject subject, String sectionName, Set scollections, Set groups, Set singlechoices,
			Set trueorfalses, Set multichoices, Set collections, Set materialanalysises, Set errorquestionses,
			Set serrorquestionses) {
		this.subject = subject;
		this.sectionName = sectionName;
		this.scollections = scollections;
		this.groups = groups;
		this.singlechoices = singlechoices;
		this.trueorfalses = trueorfalses;
		this.multichoices = multichoices;
		this.collections = collections;
		this.materialanalysises = materialanalysises;
		this.errorquestionses = errorquestionses;
		this.serrorquestionses = serrorquestionses;
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

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Set getScollections() {
		return this.scollections;
	}

	public void setScollections(Set scollections) {
		this.scollections = scollections;
	}

	public Set getGroups() {
		return this.groups;
	}

	public void setGroups(Set groups) {
		this.groups = groups;
	}

	public Set getSinglechoices() {
		return this.singlechoices;
	}

	public void setSinglechoices(Set singlechoices) {
		this.singlechoices = singlechoices;
	}

	public Set getTrueorfalses() {
		return this.trueorfalses;
	}

	public void setTrueorfalses(Set trueorfalses) {
		this.trueorfalses = trueorfalses;
	}

	public Set getMultichoices() {
		return this.multichoices;
	}

	public void setMultichoices(Set multichoices) {
		this.multichoices = multichoices;
	}

	public Set getCollections() {
		return this.collections;
	}

	public void setCollections(Set collections) {
		this.collections = collections;
	}

	public Set getMaterialanalysises() {
		return this.materialanalysises;
	}

	public void setMaterialanalysises(Set materialanalysises) {
		this.materialanalysises = materialanalysises;
	}

	public Set getErrorquestionses() {
		return this.errorquestionses;
	}

	public void setErrorquestionses(Set errorquestionses) {
		this.errorquestionses = errorquestionses;
	}

	public Set getSerrorquestionses() {
		return this.serrorquestionses;
	}

	public void setSerrorquestionses(Set serrorquestionses) {
		this.serrorquestionses = serrorquestionses;
	}

}