package com.ember.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ember.app.model.Buyer;
import com.ember.app.service.BuyerService;

@Controller
@RequestMapping("/buyer")
public class BuyerController {

	@Autowired
	private BuyerService service;
	/**
	 * Showing the register page
	 */
	@GetMapping(value = "/register")
	public String welcome(ModelMap map) {
		map.addAttribute("buyer", new Buyer());
		return "buyerRegister";
	}

	/**
	 * For inserting the seller
	 */
	@PostMapping(value = "/register")
	public String register(@ModelAttribute Buyer buyer, ModelMap map) {
		String message = "This Buyer already in DB";
		long id = service.save(buyer);

		if (id != 0){
			message = buyer.getFirstName() +" "+buyer.getLastName()+"Seller save Successfuly";
			map.addAttribute("", new Buyer());
		}
		map.addAttribute("message", message);

		return "buyerRegister";
	}

	/**
	 * For showing the edit page
	 */
	@GetMapping(value = "/edit")
	public String showEdit(@RequestParam Long buyerId, ModelMap map) {
		Buyer buyer = service.getBuyer(buyerId);
		if (buyer != null) {
			map.addAttribute("buyer", buyer);
		}
		return "buyerDataEdit";
	}

	/**
	 * For updating the seller entity
	 */

	@PostMapping(value = "/update")
	public String update(@ModelAttribute Buyer buyer, ModelMap map) {

		String message = "Not update";
		long id = service.update(buyer);
		if (id != 0)
			message = buyer.getFirstName() + "buyer updated Successfuly";

		map.addAttribute("message", message);
		return "redirect:all";
	}

	/**
	 * For Displaying all Seller
	 */
	@GetMapping(value = "/all")
	public String getAllSeller(ModelMap map) {
		map.addAttribute("buyerList", service.getBuyerList());
		map.addAttribute("buyer", new Buyer());
		return "buyerData";
	}

	/**
	 * For deleting the seller entity based on id
	 */
	@GetMapping("/delete")
	public String delete(@RequestParam Long buyerId, ModelMap map) {
		service.delete(buyerId);
		map.addAttribute("message", "deleted Successfully");

		return "redirect:all";
	}
	
	
	
}
