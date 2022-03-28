package br.com.dett.dettperson.service;

import br.com.dett.dettperson.models.Person;
import br.com.dett.dettperson.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User save(User user);
    Optional<User> findById(UUID id);
}
