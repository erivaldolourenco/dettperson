package br.com.dett.dettperson.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Table(name = "PROFILE")
@Entity
public class Profile implements GrantedAuthority {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getAuthority() {
        return this.name;
    }
}