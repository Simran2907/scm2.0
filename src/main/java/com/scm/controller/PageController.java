package com.scm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("home page handler");
    
        //sending data to view
        model.addAttribute("title", "Smart Contact Manager 2.0");
        model.addAttribute("content", "I am here to build smart contact manager usgin spring boot , thymleaf and cloud");
        model.addAttribute("repository", "http://www.github.com");
        return "HOME";
    }

    //about route
    @RequestMapping("/about")
    public String about(){
        return "About";

    }

    // services
    @RequestMapping("/services")
    public String services(){
        return "Services";

    }

    @GetMapping("/register")
    public String register(){
        return "register";

    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
