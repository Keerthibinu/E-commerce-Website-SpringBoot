package com.project.EcommerceWebsite.services;

import com.project.EcommerceWebsite.models.Category;
import com.project.EcommerceWebsite.models.User;
import com.project.EcommerceWebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> read(int id) {
        Optional<User> product = repository.findById(id);
        return product.map(Collections::singletonList).orElse(Collections.emptyList());
    }

    public List<User> readAll() {
        return repository.findAll();
    }

    public List<User> delete(int id) {
        repository.deleteById(id);
        return readAll();
    }

}
