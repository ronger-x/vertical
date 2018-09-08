package com.voally.vertical.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class VerticalAdminController {

    @GetMapping
    public String admin(HttpServletRequest request, Model model){
        return "/admin/index";
    }

    @GetMapping("/users")
    public String users(HttpServletRequest request, Model model){
        return "/admin/users";
    }

    @GetMapping("/tags")
    public String tags(HttpServletRequest request, Model model){
        return "/admin/tags";
    }

}
