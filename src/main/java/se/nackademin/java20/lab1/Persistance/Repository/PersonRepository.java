package se.nackademin.java20.lab1.Persistance.Repository;

import org.springframework.data.repository.CrudRepository;
import se.nackademin.java20.lab1.Persistance.model.Person;

import java.util.Optional;

/**
 * Created by Daniel Bojic
 * Date: 2021-08-24
 * Time: 15:58
 * Project: Lab1
 * Copyright: MIT
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Override
    Optional<Person> findById(Long aLong);
}
