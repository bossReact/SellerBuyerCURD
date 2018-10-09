package com.ember.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ember.app.model.Order;
import com.ember.app.util.OrderUtil;
@Component
public class OrderValidator implements Validator {

	@Autowired
	private OrderUtil util;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Order.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Order order=(Order)target;		
		
		if(!util.getBuyerList().contains(order.getBuyer())){
			errors.rejectValue("buyer", "", "Buyer Not Be in DB");
		}
	}

}