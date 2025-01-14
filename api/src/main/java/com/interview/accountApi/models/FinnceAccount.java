package com.interview.accountApi.models;

import jakarta.persistence.*;

@Entity
public class FinnceAccount {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user;
    private Float balance;
    public Float interestRate;

    public FinnceAccount() {}

    public FinnceAccount(Long id, UserAccount user, Float balance, Float interestRate) {
        this.id = id;
        this.user = user;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }
}
