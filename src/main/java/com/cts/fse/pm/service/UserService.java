package com.cts.fse.pm.service;

import java.util.List;

import com.cts.fse.pm.entity.User;

public interface UserService {

	User addUser(User user);
	List<User> getAllUser();
	void deleteUser(long userID);
	User editUser(User user);
}
