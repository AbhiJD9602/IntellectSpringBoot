package com.intellect.SpringBoot.service;

import java.util.List;

import com.intellect.SpringBoot.beans.User;

public interface UserService {
	
	List <User> getAllUsers();

	User getUserById(String id);

	User addUser(User user);

	User udateUser(User user);

	User deleteUser(String userId);

	boolean isUserExist(User user);

	User findById(String id);




}
