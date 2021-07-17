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
import com.shopwatch.api.dto.ColorDTO;
import com.shopwatch.api.dto.TypeDTO;
import com.shopwatch.api.entity.ColorWatch;
import com.shopwatch.api.entity.TypeWatch;
import com.shopwatch.api.service.ColorService;
import com.shopwatch.api.service.TypeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api")
public class ColorController {
	
	@Autowired
	private ColorService colorService;
	
	@CrossOrigin
	@GetMapping("/color/{id}")
	ResponseResult<ColorWatch> findColorWatchById(@PathVariable int id){
		
		String mgs;
		ColorWatch colorWatch = colorService.findById(id);
		if (colorWatch != null) {
			mgs = "ColorWatch cần tìm!";
		} else {
			mgs = "Id ColorWatch ko tồn tại!";
		}

		return new ResponseResult<ColorWatch>(mgs, colorWatch);
	}
	
	@CrossOrigin
	@GetMapping("/color")
	ResponseResult<List<ColorWatch>> findAllColorWatchByDB(){
	
		String mgs;
		List<ColorWatch> listColorWatch = colorService.selectAllColor();
		if (!listColorWatch.isEmpty()) {
			mgs = "Tất cả các ColorWatch.";
		} else {
			mgs = "Bảng ColorWatch rỗng.";
		}
		return new ResponseResult<List<ColorWatch>>(mgs, listColorWatch);
	}
	
	@CrossOrigin
	@PostMapping("/color")
	ResponseResult<ColorWatch> createColorWatch(@RequestBody ColorDTO colorDTO) {
		
		String mgs;
		ColorWatch colorWatch = colorService.createNewColor(colorDTO);
		if (colorWatch != null) {
			mgs = "Thêm mới thành công!";
		} else {
			mgs = "Thêm mới thất bại, kiểm tra Name";
		}
		return new ResponseResult<ColorWatch>(mgs, colorWatch);
	}
	
	@CrossOrigin
	@PutMapping("/color")
	ResponseResult<ColorWatch> updateColorWatch(@RequestBody ColorDTO colorDTO) {
		
		String mgs;
		ColorWatch colorWatch = colorService.updateColorWatch(colorDTO);
		if (colorWatch != null) {
			mgs = "Cập nhật thành công!";
		} else {
			mgs = "Cập nhật thất bại, kiểm tra Name và dữ liệu Input!";
		}
		return new ResponseResult<ColorWatch>(mgs, colorWatch);
	}
	
	@CrossOrigin
	@DeleteMapping("/color/{id}")
	ResponseResult<Object> deleteColorWatch(@PathVariable int id) {
		
		if (colorService.deleteColorById(id)) {
			return new ResponseResult<Object>("Xóa Thành Công!", null);
		} else {
			return new ResponseResult<Object>("Xóa Thất Bại!.Kiểm tra lại ID", null);
		}
	}

}
