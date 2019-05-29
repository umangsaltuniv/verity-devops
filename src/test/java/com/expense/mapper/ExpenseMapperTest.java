package com.expense.mapper;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import com.expense.dto.ExpenseDTO;
import com.expense.entity.Expense;

public class ExpenseMapperTest {

	private static final ModelMapper modelMapper = new ModelMapper();

	@Test
	public void Test() {

		ExpenseDTO dto = new ExpenseDTO();
		dto.setDate("23-01-1994");
		dto.setExpenseHead("Taxi");
		dto.setAmount(600000.00);
		dto.setCurrency("dolar");
		dto.setExpenseCategory("xyz");
		dto.setIsRecurring(1);
		dto.setIsSelected(1);
		dto.setDetails("details");

		Expense expense = modelMapper.map(dto, Expense.class);
		assertEquals(dto.getDate(), expense.getDate());
		assertEquals(dto.getExpenseHead(), expense.getExpenseHead());
		assertEquals(dto.getAmount(), expense.getAmount());
		assertEquals(dto.getCurrency(), expense.getCurrency());
		assertEquals(dto.getExpenseCategory(), expense.getExpenseCategory());
		assertEquals(dto.getIsRecurring(), expense.getIsRecurring());
		assertEquals(dto.getIsSelected(), expense.getIsSelected());
		assertEquals(dto.getDetails(), expense.getDetails());

	}
	
	//Make this @Test to run failing test
	
	
	@Ignore
	public void negativeTest() {

		ExpenseDTO dto = new ExpenseDTO();
		dto.setDate("23-01-1994");
		
		Expense expense = modelMapper.map(dto, Expense.class);
		assertEquals(dto.getExpenseHead(), expense.getDate());
	

	}

}
