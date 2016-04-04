package com.epam.hamori.config;

import com.epam.hamori.model.Account;
import com.epam.hamori.model.Customer;
import com.epam.hamori.repository.AccountMapper;
import com.epam.hamori.repository.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Author: Zoltan_Hamori
 */
@Component
public class DatabaseSetup {

    private final static int NUMBER_OF_CUSTOMERS = 10;
    private final static int MAX_ACCOUNT_PER_CUST = 5;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AccountMapper accountMapper;


    public void setup() {
        List<Customer> customerList = setupCustomers();
        setupAccounts(customerList);
    }

    private void setupAccounts(List<Customer> customerList) {
        customerList.forEach(cust -> {
                    final int no_of_accounts = ThreadLocalRandom.current().nextInt(MAX_ACCOUNT_PER_CUST);
                    for (int i = 0; i < no_of_accounts; i++) {
                        openAccount(cust);
                    }
                }
        );
    }

    private void openAccount(Customer customer) {
        Account account = new Account();
        account.setBalance(ThreadLocalRandom.current().nextLong(100000L));
        account.setCustomer(customer);
        accountMapper.createAccount(account);
    }

    private List<Customer> setupCustomers() {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CUSTOMERS; i++) {
            Customer customer = new Customer();
            customer.setName("c" + i);
            customers.add(customer);
            customerMapper.createCustomer(customer);
        }
        return customers;
    }
}
