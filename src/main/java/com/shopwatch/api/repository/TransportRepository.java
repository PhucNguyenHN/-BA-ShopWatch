package com.shopwatch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.Transport;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {

}
