package com.ember.app.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.ember.app.model.Order;
import com.ember.app.model.Product;
import com.ember.app.service.OrderService;
import com.ember.app.service.ProductService;

@Component
public class OrderItemUtil {

	@Autowired
	private ProductService product;
	
	@Autowired
	private OrderService order;
	
	public void addUiComponents(ModelMap map) {
		map.addAttribute("orderList", order.getAll());
		map.addAttribute("productList",product.getAll());
	}
	
	public List<Order> getOrderList(){
		return order.getAll();
	}
	public List<Product> getProductList(){
		return product.getAll();
	}
}
