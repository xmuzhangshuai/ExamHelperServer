package com.yrw.service;

import java.util.List;

import com.yrw.domains.Errorquestions;
import com.yrw.idao.IErrorQuestionDao;

public class ErrorQuestionService {
	private IErrorQuestionDao iErrorQuestionDao;

	public void setiErrorQuestionDao(IErrorQuestionDao iErrorQuestionDao) {
		this.iErrorQuestionDao = iErrorQuestionDao;
	}

	/**
	 * ���һ��������Ϣ
	 * 
	 * @param errorquestions
	 */
	public void addErrorQuestion(Errorquestions errorquestions) {
		iErrorQuestionDao.addErrorQuestion(errorquestions);
	}

	/**
	 * ��Ӷ���������Ϣ
	 * 
	 * @param errorquestionList
	 */
	public void addErrorQuestionList(List<Errorquestions> errorquestionList) {
		for (int i = 0; i < errorquestionList.size(); i++)
			iErrorQuestionDao.add(errorquestionList.get(i));
	}

	/**
	 * ɾ��ĳ���û������д���
	 * 
	 * @param userId
	 */
	public void delErrorQuestion(int userId) {
		List<Errorquestions> errorquestions = iErrorQuestionDao.getErrorQuestionByUser(userId);
		iErrorQuestionDao.delErrorQuestions(errorquestions);
	}

	/**
	 * �������������򷵻��б�
	 * 
	 * @return List<Errorquestions>
	 */
	public List<Errorquestions> getErrorQuestion() {
		return iErrorQuestionDao.getErrorQuestions();
	}
	
	/**
	 * �����û�ID���ش����б�
	 * @param UserId
	 * @return
	 */
	public List<Errorquestions> getErrorquestionsByUser(int userId){
		return iErrorQuestionDao.getErrorQuestionByUser(userId);
	}
}
