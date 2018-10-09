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

import com.ember.app.model.Seller;
import com.ember.app.service.SellerService;
import com.ember.app.validator.SellerValidator;
/**
 * 
 * @author saurabh
 *
 */

@RestController
@RequestMapping("/rest/seller")
public class SellerRestController {
	
	@Autowired
	private SellerService service;
	@Autowired
	private SellerValidator validator;
	
	/*
	 * 1.save Seller Data 
	 */
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Seller seller, Errors errors){
		
		validator.validate(seller,errors);
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else {
			Long sellerId = service.save(seller);
			return ResponseEntity.ok("Seller Created with Id: "+sellerId);
		}
	}//method
	
	/*
	 * 2.get All Records 
	 */
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		
		Object response = null;
		List<Seller> sellerList = service.getSelllerList();
		if(sellerList==null || sellerList.size()==0) {
			response  = "No Seller Records Exist.";
		}else {
			response = sellerList;
		}
		return ResponseEntity.ok(response);
	}//method
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody Seller seller,Errors errors){
		
		Object response = null;
		validator.validate(seller, errors);
		if(errors.hasErrors()) {
			response = errors.getAllErrors();
			return ResponseEntity.badRequest().body(response);
		}else {
			service.update(seller);
			response = "Seller updated with Id:"+seller.getId();
			return ResponseEntity.ok(response);
		}//method
	}
	
	/*
	 * 4.Delete Record 
	 */
	@DeleteMapping("/delete/{sellerId}")
	public ResponseEntity<Object> delete(@PathVariable Long sellerId){
		
		Object response = null;
		boolean exist = service.isExist(sellerId);
		if(!exist) {
			response = "Seller "+sellerId+" not exist.";
		}else {
			service.delete(sellerId);
			response = "Seller "+sellerId+" is deleted";
		}
		return ResponseEntity.ok(response);
	}//method
}//class

