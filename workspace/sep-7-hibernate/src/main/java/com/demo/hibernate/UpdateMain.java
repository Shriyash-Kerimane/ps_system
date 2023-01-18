package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Emp;

public class UpdateMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Emp emp = session.get(Emp.class, 100);
			System.out.println(emp.getEmpId()+" "+emp.getCity());
			emp.setSalary(emp.getSalary()+10000);
			session.merge(emp);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
