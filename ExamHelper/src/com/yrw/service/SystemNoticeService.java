package com.yrw.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.yrw.domains.Systemnotice;
import com.yrw.idao.ISystemNoticeDao;

public class SystemNoticeService {
	private ISystemNoticeDao iSystemNoticeDao;

	public void setiSystemNoticeDao(ISystemNoticeDao iSystemNoticeDao) {
		this.iSystemNoticeDao = iSystemNoticeDao;
	}


	public Systemnotice getCurrentNotice(){
		return iSystemNoticeDao.getSystemnotice();
	}
	
	public void addNotice(Systemnotice systemnotice){
		iSystemNoticeDao.addSystmnotice(systemnotice);
	}
	
	public void deleteNotice(Systemnotice existSystemnotice){
		iSystemNoticeDao.deleteSystemnotice(existSystemnotice);
	}
	
	public List<Systemnotice> getSystemnoticeListByPage(int pageNow){
	return	iSystemNoticeDao.getSystemnoticeByPage(pageNow);
	}
	
	public int getSystemnoticePageCountByPage(){
		return iSystemNoticeDao.getSystemnotciePageCount();
	}
	
}
