package com.finalproject.grocery.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.grocery.common.ApiResponse;
import com.finalproject.grocery.entity.UserProfile;
import com.finalproject.grocery.service.UserProfileService;




@RestController
@RequestMapping("/user")
public class UserProfileController {

	@Autowired private UserProfileService userProfileService;

	@GetMapping("/")
	public ResponseEntity<List<UserProfile>> getUsers() {
		List<UserProfile> dtos = userProfileService.listProfiles();
		return new ResponseEntity<List<UserProfile>>(dtos, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addSurvey(@RequestBody @Valid UserProfile profile) {
		userProfileService.addProfile(profile);
		return new ResponseEntity<>(new ApiResponse(true, "Profile has been created."), HttpStatus.CREATED);
	}	
}