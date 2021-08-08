package com.shopwatch.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwatch.api.controller.result.LoginResponseResult;
import com.shopwatch.api.controller.result.ResponseResult;
import com.shopwatch.api.dto.ChangePassDTO;
import com.shopwatch.api.dto.UpdateUserDTO;
import com.shopwatch.api.dto.UserDTO;
import com.shopwatch.api.dto.UserLoginDTO;
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
	@GetMapping("/user/{id}")
	public ResponseResult<User> getAllUserByID(@PathVariable int id) {
		
		String mgs;
		User user = userService.findByIdUser(id);
		if (user != null) {
			mgs = "User cần tìm!";
		} else {
			mgs = "Id User ko tồn tại!";
		}

		return new ResponseResult<User>(mgs, user);
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
	@PostMapping("/changePassword")
	ResponseResult<User> changePassword(@RequestBody ChangePassDTO changePassDTO) {
		String mgs;
		User user = userService.changePassword(changePassDTO);
		if (user != null) {
			mgs = "Password đã được thay đổi!";
		} else {
			mgs = "Đổi Password thất bại, vui lòng kiểm tra lại mật khẩu cũ !!! ";
		}
		return new ResponseResult<User>(mgs, user);
	}
	
	@CrossOrigin
	@PostMapping("/user")
	User createUser(@RequestBody UserDTO userDTO) {
		
		return userService.createUser(userDTO);
	}
	
	@CrossOrigin
	@PutMapping("/user")
	ResponseResult<User> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
		String mgs;
		User user = userService.updateUser(updateUserDTO);
		if (user != null) {
			mgs = "Cập nhật User thành công!";
		} else {
			mgs = "Cập nhật User thất bại!";
		}
		
		return new ResponseResult<User>(mgs, user);
	}
}
