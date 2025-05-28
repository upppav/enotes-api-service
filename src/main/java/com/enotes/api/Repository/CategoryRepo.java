package com.enotes.api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enotes.api.Entity.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

	List<Category> findByIsActiveTrue();
	

}
