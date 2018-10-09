package com.ember.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ember.app.model.Order;
import com.ember.app.service.OrderService;
import com.ember.app.validator.OrderValidator;
@RestController
@RequestMapping("/rest/order")
public class OrderRestController {
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private OrderValidator validator;
	
	/*
	 * 1.save Order Data 
	 */
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Order order, Errors errors){
		
		validator.validate(order,errors);
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else {
			Long orderId = service.save(order);
			if(orderId==0)
				return ResponseEntity.ok("ORDER ALREDY EXIST WITH THIS BUYER: "+orderId);
			return ResponseEntity.ok("ORDER Created with Id: "+orderId);
		}
	}//method
	
	/*
	 * 2.get All Records 
	 */
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		
		Object response = null;
		List<Order> orderList = service.getAll();
		if(orderList==null || orderList.size()==0) {
			response  = "No Order Records Exist.";
		}else {
			response = orderList;
		}
		return ResponseEntity.ok(response);
	}//method
	
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody Order order,Errors errors){
		
		Object response = null;
		validator.validate(order, errors);
		if(errors.hasErrors()) {
			response = errors.getAllErrors();
			return ResponseEntity.badRequest().body(response);
		}else {
			Long orderId=service.update(order);
			if(orderId==0)
				response="ORDER ALREDY EXIST WITH THIS BUYER: "+orderId;
			response = "Order updated with Id:"+order.getId();
			return ResponseEntity.ok(response);
		}//method
	}
		@DeleteMapping("/delete/{orderId}")
		public ResponseEntity<Object> delete(@PathVariable Long orderId){
			
			Object response = null;
			boolean exist = service.isExist(orderId);
			if(!exist) {
				response = "Order "+orderId+" not exist.";
			}else {
				service.delete(orderId);
				response = "Order "+orderId+" is deleted";
			}
			return ResponseEntity.ok(response);
		}//method
	}

