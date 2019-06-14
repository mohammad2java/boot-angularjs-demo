package com.github.amir.bootangularjsdemo.controller.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FormdataValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return FormdataValidator.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Formdata formdata = (Formdata) target;
		if (!formdata.getPassword().equalsIgnoreCase(formdata.getRepeatpass())) {
				errors.rejectValue("repeatpass", "repeat.pass.errors.meesage");
		}
		
	}

	
}
