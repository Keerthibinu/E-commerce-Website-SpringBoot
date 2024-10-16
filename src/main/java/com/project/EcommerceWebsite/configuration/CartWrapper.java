package com.project.EcommerceWebsite.configuration;

import com.project.EcommerceWebsite.models.Cart;

import java.util.List;

public class CartWrapper {
    private List<Cart> cartItems;

    // Getter and Setter
    public List<Cart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Cart> cartItems) {
        this.cartItems = cartItems;
    }
}
