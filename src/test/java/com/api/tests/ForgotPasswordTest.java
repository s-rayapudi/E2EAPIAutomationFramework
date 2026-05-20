package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthenticationServices;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	@Test(description = "Verify forgot password test")
	public void forgotPasswordTest() {
		AuthenticationServices authServices = new AuthenticationServices();
		Response response = authServices.forgotPassword("sandeep@qa.com");
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
