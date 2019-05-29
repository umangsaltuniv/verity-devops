package com.expense.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.expense.entity.Expense;
import com.expense.entity.User;

//repository interface and an implementation to access Expense domain objects from an in-memory database.
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	public List<Expense> findByExpenseHead(String name);

	public List<Expense> findByUser(User user);
	
	// it delete the expense from Expense list

	@Modifying
	@Query("delete from Expense where id = :id ")
	public void deleteById(@Param("id") Long id);
}
