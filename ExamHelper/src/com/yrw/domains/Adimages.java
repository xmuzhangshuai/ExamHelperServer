package com.yrw.domains;

import java.sql.Timestamp;

/**
 * Adimages entity. @author MyEclipse Persistence Tools
 */

public class Adimages implements java.io.Serializable {

	// Fields

	private Integer id;
	private String url;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Adimages() {
	}

	/** full constructor */
	public Adimages(String url, Timestamp time) {
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