package com.hamori.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Author: Zoltan_Hamori
 */
@Component
public class StartupEventListener implements ApplicationListener<ApplicationStartedEvent> {


    public StartupEventListener() {
        System.out.println("ghello");
    }


    @Autowired
    DatabaseSetup databaseSetup;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
       databaseSetup.setup();
    }
}
