package com.jsonobjects;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.domains.Examguide;

public class JExamGuide {

	private Integer id;
	private Integer examguidetypeId;
	private String title;
	private String url;
	private Date time;

	public JExamGuide() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * �����Ϊ����
	 * 
	 * @return
	 */
//	public static Examguide NetToLocal() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//	}
//
//	/**
//	 * ���ر�Ϊ����
//	 * 
//	 * @param local
//	 * @return
//	 */
//	public static JExamGuide LocalToNet(Examguide local) {
//
//	}

	public JExamGuide(Integer id, Integer examguidetypeId, String title, String url, Date time) {
		super();
		this.id = id;
		this.examguidetypeId = examguidetypeId;
		this.title = title;
		this.url = url;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExamguidetypeId() {
		return examguidetypeId;
	}

	public void setExamguidetypeId(Integer examguidetypeId) {
		this.examguidetypeId = examguidetypeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
