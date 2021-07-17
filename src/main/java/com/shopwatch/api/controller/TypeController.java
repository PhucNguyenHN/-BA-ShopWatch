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
import com.shopwatch.api.dto.GenderDTO;
import com.shopwatch.api.dto.TypeDTO;
import com.shopwatch.api.entity.GenderWatch;
import com.shopwatch.api.entity.TypeWatch;
import com.shopwatch.api.service.GenderService;
import com.shopwatch.api.service.TypeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	@CrossOrigin
	@GetMapping("/type/{id}")
	ResponseResult<TypeWatch> findTypeWatchById(@PathVariable int id){
		
		String mgs;
		TypeWatch type = typeService.findById(id);
		if (type != null) {
			mgs = "TypeWatch cần tìm!";
		} else {
			mgs = "Id TypeWatch ko tồn tại!";
		}

		return new ResponseResult<TypeWatch>(mgs, type);
	}
	
	@CrossOrigin
	@GetMapping("/type")
	ResponseResult<List<TypeWatch>> findAllTypeWatchByDB(){
	
		String mgs;
		List<TypeWatch> listTypeWatch = typeService.findAllTypeWatch();
		if (!listTypeWatch.isEmpty()) {
			mgs = "Tất cả các TypeWatch.";
		} else {
			mgs = "Bảng TypeWatch rỗng.";
		}
		return new ResponseResult<List<TypeWatch>>(mgs, listTypeWatch);
	}
	
	@CrossOrigin
	@PostMapping("/type")
	ResponseResult<TypeWatch> createTypeWatch(@RequestBody TypeDTO typeDTO) {
		
		String mgs;
		TypeWatch typeWatch = typeService.createTypeWatch(typeDTO);
		if (typeWatch != null) {
			mgs = "Thêm mới thành công!";
		} else {
			mgs = "Thêm mới thất bại, kiểm tra Name";
		}
		return new ResponseResult<TypeWatch>(mgs, typeWatch);
	}
	
	@CrossOrigin
	@PutMapping("/type")
	ResponseResult<TypeWatch> updateTypeWatch(@RequestBody TypeDTO typeDTO) {
		
		String mgs;
		TypeWatch typeWatch = typeService.updateTypeWatch(typeDTO);
		if (typeWatch != null) {
			mgs = "Cập nhật thành công!";
		} else {
			mgs = "Cập nhật thất bại, kiểm tra value Input & Name!";
		}
		return new ResponseResult<TypeWatch>(mgs, typeWatch);
	}
	
	@CrossOrigin
	@DeleteMapping("/type/{id}")
	ResponseResult<Object> deleteTypeWatch(@PathVariable int id) {
		
		if (typeService.deleteTypeWatchById(id)) {
			return new ResponseResult<Object>("Xóa Thành Công!", null);
		} else {
			return new ResponseResult<Object>("Xóa Thất Bại!.Kiểm tra lại ID", null);
		}
	}
}
