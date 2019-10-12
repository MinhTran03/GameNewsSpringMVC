package com.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springmvc.models.UserInfo;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> target) {
		return UserInfo.class.equals(target);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserInfo userInfo = (UserInfo)target;
		
		ValidationUtils.rejectIfEmpty(errors,"password" , "Pass.To.Short");
		
		String temp = userInfo.getEmail();
		if (temp.length() < 5) {
			errors.rejectValue("password", "Pass.To.Short");
		}
	}

}
