package com.shopwatch.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwatch.api.dto.BrandDTO;
import com.shopwatch.api.dto.GenderDTO;
import com.shopwatch.api.entity.Brand;
import com.shopwatch.api.entity.GenderWatch;
import com.shopwatch.api.service.GenderService;

@RestController
@RequestMapping("/v1/api")
public class GenderController {
	
	@Autowired
	private GenderService genderService;
	
	@GetMapping("/gender/{id}")
	public GenderWatch findGenderById(@PathVariable int id){
		return genderService.findById(id);
	}
	
	@GetMapping("/gender")
	public List<GenderWatch> findAllGenderWatchByDB(){
		return genderService.findAllGenderWatch();
	}
	
	@PostMapping("/gender")
	public GenderWatch createGenderWatch(@RequestBody GenderDTO genderDTO) {
		return genderService.createGenderWatch(genderDTO);
	}
	
	@PutMapping("/gender")
	public GenderWatch updateGenderWatch(@RequestBody GenderDTO genderDTO) {
		return genderService.updateGender(genderDTO);
	}
	
	@DeleteMapping("/gender")
	public void deleteGenderWatch(int id) {
		genderService.deleteWatchById(id);;
	}
}
