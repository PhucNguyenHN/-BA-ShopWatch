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

import com.shopwatch.api.controller.result.ResponseResult;
import com.shopwatch.api.dto.BrandDTO;
import com.shopwatch.api.dto.GenderDTO;
import com.shopwatch.api.entity.Brand;
import com.shopwatch.api.entity.GenderWatch;
import com.shopwatch.api.service.GenderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api")
public class GenderController {
	
	@Autowired
	private GenderService genderService;
	
	@CrossOrigin
	@GetMapping("/gender/{id}")
	ResponseResult<GenderWatch> findGenderById(@PathVariable int id){
		
		String mgs;
		GenderWatch gender = genderService.findById(id);
		if (gender != null) {
			mgs = "GenderWatch cần tìm!";
		} else {
			mgs = "Id GenderWatch ko tồn tại!";
		}

		return new ResponseResult<GenderWatch>(mgs, gender);
	}
	
	@CrossOrigin
	@GetMapping("/gender")
	ResponseResult<List<GenderWatch>> findAllGenderWatchByDB(){
		
		String mgs;
		List<GenderWatch> listGenderWatch = genderService.findAllGenderWatch();
		if (!listGenderWatch.isEmpty()) {
			mgs = "Tất cả các GenderWatch.";
		} else {
			mgs = "Bảng GenderWatch rỗng.";
		}
		return new ResponseResult<List<GenderWatch>>(mgs, listGenderWatch);
	}
	
	@CrossOrigin
	@PostMapping("/gender")
	ResponseResult<GenderWatch> createGenderWatch(@RequestBody GenderDTO genderDTO) {
		String mgs;
		GenderWatch genderWatch = genderService.createGenderWatch(genderDTO);
		if (genderWatch != null) {
			mgs = "Thêm mới thành công!";
		} else {
			mgs = "Thêm mới thất bại, kiểm tra Name";
		}
		return new ResponseResult<GenderWatch>(mgs, genderWatch);
	}
	
	@CrossOrigin
	@PutMapping("/gender")
	ResponseResult<GenderWatch> updateGenderWatch(@RequestBody GenderDTO genderDTO) {
		
		String mgs;
		GenderWatch genderWatch = genderService.updateGender(genderDTO);
		if (genderWatch != null) {
			mgs = "Cập nhật thành công!";
		} else {
			mgs = "Cập nhật thất bại, kiểm tra Name và dữ liệu Input!";
		}
		return new ResponseResult<GenderWatch>(mgs, genderWatch);
	}
	
	@CrossOrigin
	@DeleteMapping("/gender/{id}")
	ResponseResult<Object> deleteGenderWatch(@PathVariable int id) {
		
		if (genderService.deleteWatchById(id)) {
			return new ResponseResult<Object>("Xóa Thành Công!", null);
		} else {
			return new ResponseResult<Object>("Xóa Thất Bại!.Kiểm tra lại ID", null);
		}
	}
}
