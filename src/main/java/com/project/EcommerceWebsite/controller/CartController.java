package com.project.EcommerceWebsite.controller;

import com.project.EcommerceWebsite.models.Cart;
import com.project.EcommerceWebsite.models.Product;
import com.project.EcommerceWebsite.services.CartService;
import com.project.EcommerceWebsite.services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService service;

    @Autowired
    ProductService productService;

    @PostMapping("/createCart")
    public ModelAndView create(@RequestParam Integer productid,HttpSession session) {
        Integer userid = (Integer) session.getAttribute("userId");
        Date dateadded = new Date();
        Cart cart = new Cart();
        Product product = productService.findById(productid);
        cart.setPrice(product.getPrice());
        cart.setProductid(productid);
        cart.setUserid(userid);
        cart.setDateadded(dateadded);
        service.create(cart);
        productService.reduceQuantity(productid);
        return new ModelAndView("redirect:/explorePage").addObject("products", productService.readAll()).addObject("message", "Product added to cart!");
    }

    @PostMapping("/readCartByUserId")
    public ModelAndView read(HttpSession session) {
        Integer userid = (Integer) session.getAttribute("userId");
        List<Cart> cartitems = service.read(userid);
        session.setAttribute("cartitems", cartitems);
        return new ModelAndView("showCart");
    }

    @PostMapping("/readAllCarts")
    public String readAll() {
        return service.readAll().toString();
    }

    @PostMapping("/updateCart")
    public String updateCart(@ModelAttribute Cart cart) {
        return service.update(cart);
    }

    @PostMapping("/deleteCart")
    public void deleteCart(@RequestParam int id, @RequestParam int productid, HttpSession session) {
        service.delete(id);
        productService.increaseQuantity(productid);
        read(session);
    }
}
