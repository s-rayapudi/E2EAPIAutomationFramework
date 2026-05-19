package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthenticationServices;

import io.restassured.response.Response;

public class LogInTest {
	@Test(description = "Verify whether the user is able to login successfully")
	public void loginTest() {
		
		AuthenticationServices authServices = new AuthenticationServices();
		Response response = authServices.login("{\r\n"
				+ "  \"username\": \"string\",\r\n"
				+ "  \"password\": \"string\"\r\n"
				+ "}");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
