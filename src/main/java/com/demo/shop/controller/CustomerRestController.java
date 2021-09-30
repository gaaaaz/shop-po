package com.demo.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shop.entity.Customer;
import com.demo.shop.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public ResponseEntity<List<Customer>> findAllCustomers(){
		
		List<Customer> found = customerService.findAllCustomers();
		
		if(found.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(found);
		
	}
	
	@GetMapping("/{idCustomer}")
	public ResponseEntity<Customer> findCustomer(@PathVariable("idCustomer") Long idCustomer){
		
		Customer found = customerService.getCustomerById(idCustomer);
		
		if(found == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(found);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		
		Customer created = customerService.createCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@PutMapping("/{idCustomer}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("idCustomer") Long idCustomer, @RequestBody Customer customer){
		
		customer.setId(idCustomer);
		Customer updated = customerService.updateCustomer(customer);
		
		if(updated == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(updated);
		
	}
	
	@DeleteMapping("/{idCustomer}")
	public void deleteCustomer(@PathVariable("idCustomer") Long idCustomer){
		customerService.deleteCustomer(idCustomer);
	}
	
}