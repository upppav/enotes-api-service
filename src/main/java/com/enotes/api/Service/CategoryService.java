package com.enotes.api.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enotes.api.Entity.Category;

@Service
public interface CategoryService {
	
	public boolean saveCategory(Category category);
	public List<Category> getAllCategory();

}
