package com.expense.entity.repository;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.entity.repository.ExpenseRepository;
import com.expense.entity.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExpenseRepositoryTest {

	@Autowired
	private ExpenseRepository expenceRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() {

		List<Expense> getExpenses = expenceRepository.findByExpenseHead("Test-Taxi");

		assertThat(getExpenses.size(), is(1));

	}

	//Make this @Test to run failing test
	
	
	@Ignore
	public void testNegative() {

		List<Expense> getExpenses = expenceRepository.findByExpenseHead("Test-Taxi");

		assertThat(getExpenses.size(), is(2));

	}
	
	@Before
	public void getExpense() {

		User user = new User();
		user.setUsername("aaaaaa");
		user.setPassword("xxxxx");
		user.setName("Uthkrusta");
		user.setCurrency("rs");

		Expense expense = new Expense();
		expense.setDate("2016-03-01");
		expense.setExpenseHead("Test-Taxi");
		expense.setAmount(678995.97);
		expense.setCurrency("dolar");
		expense.setExpenseCategory("****");
		expense.setIsRecurring(1);
		expense.setIsSelected(1);
		expense.setDetails("details");
		expense.setUser(user);

		user.getExpenseList().add(expense);

		userRepository.save(user);
	}

}
