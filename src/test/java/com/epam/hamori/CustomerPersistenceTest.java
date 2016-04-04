package com.epam.hamori;

import com.epam.hamori.model.Customer;
import com.epam.hamori.repository.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertNotNull;

/**
 * Author: Zoltan_Hamori
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)

public class CustomerPersistenceTest {


        @Autowired
        private CustomerMapper customerMapper;


        @Test
        public void testJpaFind() {
            final String customerName ="Oriza Triznyak";
            Map<String, Object> map=new HashMap<>();
            map.put("returnedId",0L);
            Customer customer = aCustomer(customerName);
            customerMapper.createCustomer(customer);
            Customer newCustomer = customerMapper.findByName(customerName);
            assertNotNull(newCustomer);
        }

        private Customer aCustomer(String name) {
            Customer customer = new Customer();
            customer.setName(name);
            return customer;
        }




}
