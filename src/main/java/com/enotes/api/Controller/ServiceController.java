package com.enotes.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.api.Entity.Category;
import com.enotes.api.Service.CategoryService;
import com.enotes.api.dto.CategoryDto;
import com.enotes.api.dto.CategoryResponse;

import ch.qos.logback.core.util.StringCollectionUtil;

@RestController
@RequestMapping("/api/v1/category")
public class ServiceController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categorydto)
	{
		boolean saveCategory = categoryService.saveCategory(categorydto);
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
		List<CategoryDto> allCategory = categoryService.getAllCategory();
		if(org.springframework.util.CollectionUtils.isEmpty(allCategory))
{
	return ResponseEntity.noContent().build();
}
else
{
	return new ResponseEntity<>(allCategory,HttpStatus.OK);
}
	}
	@GetMapping("/get-Activecategory")
	public ResponseEntity<?> getActiveCategory()
	{
		List<CategoryResponse> allCategory = categoryService.getActiveCategory();
		if(org.springframework.util.CollectionUtils.isEmpty(allCategory))
{
	return ResponseEntity.noContent().build();
}
else
{
	return new ResponseEntity<>(allCategory,HttpStatus.OK);
}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id)
	{
	CategoryDto categoryDto=categoryService.getCategoryById(id);
	if(ObjectUtils.isEmpty(categoryDto))
	{
		return new ResponseEntity<>("Category is not present with ID : "+id,HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<>(categoryDto,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable Integer id)
	{
	Boolean deleted=categoryService.deleteCategoryById(id);
	if(deleted)
	{
		return new ResponseEntity<>("Category deleted successfully : ",HttpStatus.OK);
	}
		return new ResponseEntity<>("Category not deleted ",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

}
