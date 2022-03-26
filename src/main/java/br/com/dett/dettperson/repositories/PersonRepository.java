package br.com.dett.dettperson.repositories;

import br.com.dett.dettperson.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

}
