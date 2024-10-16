package com.project.EcommerceWebsite.controller;

import com.project.EcommerceWebsite.models.Payment;
import com.project.EcommerceWebsite.models.User;
import com.project.EcommerceWebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/readUser")
    public ModelAndView read(@RequestParam int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resultUser");
        mv.addObject("userList", service.read(id));
        return mv;
    }

    @GetMapping("/readAllUsers")
    public ModelAndView readAll() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resultUser");
        mv.addObject("userList", service.readAll());
        return mv;
    }

    @PostMapping("/deleteUser")
    public ModelAndView deleteUser(@RequestParam int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resultUser");
        mv.addObject("userList", service.delete(id));
        return mv;
    }
}
