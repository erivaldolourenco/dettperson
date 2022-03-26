package br.com.dett.dettperson.controller;

import br.com.dett.dettperson.dtos.PersonDto;
import br.com.dett.dettperson.models.Person;
import br.com.dett.dettperson.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    final PersonService personService;
    PersonController(PersonService personService){
        this.personService = personService;
    }


    @PostMapping
    public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonDto personDto){
        var person = new Person();
        BeanUtils.copyProperties(personDto, person);
        person.setCreationDate(ZonedDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPerson(@PathVariable(value = "id") UUID id){
        Optional<Person> person = personService.findById(id);
        if(!person.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(person.get());
    }

}
