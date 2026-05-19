package com.api.base;

import io.restassured.response.Response;

public class AuthenticationServices extends BaseService {
	private static final String BASE_PATH = "/api/auth/";
	
	public Response login(String requestPayload) {
		return postRequest(requestPayload, BASE_PATH + "login");
	}
}
