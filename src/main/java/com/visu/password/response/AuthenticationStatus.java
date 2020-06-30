package com.visu.password.response;

public enum AuthenticationStatus {
	
	PASS("pass"),
	FAIL("fail"),
	NOT_AVAILABLE("notAvailable");
	
	private String value;
	
	AuthenticationStatus (String value) { this.value = value; }
	
	public String getValue() { return value; }
	
	@Override
	public String toString() {
		return "AuthenticationStatus{" + "value='" + this.getValue() + '\'' + '}';
	}
	
	public static AuthenticationStatus getEnum(String value) {
		for (AuthenticationStatus authenticationStatus : AuthenticationStatus.values()) {
			if(authenticationStatus.getValue().equalsIgnoreCase(value)) {
				return authenticationStatus;
			}
		}
		throw new IllegalArgumentException("Unknown AuthenticaitonStatus for value: " + value);
	}

}
