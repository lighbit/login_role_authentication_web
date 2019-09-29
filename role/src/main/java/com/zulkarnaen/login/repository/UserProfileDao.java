package com.zulkarnaen.login.repository;

import java.util.List;

import com.zulkarnaen.login.model.UserProfile;

public interface UserProfileDao {

	List<UserProfile> findAll();

	UserProfile findByType(String type);

	UserProfile findById(int id);
}