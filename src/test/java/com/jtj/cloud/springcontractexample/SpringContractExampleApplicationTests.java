package com.jtj.cloud.springcontractexample;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public class SpringContractExampleApplicationTests extends AbstractDnocmTest {

    @Autowired
    private WebTestClient client;

    @Test
    public void contextLoads() {
        client.get().uri("/fromNone").exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Hello World");
    }

}