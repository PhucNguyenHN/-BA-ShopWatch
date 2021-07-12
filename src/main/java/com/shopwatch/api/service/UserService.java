package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.dto.UserDTO;
import com.shopwatch.api.entity.User;

public interface UserService {
		
	public User findByIdUser(int id);
		
	
	public List<User> findAllUserBD();
	
	public User createUser(UserDTO userDTO);
	
}
