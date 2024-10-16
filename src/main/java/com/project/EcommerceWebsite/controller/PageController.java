package com.project.EcommerceWebsite.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/userLogin")
    public String login() {
        return "userLogin";
    }

    @GetMapping("/userLogout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @GetMapping("/userRegister")
    public String register() {
        return "userRegister";
    }

    @GetMapping("/read")
    public String read() {
        return "read";
    }

    @GetMapping("/update")
    public String update() {
        return "update";
    }

    @GetMapping("/delete")
    public String delete() {
        return "delete";
    }

    @GetMapping("/createOrUpdateProduct")
    public String createOrUpdateProduct() {
        return "createOrUpdateProduct";
    }

    @GetMapping("/createOrUpdateCategory")
    public String createOrUpdateCategory() {
        return "createOrUpdateCategory";
    }

}
