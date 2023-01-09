package org.launchcode.homeBartender.Repositories;

import org.launchcode.homeBartender.models.Recipes;
import org.launchcode.homeBartender.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository  extends CrudRepository<Users, Integer> {
}
