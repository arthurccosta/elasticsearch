package br.com.study.elasticsearch.controller;

import br.com.study.elasticsearch.model.Person;
import br.com.study.elasticsearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping(value = "/find-one/{id}")
    public Person findOne(@PathVariable String id) {
        return personService.findOne(id);
    }

    @GetMapping(value = "/find-all")
    public Iterable<Person> findAll() {
        return personService.findAll();
    }


    @GetMapping(value = "/find-by-name/{name}")
    public List<Person> findByName(@PathVariable String name) {
        return personService.findByName(name);
    }

    @GetMapping(value = "/custom/{name}")
    public List<Person> findByNameUsingCustomQuery(@PathVariable String name) {
        return personService.findByNameUsingCustomQuery(name);
    }
}