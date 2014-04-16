package com.jsonobjects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.domains.Subject;
import com.yrw.idao.ISubjectDao;

/**
 * Entity mapped to table EXAMINATION.
 */
public class JExamination {

	private Long id;
	private String exam_type;
	private String exam_name;
	private String exam_request;
	private Integer exam_time;
	private long subject_id;

	public JExamination() {
	}

	public JExamination(Long id) {
		this.id = id;
	}

	public JExamination(Long id, String exam_type, String exam_name, String exam_request, Integer exam_time,
			long subject_id) {
		this.id = id;
		this.exam_type = exam_type;
		this.exam_name = exam_name;
		this.exam_request = exam_request;
		this.exam_time = exam_time;
		this.subject_id = subject_id;
	}

	/**
	 * 网络变为本地
	 * 
	 * @return
	 */
	public com.yrw.domains.Examination NetToLocal() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ISubjectDao iSubjectDao = (ISubjectDao) applicationContext.getBean("subjectDao");

		com.yrw.domains.Examination localExamination = new com.yrw.domains.Examination((Subject) iSubjectDao.findById(
				Subject.class, id.intValue()), exam_type, exam_name, exam_request, exam_time, null);
		localExamination.setId(id.intValue());
		return localExamination;
	}

	/**
	 * 本地变为网络
	 * 
	 * @return
	 */
	public static JErrorQuestions LocalToNet(com.yrw.domains.Errorquestions local) {
		JErrorQuestions errorQuestions = new JErrorQuestions((long) local.getId(), (long) local.getQuestionId(),
				local.getErrorTime(), local.getErrorNum(), (long) local.getUser().getId(), (long) local
						.getQuestiontype().getId(), (long) local.getSection().getId());
		return errorQuestions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExam_type() {
		return exam_type;
	}

	public void setExam_type(String exam_type) {
		this.exam_type = exam_type;
	}

	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}

	public String getExam_request() {
		return exam_request;
	}

	public void setExam_request(String exam_request) {
		this.exam_request = exam_request;
	}

	public Integer getExam_time() {
		return exam_time;
	}

	public void setExam_time(Integer exam_time) {
		this.exam_time = exam_time;
	}

	public long getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}

}
