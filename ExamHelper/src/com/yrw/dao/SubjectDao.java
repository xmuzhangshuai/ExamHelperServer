package com.yrw.dao;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.yrw.domains.Subject;
import com.yrw.idao.ISubjectDao;

/**
 * 
 * ��Ŀ���ƣ�ExamHelper �����ƣ�SubjectService ��������
 * ��Կ�Ŀ���йز���ʵ���࣬ʵ����SubjectInter�ӿ��Ҽ̳���BasicService �����ˣ�Ҷ��� ����ʱ�䣺2014-03-15 �޸��ˣ�
 * �޸�ʱ�䣺 �޸ı�ע��
 * 
 * @version
 * 
 */
public class SubjectDao extends BasicDao implements ISubjectDao {

	@Override
	public Subject getQuniqueSubject(int subjectId) {
		// TODO Auto-generated method stub
		return (Subject) this.findById(Subject.class, subjectId);
	}

	/**
	 * ��ȡ���п�Ŀ
	 * 
	 * @return List
	 */
	@Override
	public List getSubject() {
		// TODO Auto-generated method stub
		String hql = "from Subject order by id";
		List list = this.executeQuery(hql, null);
		return list;
	}

	/**
	 * ��ȡ���п�Ŀ
	 * 
	 * @return List
	 */
	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Subject";
		return this.queryPageCount(hql, null);
	}

	@Override
	public List getSubject(int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Subject order by id";
		List list = this.executeQueryByPage(hql, null, pageNow);
		return list;
	}

	@Override
	public int getPageCountLikeName(String name) {
		// TODO Auto-generated method stub
		String hql = "select count(s) from Subject as s where s.subName like '%"
				+ name + "%'";
		System.out.println(hql);
		return this.queryPageCount(hql, null);
	}

	@Override
	public List getSubjectLikeName(String name, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "select s from Subject as s where s.subName like '%"
				+ name + "%'";
		System.out.println(hql);
		List list = this.executeQueryByPage(hql, null, pageNow);
		if (list.size() != 0)
			System.out.println("��Ϊ��" + list.size());
		return list;
	}

	@Override
	public void delSubject(int subjectId) {
		// TODO Auto-generated method stub
		this.deletById(Subject.class, subjectId);
	}

	@Override
	public void addSubject(Subject subject) {
		// TODO Auto-generated method stub
		this.add(subject);
	}

	@Override
	public void delSubjects(String params) {
		// TODO Auto-generated method stub
		String hql = "delete from Subject where id in (" + params + ")";
		this.deletAll(hql);
	}

	@Override
	public void modifySubject(Subject subject) {
		this.update(subject);
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		// TODO Auto-generated method stub
		return (Subject) findById(Subject.class, subjectId);
	}

	@Override
	public int getSubjectIdByName(String subjectName) {
		// TODO Auto-generated method stub
		String hql="select s.id from Subject as s where s.subName='"+subjectName+"'";
		return  (Integer) this.uniqueQuery(hql, null);
	}

	@Override
	public Subject getSubjectByName(String subjectName) {
		// TODO Auto-generated method stub
		String hql="from Subject where subName='"+subjectName+"'";
		return (Subject)this.uniqueQuery(hql, null);
	}

}
