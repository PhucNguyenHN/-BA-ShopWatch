package com.shopwatch.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwatch.api.dto.TypeDTO;
import com.shopwatch.api.entity.GenderWatch;
import com.shopwatch.api.entity.TypeWatch;
import com.shopwatch.api.repository.TypeRepository;
import com.shopwatch.api.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService{
	
	@Autowired
	private TypeRepository typeRepo;

	@Override
	public TypeWatch findById(int id) {
		// TODO Auto-generated method stub
		return typeRepo.findById(id);
	}

	@Override
	public List<TypeWatch> findAllTypeWatch() {
		// TODO Auto-generated method stub
		return typeRepo.customSelectTypeWatchs(true);
	}

	@Override
	public TypeWatch createTypeWatch(TypeDTO typeDTO) {
		Date datetimeNow = new Date();
		TypeWatch typeWatch = typeRepo.findByNameAndStatus(typeDTO.getName(), true);
		// TODO Auto-generated method stub
		if (typeWatch == null) {
			TypeWatch type = new TypeWatch();
			type.setName(typeDTO.getName());
			type.setStatus(true);
			type.setCreate_at(datetimeNow);
			type.setUpdate_at(datetimeNow);
			return typeRepo.save(type);
		}
		return null;
	}

	@Override
	public TypeWatch updateTypeWatch(TypeDTO typeDTO) {
		Date datetimeNow = new Date();
		// TODO Auto-generated method stub
		TypeWatch type = typeRepo.findById(typeDTO.getId());
		type.setName(typeDTO.getName());
		
		type.setUpdate_at(datetimeNow);
		return typeRepo.save(type);
	}

	@Override
	public void deleteTypeWatchById(int id) {
		Date datetimeNow = new Date();
		// TODO Auto-generated method stub
		TypeWatch typeWatch = typeRepo.findById(id);
		typeWatch.setStatus(false);
		typeWatch.setUpdate_at(datetimeNow);
		typeRepo.save(typeWatch);
	}

}
