package com.hamori.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Author: Zoltan_Hamori
 */

public class AccountTypeIntegrationTest extends AbstractIntegrationTest {

    private RestTemplate restTemplate = new TestRestTemplate();

    @Value("${local.server.port}")
    private int port;

    @Test
    public void getAllAccountTypes() {
        String accountTypes = restTemplate.getForEntity("http://localhost:" + port + "/api/accountTypes", String.class).getBody();
        assertThat(accountTypes, is("[{\"id\":1,\"name\":\"Current\"},{\"id\":2,\"name\":\"Saving\"},{\"id\":3,\"name\":\"CashIsa\"}]"));
    }
}
