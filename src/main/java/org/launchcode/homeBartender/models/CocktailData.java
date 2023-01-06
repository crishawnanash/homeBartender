package org.launchcode.homeBartender.models;

import java.util.ArrayList;
import java.util.Locale;

public class CocktailData {

    public static ArrayList<Cocktails> findByName(String name, Iterable<Cocktails> cocktails){
        String lowerCaseName = name.toLowerCase();

        ArrayList<Cocktails> results = new ArrayList<>();

        for(Cocktails drink : cocktails){
            if(drink.getStrDrink().toLowerCase().contains(lowerCaseName)){
                results.add(drink);
            }

        }
        return results;
    }
}
