package com.cts.fse.pm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fse.pm.dao.UserDao;
import com.cts.fse.pm.entity.User;
import com.cts.fse.pm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	public User addUser(User user) {
		return this.userDao.save(user);
		
	}
	@Override
	public List<User> getAllUser() {
		return (List<User>) this.userDao.findAll();
	}

	@Override
	public void deleteUser(long  userID) {
		
		this.userDao.deleteById(userID);
	}
	
	@Override
	public User editUser(User user) {
		return this.userDao.save(user);
		
	}

}
