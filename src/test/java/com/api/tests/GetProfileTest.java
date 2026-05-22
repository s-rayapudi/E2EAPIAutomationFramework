package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthenticationServices;
import com.api.base.UserManagementServices;
import com.api.models.request.LoginRequest;
import com.api.models.response.GetProfileResponse;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;

public class GetProfileTest {
	
	@Test(description = "Verify whether the profile info returned successfully")
	public void getProfileInfoTest() {
		AuthenticationServices authServices = new AuthenticationServices();
		Response response = authServices.login(new LoginRequest("sandeep_r", "Incorrect@123"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		UserManagementServices userManagementServices = new UserManagementServices();
		response = userManagementServices.getProfile(loginResponse.getToken());
		GetProfileResponse getProfileResponse = response.as(GetProfileResponse.class);
		Assert.assertEquals(getProfileResponse.getUsername(), "sandeep_r");
		Assert.assertEquals(getProfileResponse.getEmail(), "sandeep@qa.com");
		
	}
	
}
