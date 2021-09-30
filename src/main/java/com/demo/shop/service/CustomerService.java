package com.demo.shop.service;

import java.util.List;

import com.demo.shop.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAllCustomers();
	public Customer getCustomerById(Long id);
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(Long id);
	
}
