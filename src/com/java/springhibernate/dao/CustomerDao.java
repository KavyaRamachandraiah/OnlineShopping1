package com.java.springhibernate.dao;

import java.util.List;

import com.java.springhibernate.model.Customer;

public interface CustomerDao {

	public void add(Customer customer);
	public Customer get(int id);
	public List<Customer> listofcustomer();
	public void delete(Customer customer);
}
