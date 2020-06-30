package com.visu.password.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visu.password.request.CredentialRequest;
import com.visu.password.response.AuthenticationStatus;
import com.visu.password.response.ValidationResponse;
import com.visu.password.service.PasswordService;

@RestController
public class PasswordController {
	
	@Autowired
	private PasswordService passwordService;

	@PostMapping("/validate")
	public ResponseEntity<ValidationResponse> validate(@RequestParam(value = "userid") String userid, @Valid @RequestBody CredentialRequest credential) {
		AuthenticationStatus status = passwordService.validate(userid, credential);
		ValidationResponse response = new ValidationResponse(status);
		return ResponseEntity.ok(response);
	}
}
