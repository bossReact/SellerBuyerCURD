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

import com.ember.app.model.Buyer;
import com.ember.app.service.BuyerService;
import com.ember.app.validator.BuyerValidator;

@RestController
@RequestMapping("/rest/buyer")
public class BuyerRestController {
	
	@Autowired
	private BuyerService service;
	
	@Autowired
	private BuyerValidator validator;
	
	/*
	 * 1.save Buyer Data 
	 */
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Buyer buyer, Errors errors){
		
		validator.validate(buyer,errors);
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else {
			Long buyerId = service.save(buyer);
			return ResponseEntity.ok("Buyer Created with Id: "+buyerId);
		}
	}//method
	
	/*
	 * 2.get All Records 
	 */
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		
		Object response = null;
		List<Buyer> buyerList = service.getBuyerList();
		if(buyerList==null || buyerList.size()==0) {
			response  = "No Buyer Records Exist.";
		}else {
			response = buyerList;
		}
		return ResponseEntity.ok(response);
	}//method

	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody Buyer buyer,Errors errors){
		
		Object response = null;
		validator.validate(buyer, errors);
		if(errors.hasErrors()) {
			response = errors.getAllErrors();
			return ResponseEntity.badRequest().body(response);
		}else {
			service.update(buyer);
			response = "Buyer updated with Id:"+buyer.getId();
			return ResponseEntity.ok(response);
		}//method
	}
	
	/*
	 * 4.Delete Record 
	 */
	@DeleteMapping("/delete/{buyerId}")
	public ResponseEntity<Object> delete(@PathVariable Long buyerId){
		
		Object response = null;
		boolean exist = service.isExist(buyerId);
		if(!exist) {
			response = "Buyer "+buyerId+" not exist.";
		}else {
			service.delete(buyerId);
			response = "Seller "+buyerId+" is deleted";
		}
		return ResponseEntity.ok(response);
	}//method
}//class
	

