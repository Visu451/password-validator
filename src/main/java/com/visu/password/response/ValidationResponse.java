package com.visu.password.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationResponse {

	@JsonProperty
	private AuthenticationStatus authenticationStatus;
		
	public ValidationResponse(AuthenticationStatus authenticationStatus) {
		super();
		this.authenticationStatus = authenticationStatus;
	}

	public String getAuthenticationStatus() {
		if(null == authenticationStatus) {
			return null;
		}
		return authenticationStatus.getValue();
	}
	
}
