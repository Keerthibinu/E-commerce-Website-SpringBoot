package com.project.EcommerceWebsite.services;

import com.project.EcommerceWebsite.models.Product;
import com.project.EcommerceWebsite.repository.CategoryRepository;
import com.project.EcommerceWebsite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Product> create(Product product) {
        repository.save(product);
        return readAll();
    }

    public List<Product> read(int id) {
        Optional<Product> product = repository.findById(id);
        return product.map(Collections::singletonList).orElse(Collections.emptyList());
    }
    public String getname(int id) {
        Optional<Product> product = repository.findById(id);
        if(product.isPresent()) {
            Product product1 = product.get();
            return product1.getName();
        }
        return null;
    }

    public List<Product> readAll() {
        return repository.findAll();
    }

    public List<Product> readAscending() {
        return repository.findAllByOrderByPriceAsc();
    }

    public List<Product> readDescending() {
        return repository.findAllByOrderByPriceDesc();
    }

    public List<Product> readByCategory(String value) {
        Integer categoryid = categoryRepository.findByName(value);
        return repository.findAllByCategoryid(categoryid);
    }

    public List<Product> readByName(String value) {
        return repository.findAllByName(value);
    }


    public List<Product> readByAvailability() { return repository.findAllByAvailability(); }

    public List<Product> update(Product product) {
        if(repository.existsById(product.getId())) {
            Optional<Product> value = repository.findById(product.getId());
            if(value.isPresent()) {
                Product existingProduct = value.get();
                existingProduct.setName(product.getName());
                existingProduct.setQuantity(product.getQuantity());
                existingProduct.setCategoryid(product.getCategoryid());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setDescription(product.getDescription());
                repository.save(existingProduct);
                return readAll();
            }
            else
                return readAll();
        }
        else
            return null;
    }

    public List<Product> delete(int id) {
        repository.deleteById(id);
        return readAll();
    }

    public void reduceQuantity(int id) {
        Optional<Product> product = repository.findById(id);
        if(product.isPresent()) {
            Product product1 = product.get();
            Integer quantity = product1.getQuantity()-1;
            product1.setQuantity(quantity);
            update(product1);
        }
    }

    public void increaseQuantity(int id) {
        Optional<Product> product = repository.findById(id);
        if(product.isPresent()) {
            Product product1 = product.get();
            Integer quantity = product1.getQuantity()+1;
            product1.setQuantity(quantity);
            update(product1);
        }
    }

    public Product findById(Integer productid) {
        Optional<Product> product = repository.findById(productid);
        return product.orElseGet(Product::new);
    }

}
