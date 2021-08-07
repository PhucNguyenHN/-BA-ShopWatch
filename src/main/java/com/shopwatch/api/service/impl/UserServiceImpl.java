package com.shopwatch.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopwatch.api.dto.UpdateUserDTO;
import com.shopwatch.api.dto.UserDTO;
import com.shopwatch.api.dto.UserLoginDTO;
import com.shopwatch.api.entity.Role;
import com.shopwatch.api.entity.User;
import com.shopwatch.api.repository.RoleRepository;
import com.shopwatch.api.repository.UserRepository;
import com.shopwatch.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User findByIdUser(int id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id);
		return user;
	}

	@Override
	public List<User> findAllUserBD() {
		// TODO Auto-generated method stub
		List<User> list = userRepository.findAll();
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
		
		return userRepository.save(user);
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(username);
	}

	@Override
	public User loginUser(UserLoginDTO userLoginDTO) {
		User user = userRepository.findByEmail(userLoginDTO.getEmail());
		// TODO Auto-generated method stub
		if (user != null) {
			if (passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User registerUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		Role role = roleRepository.findByName("ROLE_CUSTOMER");
		User userCheck = userRepository.findByEmail(userDTO.getEmail());
		if (userCheck == null) {
			User user = new User();
			user.setFullname(userDTO.getFullname());
			user.setEmail(userDTO.getEmail());
			user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			user.setPhone(userDTO.getPhone());
			user.setAddress(userDTO.getAddress());
			user.setStatus(true);
			user.setRole(role);
			
			user.setCreate_at(datetimeNow);
			user.setUpdate_at(datetimeNow);
			
			return userRepository.save(user);
			
		}
		return null;
	}

	@Override
	public User updateUser(UpdateUserDTO updateUserDTO) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		User user = userRepository.findById(updateUserDTO.getId());
		if (user != null) {
			user.setFullname(updateUserDTO.getFullname());
			user.setPhone(updateUserDTO.getPhone());
			user.setAddress(updateUserDTO.getAddress());
			user.setUpdate_at(datetimeNow);
			return userRepository.save(user);
		}
		
		return null;
	}
	
	
}

