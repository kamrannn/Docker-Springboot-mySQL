package com.springboot.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.app.model.User;
import com.springboot.app.service.UserService;

@RestController
public class UserController {

	UserService userService;
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}	

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to spring boot project of Bule Light";
	}
	
	/**
	 * Adding the user in the database
	 * @param user
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<Object> add(@RequestBody User user){
		return userService.AddUser(user);
	}
	
	/**
	 * To get the list of all users from the database
	 * @return
	 */
	@GetMapping("/list")
	public ResponseEntity<Object> list(@RequestHeader int totalRows){
		return userService.ListOfUsers(totalRows);
	}
}
