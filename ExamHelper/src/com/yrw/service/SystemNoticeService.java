package com.yrw.service;

import java.sql.Timestamp;
import java.util.Date;

import com.yrw.domains.Systemnotice;
import com.yrw.idao.ISystemNoticeDao;

public class SystemNoticeService {
	private ISystemNoticeDao iSystemNoticeDao;

	public void setiSystemNoticeDao(ISystemNoticeDao iSystemNoticeDao) {
		this.iSystemNoticeDao = iSystemNoticeDao;
	}

	public Systemnotice getCurrentNotice() {
		Systemnotice systemnotice = new Systemnotice("²âÊÔ¹«¸æ", null, new Timestamp(new Date().getTime()), true, false);
		systemnotice.setId(2);
		return systemnotice;
	}
}
