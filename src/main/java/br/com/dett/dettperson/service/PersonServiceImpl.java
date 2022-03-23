package br.com.dett.dettperson.service;

import br.com.dett.dettperson.models.Person;
import br.com.dett.dettperson.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
