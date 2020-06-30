package com.visu.password.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visu.password.model.Customer;
import com.visu.password.repository.CustomerRepository;
import com.visu.password.request.CredentialRequest;
import com.visu.password.response.AuthenticationStatus;

@Service
public class PasswordService {
	
	@Autowired
	CustomerRepository repository;

	public AuthenticationStatus validate(String userid, CredentialRequest credential) {
		List<Customer> customer = repository.findByUserid(userid);
		if(customer != null & !customer.isEmpty()) {
			return customer.get(0).getPassword().equals(credential.getCrednetial()) ? AuthenticationStatus.PASS : AuthenticationStatus.FAIL;
		}
		return AuthenticationStatus.NOT_AVAILABLE;
	}

}
