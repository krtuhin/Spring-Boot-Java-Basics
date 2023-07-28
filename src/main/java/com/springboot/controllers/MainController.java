package com.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//This is controller class
@Controller
public class MainController {

    //home page view
    @RequestMapping("/")
    public String hime() {
        System.out.println("This is home page...!");
        return "home";
    }
}
