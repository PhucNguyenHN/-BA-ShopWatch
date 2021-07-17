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
		//Check Name da ton tai
		TypeWatch typeWatch = typeRepo.findByNameAndStatus(typeDTO.getName(), true);
		if (typeWatch == null || typeDTO.getName().equals(type.getName())) {
			type.setName(typeDTO.getName());
			type.setUpdate_at(datetimeNow);
			return typeRepo.save(type);
		}
		return null;
	}

	@Override
	public boolean deleteTypeWatchById(int id) {
		Date datetimeNow = new Date();
		boolean result = false;
		// TODO Auto-generated method stub
		TypeWatch typeWatch = typeRepo.findById(id);
		if (typeWatch.isStatus()) {
			typeWatch.setStatus(false);
			typeWatch.setUpdate_at(datetimeNow);
			if (typeRepo.save(typeWatch) != null) {
				result = true;
			}
		}		
		return result;
	}

}
