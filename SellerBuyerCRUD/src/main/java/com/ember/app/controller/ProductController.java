package com.ember.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ember.app.model.Buyer;
import com.ember.app.model.Product;
import com.ember.app.service.ProductService;
import com.ember.app.util.ProductUtil;

/**
 * 
 * @author saurabh
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	private ProductUtil util;
	
	
	@Autowired
	private ProductService service;
	
	/**
	 * For showing Register Page
	 */
	@GetMapping("/register")
	 public String showRegister(ModelMap map) {
		 //Add component to UI
		map.addAttribute("product",new Product()); 
		util.addUiComponents(map);
		 return "productRegister";
	 }
	
	
	/**
	 * save Data to DB  */
	@PostMapping("/register")
	public String saveData(@ModelAttribute Product product,ModelMap map) {
		Long productId = service.save(product);
		//Clear form (model Object) after save
		map.addAttribute("product",new Product());
		//Send Message to UI After save
		map.addAttribute("message","Product created with ID: "+ productId);
		util.addUiComponents(map);
		return "productRegister";
	}
	
	/**
	 * For Displaying all Product
	 */
	@GetMapping(value = "/all")
	public String getAllSeller(ModelMap map) {
		List<Product> productList=service.getAll();
		String message="No Product FOUND";
		if(productList!=null){
			map.addAttribute("productList", service.getAll());
			message=null;
		}
			map.addAttribute("message",message);
			map.addAttribute("product", new Buyer());
		return "productData";
	}

	/*
	 * 5.Show ProductEdit Page
	 */
	@GetMapping("/edit")
	public String edit(@RequestParam Long productId,ModelMap map) {
		Product product = service.getOne(productId);
		util.addUiComponents(map);
		map.addAttribute("product",product);
		return "productDataEdit";
	}
	
	/*
	 * 6.Update ProductUpdate to DB
	 */
	@PostMapping("/update")
	public String update(@ModelAttribute Product product,ModelMap map) {
		
			service.update(product);
			return "redirect:all";
	  }
	
	/**
	 * For Deleting product based on Id
	 * @param productId
	 * @return
	 */
	@GetMapping("/delete")
	public String delete(@RequestParam long productId){
		service.delete(productId);
		return "redirect:all";
	}
}
