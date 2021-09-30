package com.demo.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.shop.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long>{
	
	
	
}
