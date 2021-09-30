package com.demo.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shop.entity.PurchaseOrder;
import com.demo.shop.service.PurchaseOrderService;

@RestController
@RequestMapping("/purchase-order")
public class PurchaseOrderRestController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<PurchaseOrder> findByOrderId(@PathVariable("orderId") Long orderId){
		
		PurchaseOrder found = purchaseOrderService.findById(orderId);
		
		if(found == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(found);
	}
	
	@PostMapping("/")
	public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
		
		PurchaseOrder created = purchaseOrderService.createPurchaseOrder(purchaseOrder);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
		
		
	}
	
	
}
