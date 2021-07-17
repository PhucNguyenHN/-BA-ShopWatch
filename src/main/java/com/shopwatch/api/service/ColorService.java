package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.dto.ColorDTO;
import com.shopwatch.api.entity.ColorWatch;

public interface ColorService {
	
	ColorWatch findById(int id);
	
	List<ColorWatch> selectAllColor();
	
	ColorWatch createNewColor(ColorDTO colorDTO);
	
	ColorWatch updateColorWatch(ColorDTO colorDTO);
	
	boolean deleteColorById(int id);
}
