package com.java.springhibernate.service;

import java.util.List;

import com.java.springhibernate.model.Customer;

public interface CustomerService {

	public void add(Customer customer);
	public Customer get(int id);
	public List<Customer> listofcustomer();
	public void delete(Customer customer);

}
