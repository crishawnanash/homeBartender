package org.launchcode.homeBartender.controllers;

import org.launchcode.homeBartender.Repositories.CocktailRepository;
import org.launchcode.homeBartender.Repositories.IngredientsRepository;
import org.launchcode.homeBartender.models.CocktailData;
import org.launchcode.homeBartender.models.Cocktails;
import org.launchcode.homeBartender.models.IngredientData;
import org.launchcode.homeBartender.models.Ingredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller

public class searchController {

    @Autowired
    private CocktailRepository cocktailRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    static HashMap<String, String> drinkChoices = new HashMap<>();

    public searchController () {

//        drinkChoices.put("all", "All");
        drinkChoices.put("cocktails", "Cocktails");
        drinkChoices.put("ingredients", "Ingredients");

    }

    @RequestMapping("/search")
    public String search(Model model){
        model.addAttribute("choices", drinkChoices);
        return("search");
    }

    @PostMapping("/results")
    public String results(Model model, @RequestParam String searchType, @RequestParam String searchTerm){

    Iterable<Cocktails> cocktails;
        Iterable<Ingredients> ingredients;
    if(searchType.toLowerCase().equals("cocktails"))
    {
        cocktails = CocktailData.findByName(searchTerm, cocktailRepository.findAll());
    } else{
        cocktails = IngredientData.findByIngredient(searchTerm, ingredientsRepository.findAll());
    }

        model.addAttribute("cocktails", cocktails);
        model.addAttribute("choices", drinkChoices);
        model.addAttribute("title","Cocktails with " + searchTerm);

        return("search");
    }
}
