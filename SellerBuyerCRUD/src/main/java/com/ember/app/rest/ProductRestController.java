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

import com.ember.app.model.Product;
import com.ember.app.service.ProductService;
import com.ember.app.validator.ProductValidator;

@RestController
@RequestMapping("/rest/product")
public class ProductRestController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductValidator validator;
	
	
	/*
	 * 1.save Product Data 
	 */
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Product product, Errors errors){
		
		validator.validate(product,errors);
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else {
			Long productId = service.save(product);
			return ResponseEntity.ok("Product Created with Id: "+productId);
		}
	}//method
	
	
	/*
	 * 2.get All Records 
	 */
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		
		Object response = null;
		List<Product> productList = service.getAll();
		if(productList==null || productList.size()==0) {
			response  = "No Product Records Exist.";
		}else {
			response = productList;
		}
		return ResponseEntity.ok(response);
	}//method
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody Product product,Errors errors){
		
		Object response = null;
		validator.validate(product, errors);
		if(errors.hasErrors()) {
			response = errors.getAllErrors();
			return ResponseEntity.badRequest().body(response);
		}else {
			service.update(product);
			response = "Product updated with Id:"+product.getId();
			return ResponseEntity.ok(response);
		}
	}
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Object> delete(@PathVariable Long productId){
		
		Object response = null;
		boolean exist = service.isExist(productId);
		if(!exist) {
			response = "Product "+productId+" not exist.";
		}else {
			service.delete(productId);
			response = "Product "+productId+" is deleted";
		}
		return ResponseEntity.ok(response);
	}//method
	
}
