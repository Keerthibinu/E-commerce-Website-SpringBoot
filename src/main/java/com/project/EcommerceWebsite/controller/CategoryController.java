package com.project.EcommerceWebsite.controller;

import com.project.EcommerceWebsite.models.Category;
import com.project.EcommerceWebsite.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService service;


    @PostMapping("/createCategory")
    public ModelAndView create(@ModelAttribute Category category) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resultCategory");
        mv.addObject("categoryList", service.create(category));
        return mv;
    }

    @PostMapping("/readCategory")
    public ModelAndView read(@RequestParam int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resultCategory");
        mv.addObject("categoryList", service.read(id));
        return mv;
    }

    @GetMapping("/readAllCategory")
    public ModelAndView readAll() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resultCategory");
        mv.addObject("categoryList", service.readAll());
        return mv;
    }

    @PostMapping("/updateCategory")
    public ModelAndView updateCategory(@ModelAttribute Category category) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resultCategory");
        mv.addObject("categoryList", service.update(category));
        return mv;
    }

    @PostMapping("/deleteCategory")
    public ModelAndView deleteCategory(@RequestParam int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resultCategory");
        mv.addObject("categoryList", service.delete(id));
        return mv;
    }
}
