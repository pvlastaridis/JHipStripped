package com.mycompany.myapp.web.rest;

import javax.inject.Inject;

import com.mycompany.myapp.Application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the UserResource REST controller.
 *
 * @see UserResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class HelloResourceTest {
	
	@Inject
	JdbcTemplate Jdbctemp;

    
    private MockMvc restUserMockMvc;
    
    @Before
    public void setup() {
        HelloResource helloResource = new HelloResource(Jdbctemp);
        this.restUserMockMvc = MockMvcBuilders.standaloneSetup(helloResource).build();
    }

    

    @Test
    public void testHelloApi() throws Exception {
        restUserMockMvc.perform(get("/api/hello/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
               // .andExpect(content().json(""));
    }

    @Test
    public void testGetUnknownHello() throws Exception {
        restUserMockMvc.perform(get("/api/hello/0")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
