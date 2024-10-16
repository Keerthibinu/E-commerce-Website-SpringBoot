package com.project.EcommerceWebsite.repository;

import com.project.EcommerceWebsite.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT id FROM Category c WHERE c.name = :value")
    Integer findByName(String value);
}
