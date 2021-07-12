package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.dto.GenderDTO;
import com.shopwatch.api.entity.GenderWatch;

public interface GenderService {
	
	GenderWatch findById(int id);
	
	List<GenderWatch> findAllGenderWatch();
	
	GenderWatch createGenderWatch(GenderDTO genderDTO);
	
	GenderWatch updateGender(GenderDTO genderDTO);
	
	void deleteWatchById(int id);
}
