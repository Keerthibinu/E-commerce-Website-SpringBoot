package com.project.EcommerceWebsite.repository;

import com.project.EcommerceWebsite.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByOrderByPriceAsc();

    List<Product> findAllByOrderByPriceDesc();

    @Query("SELECT p FROM Product p WHERE p.categoryid = :value")
    List<Product> findAllByCategoryid(Integer value);

    @Query("SELECT p FROM Product p WHERE p.name = :value")
    List<Product> findAllByName(String value);

    @Query("SELECT p FROM Product p WHERE p.quantity > 0")
    List<Product> findAllByAvailability();
}
