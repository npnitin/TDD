package com.example.TDD.controllerTest;

import com.example.TDD.TddApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


/**
 * Created by np85075 on 4/11/2019.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TddApplication.class)
public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void TestGetAllEmployees() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/employee")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$",hasSize(4))).andDo(MockMvcResultHandlers.print());
    }
}
