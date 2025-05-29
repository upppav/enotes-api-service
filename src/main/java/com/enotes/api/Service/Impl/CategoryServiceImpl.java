package com.enotes.api.Service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotes.api.Entity.Category;
import com.enotes.api.Repository.CategoryRepo;
import com.enotes.api.Service.CategoryService;
import com.enotes.api.dto.CategoryDto;
import com.enotes.api.dto.CategoryResponse;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public boolean saveCategory(CategoryDto categorydto) {
		
		Category category = mapper.map(categorydto,Category.class);
		
//		Category category=new Category();
//		category.setName(categorydto.getName());
//		category.setDescription(categorydto .getDescription());
//		category.setIsActive(categorydto.getIsActive());
		
	
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
	public List<CategoryDto> getAllCategory() {
		List<Category> allCategories = categoryRepo.findByIsDeletedFalse();
		List<CategoryDto> list = allCategories.stream().map(cat -> mapper.map(cat, CategoryDto.class)).toList();
		
		return list;
	}

	@Override
	public List<CategoryResponse> getActiveCategory() {
		// TODO Auto-generated method stub
		
		List<Category> activeCategories=categoryRepo.findByIsActiveTrueAndIsDeletedFalse();
		List<CategoryResponse> map=  activeCategories.stream()
				.map(cat ->mapper.map(cat, CategoryResponse.class)).toList();
		
		return map;
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		// TODO Auto-generated method stub
	Optional<Category> findById = categoryRepo.findByIdAndIsDeletedFalse(id);
	if(findById.isPresent())
	{
		Category category=findById.get();
		return mapper.map(category, CategoryDto.class);
	}
		return null;
	}

	@Override
	public Boolean deleteCategoryById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Category> findById = categoryRepo.findById(id);
		if(findById.isPresent())
		{
			Category category=findById.get();
			category.setIsDeleted(true);
			categoryRepo.save(category);
			return true;
		}
		return false;
	}


	

}
