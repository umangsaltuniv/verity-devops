package com.expense.service;

import java.util.List;

import com.expense.entity.Expense;
import com.expense.entity.User;


public interface ExpenseService {
	public Expense saveExpense(Expense expense);

	public List<Expense> getExpense();

	public List<Expense> getExpenseByUserId(Long userId);

	public Expense getById(Long expenseId);

	public void deleteById(Long expenseId);



}
