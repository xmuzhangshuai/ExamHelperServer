package com.yrw.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.yrw.domains.Multichoice;
import com.yrw.domains.Section;
import com.yrw.domains.Trueorfalse;
import com.yrw.idao.ITrueOrFalseDao;

public class TrueOrFalseDao extends BasicDao implements ITrueOrFalseDao {


	@Override
	public List getTrueOrFalseBySubject(int pageNow, int subjectId) {
		// TODO Auto-generated method stub
		String hql = "from Trueorfalse as s where s.section.id is in(select id from Section where subjectId="
				+ subjectId;
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	@Override
	public int getPageCountBySubject(int subjectId) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Trueorfalse as s where s.section.id is in(select id from Section where subjectId="
				+ subjectId;
		return this.queryPageCount(hql, null);
	}
	@Override
	public List getTrueOrFalseBySection(int pageNow, int sectionId) {
		// TODO Auto-generated method stub
		String hql = "from Trueorfalse as t where t.section.id="
				+ sectionId+" order by t.id desc";
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	@Override
	public int getPageCountBySection(int sectionId) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Trueorfalse as t where t.section.id="
				+ sectionId;
		return this.queryPageCount(hql, null);
	}


	@Override
	public List getTrueOrFalseByStem(String stem,int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Trueorfalse where questionStem like '%"+stem+"%'";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getPageCountByStem(String stem) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Trueorfalse where questionStem like '%"+stem+"%'";
		return this.queryPageCount(hql, null);
	}
	@Override
	public void delTrueOrFalse(Object object) {
		// TODO Auto-generated method stub
		Trueorfalse trueorfalse=(Trueorfalse)object;
		
		
		if (trueorfalse != null) {
			Section section = trueorfalse.getSection();
			Set<Trueorfalse> trueorfalses = section.getTrueorfalses();
			Iterator<Trueorfalse> iterator = trueorfalses.iterator();
			while (iterator.hasNext())
				if (iterator.next().getId() == trueorfalse.getId()) {
					iterator.remove();
					break;
				}
			this.deletById(Trueorfalse.class, trueorfalse.getId());
		}
	}
	@Override
	public void addTrueOrFalse(Trueorfalse trueorfalse){
		this.add(trueorfalse);
	}
	@Override
	public void updateTrueOrFalse(Trueorfalse trueorfalse){
		this.update(trueorfalse);
	}

	@Override
	public Trueorfalse showTrueorfalse(int trueOrFalseId) {
		// TODO Auto-generated method stub
	return (Trueorfalse)this.findById(Trueorfalse.class, trueOrFalseId);
	}

	@Override
	public void delTrueOrFalses(String params) {
		// TODO Auto-generated method stub
		String hql = "delete from Trueorfalse where id in (" + params + ")";
		this.deletAll(hql);
	}

	

	

}
