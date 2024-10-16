package com.project.EcommerceWebsite.services;

import com.project.EcommerceWebsite.models.Cart;
import com.project.EcommerceWebsite.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository repository;

    public void create(Cart cart) {
        repository.save(cart);
    }

    public List<Cart> read(int id) {
        return repository.findAllByUserid(id);
    }

    public List<Cart> readAll() {
        return repository.findAll();
    }

    public String update(Cart cart) {
        if(repository.existsById(cart.getId())) {
            Optional<Cart> value = repository.findById(cart.getId());
            if(value.isPresent()) {
                Cart existingCart = value.get();
                existingCart.setUserid(cart.getUserid());
                existingCart.setProductid(cart.getProductid());
                existingCart.setDateadded(cart.getDateadded());
                repository.save(existingCart);
                return "Updated";
            }
            else
                return "Cart not found";
        }
        else
            return "Cart not found";
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    @Transactional
    public void deleteByUserId(Integer userId) {

        repository.deleteAllByUserid(userId);
    }
}
