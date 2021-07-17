package com.shopwatch.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwatch.api.dto.ColorDTO;
import com.shopwatch.api.entity.ColorWatch;
import com.shopwatch.api.repository.ColorRepository;
import com.shopwatch.api.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService{
	
	@Autowired
	private ColorRepository colorRepo;

	@Override
	public ColorWatch findById(int id) {
		// TODO Auto-generated method stub
		return colorRepo.findById(id);
	}

	@Override
	public List<ColorWatch> selectAllColor() {
		// TODO Auto-generated method stub
		return colorRepo.customSelectColor(true);
	}

	@Override
	public ColorWatch createNewColor(ColorDTO colorDTO) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		ColorWatch colorWatch = colorRepo.findByNameAndStatus(colorDTO.getName(), true);
		if (colorWatch == null) {
			ColorWatch color = new ColorWatch();
			color.setName(colorDTO.getName());
			color.setStatus(true);
			color.setCreate_at(datetimeNow);
			color.setUpdate_at(datetimeNow);
			return colorRepo.save(color);
		}
		return null;
	}

	@Override
	public ColorWatch updateColorWatch(ColorDTO colorDTO) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		ColorWatch colorWatch = colorRepo.findById(colorDTO.getId());
		//Check Name da ton tai
		ColorWatch colorCheck = colorRepo.findByNameAndStatus(colorDTO.getName(), true);
		if (colorCheck == null || colorDTO.getName().equals(colorWatch.getName())) {
			colorWatch.setName(colorDTO.getName());
			colorWatch.setUpdate_at(datetimeNow);
			return colorRepo.save(colorWatch);
		}
		return null;
	}

	@Override
	public boolean deleteColorById(int id) {
		Date datetimeNow = new Date();
		// TODO Auto-generated method stub
		ColorWatch color = colorRepo.findById(id);
		boolean result = false;
		if (color.isStatus()) {
			color.setStatus(false);
			color.setUpdate_at(datetimeNow);
			if (colorRepo.save(color) != null) {
				result = true;
			}
		}
		return result;
	}

}
