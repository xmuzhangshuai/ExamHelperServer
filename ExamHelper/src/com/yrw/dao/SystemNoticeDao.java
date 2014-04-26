package com.yrw.dao;

import java.sql.Timestamp;
import java.util.List;

import com.yrw.domains.Systemnotice;
import com.yrw.idao.ISystemNoticeDao;

public class SystemNoticeDao extends BasicDao implements ISystemNoticeDao {

	@Override
	public Systemnotice getSystemnotice() {
		// TODO Auto-generated method stub
		String hql="from Systemnotice as s where s.valid=true";
		return (Systemnotice) this.uniqueQuery(hql, null);
	}

	@Override
	public void addSystmnotice(Systemnotice systemnotice) {
		// TODO Auto-generated method stub
		Systemnotice existSystemnotice=getSystemnotice();
		existSystemnotice.setValid(false);
		this.update(existSystemnotice);
		
		this.add(systemnotice);
	}

	@Override
	public void deleteSystemnotice(Systemnotice systemnotice) {
		// TODO Auto-generated method stub
		
		this.deletById(Systemnotice.class, systemnotice.getId());
	}

	@Override
	public List<Systemnotice> getSystemnoticeByPage(int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Systemnotice as s order by s.time desc";
		return this.executeQueryByPage(hql, null, pageNow);
	}

	@Override
	public int getSystemnotciePageCount() {
		// TODO Auto-generated method stub
		String hql="select count(s) from Systemnotice as s";
		return this.queryPageCount(hql, null);
	}


}
