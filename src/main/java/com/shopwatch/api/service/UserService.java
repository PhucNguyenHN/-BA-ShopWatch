package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.dto.UpdateUserDTO;
import com.shopwatch.api.dto.UserDTO;
import com.shopwatch.api.dto.UserLoginDTO;
import com.shopwatch.api.entity.User;

public interface UserService {
		
	User findByIdUser(int id);
		
	User findByUserName(String username);
	
	List<User> findAllUserBD();
	
	User createUser(UserDTO userDTO);
	
	User updateUser(UpdateUserDTO updateUserDTO);
	
	User registerUser(UserDTO userDTO);
	
	User loginUser(UserLoginDTO userLoginDTO);
	
}
