package com.zulkarnaen.login.service;

import java.util.List;

import com.zulkarnaen.login.model.UserProfile;

public interface UserProfileService {

	List<UserProfile> findAll();

	UserProfile findByType(String type);

	UserProfile findById(int id);
}