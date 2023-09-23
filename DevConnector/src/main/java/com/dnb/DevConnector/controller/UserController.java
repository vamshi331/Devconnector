package com.dnb.DevConnector.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return user;
	}
	
	@GetMapping("/getid/{User_id}")
	public ResponseEntity<?> getUserById
	(@PathVariable("User_id") String User_id) throws Exception {
		Optional<User> optional = userService.getUserBymail(User_id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new Exception("Id not valid");
		}
	}


	@DeleteMapping("/{User_id}")
	public ResponseEntity<?> deleteUserById
	(@PathVariable("User_id") String User_id) throws Exception{
		if(userService.getUserBymail(User_id)!=null) {
			userService.deleteUserByMail(User_id);
			return ResponseEntity.ok("Deleted");
		}
		else {
			throw new Exception("ID is not valid");
		}
	}
}
