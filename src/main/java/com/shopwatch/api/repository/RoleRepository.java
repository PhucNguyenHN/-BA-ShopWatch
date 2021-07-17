package com.shopwatch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}