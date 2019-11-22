package com.example.springboottest;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerMockmvcTests {

    @Autowired
    private MockMvc mockMvc;
    
	/*
	 * @Test public void testCreateRetrieveWithMockMVC() throws Exception {
	 * this.mockMvc.perform(post("/students")).andExpect(status().is2xxSuccessful())
	 * ; this.mockMvc.perform(get("/students/1")).andDo(print()).andExpect(status().
	 * isOk()) .andExpect(content().string(containsString("Rajesh"))); }
	 */
    
    @Test
    public void testCreateRetrieveWithMockMvc() throws Exception{
    	this.mockMvc.perform(post("/students")).andExpect(status().is2xxSuccessful());
    	this.mockMvc.perform(get("/students/1")).andExpect(status().isOk()).andExpect(content().string(containsString("Rajesh")));
       	this.mockMvc.perform(get("/students/2")).andExpect(status().isOk()).andExpect(content().string(containsString("Sumit")));
       	this.mockMvc.perform(get("/students/3")).andExpect(status().isOk()).andExpect(content().string(containsString("Rohit")));
    	this.mockMvc.perform(get("/students/1")).andExpect(status().isOk()).andExpect(content().string(containsString("10")));
    	this.mockMvc.perform(get("/students/2")).andExpect(status().isOk()).andExpect(content().string(containsString("9")));
    	this.mockMvc.perform(get("/students/3")).andExpect(status().isOk()).andExpect(content().string(containsString("10")));
    }
    
 
}

