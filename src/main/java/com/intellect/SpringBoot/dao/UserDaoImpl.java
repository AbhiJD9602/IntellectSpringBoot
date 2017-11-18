package com.intellect.SpringBoot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.intellect.SpringBoot.beans.User;

@Repository
public class UserDaoImpl implements UserDao {

	List<User> userList = new ArrayList<User>();
	
	@Override
	public List<User> getUsers() {
		return userList;
	}

	@Override
	public User getUser(String id) {;
		User userObj=null;
		for(User user: userList){
			if(user.getId().equals(id)){
				userObj = user;
				break;
			}
				
		}
		return userObj;
	}

	@Override
	public User addUser(User user) {
		userList.add(user);
		return user;
	}

	@Override
	public User udateUser(User user) {
		int index=-1;
		for(User userObj: userList){
			if(userObj.getId().equals(user.getId())){
				++index ;
				break;
			}
			userList.set(index, user);
		}

		
		return user;
	}

	@Override
	public User deleteUser(String userId) {
		User user =null;
		int index=-1;
		for(User userObj: userList){
			if(userObj.getId().equals(userId)){
				++index ;
				user= userObj;
				break;
			}
		
	   }
         userList.remove(index);
		
		 return user;
     }

	@Override
	public boolean isUserExist(User user) {
		boolean status = false;
		for(User userObj: userList){
			if(userObj.getId()== user.getId() ){
				status = true;
				break;
			}
		
	   }
		return status;
    }

	@Override
	public User findById(String id) {
		User userObj=null;
		for(User user: userList){
			if(user.getId()== id){
				userObj = user;
				break;
			}
				
		}
		return userObj;
	}
	
}