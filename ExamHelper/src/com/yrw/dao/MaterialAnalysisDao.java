package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Materialanalysis;
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
				+ sectionId;
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
	public void delMaterialAnalysis(int materialanalysisId) {
		// TODO Auto-generated method stub
		this.deletById(Materialanalysis.class, materialanalysisId);
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

}
