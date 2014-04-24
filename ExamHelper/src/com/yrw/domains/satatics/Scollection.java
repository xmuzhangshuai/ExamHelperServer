package com.yrw.domains.satatics;

import java.util.Date;

import com.yrw.domains.Questiontype;
import com.yrw.domains.Section;
import com.yrw.domains.Subject;
import com.yrw.domains.User;

public class Scollection {
	private Integer id;
	private User user;
	private Questiontype questiontype;
	private Section section;
	private Subject subject;
	private Integer questionId;
	private Date collectTime;
	private Integer collectionCount;

	public Scollection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scollection(Integer id, User user, Questiontype questiontype, Section section, Subject subject,
			Integer questionId, Date collectTime, Integer collectionCount) {
		super();
		this.id = id;
		this.user = user;
		this.questiontype = questiontype;
		this.section = section;
		this.subject = subject;
		this.questionId = questionId;
		this.collectTime = collectTime;
		this.collectionCount = collectionCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Questiontype getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(Questiontype questiontype) {
		this.questiontype = questiontype;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Date getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

	public Integer getCollectionCount() {
		return collectionCount;
	}

	public void setCollectionCount(Integer collectionCount) {
		this.collectionCount = collectionCount;
	}

}
