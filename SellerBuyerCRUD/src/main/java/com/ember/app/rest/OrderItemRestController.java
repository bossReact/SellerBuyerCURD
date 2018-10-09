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

import com.ember.app.model.OrderItem;
import com.ember.app.service.OrderItemService;
import com.ember.app.validator.OrderItemValidator;
/**
 * 
 * @author saurabh
 *
 */
@RestController
@RequestMapping("/rest/orderItem")
public class OrderItemRestController {
	

	@Autowired
	private OrderItemService service;
	
	@Autowired
	private OrderItemValidator validator;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody OrderItem orderItem, Errors errors){
		
		validator.validate(orderItem,errors);
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else {
			Long orderItemId = service.save(orderItem);
			if(orderItemId==0)
				return ResponseEntity.ok("ORDER ITEM ALREDY EXIST WITH THIS BUYER: "+orderItemId);
			return ResponseEntity.ok("ORDER ITEM CREATED with Id: "+orderItemId);
		}
	}//method
	
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		
		Object response = null;
		List<OrderItem> orderItemList = service.getAll();
		if(orderItemList==null || orderItemList.size()==0) {
			response  = "No Order Item Records Exist.";
		}else {
			response = orderItemList;
		}
		return ResponseEntity.ok(response);
	}//method
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody OrderItem orderItem,Errors errors){
		
		Object response = null;
		validator.validate(orderItem, errors);
		if(errors.hasErrors()) {
			response = errors.getAllErrors();
			return ResponseEntity.badRequest().body(response);
		}else {
			Long orderItemId=service.update(orderItem);
			if(orderItemId==0)
				response="ORDER ITEM ALREDY EXIST WITH THIS BUYER: "+orderItemId;
			response = "Order ITEM updated with Id:"+orderItem.getId();
			return ResponseEntity.ok(response);
		}
	}
	
	@DeleteMapping("/delete/{orderItemId}")
	public ResponseEntity<Object> delete(@PathVariable Long orderItemId){
		
		Object response = null;
		boolean exist = service.isExist(orderItemId);
		if(!exist) {
			response = "Order ITEM"+orderItemId+" not exist.";
		}else {
			service.delete(orderItemId);
			response = "Order ITEM "+orderItemId+" is deleted";
		}
		return ResponseEntity.ok(response);
	}//method
}
	

