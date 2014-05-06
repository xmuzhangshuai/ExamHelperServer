package com.yrw.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Questionsofmaterial;
import com.yrw.domains.Section;
import com.yrw.domains.Singlechoice;
import com.yrw.idao.IQuestionsOfMaterial;

public class QuestionOfMaterialDao extends BasicDao implements
		IQuestionsOfMaterial {

	@Override
	public List getQuestionOfMaterialByMaterialId(int pageNow, int materialId) {
		// TODO Auto-generated method stub
		String hql = "select q from Questionsofmaterial q where q.materialanalysis.id="
				+ materialId + " order by q.questionNumber";
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
	public Questionsofmaterial showQuestionOfMaterial(int questionOfMaterialId) {
		// TODO Auto-generated method stub

		return (Questionsofmaterial) this.findById(Questionsofmaterial.class,
				questionOfMaterialId);
	}

	@Override
	public void addQuestionOfMaterial(Questionsofmaterial questionOfMaterial) {
		// TODO Auto-generated method stub
		this.add(questionOfMaterial);
	}

	@Override
	public void delQuestionOfMaterial(Object object) {
		// TODO Auto-generated method stub
		Questionsofmaterial questionsofmaterial = (Questionsofmaterial) object;
		if (questionsofmaterial != null) {
			Materialanalysis materialanalysis = questionsofmaterial
					.getMaterialanalysis();
			Set<Questionsofmaterial> questionsofmaterials = materialanalysis
					.getQuestionsofmaterials();
			Iterator<Questionsofmaterial> iterator = questionsofmaterials
					.iterator();
			while (iterator.hasNext())
				if (iterator.next().getId() == questionsofmaterial.getId()) {
					iterator.remove();
					break;
				}
			this.deletById(Questionsofmaterial.class,
					questionsofmaterial.getId());
		}
	}

	@Override
	public void updateQuestionOfMaterial(Questionsofmaterial questionOfMaterial) {
		// TODO Auto-generated method stub
		String hql = "update Questionsofmaterial as q set q.questionNumber="
				+ questionOfMaterial.getQuestionNumber() + " where q.id ="
				+ questionOfMaterial.getId();
		this.executeUpdate(hql, null);
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
		Object object = this.uniqueQuery(hql, null);
		if (object == null)
			return 0;
		else
			return (Integer) object;
	}

	@Override
	public List getQuestionOfMaterialByMaterialId(int materialId) {
		// TODO Auto-generated method stub
		String hql = "from Questionsofmaterial as q where q.materialanalysis.id="
				+ materialId + " order by q.questionNumber";
		return this.executeQuery(hql, null);

	}

}
