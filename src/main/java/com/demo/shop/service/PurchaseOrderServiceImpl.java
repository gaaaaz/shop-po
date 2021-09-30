package com.demo.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shop.entity.PurchaseOrder;
import com.demo.shop.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	public PurchaseOrderRepository purchaseOrderRepository;

	@Override
	public PurchaseOrder findById(Long id) {
		return purchaseOrderRepository.findById(id).get(); //Si es lazy, usar esto para findById
	}

	@Override
	public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
		return purchaseOrderRepository.save(purchaseOrder);
	}
	
	
	
	
}
