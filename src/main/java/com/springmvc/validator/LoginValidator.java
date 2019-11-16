package com.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springmvc.models.UserLogin;

@Component
public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserLogin.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserLogin user = (UserLogin)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Email.NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password.NotEmpty");
		
		if(errors.getFieldErrorCount("email") == 0) {
			String email = user.getEmail();
			if (email.matches("^\\w+@\\w+\\..{2,3}(.{2,3})?$") == false) {
					errors.rejectValue("email", "Email.NotValid");
				}
		}
	}

}
