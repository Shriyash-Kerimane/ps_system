package com.demo.query.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.entity.Emp;

public class HQL1 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Query<Emp> query = session.createQuery("from Emp e where e.name like 'SH%'",Emp.class);
			
			List<Emp> empList = query.getResultList();
			
			empList.forEach(e->System.out.println(e.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
