package com.project.EcommerceWebsite.controller;

import com.project.EcommerceWebsite.models.Product;
import com.project.EcommerceWebsite.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/createProduct")
    public ModelAndView create(@ModelAttribute Product product) {
        ModelAndView mv = new ModelAndView("resultProduct");
        mv.addObject("productList",  service.create(product));
        return  mv;
    }

    @PostMapping("/readProduct")
    public ModelAndView read(@RequestParam int id) {
        ModelAndView mv = new ModelAndView("resultProduct");
        mv.addObject("productList", service.read(id));
        return  mv;
    }

    @GetMapping("/readAllProducts")
    public ModelAndView readAll() {
        ModelAndView mv = new ModelAndView("resultProduct");
        mv.addObject("productList", service.readAll());
        return  mv;
    }

    @PostMapping("/sort")
    public ModelAndView readByOrder(@RequestParam String keyword) {
        List<Product> products;
        if(keyword.equals("priceascending"))
            products = service.readAscending();
        else
            products = service.readDescending();
        ModelAndView mv = new ModelAndView("explorePage");
        mv.addObject("products", products);
        return  mv;
    }

    @PostMapping("/search")
    public ModelAndView searchBy(@RequestParam String keyword,@RequestParam String value) {
        List<Product> products;
        if(keyword.equals("category"))
            products = service.readByCategory(value);
        else if(keyword.equals("name"))
            products = service.readByName(value);
        else
            products = service.readByAvailability();
        ModelAndView mv = new ModelAndView("explorePage");
        mv.addObject("products", products);
        return  mv;
    }

    @GetMapping("/productDetails")
    public ModelAndView searchBy(@RequestParam Integer id) {
        Product product = service.findById(id);
        ModelAndView mv = new ModelAndView("productDetails");
        mv.addObject("products", product);
        return  mv;
    }

    @PostMapping("/updateProduct")
    public ModelAndView updateProduct(@ModelAttribute Product product) {
        ModelAndView mv = new ModelAndView("resultProduct");
        mv.addObject("productList", service.update(product));
        return  mv;
    }

    @PostMapping("/deleteProduct")
    public ModelAndView deleteProduct(@RequestParam int id) {
        ModelAndView mv = new ModelAndView("resultProduct");
        mv.addObject("productList", service.delete(id));
        return  mv;
    }
}
