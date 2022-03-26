package br.com.dett.dettperson.service;

import br.com.dett.dettperson.models.Person;

import java.util.Optional;
import java.util.UUID;

public interface PersonService {
   Person save(Person person);
   Optional<Person> findById(UUID id);
}
