package com.ember.app.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.ember.app.model.Buyer;
import com.ember.app.service.BuyerService;

@Component
public class OrderUtil {

	@Autowired
	private BuyerService service;

	public void addUi(ModelMap map) {
		map.addAttribute("buyerList", service.getBuyerList());
	}
	
	public List<Buyer> getBuyerList(){
		return service.getBuyerList();
	}

	

}
