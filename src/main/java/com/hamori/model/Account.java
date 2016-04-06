package com.hamori.model;

import java.io.Serializable;

/**
 * Created by Zoltan_Hamori on 4/4/2016.
 */
public class Account implements Serializable {

    private Long id;
    private Long balance;
    private Customer customer;
    private AccountType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", customer=" + customer +
                ", type=" + type +
                '}';
    }
}
