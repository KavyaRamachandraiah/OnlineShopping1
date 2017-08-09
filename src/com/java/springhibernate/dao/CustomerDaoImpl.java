package com.java.springhibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.springhibernate.model.Customer;

@Repository
public class CustomerDaoImpl  implements CustomerDao{
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void add(Customer customer) {
		sessionfactory.getCurrentSession().saveOrUpdate(customer);
	
	}

	@Override
	public Customer get(int id) {
		 return (Customer)sessionfactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> listofcustomer() {
		return sessionfactory.getCurrentSession().createCriteria(Customer.class).list();
	}

	@Override
	public void delete(Customer customer) {
		sessionfactory.getCurrentSession().createQuery("delete from Customer where id="+customer.getId()).executeUpdate();
	}

	
	
}
