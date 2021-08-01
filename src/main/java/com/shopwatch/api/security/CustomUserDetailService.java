package com.shopwatch.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.shopwatch.api.entity.User;
import com.shopwatch.api.service.UserService;

@Component
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserService userService;

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userService.findByUserName(username);
		return CustomUserDetails.fromUserToCustomUserDetails(user);
	}
	
}
