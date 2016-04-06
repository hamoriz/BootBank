package com.hamori.repository;

import com.hamori.DemoApplication;
import com.hamori.model.Customer;
import com.hamori.repository.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Author: Zoltan_Hamori
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)

public class CustomerPersistenceTest {


    @Autowired
    private CustomerMapper customerMapper;


    @Test
    public void customerFindByName() {
        final String customerName = "Oriza Triznyak";
        customerMapper.createCustomer(aCustomer(customerName));

        Customer newCustomer = customerMapper.findByName(customerName);

        assertNotNull(newCustomer);
        assertThat(newCustomer.getName(), is(customerName));
    }

    @Test
    public void customerFindById() {


        Customer customer=aCustomer("Robert Gida");
        customerMapper.createCustomer(customer);

        Customer newCustomer = customerMapper.findById(customer.getId());

        assertNotNull(newCustomer);
        assertThat(newCustomer.getName(), is("Robert Gida"));
    }

    private Customer aCustomer(String name) {
        Customer customer = new Customer();
        customer.setName(name);
        return customer;
    }


}
