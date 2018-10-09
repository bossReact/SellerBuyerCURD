package com.ember.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ember.app.model.Buyer;
import com.ember.app.model.Seller;
import com.ember.app.service.SellerService;

@Controller
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SellerService service;
	/**
	 * Showing the register page
	 */
	@GetMapping(value = "/register")
	public String welcome(ModelMap map) {
		map.addAttribute("seller", new Seller());
		return "SellerRegister";
	}

	/**
	 * For inserting the seller
	 */
	@PostMapping(value = "/register")
	public String register(@ModelAttribute Seller seller, ModelMap map) {
		String message = "This User already in DB";
		long id = service.save(seller);

		if (id != 0){
			message = seller.getName() + "Seller save Successfuly";
			map.addAttribute("", new Buyer());
		}
		map.addAttribute("message", message);
		return "SellerRegister";
	}

	/**
	 * For showing the edit page
	 */
	@GetMapping(value = "/edit")
	public String showEdit(@RequestParam Long sellerId, ModelMap map) {
		Seller seller = service.getSeller(sellerId);
		if (seller != null) {
			map.addAttribute("seller", seller);
		}
		return "sellerDataEdit";
	}

	/**
	 * For updating the seller entity
	 */

	@PostMapping(value = "/update")
	public String update(@ModelAttribute Seller seller, ModelMap map) {

		String message = "Not update";
		long id = service.update(seller);
		if (id != 0)
			message = seller.getName() + "Seller updated Successfuly";

		map.addAttribute("message", message);
		return "redirect:all";
	}

	/**
	 * For Displaying all Seller
	 */
	@GetMapping(value = "/all")
	public String getAllSeller(ModelMap map) {
		map.addAttribute("sellerList", service.getSelllerList());
		map.addAttribute("seller", new Seller());
		return "SellerData";
	}

	/**
	 * For deleting the seller entity based on id
	 */
	@GetMapping("/delete")
	public String delete(@RequestParam Long sellerId, ModelMap map) {
		service.delete(sellerId);
		map.addAttribute("message", "deleted Successfully");

		return "redirect:all";
	}
	
	
	
}
