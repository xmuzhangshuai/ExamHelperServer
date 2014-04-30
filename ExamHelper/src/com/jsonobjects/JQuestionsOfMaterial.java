package com.jsonobjects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Questionsofmaterial;
import com.yrw.idao.IMaterialAnalysisDao;

/**
 * Entity mapped to table QUESTIONS_OF_MATERIAL.
 */
public class JQuestionsOfMaterial {

	private Long id;
	private Integer qusetion_number;
	private String question_stem;
	private String answer;
	private String analysis;
	private Integer score;
	private long material_id;

	public JQuestionsOfMaterial() {
	}

	public JQuestionsOfMaterial(Long id) {
		this.id = id;
	}

	/**
	 * 网络变为本地
	 * 
	 * @return
	 */
	public com.yrw.domains.Questionsofmaterial NetToLocal() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IMaterialAnalysisDao iMaterialAnalysisDao = (IMaterialAnalysisDao) applicationContext
				.getBean("materialAnalysisDao");

		com.yrw.domains.Questionsofmaterial local = new com.yrw.domains.Questionsofmaterial(
				(Materialanalysis) iMaterialAnalysisDao.findById(Materialanalysis.class, id.intValue()),
				qusetion_number, question_stem, answer, analysis, score);
		local.setId(id.intValue());
		return local;
	}

	/**
	 * 本地变为网络
	 * 
	 * @return
	 */
	public static JQuestionsOfMaterial LocalToNet(Questionsofmaterial local) {
		JQuestionsOfMaterial net = new JQuestionsOfMaterial((long) local.getId(), local.getQuestionNumber(),
				local.getQuestionStem(), local.getAnswer(), local.getAnalysis(), local.getScore(), local
						.getMaterialanalysis().getId());
		return net;
	}

	public JQuestionsOfMaterial(Long id, Integer qusetion_number, String question_stem, String answer, String analysis,
			Integer score, long material_id) {
		this.id = id;
		this.qusetion_number = qusetion_number;
		this.question_stem = question_stem;
		this.answer = answer;
		this.analysis = analysis;
		this.score = score;
		this.material_id = material_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQusetion_number() {
		return qusetion_number;
	}

	public void setQusetion_number(Integer qusetion_number) {
		this.qusetion_number = qusetion_number;
	}

	public String getQuestion_stem() {
		return question_stem;
	}

	public void setQuestion_stem(String question_stem) {
		this.question_stem = question_stem;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public long getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(long material_id) {
		this.material_id = material_id;
	}

}
