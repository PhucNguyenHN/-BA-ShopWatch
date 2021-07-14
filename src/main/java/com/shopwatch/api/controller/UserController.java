package com.shopwatch.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwatch.api.dto.UserDTO;
import com.shopwatch.api.entity.User;
import com.shopwatch.api.service.UserService;

@RestController
@RequestMapping("/v1/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@GetMapping("/user")
	public List<User> createUsser() {
		
		return userService.findAllUserBD();
	}
	
	@CrossOrigin
	@PostMapping("/user")
	public User createUsser(@RequestBody UserDTO userDTO) {
		
		return userService.createUser(userDTO);
	}
}
