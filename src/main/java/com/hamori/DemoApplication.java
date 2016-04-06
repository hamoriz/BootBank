package com.hamori;

import com.hamori.config.StartupEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    @Autowired
    public StartupEventListener eventListener;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
