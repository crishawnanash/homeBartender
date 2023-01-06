package org.launchcode.homeBartender.Repositories;

import org.launchcode.homeBartender.models.Cocktails;
import org.launchcode.homeBartender.models.Recipes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface RecipeRepository extends CrudRepository<Recipes, Integer> {
}
