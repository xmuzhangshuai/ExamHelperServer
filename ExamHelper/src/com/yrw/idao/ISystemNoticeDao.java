package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Systemnotice;

public interface ISystemNoticeDao extends IBasicDao {
	public Systemnotice getSystemnotice();
	public void addSystmnotice(Systemnotice systemnotice);
	public void deleteSystemnotice(Systemnotice systemnotice);
	public List<Systemnotice> getSystemnoticeByPage(int pageNow);
	public int getSystemnotciePageCount();

}
