package com.rakesh.helloservice.web;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.rakesh.helloservice.app.HelloServiceApplication;

@SpringBootTest(classes = HelloServiceApplication.class)
@RunWith(SpringRunner.class)
public class HelloControllerShould {
	@InjectMocks
	HelloController helloController;

	@Autowired
	WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void initTests() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void returnSimpleMessageWhenNoParameterIsSpecified() throws Exception {
		mvc.perform(get("/greeting/v1/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.message", equalTo("Hello")));
	}

	@Test
	public void returnMessageWithWithInputParameter() throws Exception {
		mvc.perform(get("/greeting/v1/hello/rakesh").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.message", equalTo("Hello Rakesh")));
	}
}
