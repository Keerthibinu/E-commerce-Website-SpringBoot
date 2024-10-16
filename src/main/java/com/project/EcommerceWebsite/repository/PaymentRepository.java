package com.project.EcommerceWebsite.repository;

import com.project.EcommerceWebsite.models.Cart;
import com.project.EcommerceWebsite.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findAllByUserid(int id);
}
