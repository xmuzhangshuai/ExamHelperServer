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
	 * 添加一条错误信息
	 * 
	 * @param errorquestions
	 */
	public void addErrorQuestion(Errorquestions errorquestions) {
		iErrorQuestionDao.addErrorQuestion(errorquestions);
	}

	/**
	 * 添加多条错误信息
	 * 
	 * @param errorquestionList
	 */
	public void addErrorQuestionList(List<Errorquestions> errorquestionList) {
		for (int i = 0; i < errorquestionList.size(); i++)
			iErrorQuestionDao.add(errorquestionList.get(i));
	}

	/**
	 * 删除某个用户的所有错题
	 * 
	 * @param userId
	 */
	public void delErrorQuestion(int userId) {
		List<Errorquestions> errorquestions = iErrorQuestionDao.getErrorQuestionByUser(userId);
		iErrorQuestionDao.delErrorQuestions(errorquestions);
	}

	/**
	 * 按错题人数降序返回列表
	 * 
	 * @return List<Errorquestions>
	 */
	public List<Errorquestions> getErrorQuestion() {
		return iErrorQuestionDao.getErrorQuestions();
	}
	
	/**
	 * 根据用户ID返回错题列表
	 * @param UserId
	 * @return
	 */
	public List<Errorquestions> getErrorquestionsByUser(int userId){
		return iErrorQuestionDao.getErrorQuestionByUser(userId);
	}
}
