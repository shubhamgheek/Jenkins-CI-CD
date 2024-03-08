package io.shubham.JenkinsCICD.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class JenkinsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getDemoResponseTest() throws Exception {
        String name = "Shubham Arora";

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/jenkins/{name}", name))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello " + name + ", Good to see you !"));
    }
}
