package com.ember.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ember.app.model.Product;
import com.ember.app.util.ProductUtil;
@Component
public class ProductValidator implements Validator {

	@Autowired
	private ProductUtil util;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product=(Product)target;		
		
		if(!util.getSellerList().contains(product.getSeller())){
			errors.rejectValue("seller", "", "Buyer Not Be in DB");
		}
		if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]").matcher(product.getName()).matches()) {
			errors.rejectValue("name", "", "Input only character");
		}
		if(product.getName().equals("")||product.getName().length()<0){
			errors.rejectValue("name", "", "please Provide the product name");
		}
		
	}

}