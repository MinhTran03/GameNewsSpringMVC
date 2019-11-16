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

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "FirstName.NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "LastName.NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Email.NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password.NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "BirthDate.NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "PhoneNumber.NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "Address.NotEmpty");

		if(errors.getFieldErrorCount("email") == 0) {
			String email = userInfo.getEmail();
			if (email.matches("^\\w+@\\w+\\..{2,3}(.{2,3})?$") == false) {
					errors.rejectValue("email", "Email.NotValid");
				}
		}
		
		if(errors.getFieldErrorCount("password") == 0) {
			String password = userInfo.getPassword();
			if (password.length() < 6) {
					errors.rejectValue("password", "Password.Min");
			}else {
				String cp = userInfo.getConfirmPassword();
				if(!password.equals(cp)) {
					errors.rejectValue("password", "Password.NotConfirm");
				}
			}
		}
		
		if(errors.getFieldErrorCount("birthday") == 0) {
			LocalDate birth = userInfo.getBirthday();
			if(birth != null) {
				LocalDate today = LocalDate.now();
				if (birth.isAfter(today)) {
						errors.rejectValue("birthday", "BirthDate.NotValid");
				}
			}
		}
	}
	
}
