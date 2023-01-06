package org.launchcode.homeBartender.models;

import java.util.ArrayList;

public class IngredientData {
    public static ArrayList<Cocktails> findByIngredient(String name, Iterable<Ingredients> ingredients){
        String lowerCaseName = name.toLowerCase();

        ArrayList<Ingredients> results = new ArrayList<>();
        ArrayList<Cocktails> cocktailNames = new ArrayList<>();
        ArrayList<Cocktails> listOnce = new ArrayList<>();

        for(Ingredients ingred : ingredients){
            if(ingred.getIngredient().toLowerCase().contains(lowerCaseName)){
                results.add(ingred);
            }
        }

        for(Ingredients ingred : results)
        {
            Cocktails  cocktail = ingred.getRecipes().getCocktails();
            cocktailNames.add(cocktail);
        }

        for(Cocktails drink : cocktailNames)
        {
            if(!listOnce.contains(drink))
            {
                listOnce.add(drink);
            }
        }

        return listOnce;
    }
}
