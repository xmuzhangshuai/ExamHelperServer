package com.yrw.tests;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.config.DefaultValue;
import com.yrw.dao.AnswerQueryDao;
import com.yrw.dao.BasicDao;
import com.yrw.dao.ManagerDao;
import com.yrw.domains.Answerquery;
import com.yrw.domains.Manager;
import com.yrw.domains.Query;
import com.yrw.domains.User;
import com.yrw.idao.IManagerDao;

public class SpringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	/*	
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.getCurrentSession();
		Transaction ts=session.beginTransaction();
		
		
		String hql = "select count(*) from Answerquery";
		int pageCount = this.queryPageCount(hql, null);
		return pageCount;
		
				/*
		 * String string=""; String string2=string+"a,b,c"; String
		 * []td=string2.split(","); for(int i=0;i<td.length;i++)
		 * System.out.println(td[i]);
		 */
		/*
		 * ApplicationContext ac=new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 * ManagerInter userInter=(ManagerInter)ac.getBean("managerService");
		 * 
		 * 
		 * Manager user=(Manager) userInter.findById(Manager.class, 1);
		 * System.out.println(user.getName());
		 */

		
	}

}
