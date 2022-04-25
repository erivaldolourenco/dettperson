package br.com.dett.dettperson.controller;

import br.com.dett.dettperson.dtos.UserDto;
import br.com.dett.dettperson.models.Person;
import br.com.dett.dettperson.models.User;
import br.com.dett.dettperson.service.PersonService;
import br.com.dett.dettperson.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    final UserService userService;
    final PersonService personService;

    UserController(UserService userService, PersonService personService){
        this.userService = userService;
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto){
        var user = new User(userDto.getUsername(),userDto.getEmail(),userDto.getPassword());
        userService.save(user);
        var person = new Person(user, userDto.getFirstName(), userDto.getLastName());
        person.setCreationDate(ZonedDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPerson(@PathVariable(value = "id") UUID id){
        Optional<User> user = userService.findById(id);
        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não existe!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }
}
