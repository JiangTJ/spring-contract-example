package com.jtj.cloud.springcontractexample;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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
@ActiveProfiles("stub")
public abstract class AbstractDnocmTest {
}
