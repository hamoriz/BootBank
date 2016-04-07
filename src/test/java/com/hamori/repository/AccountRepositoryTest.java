package com.hamori.repository;

import com.hamori.DemoApplication;
import com.hamori.model.Account;
import com.hamori.model.AccountType;
import com.hamori.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Author: Zoltan_Hamori
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class AccountRepositoryTest {


    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountTypeMapper typeMapper;


    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void accountFindByCustomer() {

        final String customerName = "Jimi Hendrix";
        final Long balance = 12345L;
        Account account = createAccount(balance, customerName, "Saving");

        List<Account> customerAccounts = accountMapper.findByCustomer(account.getCustomer());

        assertThat(customerAccounts.size(), is(1));
        assertThat(customerAccounts.get(0).getCustomer().getName(), is(customerName));
        assertThat(customerAccounts.get(0).getBalance(), is(balance));
    }

    @Test
    public void accountFindById() {
        final String customerName = "Jimi Hendrix";
        final Long balance = 12345L;
        Account account = createAccount(balance, customerName, "Saving");

        Account newAccount = accountMapper.findById(account.getId());

        assertThat(newAccount.getId(), is(account.getId()));
        assertThat(newAccount.getCustomer().getName(), is(customerName));
        assertThat(newAccount.getBalance(), is(balance));
    }

    private Account createAccount(Long balance, String customerName, String accountType) {
        Customer customer = new Customer();
        customer.setName(customerName);
        customerMapper.createCustomer(customer);
        final AccountType type = typeMapper.findByName(accountType);

        Account account = aVanillaAccount(balance, customer, type);
        accountMapper.createAccount(account);
        return account;
    }

    private Account aVanillaAccount(Long balance, Customer customer, AccountType type) {
        Account account = new Account();
        account.setBalance(balance);
        account.setCustomer(customer);
        account.setType(type);
        return account;
    }


}
