package com.enotes.api.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enotes.api.Entity.Category;
import com.enotes.api.dto.CategoryDto;
import com.enotes.api.dto.CategoryResponse;

@Service
public interface CategoryService {
	
	public boolean saveCategory(CategoryDto categorydto);
	public List<CategoryDto> getAllCategory();
	public List<CategoryResponse> getActiveCategory();

}
