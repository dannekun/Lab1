package se.nackademin.java20.lab1.Domain;

import org.springframework.data.repository.CrudRepository;
import se.nackademin.java20.lab1.Domain.Person;

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

    Optional<Person> findByName(String name);

}
