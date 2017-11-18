package com.intellect.SpringBoot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.SpringBoot.beans.User;
import com.intellect.SpringBoot.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao  userDao;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public User udateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.udateUser(user);
	}

	@Override
	public User deleteUser(String userId) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId);
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return userDao.isUserExist( user);
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}
	
}
