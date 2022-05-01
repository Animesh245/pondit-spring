package com.spring.helloWorld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RootController {
    @GetMapping("/")
    public String helloWorld(Model model){
        model.addAttribute("name", "Worried Man");
        return "hello";
    }

    @GetMapping("/register")
    public String registerUser(Model model){
        return "register";
    }

    @PostMapping("/confirm")
    public String userConfirmation(Model model){
        return "confirm";
    }

}
