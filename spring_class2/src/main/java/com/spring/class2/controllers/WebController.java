package com.spring.class2.controllers;

import com.spring.class2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class WebController {
    @Autowired
    private AccountService accountService;

//    @GetMapping("/")
//    public ModelAndView helloWorld() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("name", "Sufyan");
//        modelAndView.setViewName("viewpage");
//        return modelAndView;
//    }

    @GetMapping()
    public String accountDetails(Model model){
        System.out.println(accountService.getAccountDetails());
        model.addAttribute("name", "Sufyan");
        model.addAttribute("details", accountService.getAccountDetails());
        return "viewpage";
    }

    @GetMapping("/hello")
    public String helloName(Model model, @RequestParam(name = "name", defaultValue = "") String name){
        model.addAttribute("name", name.isBlank() ? "Sufyan": name);
        return "viewpage";
    }
}
