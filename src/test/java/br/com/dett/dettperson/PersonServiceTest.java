package br.com.dett.dettperson;

import br.com.dett.dettperson.models.Person;
import br.com.dett.dettperson.models.User;
import br.com.dett.dettperson.repositories.PersonRepository;
import br.com.dett.dettperson.service.PersonService;
import br.com.dett.dettperson.service.PersonServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PersonServiceTest {

    @TestConfiguration
    static class PersonServiceTestConfiguration {
        @Bean
        public PersonService personService(){
            return new PersonServiceImpl();
        }
    }

    @Autowired
    PersonService personService;

    @MockBean
    PersonRepository personRepository;

    @Test
    public void personTestServiceSaveNewPerson(){
        User user = new User("erivaldolourenco", "erivaldo@email.com", "password");
        Person person = new Person(user, "Erivaldo", "Lourenço");
        Person savePerson = personService.save(person);
        Assertions.assertEquals(person.getCreationDate(), savePerson.getCreationDate());
    }

    @BeforeEach
    public void setup(){
        User user = new User("erivaldolourenco", "erivaldo@email.com", "password");
        Person person = new Person(user, "Erivaldo", "Lourenço");
        Mockito.when(personRepository.save(person)).thenReturn(person);
    }

}
