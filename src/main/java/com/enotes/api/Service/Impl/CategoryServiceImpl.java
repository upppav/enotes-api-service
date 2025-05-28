package com.enotes.api.Service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotes.api.Entity.Category;
import com.enotes.api.Repository.CategoryRepo;
import com.enotes.api.Service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public boolean saveCategory(Category category) {
		category.setIsDeleted(false);
		category.setCreatedOn(new Date());
		category.setCreatedBy(1);
		Category save = categoryRepo.save(category);
		if(ObjectUtils.isEmpty(save))
		{
		return false;
		}
		else
			return true;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> allCategories = categoryRepo.findAll();
		return allCategories;
	}

	

}
