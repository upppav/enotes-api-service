package com.enotes.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.api.Entity.Category;
import com.enotes.api.Service.CategoryService;

import ch.qos.logback.core.util.StringCollectionUtil;

@RestController
@RequestMapping("/api/v1/category")
public class ServiceController {
	@Autowired
	private CategoryService categoryService;
	@PostMapping("/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody Category category)
	{
		boolean saveCategory = categoryService.saveCategory(category);
		if(saveCategory) {
		return new ResponseEntity<>("saved successfully",HttpStatus.CREATED);
	}
		else
		{
			return new ResponseEntity<>("Not saved successfully",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}	
	@GetMapping("/get-category")
	public ResponseEntity<?> getAllCategory()
	{
		List<Category> allCategory = categoryService.getAllCategory();
		if(org.springframework.util.CollectionUtils.isEmpty(allCategory))
{
	return ResponseEntity.noContent().build();
}
else
{
	return new ResponseEntity<>(allCategory,HttpStatus.OK);
}
	}
	

}
