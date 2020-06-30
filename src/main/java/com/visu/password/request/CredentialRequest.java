package com.visu.password.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.visu.password.validation.Credential;

public class CredentialRequest {
	
	private static final String PASSWORD_REGEX = "(([a-z0-9])((?=.*\\d)(?=.*[a-z]).{5,12}))";
	private static final String INVALID_PASSWORD = "The passowrd must be between 5 and 12 characters in length, and must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.";

	@NotNull
	@Pattern (regexp = PASSWORD_REGEX, message = INVALID_PASSWORD)
	@Size(min=5, max=12)
	@Credential
	private String credential;
	
	@JsonCreator
	public CredentialRequest(@JsonProperty("credential") String credential) { this.credential = credential; }
	
	public String getCrednetial() { return credential; }

}
