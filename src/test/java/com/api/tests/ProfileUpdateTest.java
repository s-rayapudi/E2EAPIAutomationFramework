package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthenticationServices;
import com.api.base.UserManagementServices;
import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateProfileRequest;
import com.api.models.response.GetProfileResponse;
import com.api.models.response.LoginResponse;
import com.api.models.response.UpdateProfileResponse;

import io.restassured.response.Response;

public class ProfileUpdateTest {
	@Test(description = "Verify whether we are able to update the profile")
	public void profileUpdate() {
		AuthenticationServices authServices = new AuthenticationServices();
		Response response = authServices.login(new LoginRequest("sandeep_r", "Incorrect@123"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		UserManagementServices userManagementServices = new UserManagementServices();
		response = userManagementServices.getProfile(loginResponse.getToken());
		GetProfileResponse getProfileResponse = response.as(GetProfileResponse.class);
		Assert.assertEquals(getProfileResponse.getUsername(), "sandeep_r");
		
		UpdateProfileRequest profileUpdateRequest = new UpdateProfileRequest.Builder()
														.firstName("Man")
														.lastName("United")
														.email("sandeep@qa.com")
														.mobileNumber("9848022331").build();
		
		response = userManagementServices.updateProfile(loginResponse.getToken(), profileUpdateRequest);
		System.out.println(response.asPrettyString());
		UpdateProfileResponse updateProfileResponse = response.as(UpdateProfileResponse.class);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(updateProfileResponse.getFirstName(), "Man");
		Assert.assertEquals(updateProfileResponse.getMobileNumber(), "9848022331");
		
	}
}
