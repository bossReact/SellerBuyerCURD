package com.ember.app.service;

import java.util.List;

import com.ember.app.model.OrderItem;

public interface OrderItemService {

	public Long save(OrderItem orderItem);
	public long update(OrderItem orderItem);
	public void delete(Long orderItemId);
	public OrderItem getOne(Long orderItemId);
	public boolean isExist(Long orderItemId);
	public List<OrderItem> getAll();
	
}
