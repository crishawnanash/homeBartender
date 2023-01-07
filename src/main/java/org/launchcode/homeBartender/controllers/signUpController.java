package org.launchcode.homeBartender.controllers;

import org.launchcode.homeBartender.models.SignUp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class signUpController {

    @RequestMapping("/signUp")
    public String main(Model model) {

        return "signIn";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute SignUp signUp, Model model){


        return "main";
    }
}
