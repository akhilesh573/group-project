package com.finalproject.grocery.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.grocery.entity.UserProfile;
import com.finalproject.grocery.repository.UserProfileRepository;



@Service
public class UserProfileService {

	@Autowired 
	private UserProfileRepository userRepo;
	

	public void addProfile(UserProfile userProfile) {
		userRepo.save(userProfile);
	}
	
	public List<UserProfile> listProfiles(){
		return userRepo.findAll();		
	}
	
}
