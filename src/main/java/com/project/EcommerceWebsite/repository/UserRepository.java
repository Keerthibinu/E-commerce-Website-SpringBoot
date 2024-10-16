package com.project.EcommerceWebsite.repository;

import com.project.EcommerceWebsite.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    String findUsernameById(Integer userId);
}
