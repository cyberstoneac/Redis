package com.redis.exaple.redis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.exaple.redis.demo.model.User;
import com.redis.exaple.redis.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/user/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> postUser(@RequestBody User user) {
		userService.setKey(user.getId(), user);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getUser(@PathVariable int id) {
		return new ResponseEntity<String>(userService.getKey(id), HttpStatus.OK);
	}

}
