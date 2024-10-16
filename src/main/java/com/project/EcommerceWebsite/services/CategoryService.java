package com.project.EcommerceWebsite.services;

import com.project.EcommerceWebsite.models.Category;
import com.project.EcommerceWebsite.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public List<Category> create(Category category) {
        repository.save(category);
        return readAll();
    }

    public List<Category> read(int id) {
        Optional<Category> product = repository.findById(id);
        return product.map(Collections::singletonList).orElse(Collections.emptyList());
    }

    public List<Category> readAll() {
        return repository.findAll();
    }

    public List<Category> update(Category category) {
        if(repository.existsById(category.getId())) {
            Optional<Category> value = repository.findById(category.getId());
            if(value.isPresent()) {
                Category existingCategory = value.get();
                existingCategory.setName(category.getName());
                repository.save(existingCategory);
            }
            return readAll();
        }
        else
            return null;
    }

    public List<Category> delete(int id) {
        repository.deleteById(id);
        return readAll();
    }
}
