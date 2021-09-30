package com.demo.shop.service;

import java.util.List;

import com.demo.shop.entity.PurchaseOrder;

public interface PurchaseOrderService {

	public PurchaseOrder findById(Long id);
	public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder);
	
}
