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
import com.ember.app.model.OrderItem;
import com.ember.app.model.Product;
import com.ember.app.service.OrderItemService;
import com.ember.app.util.OrderItemUtil;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {

	@Autowired
	private OrderItemUtil util;
	
	@Autowired
	private OrderItemService service;
	
	/**
	 * For Showing Order Item Registration Form
	 */
	@GetMapping("/register")
	 public String showRegister(ModelMap map) {
		 //Add component to UI
		map.addAttribute("orderItem",new OrderItem()); 
		util.addUiComponents(map);
		 return "orderItemRegister";
	 }
	
	/**
	 * save OrderItem Data to DB  */
	@PostMapping("/register")
	public String saveData(@ModelAttribute OrderItem orderItem,ModelMap map) {
		Long orderItemId = service.save(orderItem);
		//Clear form (model Object) after save
		if(orderItemId!=0){
		map.addAttribute("orderItem",new OrderItem());
		//Send Message to UI After save
		map.addAttribute("message","OrderItem created with ID: "+ orderItemId);
		}
		util.addUiComponents(map);
		return "orderItemRegister";
	}
	
	/**
	 * For Displaying all OrderItem
	 */
	@GetMapping(value = "/all")
	public String getAllSeller(ModelMap map) {
		List<OrderItem> orderItemList=service.getAll();
		String message="No OrderItem FOUND";
		if(orderItemList!=null){
			map.addAttribute("orderItemList", orderItemList);
			message=null;
		}
			map.addAttribute("message",message);
		return "orderItemData";
	}
	
	/*
	 * 5.Show ProductEdit Page
	 */
	@GetMapping("/edit")
	public String edit(@RequestParam Long orderItemId,ModelMap map) {
		OrderItem orderItem = service.getOne(orderItemId);
		util.addUiComponents(map);
		map.addAttribute("orderItem",orderItem);
		return "orderItemDataEdit";
	}
	
	/*
	 * 6.Update ProductUpdate to DB
	 */
	@PostMapping("/update")
	public String update(@ModelAttribute OrderItem orderItem,ModelMap map) {
		
		long orderItemId=service.update(orderItem);
		String message="No OrderItem FOUND";
		List<OrderItem> orderItemList=service.getAll();
		if(orderItemId!=0){
			util.addUiComponents(map);
			map.addAttribute("orderItemList", orderItemList);
			message=null;
		}
		map.addAttribute("message",message);
		return "orderItemData";
	  }
	
	
	/**
	 * For Deleting product based on Id
	 * @param productId
	 * @return
	 */
	@GetMapping("/delete")
	public String delete(@RequestParam long orderItemId){
		service.delete(orderItemId);
		return "redirect:all";
	}
	
	
	
	
	
}
