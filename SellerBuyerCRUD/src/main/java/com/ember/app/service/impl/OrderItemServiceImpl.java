package com.ember.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ember.app.model.OrderItem;
import com.ember.app.repo.OrderItemRepository;
import com.ember.app.service.OrderItemService;
@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository repo;
	
	@Override
	public Long save(OrderItem orderItem) {
		long id=0;
		try{	
		id=repo.save(orderItem).getId();
		}catch(Exception e){
			id=0;
		}
	return id;
	}

	@Override
	public long update(OrderItem orderItem) {
		long id=0;
		try{	
		id=repo.save(orderItem).getId();
		}catch(Exception e){
			id=0;
		}
	return id;
	}

	@Override
	public void delete(Long orderItemId) {
		repo.deleteById(orderItemId);
	}

	@Override
	public OrderItem getOne(Long orderItemId) {
		return repo.getOne(orderItemId);
	}

	@Override
	public List<OrderItem> getAll() {
		return repo.findAll();
	}

	@Override
	public boolean isExist(Long orderItemId) {
		return repo.existsById(orderItemId);
	}

}
