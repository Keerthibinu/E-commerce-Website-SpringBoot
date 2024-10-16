package com.project.EcommerceWebsite.services;

import com.project.EcommerceWebsite.models.User;
import com.project.EcommerceWebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    UserRepository repository;

    public String create(User user) {
        if(repository.existsByUsername(user.getUsername()))
            return "Username already exists";
        else {
            repository.save(user);
            return "Saved";
        }
    }

    public User check(User userData) {
        Optional<User> user = Optional.ofNullable(repository.findByUsernameAndPassword(userData.getUsername(), userData.getPassword()));
        if(user.isPresent()) {
            User userInfo = user.get();
            return userInfo;
        }
        return null;
    }

    public String getUsernameById(Integer userId) {
        Optional<User> user = repository.findById(userId);
        if(user.isPresent()) {
            User user1 = user.get();
            return user1.getUsername();
        }
        return null;
    }
}
