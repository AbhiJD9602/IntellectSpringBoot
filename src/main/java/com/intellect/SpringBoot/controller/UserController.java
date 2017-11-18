package com.intellect.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.intellect.SpringBoot.beans.User;
import com.intellect.SpringBoot.responses.Response;
import com.intellect.SpringBoot.responses.StatusCode;
import com.intellect.SpringBoot.responses.UserApiResponse;
import com.intellect.SpringBoot.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/allusers/", method = RequestMethod.GET)
	public ResponseEntity<UserApiResponse<List<User>>> getUsers(){
		List<User> users = userService.getAllUsers();
		if (users.isEmpty()) {
			UserApiResponse userApiResponse= new UserApiResponse();
			userApiResponse.setMessage(Response.NOCONTENT.toString());
			userApiResponse.setStatusCode(StatusCode.NOCONTENT.toString());
			return new ResponseEntity(userApiResponse,HttpStatus.OK);
		}
		UserApiResponse<List<User>> userApiResponse= new  UserApiResponse<List<User>>();
		userApiResponse.setMessage(Response.SUCCESS.toString());
		userApiResponse.setStatusCode(StatusCode.SUCESS.toString());
		userApiResponse.setResoponseBody( users);
		return new ResponseEntity<UserApiResponse<List<User>>>(userApiResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserApiResponse<User>> getUser(@PathVariable("id") String id){
		UserApiResponse<User> userApiResponse = new UserApiResponse<User>();
		User user = userService.getUserById(id);
		if (user == null) {
			userApiResponse.setMessage(Response.NOCONTENT.toString());
			userApiResponse.setStatusCode(StatusCode.NOCONTENT.toString());
			return new ResponseEntity<UserApiResponse<User>>(userApiResponse, HttpStatus.OK);
		}
		userApiResponse.setMessage(Response.SUCCESS.toString());
		userApiResponse.setStatusCode(StatusCode.SUCESS.toString());
		userApiResponse.setResoponseBody(user);
		return new ResponseEntity<UserApiResponse<User>>(userApiResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "/createUser/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) {


		if (userService.isUserExist(user)) {

			UserApiResponse userApiResponse= new UserApiResponse();
			userApiResponse.setMessage(Response.ALLREADYEXIT.toString());
			userApiResponse.setStatusCode(StatusCode.ALLREADYEXIT.getErrorcode());
			return new ResponseEntity(userApiResponse,HttpStatus.OK);    

		}
		user.setIsActive(true);
		userService.addUser(user);

		return new ResponseEntity<String>(HttpStatus.CREATED);
	}



	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody User user) {

		User currentUser = userService.findById(id);

		if (currentUser == null) {
			;
			return new ResponseEntity("Can't update, user not found", HttpStatus.NOT_FOUND);
		}

		currentUser.setEmail(user.getEmail());
		


		userService.udateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {

		User user = userService.findById(id);
		if (user == null) {

			return new ResponseEntity("Can't delete, user not found",HttpStatus.NOT_FOUND);
		}
		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}




}
