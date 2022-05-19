package com.pondit.b4.controllers;

import com.pondit.b4.dao.UserDao;
import com.pondit.b4.entity.User;
//import com.pondit.b4.model.FormObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/form")
public class FormController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/form")
    public String getForm(Model model) {
//        FormObject formObject = new FormObject();
        User user = new User();
        model.addAttribute("pageTitle", "Practicing Form with Taglib & Bootstrap 5");
        model.addAttribute("usr", user);
        List<String> locationList = new ArrayList<>();
        locationList.add("Dhaka");
        locationList.add("Chittagong");
        locationList.add("Khulna");
        locationList.add("Sylhet");
        locationList.add("Rajshahi");
        model.addAttribute("locationList", locationList);
        return "form-elements";
    }

    @PostMapping("/save")
    public String postForm (Model model, @ModelAttribute("usr") User user) {
        System.out.printf(user.toString());
        model.addAttribute("Name", user.getName());
        model.addAttribute("email", user.getEmail());
        userDao.createUser(user);
        return "form";
    }
}

//    @GetMapping("/userList")
//    public String getAllUsers(Model model)
//}
