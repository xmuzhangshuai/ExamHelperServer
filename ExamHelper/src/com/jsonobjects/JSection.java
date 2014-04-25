package com.jsonobjects;


/**
 * Entity mapped to table SECTION.
 */
public class JSection {

	private Long id;
	/** Not-null value. */
	private String section_name;
	private long subject_id;

	public JSection() {
	}

	public JSection(Long id) {
		this.id = id;
	}

	public JSection(Long id, String section_name, long subject_id) {
		this.id = id;
		this.section_name = section_name;
		this.subject_id = subject_id;
	}

	/**
	 * 网络变为本地
	 * 
	 * @return
	 */
//	public Section NetToLocal() {
//
//		Section local = new Section(section_name, new Long(subject_id).intValue(),
//				null, null, null, null, null, null, null);
//		local.setId(id.intValue());
//		return local;
//	}

	/**
	 * 本地变为网络
	 * 
	 * @return
	 */
//	public static JSection LocalToNet(com.yrw.domains.Section local) {
//		JSection net = new JSection((long) local.getId(), local.getSectionName(), local.getSubjectId());
//		return net;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/** Not-null value. */
	public String getSection_name() {
		return section_name;
	}

	/**
	 * Not-null value; ensure this value is available before it is saved to the
	 * database.
	 */
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public long getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", section_name=" + section_name + ", subject_id=" + subject_id + "]";
	}

}
