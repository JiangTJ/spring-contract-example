package com.jtj.cloud.springcontractexample;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebFlux;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by MrTT (jiang.taojie@foxmail.com)
 * 2019/3/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = SpringContractExampleApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "server.port=0",
                "eureka.client.enabled=false",
                "spring.cloud.config.failFast=false"
        }
)
@AutoConfigureWebTestClient
@AutoConfigureStubRunner
@Profile("stub")
public abstract class AbstractDnocmTest {
}
