package com.ember.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ember.app.model.Buyer;
@Component
public class BuyerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Buyer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Buyer buyer=(Buyer)target;
		
		if(!Pattern.compile("[a-zA-Z \\t\\n\\x0B\\f\\r]{10,255}").matcher(buyer.getFirstName()).matches()) {
			errors.rejectValue("firstName", "", "Chars only range of 10-255 accepted");
		}
		if(buyer.getFirstName()=="" ||buyer.getFirstName().length()<0){
			errors.rejectValue("firstName", "", "FirstName not valid");
		}
		if(buyer.getLastName()=="" ||buyer.getLastName().length()<0){
			errors.rejectValue("lastName", "", "LastName not valid");
		}
		
	}

}
