package com.yrw.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.yrw.domains.Materialanalysis;
import com.yrw.domains.Questionsofmaterial;
import com.yrw.domains.Section;
import com.yrw.domains.Trueorfalse;
import com.yrw.idao.IMaterialAnalysisDao;

public class MaterialAnalysisDao extends BasicDao implements
		IMaterialAnalysisDao {

	@Override
	public List getMaterialAnalysisBySubject(int pageNow, int subjectId) {
		// TODO Auto-generated method stub
		String hql = "select m from Materialanalysis as m where m.section.id in (select section.id from Section  section where section.subjectId="
				+ subjectId + ")";
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	@Override
	public int getPageCountBySubject(int subjectId) {
		// TODO Auto-generated method stub
		String hql = "select count(m) from Materialanalysis as m where m.section.id in (select section.id from Section  section where section.subjectId="
				+ subjectId + ")";
		int pageCount = this.queryPageCount(hql, null);
		return pageCount;
	}

	@Override
	public List getMaterialAnalysisBySection(int pageNow, int sectionId) {
		// TODO Auto-generated method stub
		String hql = "from Materialanalysis as m where m.section.id="
				+ sectionId+" order by m.id desc";
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	@Override
	public int getPageCountBySection(int sectionId) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Materialanalysis as m where m.section.id="
				+ sectionId;
		return this.queryPageCount(hql, null);
	}

	@Override
	public Materialanalysis showMaterialAnalysis(int materialAnalysisId) {
		// TODO Auto-generated method stub

		return (Materialanalysis) this.findById(Materialanalysis.class,
				materialAnalysisId);
	}

	@Override
	public void addMaterialAnalysis(Materialanalysis materialanalysis) {
		// TODO Auto-generated method stub
		this.add(materialanalysis);
	}

	@Override
	public void delMaterialAnalysis(Object object) {
		// TODO Auto-generated method stub
		Materialanalysis materialanalysis=(Materialanalysis)object;
		
		if (materialanalysis != null) {
			//É¾³ýÐ¡Ìâ
			delQuestionsofMaterial(materialanalysis.getQuestionsofmaterials());
			materialanalysis.setQuestionsofmaterials(null);
			//É¾³ýÕÂ½Ú
			Section section = materialanalysis.getSection();
			Set<Materialanalysis> materialanalysises = section.getMaterialanalysises();
			Iterator<Materialanalysis> iterator = materialanalysises.iterator();
			while (iterator.hasNext())
				if (iterator.next().getId() == materialanalysis.getId()) {
					iterator.remove();
					break;
				}
			this.deletById(Materialanalysis.class,  materialanalysis.getId());
		}
	}
	@Override
	public void delQuestionsofMaterial(Set<Questionsofmaterial> questionsOfMaterial) {
		// TODO Auto-generated method stub
		if(questionsOfMaterial!=null){
			Iterator<Questionsofmaterial>iterator=questionsOfMaterial.iterator();
			while(iterator.hasNext()){
				Questionsofmaterial questionofmaterial=(Questionsofmaterial)iterator.next();
				this.deletById(Questionsofmaterial.class,questionofmaterial.getId());
			}
		}
	}
	@Override
	public void delMaterialAnalysises(List<Materialanalysis> materialanalysises) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMaterialAnalysis(Materialanalysis materialanalysis) {
		// TODO Auto-generated method stub
		this.update(materialanalysis);
	}

	@Override
	public List getMaterialAnalysisByStem(int pageNow, String stem) {
		// TODO Auto-generated method stub
		String hql = "from Materialanalysis as s where s.material like '%" + stem + "%'";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountByStem(String stem) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Singlechoice as s where s.material like '%"
				+ stem + "%'";
		return this.queryPageCount(hql, null);
	}

	@Override
	public int getMaterialAnalysisIdByMaterial(String material) {
		// TODO Auto-generated method stub
		String hql="select m.id from Materialanalysis as m where m.material='"+material+"'";
		return (Integer) this.uniqueQuery(hql, null);
	}

	@Override
	public void delMaterialAnalysises(String params) {
		// TODO Auto-generated method stub
		String hql = "delete from Materialanalysis where id in (" + params + ")";
		this.deletAll(hql);
	}

	

}
