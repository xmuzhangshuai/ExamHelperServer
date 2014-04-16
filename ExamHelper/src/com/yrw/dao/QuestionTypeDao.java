package com.yrw.dao;

import java.util.List;

import com.yrw.domains.Questiontype;
import com.yrw.idao.IQuestionTypeDao;

public class QuestionTypeDao extends BasicDao implements IQuestionTypeDao {

	@Override
	public List getQuestionType(int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from  Questiontype";

		List list = this.executeQueryByPage(hql, null, pageNow);

		return list;
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Questiontype";
		return this.queryPageCount(hql, null);
	}

	@Override
	public void modifyQuestionTypeName(int questionTypeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delQuestionType(Questiontype questiontype) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addQuestionType(Questiontype questiontype) {
		// TODO Auto-generated method stub

	}

	@Override
	public Questiontype getQuestiontypeById(int id) {
		// TODO Auto-generated method stub
		return (Questiontype) this.findById(Questiontype.class, id);
	}

	@Override
	public List getQuestionTypes() {
		// TODO Auto-generated method stub
		String hql = "from Questiontype";
		return this.executeQuery(hql, null);
	}

}
