package com.springboot.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.app.model.User;
import com.springboot.app.repository.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	/**
	 * This method is adding the user
	 * @param user
	 * @return
	 */
	public ResponseEntity<Object> AddUser(User user){
		try {
			userRepository.save(user);
			return new ResponseEntity<>("User is successfully Added", HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * This method is getting the list of users from database
	 * @return
	 */
	public ResponseEntity<Object> ListOfUsers(int totalRows){
		try {
			List<User> usersList = userRepository.findAll();
			if(null==usersList) {
				return new ResponseEntity<>("There are no users in the database", HttpStatus.NOT_FOUND);
			}else {
				if(totalRows>usersList.size()) {
					return new ResponseEntity<>("There are less number of rows in the database than you are entering", HttpStatus.NOT_FOUND);
				}
				else {
					List<User> newUsersList = new ArrayList<>();
					for(int i=0; i<totalRows;i++) {
						newUsersList.add(usersList.get(i));
					}
					return new ResponseEntity<>(newUsersList, HttpStatus.OK);
				}
			}
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
