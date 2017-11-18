package com.intellect.SpringBoot.dao;

import java.util.List;

import com.intellect.SpringBoot.beans.User;

public interface UserDao {

	List <User> getUsers();

	User getUser(String userId);

	User addUser(User user);

	User udateUser(User user);

	User deleteUser(String userId);

	boolean isUserExist(User user);

	User findById(String id);


}
