package br.com.study.elasticsearch.service;

import br.com.study.elasticsearch.model.Person;

import java.util.List;

public interface PersonService {

    Person save(Person person);

    void delete(Person person);

    Person findOne(String id);

    Iterable<Person> findAll();

    List<Person> findByName(String name);

    List<Person> findByNameUsingCustomQuery(String name);
}
