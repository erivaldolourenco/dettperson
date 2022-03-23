package br.com.dett.dettperson.repositories;

import br.com.dett.dettperson.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {

}
