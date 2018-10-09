package com.ember.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ember.app.model.Order;
import com.ember.app.repo.OrderRepository;
import com.ember.app.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repo;
	@Override
	public Long save(Order order) {

		long id=0;
		try{	
		id=repo.save(order).getId();
		}catch(Exception e){
			id=0;
		}
	return id;
	}

	@Override
	public Long update(Order order) {
		long id=0;
		try{	
		id=repo.save(order).getId();
		}catch(Exception e){
			id=0;
		}
		return id;
	}

	@Override
	public void delete(Long orderId) {
		repo.deleteById(orderId);
	}

	@Override
	public Order getOne(Long orderId) {
		return repo.getOne(orderId);
	}

	@Override
	public List<Order> getAll() {
		return repo.findAll();
	}

	@Override
	public boolean isExist(Long orderId) {
		return repo.existsById(orderId);
	}

}
