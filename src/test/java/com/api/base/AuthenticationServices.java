package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthenticationServices extends BaseService {
	private static final String BASE_PATH = "/api/auth/";
	
	public Response login(LoginRequest requestPayload) {
		return postRequest(requestPayload, BASE_PATH + "login");
	}
	
	public Response signup(SignUpRequest requestPayload) {
		return postRequest(requestPayload, BASE_PATH + "signup");
	}
}
