package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Studyrecord;
import com.yrw.idao.IStudyRecordDao;

public class StudyRecordDao extends BasicDao implements IStudyRecordDao {

	@Override
	public List getStudyRecordByUserId(int pageNow, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPageCountByUserId(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List showStudyRecord(int studyRecordId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStudyRecord(Studyrecord studyrecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delStudyRecord(Studyrecord studyrecord) {
		// TODO Auto-generated method stub

	}

}
