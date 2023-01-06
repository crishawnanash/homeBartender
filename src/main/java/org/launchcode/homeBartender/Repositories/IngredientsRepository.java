package org.launchcode.homeBartender.Repositories;

import org.launchcode.homeBartender.models.Ingredients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IngredientsRepository extends CrudRepository<Ingredients,Integer> {

}
