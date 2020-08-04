package br.com.study.elasticsearch.service.impl;

import br.com.study.elasticsearch.model.Person;
import br.com.study.elasticsearch.repository.PersonRepository;
import br.com.study.elasticsearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public void delete(Person person) {
        repository.delete(person);
    }

    @Override
    public Person findOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Person> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Person> findByNameUsingCustomQuery(String name) {
        return repository.findByNameCustomQuery(name);
    }

}
