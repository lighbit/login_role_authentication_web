package com.zulkarnaen.login.service;

import com.zulkarnaen.login.model.User;

public interface UserService {

	User findById(int id);

	User findBySso(String sso);

	void save(User user);

}