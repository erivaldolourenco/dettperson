package br.com.dett.dettperson.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name="TB_PERSON")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_PERSON")
    private UUID id;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="ID_USER")
    private User user;
    @Column(name="FIRS_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="CPF")
    private String cpf;
    @Column(name="BIRTH_DATE")
    private ZonedDateTime birthDate;
    @Column(name="PHONE_NUMBER")
    private ZonedDateTime phoneNumber;
    @Column(name="CREATION_DATE")
    private ZonedDateTime creationDate;

    public Person(User user, String firstName, String lastName) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creationDate = ZonedDateTime.now();
    }

    public Person() {
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ZonedDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(ZonedDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public ZonedDateTime getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(ZonedDateTime phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
