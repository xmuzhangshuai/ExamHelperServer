package com.yrw.domains;

import java.sql.Timestamp;

/**
 * Examguide entity. @author MyEclipse Persistence Tools
 */

public class Examguide implements java.io.Serializable {

	// Fields

	private Integer id;
	private Examguidetype examguidetype;
	private String title;
	private String url;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Examguide() {
	}

	/** minimal constructor */
	public Examguide(Examguidetype examguidetype) {
		this.examguidetype = examguidetype;
	}

	/** full constructor */
	public Examguide(Examguidetype examguidetype, String title, String url, Timestamp time) {
		this.examguidetype = examguidetype;
		this.title = title;
		this.url = url;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Examguidetype getExamguidetype() {
		return this.examguidetype;
	}

	public void setExamguidetype(Examguidetype examguidetype) {
		this.examguidetype = examguidetype;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}