package com.project.EcommerceWebsite.controller;

import com.project.EcommerceWebsite.configuration.CartWrapper;
import com.project.EcommerceWebsite.models.Cart;
import com.project.EcommerceWebsite.models.Payment;
import com.project.EcommerceWebsite.models.Product;
import com.project.EcommerceWebsite.services.AccountService;
import com.project.EcommerceWebsite.services.CartService;
import com.project.EcommerceWebsite.services.PaymentService;
import com.project.EcommerceWebsite.services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class PaymentController {

    @Autowired
    PaymentService service;
    @Autowired
    CartService cartservice;
    @Autowired
    ProductService productService;

    @Autowired
    AccountService accountService;

    @PostMapping("/checkOut")
    public ModelAndView create(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        String username = accountService.getUsernameById(userId);
        List<Cart> cart = (List<Cart>) session.getAttribute("cartitems");
        Payment payment = service.create(userId,cart);
        ModelAndView model = new ModelAndView("payment");
        model.addObject("total",payment.getTotal());
        model.addObject("username",username);
        cartservice.deleteByUserId(userId);
        return model;
    }

    @PostMapping("/readPayment")
    public Optional<Payment> read(@RequestParam int id) {
        return service.read(id);
    }

    @PostMapping("/readAllPayments")
    public String readAll() {
        return service.readAll().toString();
    }

    @PostMapping("/paid")
    public ModelAndView paid() {
        ModelAndView model = new ModelAndView("explorePage");
        model.addObject("message","Payment Successful");
        List<Product> products = productService.readAll();
        model.addObject("products", products);
        return model;
    }

}
