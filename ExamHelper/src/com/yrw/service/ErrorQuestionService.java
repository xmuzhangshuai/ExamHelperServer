package com.yrw.service;

import java.util.List;

import com.yrw.domains.Errorquestions;
import com.yrw.domains.Serrorquestions;
import com.yrw.idao.IErrorQuestionDao;
import com.yrw.idao.ISerrorQuestionDao;

public class ErrorQuestionService {
	private IErrorQuestionDao iErrorQuestionDao;
	private ISerrorQuestionDao iSerrorQuestionDao;

	public void setiSerrorQuestionDao(ISerrorQuestionDao iSerrorQuestionDao) {
		this.iSerrorQuestionDao = iSerrorQuestionDao;
	}

	public void setiErrorQuestionDao(IErrorQuestionDao iErrorQuestionDao) {
		this.iErrorQuestionDao = iErrorQuestionDao;
	}

	/**
	 * �����û�ID���ش����б�
	 * 
	 * @param UserId
	 * @return
	 */
	public List<Errorquestions> getErrorquestionsByUser(int userId) {
		return iErrorQuestionDao.getErrorQuestionByUser(userId);
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
		List<Errorquestions> errorquestions = iErrorQuestionDao
				.getErrorQuestionByUser(userId);
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
	 * ��ȡ����ҳ��
	 * 
	 * @return
	 */
	public int getSErrorQuestionPageCount() {
		return iSerrorQuestionDao.getPageCount();
	}

	/**
	 * ����ҳ�뷵��List
	 * 
	 * @return
	 */
	public List<Serrorquestions> getSErrorQuestionListByPageNow(int pageNow) {
		return iSerrorQuestionDao.getSerrorquestions(pageNow);
	}

	public int getSErrorQuestionPageCountBySubject(int subjectId) {
		return iSerrorQuestionDao.getPageCountBySubejectId(subjectId);
	}

	public List<Serrorquestions> getSErrorQuestionListBySubject(int subjectId,
			int pageNow) {
		return iSerrorQuestionDao.getSerrorquestionsBySubjectId(subjectId,
				pageNow);
	}

	public int getSErrorQuestionPageCountBySection(int sectionId) {
		return iSerrorQuestionDao.getPageCountBySectionId(sectionId);
	}

	public List<Serrorquestions> getSErrorListBySection(int sectionId,
			int pageNow) {
		return iSerrorQuestionDao.getSerrorquestionsBySectionId(sectionId,
				pageNow);
	}

	public int getSErrorQuestionPageCountByQuestionType(int questionTypeId) {
		return iSerrorQuestionDao.getPageCountByQuestionTypeId(questionTypeId);
	}

	public List<Serrorquestions> getSErrorQuestionListByQuestionType(
			int questionTypeId, int pageNow) {
		return iSerrorQuestionDao.getSerrorquestionsByQuestionTypeId(
				questionTypeId, pageNow);
	}

}
