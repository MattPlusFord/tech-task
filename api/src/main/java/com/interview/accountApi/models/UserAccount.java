package com.interview.accountApi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    public UserAccount(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserAccount() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
