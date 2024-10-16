package com.project.EcommerceWebsite.controller;

import com.project.EcommerceWebsite.models.*;
import com.project.EcommerceWebsite.services.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.net.InetAddress;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService service;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    PaymentService paymentService;

    @PostMapping("/createUser")
    public ModelAndView create(@ModelAttribute User user) {
        String result = service.create(user);
        ModelAndView mv = new ModelAndView();
        mv.addObject("result", user.getUsername());
        if(result.equals("Saved")) {
            mv.addObject("message", "Registration Successful, Login to explore Products");
            mv.setViewName("userLogin");
        }
        else {
            mv.addObject("message", "Username already taken");
            mv.setViewName("userRegister");
        }
        return mv;
    }

    @PostMapping("/checkUser")
    public ModelAndView check(@ModelAttribute User userData, HttpSession session) {
        User user = service.check(userData);
        ModelAndView mv = new ModelAndView();
        if(user!=null) {
            mv.addObject("products", productService.readAll());
            mv.setViewName("explorePage");
            session.setAttribute("userId", user.getId());
        }
        else {
            mv.addObject("message", "Invalid username or Password, Try again");
            mv.setViewName("userLogin");
        }
        return mv;
    }

    @GetMapping("/explorePage")
    public ModelAndView readAll(HttpSession session) {
        List<Product> products = productService.readAll();
        Integer userId = (Integer) session.getAttribute("userId");
        ModelAndView mv = new ModelAndView("explorePage");
        List<Category> categories = categoryService.readAll();
        mv.addObject("categories", categories);
        mv.addObject("products", products);
        mv.addObject("userId", userId);
        return mv;
    }

    @GetMapping("/userProfile")
    public ModelAndView userProfile(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        ModelAndView mv = new ModelAndView("userProfile");
        List<User> userList = userService.read(userId);
        for(User user: userList)
            mv.addObject("user", user);
        List<Cart> cartItems = cartService.read(userId);
        List<Payment> paymentHistory = paymentService.readAllUserid(userId);
        mv.addObject("cartItems", cartItems);
        mv.addObject("paymentHistory", paymentHistory);
        return mv;
    }
}
