package com.nagarro.user.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.user.exception.BadRequestException;
import com.nagarro.user.exception.DataValidationException;
import com.nagarro.user.exception.UserAlreadyExistException;
import com.nagarro.user.exception.UserNotFoundException;
import com.nagarro.user.model.Users;
import com.nagarro.user.model.UserResponse;
import com.nagarro.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/list")
	public ResponseEntity<UserResponse> listAllUsers() throws DataValidationException {
		UserResponse userResponse = new UserResponse();

		List<Users> users = userService.list();

		if (users.isEmpty()) {

			throw new DataValidationException("Record Not Found");
		}
		userResponse.setUserList(users);

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUser(@PathVariable("id") int id) throws UserNotFoundException {
		log.info("Fetching User with id " + id);
		UserResponse userResponse = new UserResponse();
		Users user = userService.get(id);
		if (user == null) {
			log.info("User with id " + id + " not found");
			throw new UserNotFoundException("User Not Found");

		}
		userResponse.setUser(user);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Users> createUser(@RequestBody Users user)
			throws UserAlreadyExistException, BadRequestException {
		log.info("Creating User " + user.getUsername());
		System.out.println("Helllo How Are You");
		if (user.getUsername() == null) {
			throw new BadRequestException("Bad Request");
		}
		

		else if ((userService.isUserExist(user.getUsername()))) {
			log.info("A User with name " + user.getUsername() + " already exist");
			throw new UserAlreadyExistException("User Already Exist");

		}

		userService.save(user);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Users> deleteUser(@PathVariable("id") int id) throws UserNotFoundException {
		log.info("Fetching & Deleting User with id " + id);

		Users user = userService.get(id);
		if (user == null) {
			log.info("Unable to delete. User with id " + id + " not found");
			throw new UserNotFoundException("User Not Found");

		}

		userService.delete(id);
		return new ResponseEntity<Users>(HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody Users user) throws UserNotFoundException {
		log.info("Updating User with id " + id);
		Users updateduser = userService.get(id);
		if (updateduser == null) {
			log.info("Unable to update. User with id " + id + " not found");
			throw new UserNotFoundException("User Not Found");

		}
		userService.update(id, user);
		return new ResponseEntity<Users>(user, HttpStatus.OK);

	}

}
