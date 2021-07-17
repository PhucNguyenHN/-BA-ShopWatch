package com.shopwatch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer>{

}
