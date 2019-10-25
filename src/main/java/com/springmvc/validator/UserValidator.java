package com.springmvc.validator;

import java.time.LocalDate;

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

		UserInfo userInfo = (UserInfo) target;

		ValidationUtils.rejectIfEmpty(errors, "firstName", "FirstName.NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "LastName.NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "email", "Email.NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "password", "Password.NotEmpty");

		String email = userInfo.getEmail();
		if (email.matches("^\\w+@\\w+\\..{2,3}(.{2,3})?$") == false) {
			if(errors.getFieldErrorCount("email") == 0) {
				errors.rejectValue("email", "Email.NotValid");
			}
		}
		
		String password = userInfo.getPassword();
		if (password.length() < 6) {
			if(errors.getFieldErrorCount("password") == 0) {
				errors.rejectValue("password", "Password.Min");
			}
		}
		
		LocalDate birth = userInfo.getBirthday();
		LocalDate today = LocalDate.now();
		if (birth.isAfter(today)) {
			if(errors.getFieldErrorCount("birthday") == 0) {
				errors.rejectValue("birthday", "BirthDate.NotValid");
			}
		}
	}
	
}
