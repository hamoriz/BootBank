package com.epam.hamori;

import com.epam.hamori.config.DatabaseSetup;
import com.epam.hamori.repository.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private DatabaseSetup databaseSetup;

    @Autowired
    private CustomerMapper customerMapper;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        databaseSetup.setup();

    }


}
