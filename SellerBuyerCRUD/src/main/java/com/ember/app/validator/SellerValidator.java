package com.ember.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ember.app.model.Seller;
@Component
public class SellerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Seller.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Seller seller=(Seller)target;
		
		if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]{10,255}").matcher(seller.getName()).matches()) {
			errors.rejectValue("name", "", "Chars only range of 10-255 accepted");
		}
		
	}

}
