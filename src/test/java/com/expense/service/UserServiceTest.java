package com.expense.service;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.expense.entity.User;
import com.expense.entity.repository.UserRepository;
import com.expense.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

	@Mock
	UserRepository userRepository;
	
	@Mock
	PasswordEncoder passwordEncoder;

	@InjectMocks
	UserService userService = new UserServiceImpl();

	
	  @Before 
	  public void init() 
	  { 
		  MockitoAnnotations.initMocks(this); 
	  }
	 

	@Test	
	public void saveUserTest() {
		
		User user = new User();
		user.setUsername("SUN");
		
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		User created = userService.saveUser(user);
		
		assertThat(created.getUsername(), is("SUN"));	
	}
	
	@Test
	public void getAllUserTest() {	
		
		User user = new User();
		user.setUsername("SUN");
		user.setPassword("123");
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		when(passwordEncoder.encode(Mockito.any(String.class))).thenReturn("123");
		User created = userService.saveUser(user);

		List<User> userList = new ArrayList<User>();
		userList.add(created);
		when(userRepository.findAll()).thenReturn(userList);
		
		List<User> userList1 = userService.getUser();
		assertEquals(1, userList1.size());
	}
	
}
