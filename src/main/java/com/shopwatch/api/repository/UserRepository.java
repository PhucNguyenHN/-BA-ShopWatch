package com.shopwatch.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findById(int id);
	
}
