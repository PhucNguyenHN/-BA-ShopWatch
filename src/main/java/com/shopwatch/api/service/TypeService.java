package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.dto.TypeDTO;
import com.shopwatch.api.entity.TypeWatch;

public interface TypeService {
	
	TypeWatch findById(int id);
	
	List<TypeWatch> findAllTypeWatch();
	
	TypeWatch createTypeWatch(TypeDTO typeDTO);
	
	TypeWatch updateTypeWatch(TypeDTO typeDTO);
	
	void deleteTypeWatchById(int id);
}
