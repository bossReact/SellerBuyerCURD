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
import com.ember.app.model.Order;
import com.ember.app.model.Product;
import com.ember.app.service.OrderService;
import com.ember.app.util.OrderUtil;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderUtil util;
	
	@Autowired
	private OrderService service;
	/**
	 * For showing the order registration page
	 */
	@GetMapping("/register")
	public String showOrderPage(ModelMap map){
		util.addUi(map);
		map.addAttribute("order", new Order());
		return "orderRegister";
	}
	
	/**
	 * For inserting the order
	 */
	@PostMapping("/register")
	public String insertOrder(@ModelAttribute Order order,ModelMap map){
		Long orderId = service.save(order);
		//Clear form (model Object) after save
		if(orderId!=0){
		map.addAttribute("order",new Order());
		//Send Message to UI After save
		map.addAttribute("message","Order created with ID: "+ orderId);
		}
		util.addUi(map);
		return "orderRegister";
	}
	
	
	/**
	 * For Displaying all Orders
	 */
	@GetMapping(value = "/all")
	public String getAllOrders(ModelMap map) {
		List<Order> orderList=service.getAll();
		String message="No Product FOUND";
		if(orderList!=null){
			map.addAttribute("orderList", orderList);
			message=null;
		}
			map.addAttribute("message",message);
			map.addAttribute("order", new Order());
		return "orderData";
	}
	
	/*
	 * 5.Show OrderEdit Page
	 */
	@GetMapping("/edit")
	public String edit(@RequestParam Long orderId,ModelMap map) {
		Order order = service.getOne(orderId);
		util.addUi(map);
		map.addAttribute("order", order);
		return "orderDataEdit";
	}
	
	/*
	 * 6.Update Order Data to DB
	 */
	@PostMapping("/update")
	public String update(@ModelAttribute Order order,ModelMap map) {
		
			Long id=service.update(order);
			return "redirect:all";
	  }
	
	@GetMapping("/delete")
	public String delete(@RequestParam long orderId){
		service.delete(orderId);
		return "redirect:all";
	}

	
}
