package org.launchcode.homeBartender.Repositories;

import org.launchcode.homeBartender.models.Cocktails;
import org.launchcode.homeBartender.models.FormData;
import org.launchcode.homeBartender.models.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LoginRepository extends CrudRepository<Login, Integer> {
}
