package com.hamori.config;

import com.hamori.model.Account;
import com.hamori.model.AccountType;
import com.hamori.model.Customer;
import com.hamori.repository.AccountMapper;
import com.hamori.repository.AccountTypeMapper;
import com.hamori.repository.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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

    @Autowired
    private AccountTypeMapper accountTypeMapper;

    @PostConstruct
    public void setup() {
        List<Customer> customerList = setupCustomers();
        setupAccounts(customerList);
    }

    private void setupAccounts(List<Customer> customerList) {
        List<AccountType> types = accountTypeMapper.findAll();
        customerList.forEach(cust -> {
                    final int no_of_accounts = ThreadLocalRandom.current().nextInt(MAX_ACCOUNT_PER_CUST);
                    for (int i = 0; i < no_of_accounts; i++) {
                        openAccount(cust, types.get(ThreadLocalRandom.current().nextInt(types.size())));
                    }
                }
        );
    }

    private void openAccount(Customer customer, AccountType type) {
        Account account = new Account();
        account.setBalance(ThreadLocalRandom.current().nextLong(100000L));
        account.setCustomer(customer);
        account.setType(type);
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
