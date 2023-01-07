package org.launchcode.homeBartender.controllers;

import org.launchcode.homeBartender.Repositories.CocktailRepository;
import org.launchcode.homeBartender.Repositories.IngredientsRepository;
import org.launchcode.homeBartender.models.Cocktails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {

    @Autowired
    private CocktailRepository cocktailRepository;
    @Autowired
    private IngredientsRepository ingredientsRepository;

    @RequestMapping("/all")
    public String main(Model model) {
        model.addAttribute("title","All Cocktails");
        model.addAttribute("cocktails",cocktailRepository.findAll());
        model.addAttribute("ingredients",ingredientsRepository.findAll());

        return "main";
    }
}
