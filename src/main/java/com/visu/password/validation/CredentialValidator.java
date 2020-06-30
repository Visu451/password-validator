package com.visu.password.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class CredentialValidator implements ConstraintValidator<Credential, String>{
	
	@Override
	public boolean isValid(String password, ConstraintValidatorContext context){

		for (int index = 0; index < password.length(); index++) {
			char c1 = password.charAt(index);
			int index2 = password.indexOf(c1, index + 1);
			if (index2 != -1) {
				String str1 = password.substring(index, index2);
				String str2 = password.substring(index2, 2 * index2 - index);
				if(str1.equals(str2)){
					return false;
				}
			}
		}
		return true;
	}
}
