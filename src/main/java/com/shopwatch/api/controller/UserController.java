package com.shopwatch.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwatch.api.controller.result.LoginResponseResult;
import com.shopwatch.api.controller.result.ResponseResult;
import com.shopwatch.api.dto.BrandDTO;
import com.shopwatch.api.dto.UserDTO;
import com.shopwatch.api.dto.UserLoginDTO;
import com.shopwatch.api.entity.Brand;
import com.shopwatch.api.entity.User;
import com.shopwatch.api.security.jwt.JwtProvider;
import com.shopwatch.api.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private JwtProvider jwtProvider;
	
	@CrossOrigin
	@GetMapping("/user")
	public List<User> getAllUser() {
		
		return userService.findAllUserBD();
	}
	
	@CrossOrigin
	@PostMapping("/login")
	LoginResponseResult<User> LoginUser(@RequestBody UserLoginDTO userLoginDTO) {
		String mgs;
		String token;
		User user = userService.loginUser(userLoginDTO);
		if (user != null) {
			token = jwtProvider.generateToken(userLoginDTO.getEmail());
			mgs = "Login thành công!";
		} else {
			mgs = "Login thất bại, vui lòng kiểm tra lại !!!";
			token= "";
		}
		return new LoginResponseResult<User>(mgs,token, user);
	}
	
	@CrossOrigin
	@PostMapping("/register")
	ResponseResult<User> RegisterUser(@RequestBody UserDTO userDTO) {
		String mgs;
		User user = userService.registerUser(userDTO);
		if (user != null) {
			mgs = "Đăng Ký thành công!";
		} else {
			mgs = "Đăng Ký thất bại, e-mail này đã đc đăng ký!!! ";
		}
		return new ResponseResult<User>(mgs, user);
	}
	
	@CrossOrigin
	@PostMapping("/user")
	public User createUsser(@RequestBody UserDTO userDTO) {
		
		return userService.createUser(userDTO);
	}
}
