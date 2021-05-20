package com.finalproject.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalproject.grocery.entity.Category;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByCategoryName(String categoryName);

}
