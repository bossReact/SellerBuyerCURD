package com.ember.app.service;

import java.util.List;

import com.ember.app.model.Order;

public interface OrderService {
	public Long save(Order order);
	public Long update(Order order);
	public void delete(Long orderId);
	public Order getOne(Long orderId);
	public List<Order> getAll();
	public boolean isExist(Long orderId);
}
