package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Questionsofmaterial;
import com.yrw.idao.IQuestionsOfMaterial;

public class QuestionOfMaterialDao extends BasicDao implements
		IQuestionsOfMaterial {

	@Override
	public List getQuestionOfMaterialByMaterialId(int pageNow, int materialId) {
		// TODO Auto-generated method stub
		String hql = "select q from Questionsofmaterial q where q.materialanalysis.id="
				+ materialId;
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountByMaterialId(int materialId) {
		// TODO Auto-generated method stub
		String hql = "select count(q) from Questionsofmaterial q where q.materialanalysis.id="
				+ materialId;
		return this.queryPageCount(hql, null);
	}

	@Override
	public Questionsofmaterial showQuestionOfMaterial(int questionOfMaterial) {
		// TODO Auto-generated method stub

		return (Questionsofmaterial) this.findById(Questionsofmaterial.class,
				questionOfMaterial);
	}

	@Override
	public void addQuestionOfMaterial(Questionsofmaterial questionOfMaterial) {
		// TODO Auto-generated method stub
		this.add(questionOfMaterial);
	}

	@Override
	public void delQuestionOfMaterial(Questionsofmaterial questionOfMaterial) {
		// TODO Auto-generated method stub
		this.deletById(Questionsofmaterial.class, questionOfMaterial.getId());
	}

	@Override
	public void updateQuestionOfMaterial(Questionsofmaterial questionOfMaterial) {
		// TODO Auto-generated method stub
		this.update(questionOfMaterial);
	}

	@Override
	public List getQuestionofMaterialByStem(int pageNow, String stem) {
		// TODO Auto-generated method stub
		String hql = "from Questionsofmaterial as q where q.questionStem like '%"
				+ stem + "%'";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountByStem(String stem) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Questionsofmaterial as q where q.questionStem like '%"
				+ stem + "%'";
		return this.queryPageCount(hql, null);
	}

	@Override
	public int getMaxQuestionNumByMaterialId(int materiaAnalysisId) {
		// TODO Auto-generated method stub
		String hql = "select max(q.questionNumber) from Questionsofmaterial q where q.materialanalysis.id="
				+ materiaAnalysisId;
		return (Integer) this.uniqueQuery(hql, null);
	}

	

}
