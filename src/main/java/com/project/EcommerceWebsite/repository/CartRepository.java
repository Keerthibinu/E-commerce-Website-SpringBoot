package com.project.EcommerceWebsite.repository;

import com.project.EcommerceWebsite.models.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByUserid(int id);

    @Modifying
    @Transactional
    void deleteAllByUserid(Integer userId);
}
