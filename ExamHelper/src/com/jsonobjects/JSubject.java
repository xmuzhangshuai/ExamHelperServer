package com.jsonobjects;

import com.yrw.domains.Subject;

/**
 * Entity mapped to table SUBJECT.
 */
public class JSubject {

	private Long id;
	/** Not-null value. */
	private String subject_name;

	public JSubject() {
	}

	public JSubject(Long id) {
		this.id = id;
	}

	/**
	 * �����Ϊ����
	 * 
	 * @return
	 */
	public Subject NetToLocal() {

		Subject local = new Subject(subject_name, null,null);
		local.setId(id.intValue());
		return local;
	}

	/**
	 * ���ر�Ϊ����
	 * 
	 * @return
	 */
	public static JSubject LocalToNet(com.yrw.domains.Subject local) {
		JSubject net = new JSubject((long) local.getId(), local.getSubName());
		return net;
	}

	public JSubject(Long id, String subject_name) {
		this.id = id;
		this.subject_name = subject_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subject_name=" + subject_name + "]";
	}

	/** Not-null value. */
	public String getSubject_name() {
		return subject_name;
	}

	/**
	 * Not-null value; ensure this value is available before it is saved to the
	 * database.
	 */
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

}
