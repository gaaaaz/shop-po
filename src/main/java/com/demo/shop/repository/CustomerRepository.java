package com.demo.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.shop.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
	
}
