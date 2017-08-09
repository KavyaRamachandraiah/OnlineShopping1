package com.java.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.springhibernate.dao.CustomerDao;
import com.java.springhibernate.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerdao;

	@Override
	public void add(Customer customer) {
		customerdao.add(customer);
		
	}

	@Override
	public Customer get(int id) {
		return customerdao.get(id);
	}

	@Override
	public List<Customer> listofcustomer() {
		return customerdao.listofcustomer();
	}

	@Override
	public void delete(Customer customer) {
		customerdao.delete(customer);
	}

	
	
}
