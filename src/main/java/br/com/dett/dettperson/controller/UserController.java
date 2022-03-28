package br.com.dett.dettperson.controller;

import br.com.dett.dettperson.dtos.UserDto;
import br.com.dett.dettperson.models.Person;
import br.com.dett.dettperson.models.User;
import br.com.dett.dettperson.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto){
        var user = new User();
        BeanUtils.copyProperties(userDto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
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
