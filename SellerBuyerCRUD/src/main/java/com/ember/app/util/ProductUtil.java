package com.ember.app.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.ember.app.model.Seller;
import com.ember.app.service.SellerService;
@Component
public class ProductUtil {

	@Autowired
	private SellerService service;
	
	public void addUiComponents(ModelMap map) {
	map.addAttribute("sellerList", service.getSelllerList());
	}
	
	public List<Seller> getSellerList(){
		return service.getSelllerList();
	}
	
	

}
