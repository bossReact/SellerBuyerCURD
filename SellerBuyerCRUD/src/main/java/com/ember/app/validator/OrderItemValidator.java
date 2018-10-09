package com.ember.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ember.app.model.OrderItem;
import com.ember.app.util.OrderItemUtil;
/**
 * 
 * @author saurabh
 *
 */
@Component
public class OrderItemValidator implements Validator {

	@Autowired
	private OrderItemUtil util;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return OrderItem.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderItem orderItem=(OrderItem)target;	
		
		if(!util.getProductList().contains(orderItem.getProduct()))
		{
			errors.rejectValue("product", "", "This Product Not Be in DB");
		}
		if(!util.getOrderList().contains(orderItem.getOrder())){
			errors.rejectValue("product", "", "This Order Not Be in DB");
		}
		
		
	}

}