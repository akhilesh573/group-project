package com.finalproject.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.grocery.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
