package com.enotes.api.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enotes.api.Entity.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

	List<Category> findByIsActiveTrueAndIsDeletedFalse();


	Optional<Category> findByIdAndIsDeletedFalse(Integer id);

	List<Category> findByIsDeletedFalse();

	 
	

}
