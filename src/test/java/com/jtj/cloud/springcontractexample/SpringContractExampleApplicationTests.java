package com.jtj.cloud.springcontractexample;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SpringContractExampleApplicationTests extends AbstractDnocmTest {

    @Autowired
    private MockMvc client;

    @Test
    public void contextLoads() throws Exception {
        client.perform(get("/fromNone"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"从入库到精通\",\"price\":666}"));
    }

}
