package com.epam.hamori.model;

/**
 * Author: Zoltan_Hamori
 */
public enum AccountType {

    CURRENT("Current"),
    SAVING("Saving"),
    CASH_ISA("CashIsa");

    private String name;

    AccountType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "name='" + name + '\'' +
                '}';
    }
}
