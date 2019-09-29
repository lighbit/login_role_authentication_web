package com.zulkarnaen.login.repository;

import com.zulkarnaen.login.model.User;

public interface UserDao {

	User findById(int id);

	User findBySSO(String sso);

	void save(User user);

}
