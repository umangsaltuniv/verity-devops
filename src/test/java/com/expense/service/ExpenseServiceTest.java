package com.expense.service;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.expense.controller.ExpenseController;
import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.entity.repository.ExpenseRepository;
import com.expense.service.impl.ExpenseServiceImpl;

public class ExpenseServiceTest {

	Logger log = Logger.getLogger(ExpenseServiceTest.class.getName());
	
	@Mock
	ExpenseRepository expenseRepository;

	@InjectMocks
	ExpenseService expenseService = new ExpenseServiceImpl();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveExpenseTest() {
		Expense expense = new Expense();
		expense.setAmount(1000.00);

		when(expenseRepository.save(Mockito.any(Expense.class))).thenReturn(expense);
		Expense created = expenseService.saveExpense(expense);

		log.info("created: "+created);
		assertThat(created.getAmount(), is(1000.00));
	}

	@Test
	public void getAllUserTest() {

		Expense expense = new Expense();
		expense.setAmount(1000.00);

		when(expenseRepository.save(Mockito.any(Expense.class))).thenReturn(expense);
		Expense created = expenseService.saveExpense(expense);

		ArrayList<Expense> expenseList = new ArrayList<Expense>();
		expenseList.add(created);
		when(expenseRepository.findAll()).thenReturn(expenseList);

		List<Expense> expenseList1 = expenseService.getExpense();
		assertEquals(1, expenseList1.size());
	}
	


}
