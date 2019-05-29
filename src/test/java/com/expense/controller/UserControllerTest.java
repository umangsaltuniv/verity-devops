package com.expense.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.expense.ExpenseApplication;
import com.expense.entity.User;
import com.expense.service.ExpenseService;
import com.expense.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ExpenseApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private UserService userService;
	
	@Mock
	PasswordEncoder passwordEncoder;
	
	@InjectMocks
    private UserController userController;
	
	@Test
	public void testCreateUser() throws Exception {

		mockMvc.perform(post("/add-user").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.accept(MediaType.APPLICATION_FORM_URLENCODED).param("name", "Test User").param("username", "testuser")
				.param("password", "testuser")
				.with(org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf())
				.sessionAttr("User", new User())).andExpect(status().isOk()).andExpect(view().name("register.jsp"))
				.andExpect(forwardedUrl("register.jsp"))
				//.andExpect(model().attribute("User", Matchers.hasProperty("name", Matchers.is("Test User"))))
				;

	}

	// Make this @Test to run failing test
	

	@Ignore
	public void negativeTestCreateUser() throws Exception {

		mockMvc.perform(post("/add-user").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.accept(MediaType.APPLICATION_FORM_URLENCODED).param("name", "Test User").param("username", "testuser")
				.param("password", "testuser")
				.with(org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf())
				.sessionAttr("User", new User())).andExpect(status().isOk()).andExpect(view().name("register.jsp"))
				.andExpect(forwardedUrl("login.jsp"))
				.andExpect(model().attribute("User", Matchers.hasProperty("name", Matchers.is("Test User"))));

	}
	

	// Test failure for invalid username
	// Make this @Test to run failing test
		
	
	  @Ignore
	  public void testGetUser() throws Exception 
	  {
		  	User user = new User();
		  	user.setUsername("admin");
		  	user.setPassword("admin");
		  	user.setName("User Admin");

	        //mocking the bean
	        Mockito.when(userService.getByUsername("xyz")).thenReturn(user);

	        //response is retrieved as MvcResult
	        mockMvc.perform(post("/add-user")
	                .accept(MediaType.APPLICATION_JSON)
	                .with(httpBasic(user.getUsername(), user.getPassword())))
	                .andExpect(status().isUnprocessableEntity());
	    }
	  

}
