package com.shopwatch.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwatch.api.dto.GenderDTO;
import com.shopwatch.api.entity.GenderWatch;
import com.shopwatch.api.repository.GenderRepository;
import com.shopwatch.api.service.GenderService;

@Service
public class GenderServiceImpl implements GenderService {
	
	@Autowired
	private GenderRepository genderRepo;
	
	@Override
	public GenderWatch findById(int id) {
		// TODO Auto-generated method stub
		return genderRepo.findById(id);
	}

	@Override
	public List<GenderWatch> findAllGenderWatch() {
		// TODO Auto-generated method stub
		return genderRepo.customSelectGenderWatchs(true);
	}

	@Override
	public GenderWatch createGenderWatch(GenderDTO genderDTO) {
		Date datetimeNow = new Date();
		GenderWatch genderWatch = genderRepo.findByNameAndStatus(genderDTO.getName(), true);
		// TODO Auto-generated method stub
		if (genderWatch == null) {
			GenderWatch gender = new GenderWatch();
			gender.setName(genderDTO.getName());
			gender.setStatus(true);
			gender.setCreate_at(datetimeNow);
			gender.setUpdate_at(datetimeNow);
			return genderRepo.save(gender);
		}
		return null;
	}

	@Override
	public GenderWatch updateGender(GenderDTO genderDTO) {
		Date datetimeNow = new Date();
		// TODO Auto-generated method stub
		GenderWatch gender = genderRepo.findById(genderDTO.getId());
		gender.setName(genderDTO.getName());
		
		gender.setUpdate_at(datetimeNow);
		return genderRepo.save(gender);
	}

	@Override
	public void deleteWatchById(int id) {

		Date datetimeNow = new Date();
		// TODO Auto-generated method stub
		GenderWatch genderWatch = genderRepo.findById(id);
		genderWatch.setStatus(false);
		genderWatch.setUpdate_at(datetimeNow);
		genderRepo.save(genderWatch);
	}

}
