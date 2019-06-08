package com.expense.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.expense.controller.ExpenseController;
import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.entity.repository.ExpenseRepository;
import com.expense.entity.repository.UserRepository;
import com.expense.service.ExpenseService;

// Service implementation with business logic and access repository

@Service
public class ExpenseServiceImpl implements ExpenseService {

	Logger log = Logger.getLogger(ExpenseController.class.getName());

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public Expense saveExpense(Expense expense) {
		
		//Uncomment below 2 lines to make test fail (ExpenseServiceTest.saveExpenseTest())
		//expense.setAmount(2000.00);
		//return expense;
		
		//Comment below line to make test fail
		return expenseRepository.save(expense);
	}

	public List<Expense> getExpense() {
		return expenseRepository.findAll();
	}

	@Override
	public List<Expense> getExpenseByUserId(Long userId) {
		User user = userRepository.getOne(userId);
		return expenseRepository.findByUser(user);
	}

	@Override
	public Expense getById(Long expenseId) {
		return expenseRepository.getOne(expenseId);
	}

	@Override
	public void deleteById(Long expenseId) {
		//Uncomment below line to make test fail (ExpenseControllerTest.testDeleteExpense())
		log.info("Debug delete");
		
		//Comment below 2 lines to make test fail
		//expenseRepository.deleteById(expenseId);
		//expenseRepository.flush();
	}

}
