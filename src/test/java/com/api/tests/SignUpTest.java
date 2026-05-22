package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthenticationServices;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListener.class)
public class SignUpTest {
	
	@Test(description = "Verify SignUp Test")
	public void signupTest() {
	
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
				.userName("sandeep_sr2")
				.password("Incorrect@123")
				.email("sandeep@qe.com")
				.firstName("Sandeep")
				.lastName("Raya")
				.mobileNumber("7848022338")
				.build();

		AuthenticationServices authServices = new AuthenticationServices();
		Response response = authServices.signup(signUpRequest);
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);
	}
	
}
