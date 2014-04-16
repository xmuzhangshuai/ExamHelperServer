package com.jsonobjects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.domains.Examination;
import com.yrw.idao.IExaminationDao;
import com.yrw.idao.IQuestionTypeDao;

/**
 * Entity mapped to table EXAM_SECTION.
 */
public class JExamSection {

	private Long id;
	private String request;
	private Integer question_num;
	private Integer question_score;
	private long questionType_id;
	private long exam_id;

	public JExamSection() {
	}

	public JExamSection(Long id) {
		this.id = id;
	}

	public JExamSection(Long id, String request, Integer question_num, Integer question_score, long questionType_id,
			long exam_id) {
		this.id = id;
		this.request = request;
		this.question_num = question_num;
		this.question_score = question_score;
		this.questionType_id = questionType_id;
		this.exam_id = exam_id;
	}

	/**
	 * 网络变为本地
	 * 
	 * @return
	 */
	public com.yrw.domains.Examsection NetToLocal() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IQuestionTypeDao iQuestionTypeDao = (IQuestionTypeDao) applicationContext.getBean("questionTypeDao");
		IExaminationDao iExaminationDao = (IExaminationDao) applicationContext.getBean("examinationDao");

		com.yrw.domains.Examsection local = new com.yrw.domains.Examsection(
				iQuestionTypeDao.getQuestiontypeById(new Long(questionType_id).intValue()),
				(Examination) iExaminationDao.findById(Examination.class, id.intValue()), request, question_num,
				question_score, null);
		local.setId(id.intValue());
		return local;
	}

	/**
	 * 本地变为网络
	 * 
	 * @return
	 */
	public static JExamSection LocalToNet(com.yrw.domains.Examsection local) {
		JExamSection net = new JExamSection((long) local.getId(), local.getRequest(), local.getQuestionNum(),
				local.getQuestionScore(), local.getQuestiontype().getId(), local.getExamination().getId());
		return net;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Integer getQuestion_num() {
		return question_num;
	}

	public void setQuestion_num(Integer question_num) {
		this.question_num = question_num;
	}

	public Integer getQuestion_score() {
		return question_score;
	}

	public void setQuestion_score(Integer question_score) {
		this.question_score = question_score;
	}

	public long getQuestionType_id() {
		return questionType_id;
	}

	public void setQuestionType_id(long questionType_id) {
		this.questionType_id = questionType_id;
	}

	public long getExam_id() {
		return exam_id;
	}

	public void setExam_id(long exam_id) {
		this.exam_id = exam_id;
	}

}
