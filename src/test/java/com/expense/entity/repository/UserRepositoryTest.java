package com.expense.entity.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.expense.entity.User;
import com.expense.entity.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() {

		User getUserName = userRepository.findByName("xxxxx");

		assertEquals("save succssful", "xxxxx", (getUserName.getName()));

	}
	
	
	//Make this @Test to run failing test

	
	@Ignore
	public void negativeTest() {

		User getUserName = userRepository.findByName("xxxxx");

		assertEquals("save succssful", "#####", (getUserName.getName()));

	}

	@Before
	public void getUser() {
		User user = new User();
		user.setUsername("madhu");
		user.setPassword("*****");
		user.setName("xxxxx");
		user.setCurrency("rs");
		userRepository.save(user);

	}

}
