package com.shopwatch.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwatch.api.dto.UserDTO;
import com.shopwatch.api.entity.User;
import com.shopwatch.api.repository.UserRepository;
import com.shopwatch.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User findByIdUser(int id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id);
		return user;
	}

	@Override
	public List<User> findAllUserBD() {
		// TODO Auto-generated method stub
		List<User> list = userRepo.findAll();
		return list;
	}

	@Override
	public User createUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		User user = new User();
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setStatus(true);
		user.setCreate_at(datetimeNow);
		user.setUpdate_at(datetimeNow);
		
		return userRepo.save(user);
	}
	
	
}

