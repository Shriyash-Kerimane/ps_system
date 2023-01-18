package com.demo.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.demo.entity.Customer;
import com.demo.entity.CustomerDao;

public class CustomerHibernateImpl implements CustomerDao {

	@Override
	public Customer findCustomerById(int id) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Customer customer = null;

		try {
			customer = session.get(Customer.class, id);

			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			session.close();
			return customer;
		} finally {
			session.close();
		}

		return customer;
	}

	@Override
	public String save(Customer c) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Customer customer = null;

		try {

			if (findCustomerById(c.getCustId()) == null) {
				customer = new Customer(c.getCustId(), c.getCustName(), c.getAddress(), c.getAccountNo(),
						c.getBalance());

				session.persist(customer);

				tx.commit();

				session.close();
			}

			else {
				session.close();
				return "Employee Already Exists";
			}
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			session.close();
			return "Employee Not Saved";
		}

		return "Employee Saved Successfully";

	}

	@Override
	public String update(Customer c) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Customer customer = null;

		try {

			if (findCustomerById(c.getCustId()) != null) {
				customer = session.getReference(Customer.class, c.getCustId());

				customer.setCustName(c.getCustName());
				customer.setAddress(c.getAddress());
				customer.setBalance(c.getBalance());

				session.merge(customer);

				tx.commit();

				session.close();
			}

			else {
				session.close();
				return "Employee Does Not Exists";
			}
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			session.close();
			return "Employee Not Updated";
		}

		return "Employee Updated Successfully";

	}

	@Override
	public String delete(int customerId) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		try {

			if (findCustomerById(customerId) != null) {

				Customer customer = session.getReference(Customer.class, customerId);

				session.remove(customer);

				tx.commit();

				session.close();

			}

			else {
				session.close();
				return "Employee Does Not Exists";
			}
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			session.close();
			return "Employee Not Saved";
		}

		return "Employee Deleted Successfully";

	}

	@Override
	public List<Customer> listAll() {
		Session session = getSession();
		List<Customer> customerList = new ArrayList<>();

		try {
			Query<Customer> customer = session.createQuery("from CustomerBean", Customer.class);

			customerList = customer.getResultList();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		} finally {
			session.close();
		}

		return customerList;

	}

	public Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();

	}
}