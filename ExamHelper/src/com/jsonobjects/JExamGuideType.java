package com.jsonobjects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.domains.Examguidetype;

public class JExamGuideType {

	private Integer id;
	private Integer subjectId;
	private String typeName;

	/**
	 * 网络变为本地
	 * 
	 * @return
	 */
	// public static Examguidetype NetToLocal() {
	// ApplicationContext applicationContext = new
	// ClassPathXmlApplicationContext("applicationContext.xml");
	//
	// }

	/**
	 * 本地变为网络
	 * 
	 * @param local
	 * @return
	 */
	// public static JExamGuideType LocalToNet(Examguidetype local) {
	//
	// }

	public JExamGuideType() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public JExamGuideType(Integer id, int subjectId, String typeName) {
		super();
		this.id = id;
		this.subjectId = subjectId;
		this.typeName = typeName;
	}

}
