package com.shopwatch.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwatch.api.dto.GenderDTO;
import com.shopwatch.api.dto.TypeDTO;
import com.shopwatch.api.entity.GenderWatch;
import com.shopwatch.api.entity.TypeWatch;
import com.shopwatch.api.service.GenderService;
import com.shopwatch.api.service.TypeService;

@RestController
@RequestMapping("/v1/api")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	@CrossOrigin
	@GetMapping("/type/{id}")
	public TypeWatch findTypeWatchById(@PathVariable int id){
		return typeService.findById(id);
	}
	
	@CrossOrigin
	@GetMapping("/type")
	public List<TypeWatch> findAllTypeWatchByDB(){
		return typeService.findAllTypeWatch();
	}
	
	@CrossOrigin
	@PostMapping("/type")
	public TypeWatch createTypeWatch(@RequestBody TypeDTO typeDTO) {
		return typeService.createTypeWatch(typeDTO);
	}
	
	@CrossOrigin
	@PutMapping("/type")
	public TypeWatch updateTypeWatch(@RequestBody TypeDTO typeDTO) {
		return typeService.updateTypeWatch(typeDTO);
	}
	
	@CrossOrigin
	@DeleteMapping("/type/{id}")
	public void deleteTypeWatch(@PathVariable int id) {
		typeService.deleteTypeWatchById(id);;
	}
}
