package br.com.dett.dettperson.models;

import javax.validation.constraints.Email;
import java.time.ZonedDateTime;

public class User {
    private String username;
    private Email email;
    private String passworld;
    private ZonedDateTime lastLogin;

    public User(String username, Email email, String passworld) {
        this.username = username;
        this.email = email;
        this.passworld = passworld;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
