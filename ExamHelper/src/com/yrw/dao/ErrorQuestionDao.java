package com.yrw.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.yrw.domains.Errorquestions;
import com.yrw.domains.Serrorquestions;
import com.yrw.idao.IErrorQuestionDao;
import com.yrw.idao.ISerrorQuestionDao;

public class ErrorQuestionDao extends BasicDao implements IErrorQuestionDao {

	private ISerrorQuestionDao iSerrorQuestionDao;

	public void setiSerrorQuestionDao(ISerrorQuestionDao iSerrorQuestionDao) {
		this.iSerrorQuestionDao = iSerrorQuestionDao;
	}

	@Override
	public int getErrorQuestionCountByUser(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getErrorQuestionByUser(int userId, int pageNow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addErrorQuestion(Errorquestions errorquestions) {
		// TODO Auto-generated method stub
		int questionId = errorquestions.getQuestionId();
		int questionTypeId = errorquestions.getQuestiontype().getId();
		Serrorquestions serrorquestions = null;

		String hql = "from Errorquestions as e where e.questiontype.id=" + questionTypeId + " and e.questionId="
				+ questionId + " and e.user.id=" + errorquestions.getUser().getId();
		Errorquestions errorQuestion = (Errorquestions) this.uniqueQuery(hql, null);
		if (errorQuestion != null) {
			errorQuestion.setErrorNum(errorQuestion.getErrorNum() + 1);
			errorQuestion.setErrorTime(new Timestamp(System.currentTimeMillis()));
			this.update(errorQuestion);

			// serrorquestions=iSerrorQuestionDao.getSerrorquestions(questionTypeId,
			// questionId);
			// serrorquestions.setErrorNum(serrorquestions.getErrorNum()+1);
			// iSerrorQuestionDao.update(serrorquestions);
		} else {
			this.add(errorquestions);

			// serrorquestions=new Serrorquestions();
			// serrorquestions.setErrorNum(1);
			// serrorquestions.setQuestionId(questionId);
			// serrorquestions.setQuestiontype(errorquestions.getQuestiontype());
			// serrorquestions.setSection(errorquestions.getSection());
			// iSerrorQuestionDao.add(serrorquestions);
		}

		serrorquestions = iSerrorQuestionDao.getSerrorquestions(questionTypeId, questionId);
		if (serrorquestions != null) {
			serrorquestions.setErrorNum(serrorquestions.getErrorNum() + 1);
			iSerrorQuestionDao.update(serrorquestions);
		} else {
			serrorquestions = new Serrorquestions(errorquestions.getQuestiontype(), errorquestions.getSection(),
					questionId, 1);
			iSerrorQuestionDao.add(serrorquestions);
		}

	}

	@Override
	public List getErrorQuestionByUser(int userId) {
		// TODO Auto-generated method stub
		String hql = "from Errorquestions as e where e.user.id=" + userId + " order by e.errorTime desc";
		return this.executeQuery(hql, null);
	}

	@Override
	public void delErrorQuestions(List<Errorquestions> errorQuestionList) {
		// TODO Auto-generated method stub

		String hql = "delete from Errorquestions where id in (";
		for (int i = 0; i < errorQuestionList.size(); i++) {
			hql = hql + errorQuestionList.get(i).getId();
			if (i != errorQuestionList.size() - 1)
				hql = hql + ",";
		}
		hql = hql + ")";
		this.deletAll(hql);
	}

	@Override
	public List getErrorQuestions() {
		// TODO Auto-generated method stub
		String hql = "from Errorquestions order by errorNum desc";
		return this.executeQuery(hql, null);
	}

	@Override
	public void addErrorQuestionList(List<Errorquestions> errorquestionsList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < errorquestionsList.size(); i++)
			addErrorQuestion(errorquestionsList.get(i));

	}
}
