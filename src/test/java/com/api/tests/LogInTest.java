package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthenticationServices;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListener.class)
public class LogInTest {
	@Test(description = "Verify whether the user is able to login successfully")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("string", "string");
		AuthenticationServices authServices = new AuthenticationServices();
		Response response = authServices.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getUsername(), "string");
		Assert.assertEquals(loginResponse.getEmail(), "disha134@gmail.com");
		Assert.assertEquals(loginResponse.getId(), 38);
	}
	
}
